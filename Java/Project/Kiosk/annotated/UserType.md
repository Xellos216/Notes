### 📄 UserType.java (주석 포함 버전)

```java
package kiosk.model;

/**
 * 사용자 할인 유형을 정의하는 enum
 * 각 항목마다 할인율을 포함
 */
public enum UserType {
    CAT(0.01),
    DOG(0.02),
    IDIOT(0.03);

    private final double discountRate;

    UserType(double discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * 할인율 반환
     */
    public double getDiscountRate() {
        return discountRate;
    }

    /**
     * 숫자 입력(1~3)을 enum으로 변환
     */
    public static UserType fromInt(int input) {
        return switch (input) {
            case 1 -> CAT;
            case 2 -> DOG;
            case 3 -> IDIOT;
            default -> throw new IllegalArgumentException("잘못된 할인 유형입니다.");
        };
    }

    /**
     * 사용자에게 출력할 이름
     */
    @Override
    public String toString() {
        return switch (this) {
            case CAT -> "고양이";
            case DOG -> "강아지";
            case IDIOT -> "머저리";
        };
    }
}
```

📝 할인 정책을 enum으로 구현함으로써 고정된 할인율과 명칭을 구조화했으며,  
번호 → enum 변환(`fromInt`)과 사용자 명칭 반환(`toString`)이 주요 기능입니다.