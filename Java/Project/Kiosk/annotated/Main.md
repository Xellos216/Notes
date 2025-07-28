### 📄 Main.java (주석 포함, CLI 진입 포인트)

```java
package kiosk;

import kiosk.util.InputHandler;
import kiosk.model.Menu;
import kiosk.model.Category;
import kiosk.model.CartItem;
import kiosk.service.KioskService;
import kiosk.ui.ConsolePrinter;

import java.util.List;
import java.util.Set;

/**
 * 💡 애플리케이션 **엔트리 포인트**
 * - 콘솔 UI 루프를 돌며 사용자 입력을 받아 KioskService 에 위임
 * - 카테고리→메뉴→장바구니→결제 흐름을 제어
 */
public class Main {
    public static void main(String[] args) {
        // 1️⃣ 서비스·데이터 초기화
        KioskService kiosk = new KioskService();
        kiosk.initializeMenu();

        // 2️⃣ 메인 루프 (무한 반복 → 0 입력 시 종료)
        while (true) {
            ConsolePrinter.printMainBanner();
            int option = InputHandler.getIntInput("메뉴 번호를 선택하세요: ");
            System.out.println();

            switch (option) {
                case 1 -> handleMenu(Category.COFFEES, kiosk);
                case 2 -> handleMenu(Category.NON_COFFEES, kiosk);
                case 3 -> handleMenu(Category.DESSERTS, kiosk);
                case 4 -> kiosk.showCart();
                case 5 -> kiosk.checkout();
                case 0 -> {
                    ConsolePrinter.bye();
                    return; // 프로그램 종료
                }
                default -> System.out.println("올바른 번호를 입력하세요.\n");
            }
        }
    }

    /**
     * ☕ 카테고리별 메뉴 처리 (온도 옵션 포함)
     */
    private static void handleMenu(Category category, KioskService kiosk) {
        kiosk.showMenuByCategory(category);
        System.out.println();
        int menuIndex = InputHandler.getIntInput("메뉴 번호를 선택해주세요 (0=뒤로): ");
        if (menuIndex == 0) return;

        List<Menu> menus = kiosk.getMenuList().stream()
                .filter(m -> m.getCategory() == category)
                .toList();
        if (menuIndex < 1 || menuIndex > menus.size()) {
            System.out.println("잘못된 번호입니다.\n");
            return;
        }

        Menu selected = menus.get(menuIndex - 1);

        // 1️⃣ 수량 입력
        int quantity = InputHandler.getPositiveInt("수량: ");

        // 2️⃣ 온도 옵션 (커피·논커피 카테고리 한정)
        String temp = null;
        Set<String> noTempItems = Set.of("Cheesecake", "Brownie");
        if ((category == Category.COFFEES || category == Category.NON_COFFEES)
                && !noTempItems.contains(selected.getName())) {

            while (true) {
                String input = InputHandler.getStringInput("1. ICE  2. HOT : ").trim();
                if (input.equals("1")) {
                    temp = "ICE";
                    break;
                } else if (input.equals("2")) {
                    temp = "HOT";
                    break;
                } else {
                    System.out.println("1 또는 2만 입력 가능합니다.\n");
                }
            }
        }

        // 3️⃣ 확인/취소
        System.out.println();
        ConsolePrinter.confirm(selected, quantity, temp);
        System.out.println("1. 확인  2. 취소\n");

        int confirm = InputHandler.getIntInput("선택: ");
        System.out.println();

        if (confirm == 1) {
            if (temp != null) {
                kiosk.addToCart(selected, quantity, temp);
            } else {
                kiosk.addToCart(selected, quantity);
            }
        } else {
            System.out.println("선택한 메뉴가 취소되었습니다.\n");
        }
    }
}
```

---

#### ✅ 핵심 변경점·리팩토링 포인트

1. **Service 위임**: `KioskService`로 핵심 비즈니스 로직 위임해 `Main`은 입·출력 흐름 제어에 집중.
2. **ConsolePrinter 활용**: 배너·확인 메시지 등을 전담 → 코드 중복 최소화.
3. **메서드 분할**: 메뉴 처리 로직을 `handleMenu()`로 분리해 가독성·테스트 용이성 향상.
4. **온도 옵션 로직 개선**: `category`별 & 예외 메뉴 세트(`noTempItems`) 조건으로 옵션 선택 제한.
5. **입력 검증 강화**: 메뉴 번호, 수량, 옵션 입력에서 잘못된 입력 시 친절한 안내 후 재시도.

