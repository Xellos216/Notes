### 📄 KioskService.java (주석 포함, 의존성 분리·SOLID 개선 버전)

```java
package Kiosk.service;

import Kiosk.model.*;
import Kiosk.ui.ConsolePrinter;
import Kiosk.util.InputHandler;

/**
 * 🎛️ **키오스크 애플리케이션의 도메인 서비스 레이어**
 * - UI 로직(ConsolePrinter) ↔ 도메인 모델(Cart, Menu) 연결
 * - 단일 책임 원칙(SRP) 준수: 주문 흐름 제어에 집중, 입출력 처리 분리
 * - 향후 Web MVC 확장을 고려해 특정 UI 구현체에 의존하지 않도록 설계
 */
public class KioskService {

    /* ----------------- 의존 객체 ----------------- */
    private final ConsolePrinter printer;        // 출력 담당 (전략 패턴 대체 가능)
    private final Cart cart = new Cart();        // 사용자의 장바구니

    /* ----------------- 생성자 ----------------- */
    public KioskService(ConsolePrinter printer) {
        this.printer = printer;
        seedMenus();
    }

    /* ----------------- 메뉴 초기 데이터 ----------------- */
    private final List<Menu> menus = new ArrayList<>();

    /** 더미 데이터 주입 (실무에서는 DB or API) */
    private void seedMenus() {
        menus.add(new Menu("Americano", 3000, Category.COFFEES));
        menus.add(new Menu("Latte", 3500, Category.COFFEES));
        menus.add(new Menu("Lemonade", 4000, Category.NON_COFFEES));
        menus.add(new Menu("Cheesecake", 4800, Category.DESSERTS));
    }

    /* ----------------- 키오스크 진입 ----------------- */
    public void start() {
        printer.welcome();
        while (true) {
            printer.showMainOptions();
            int sel = InputHandler.getIntInRange("메뉴 선택: ", 1, 4);
            switch (sel) {
                case 1 -> chooseCategory();
                case 2 -> cart.displayCart();
                case 3 -> proceedPayment();
                case 4 -> { printer.goodbye(); return; }
            }
        }
    }

    /* ----------------- 카테고리 선택 ----------------- */
    private void chooseCategory() {
        printer.printCategories(Category.values());
        int idx = InputHandler.getIntInRange("카테고리 번호: ", 1, Category.values().length);
        Category category = Category.values()[idx - 1];
        chooseMenu(category);
    }

    /* ----------------- 메뉴 선택 ----------------- */
    private void chooseMenu(Category category) {
        List<Menu> filtered = menus.stream()
                                   .filter(m -> m.getCategory() == category)
                                   .toList();
        printer.printMenus(filtered);
        int choice = InputHandler.getIntInRange("메뉴 번호(0=뒤로): ", 0, filtered.size());
        if (choice == 0) return;
        Menu menu = filtered.get(choice - 1);

        int qty = InputHandler.getPositiveInt("수량: ");
        String temp = needsTemperature(category) ? askTemperature() : null;
        cart.addItem(new CartItem(menu, qty, temp));
        printer.notifyAdded(menu.getName());
    }

    /* ----------------- 옵션 여부 ----------------- */
    private boolean needsTemperature(Category category) {
        return category == Category.COFFEES || category == Category.NON_COFFEES;
    }

    private String askTemperature() {
        printer.askTemperature();
        int t = InputHandler.getIntInRange("선택: ", 1, 2);
        return t == 1 ? "HOT" : "ICE";
    }

    /* ----------------- 결제 ----------------- */
    private void proceedPayment() {
        if (cart.isEmpty()) {
            printer.alertEmptyCart();
            return;
        }
        cart.displayCart();
        if (InputHandler.getStringInput("결제하시겠습니까? (y/n)").equalsIgnoreCase("y")) {
            // TODO: 결제 API 연동 or 모의 결제 처리
            printer.paymentSuccess(cart.getTotalPrice());
            cart.clear();
        }
    }
}
```

---

#### ✅ 핵심 변경점·리팩토링 포인트

1. **SOLID 적용**: 출력 책임(ConsolePrinter) 주입 → 단일 책임 및 의존성 역전.
2. **스트림 API 활용**: 카테고리 필터링·리스트 출력 로직 간결화.
3. **옵션 선택 로직 분리**: `needsTemperature()` 추출로 카테고리 별 온도 옵션 여부 명확화.
4. **시나리오 메서드 분할**: `chooseCategory()` → `chooseMenu()` → `proceedPayment()` 단계적 분리로 가독성 향상.
5. **확장성 고려**: 메뉴 데이터 `seedMenus()`를 별도 메서드로 두어 DB·파일 연동 대비.

