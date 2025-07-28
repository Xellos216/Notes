### 📄 Menu.java (주석 포함, 가격 포맷 개선 버전)

```java
package Kiosk.model;

import static Kiosk.util.ConsoleStyle.money; // 💲 숫자 → "#,###원" 포맷 변환 유틸

/**
 * 🍽️ **메뉴 단위 객체**
 * - 이름·가격·카테고리 세 필드만 가진 간결한 VO(Value Object) 성격
 * - `toString()`에서 금액을 보기 좋은 문자열로 가공해 출력(UI 친화)
 */
public class Menu {

    /** 표시명(예: "Americano") */
    private final String name;
    /** 단가(￦) – 음수 입력 방어는 외부에서 책임 */
    private final int price;
    /** 메뉴 대분류(enum) */
    private final Category category;

    /** 생성자: 세 필드 모두 필수 */
    public Menu(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    /* ----------------- Getter ----------------- */
    public String getName() { return name; }
    public int getPrice() { return price; }
    public Category getCategory() { return category; }

    /* ----------------- Object overrides ----------------- */

    /**
     * UI 목록 출력용: "아메리카노 - 3,000원" 형태
     */
    @Override
    public String toString() {
        return String.format("%s - %s", name, money(price));
    }
}
```

---

#### ✅ 핵심 변경점·리팩토링 포인트

1. ``** 정적 import**로 금액 포맷 분리 → `toString()` 가독성 향상.
2. **불변 필드(**``**) 적용**: Menu 인스턴스 생성 후 변하지 않는 값으로 설계해 안정성 개선.
3. **VO(Value Object) 지향**: 동등성 비교가 필요하면 `equals()`/`hashCode()`를 추가 구현해 값 기반 비교 가능.

