### 📄 ConsolePrinter.java (주석 포함, 메시지·스타일 유틸 통합 버전)

```java
package Kiosk.ui;

import Kiosk.model.Category;
import Kiosk.model.Cart;
import Kiosk.model.CartItem;
import Kiosk.model.Menu;

import java.util.List;

/**
 * 🖨️ **콘솔 전용 출력 유틸리티** (순수 View 레이어)
 * - 모든 System.out 관련 책임을 한곳에 모아 SRP 준수
 * - 컬러/스타일 ANSI 코드 상수화 → 가독성 + 유지보수 용이
 * - 금액 포맷, 배너, 경고 등 자주 쓰는 메시지 헬퍼 제공
 * - `static` 유틸 클래스 (생성자 private)
 */
public final class ConsolePrinter {

    /* ----------------- ANSI Style ----------------- */
    private static final String RESET = "\u001B[0m";
    private static final String BOLD  = "\u001B[1m";
    private static final String CYAN  = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";

    private ConsolePrinter() {/* static util */}

    /* ----------------- 공통 헬퍼 ----------------- */

    /** ￦금액 → "#,###원" */
    public static String money(int won) {
        return String.format("%,d원", won);
    }

    /* ----------------- 앱 배너 ----------------- */

    /** 시작 인사 + 배너 */
    public static void welcome() {
        printMainBanner();
    }

    /** 메인 배너 (재사용) */
    public static void printMainBanner() {
        System.out.println(CYAN + BOLD + "===== Welcome to Kiosk ☕ =====" + RESET);
    }

    /** 종료 메시지 */
    public static void goodbye() {
        System.out.println("이용해 주셔서 감사합니다. 안녕히 가세요!\n");
    }

    /* ----------------- 메인 옵션 ----------------- */

    public static void showMainOptions() {
        System.out.println("[ Main Menu ]");
        System.out.println("1. 카테고리 선택");
        System.out.println("2. 장바구니 보기");
        System.out.println("3. 결제하기");
        System.out.println("4. 종료\n");
    }

    /* ----------------- 카테고리·메뉴 출력 ----------------- */

    public static void printCategories(Category[] cats) {
        System.out.println("[ Category ]");
        for (int i = 0; i < cats.length; i++) {
            System.out.printf("%d. %s%n", i + 1, cats[i]);
        }
        System.out.println();
    }

    public static void printMenus(List<Menu> menus) {
        System.out.println("[ Menu ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, menus.get(i));
        }
        System.out.println("0. 뒤로\n");
    }

    /* ----------------- 장바구니 & 결제 ----------------- */

    public static void notifyAdded(String name) {
        System.out.printf(YELLOW + "%s 가 장바구니에 추가되었습니다.%n" + RESET + "%n", name);
    }

    public static void alertEmptyCart() {
        System.out.println("[ 장바구니가 비어 있습니다. ]\n");
    }

    public static void paymentSuccess(int total) {
        System.out.printf("결제 완료! 총 결제 금액: %s%n%n", money(total));
    }

    /* ----------------- 입력 확인 ----------------- */

    /**
     * 메뉴 선택 후 최종 확인 메시지
     */
    public static void confirm(Menu menu, int qty, String temp) {
        String label = temp == null ? menu.getName() : menu.getName() + "(" + temp + ")";
        System.out.printf("%s × %d = %s%n", label, qty, money(menu.getPrice() * qty));
    }

    /** 온도 옵션 안내 */
    public static void askTemperature() {
        System.out.println("1. HOT\n2. ICE\n");
    }

    /* ----------------- 디버그 / info ----------------- */

    public static void info(String msg) {
        System.out.println(msg);
    }

    /* ----------------- 장바구니 상세 ----------------- */

    public static void showCart(Cart cart) {
        if (cart.isEmpty()) {
            alertEmptyCart();
            return;
        }
        System.out.println(BOLD + "[ 현재 장바구니 ]" + RESET);
        int total = 0;
        for (CartItem ci : cart.getItems()) {
            System.out.printf("%s = %s%n", ci, money(ci.getTotalPrice()));
            total += ci.getTotalPrice();
        }
        System.out.printf("총 결제 금액: %s%n%n", money(total));
    }
}
```

---

#### ✅ 핵심 변경점·리팩토링 포인트

1. **출력 책임 단일화**: `System.out` 호출 분산을 막고, ConsolePrinter 단일 클래스로 집중.
2. **ANSI 코드 상수화**: 컬러·볼드 텍스트를 상수로 관리해 재사용성과 유지보수성 향상.
3. **메시지 헬퍼 세분화**: `welcome()`, `showMainOptions()`, `paymentSuccess()` 등 시나리오 단계별 메서드 구분.
4. **금액 포맷 재사용**: `money()` 메서드로 통일된 통화 표기 적용.
5. ``** 추출**: 주문 확인 로직을 별도 메서드로 분리해 Main 클래스 단순화.

