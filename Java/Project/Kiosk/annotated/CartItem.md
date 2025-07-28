### 📄 CartItem.java (주석 포함, 리팩토링 후 버전)

```java
package Kiosk.model;

import java.util.Objects;

/**
 * 🧩 장바구니 내부의 "단일 메뉴 + 옵션" 단위를 표현하는 도메인 객체
 * - 메뉴(Menu) 자체 정보 + 수량(quantity) + 온도 옵션(temperature) 보유
 * - equals/hashCode 오버라이딩 → 이름·온도 동일 시 동일 객체 취급 (Cart 병합용)
 */
public class CartItem {

    /** 실제 메뉴 객체 */
    private final Menu menu;
    /** 선택된 수량 (양수) */
    private int quantity;
    /** HOT / ICE, 디저트의 경우 null */
    private final String temperature;

    /**
     * 온도 옵션이 없는 메뉴(디저트 etc.) 생성자
     */
    public CartItem(Menu menu, int quantity) {
        this(menu, quantity, null);
    }

    /**
     * 전체 필드 초기화용 주 생성자
     */
    public CartItem(Menu menu, int quantity, String temperature) {
        this.menu = menu;
        this.quantity = quantity;
        this.temperature = temperature;
    }

    /* ----------------- 비즈니스 로직 ----------------- */

    /**
     * 총 금액 = 메뉴 단가 × 수량
     */
    public int getTotalPrice() {
        return menu.getPrice() * quantity;
    }

    /**
     * 동일 CartItem 추가 시 수량 증가
     */
    public void addQuantity(int qty) {
        if (qty <= 0) return;
        this.quantity += qty;
    }

    /**
     * 수량 감소 (0 미만으로는 내려가지 않음)
     */
    public void decreaseQuantity(int amount) {
        if (amount <= 0) return;
        this.quantity = Math.max(0, this.quantity - amount);
    }

    /* ----------------- Getter ----------------- */

    public Menu getMenu() { return menu; }
    public int getQuantity() { return quantity; }
    public String getTemperature() { return temperature; }

    /* ----------------- Object overrides ----------------- */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItem other)) return false;
        return Objects.equals(menu, other.menu) &&
               Objects.equals(temperature, other.temperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu, temperature);
    }

    @Override
    public String toString() {
        // 예: "아메리카노 (ICE) x2" 또는 "치즈케이크 x1"
        return temperature == null
                ? String.format("%s x%d", menu.getName(), quantity)
                : String.format("%s (%s) x%d", menu.getName(), temperature, quantity);
    }
}
```

---

#### ✅ 핵심 변경점·리팩토링 포인트

1. ``: 기존 소문자 패키지를 대문자 K로 정규화 → 프로젝트 구조 통일.
2. **불변 필드 강화**: 메뉴·옵션 값은 최종(`final`)로 지정해 불변성 확보.
3. **수량 검증 로직 보강**: `addQuantity()`, `decreaseQuantity()`에서 음수 입력 방어.
4. ``** 포맷 개선**: 수량·온도 표기를 한 줄에 표시해 UI 측 가독성 향상.

