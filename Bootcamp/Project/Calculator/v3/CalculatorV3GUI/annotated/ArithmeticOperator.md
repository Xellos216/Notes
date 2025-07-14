# 📘 ArithmeticOperator.java (연산자 Enum 구조) 주석 & 개념 정리

---

## ✅ 1. 전체 코드 (상세 주석 포함)

```java
package model;

// 사칙연산 및 확장 연산을 정의한 Enum
public enum ArithmeticOperator {
    PLUS("+", false,(a, b) -> a + b),  // 덧셈
    MINUS("-", false,(a, b) -> a - b),  // 뺄셈
    MULTIPLY("*", false,(a, b) -> a * b),  // 곱셈
    DIVIDE("/", false,(a, b) -> {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }),  // 0 나누기 예외 처리 포함
    POWER("^", false, (a, b) -> Math.pow(a, b)),  // 거듭제곱
    ROOT("sqrt", true,(a, b) -> {
        if (a < 0) throw new ArithmeticException("Cannot take root of negative number");
        return Math.sqrt(a);
    });  // 제곱근 (단항 연산)

    private final String symbol;  // 연산자 기호
    private final boolean unary;  // 단항 여부
    private final Operation operation;  // 연산 로직

    ArithmeticOperator(String symbol, boolean unary, Operation operation) {
        this.symbol = symbol;
        this.unary = unary;
        this.operation = operation;
    }

    // 실제 연산 수행
    public double apply(double a, double b) {
        return operation.operate(a, b);
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isUnary() {
        return unary;
    }

    // 람다식 기반 연산을 위한 인터페이스
    @FunctionalInterface
    private interface Operation {
        double operate(double a, double b);
    }

    // 기호로 Enum 값을 찾는 유틸 메서드
    public static ArithmeticOperator fromSymbol(String symbol) {
        for (ArithmeticOperator op : values()) {
            if (op.getSymbol().equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Invalid operator: " + symbol);
    }
}
```

---

## ✅ 2. 핵심 개념 정리

| 항목 | 설명 | 예시 |
|------|------|------|
| `enum` | 고정된 상수 집합 정의 | `PLUS`, `MINUS`, ... |
| `symbol` | 문자열 연산자 기호 | `"+"`, `"sqrt"` 등 |
| `isUnary()` | 단항 연산 여부 판단 | `sqrt → true` |
| `apply()` | 두 숫자에 대해 연산 실행 | `op.apply(3, 2)` |
| `Operation` | 연산 람다식을 위한 인터페이스 | `(a, b) -> a + b` |
| `fromSymbol()` | 입력 기호로 Enum 찾기 | `"+" → PLUS` |

---

## ✅ 3. 설계 구조 요약

```text
사용자 입력 기호 (e.g., "+")
   ↓
fromSymbol("+")

   ↓ (Enum 객체 획득)
ArithmeticOperator.PLUS

   ↓
apply(a, b) → 내부 Operation 람다 실행
```

---

## ✅ 4. 확장성 및 유지보수 팁

| 항목 | 설명 |
|------|------|
| 연산 추가 용이 | 새로운 연산자(예: `%`)는 Enum 상수 하나 추가로 끝 |
| 예외 처리 내장 가능 | DIVIDE, ROOT 등에서 내부적으로 예외 처리 |
| 단항 연산 식별 | `isUnary()`로 UI 및 계산 흐름에서 분기 가능 |
| 람다식 활용 | 각 연산을 함수처럼 간결하게 정의 가능 |
| 연산자 기호로 파싱 | `fromSymbol()`으로 사용자 입력 매핑 쉽게 처리 |

---

이 문서는 `ArithmeticOperator.java`의 구조와 동작 방식, 각 연산자의 내부 구현 및 확장 포인트를 주석과 표로 정리한 문서입니다.
