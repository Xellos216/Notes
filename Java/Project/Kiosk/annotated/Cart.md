### 📄 Cart.java (주석 포함, Stream 최적화 버전)

```java
package kiosk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 🛒 장바구니 전체를 관리하는 클래스
 * - 동일 메뉴/옵션 항목 병합
 * - 총액 계산
 */
public class Cart {

    /** 장바구니 항목 리스트 */
    private final List<CartItem> cartItems = new ArrayList<>();

    /**
     * 장바구니에 항목 추가
     * - 이미 같은 메뉴(이름+온도)가 있으면 수량만 증가
     * - Java Stream + Optional.ifPresentOrElse 로 병합 처리
     */
    public void addItem(CartItem newItem) {
        cartItems.stream()
                 .filter(item -> item.equals(newItem))
                 .findFirst()
                 .ifPresentOrElse(
                     item -> item.addQuantity(newItem.getQuantity()),
                     () -> cartItems.add(newItem)
                 );
    }

    /** 장바구니 항목 전체 출력 (콘솔 UI 전용) */
    public void displayCart() {
        System.out.println("🛒 장바구니 목록:");
        if (cartItems.isEmpty()) {
            System.out.println("[비어 있음]");
        } else {
            for (int i = 0; i < cartItems.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, cartItems.get(i));
            }
            System.out.printf("총 금액: %d원%n", getTotalPrice());
        }
        System.out.println();
    }

    /** 장바구니 비우기 */
    public void clear() {
        cartItems.clear();
    }

    /** 장바구니가 비어있는지 여부 반환 */
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    /** 총 금액 계산 (스트림 합계) */
    public int getTotalPrice() {
        return cartItems.stream()
                        .mapToInt(CartItem::getTotalPrice)
                        .sum();
    }
}
```

---

#### ✅ 핵심 변경점·리팩토링 포인트

1. **Stream + Optional** 로 중복 항목 병합 로직 간결화
2. **final 불변 리스트 참조**로 외부에서 교체 방지 → 안정성 향상
3. 출력 메서드 `displayCart()`에서 총액까지 한 번에 출력하도록 UI 책임 명확화

