### 📄 Category.java (주석 포함, Enum toString 최적화 버전)

```java
package Kiosk.model;

/**
 * ☕ 메뉴 대분류를 나타내는 Enum
 * - UI/콘솔 출력용으로 toString() 오버라이딩
 * - Java 17 switch expression 사용 → 가독성·확장성 향상
 */
public enum Category {
    /** 커피류 */
    COFFEES,
    /** 논커피(차·에이드 등) */
    NON_COFFEES,
    /** 디저트류 */
    DESSERTS;

    /**
     * Enum 이름 대신 유저 친화적 문자열 반환
     * ex) COFFEES → "Coffees"
     */
    @Override
    public String toString() {
        return switch (this) {
            case COFFEES    -> "Coffees";
            case NON_COFFEES -> "Non-Coffees";
            case DESSERTS   -> "Desserts";
        };
    }
}
```

---

#### ✅ 핵심 변경점·리팩토링 포인트

1. **Enum 값 다수형 표기**: `COFFEES`, `NON_COFFEES`로 명확히 구분.
2. **Java 17의 switch expression** 활용으로 `toString()` 간결화.
3. javadoc 주석 추가로 Enum 각 항목 의미 명시.

