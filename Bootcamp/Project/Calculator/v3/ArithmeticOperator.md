# 📘 ArithmeticOperator.java 주석 & 개념 정리

---

## ✅ 1. 전체 코드 (상세 주석 포함)

```java
import java.util.function.BinaryOperator;

// 사칙연산(+, -, *, /)을 정의한 열거형(Enum)
public enum ArithmeticOperator {

    // 각 연산 기호와 함께 해당 연산을 수행할 람다식을 정의
    PLUS("+", (double a, double b) -> a + b),
    MINUS("-", (double a, double b) -> a - b),
    MULTIPLY("*", (double a, double b) -> a * b),
    DIVIDE("/", (double a, double b) -> {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    });

    // 기호(+, -, *, /)
    private final String symbol;

    // 연산을 수행하는 함수형 인터페이스
    private final Operation operation;

    // 생성자: 각 열거 상수에 대한 symbol과 operation 할당
    ArithmeticOperator(String symbol, Operation operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    // 연산 실행: 내부 인터페이스의 operate 메서드 호출
    public double apply(double a, double b) {
        return operation.operate(a, b);
    }

    // 기호 반환
    public String getSymbol() {
        return symbol;
    }

    // 연산 수행을 위한 함수형 인터페이스 정의
    @FunctionalInterface
    private interface Operation {
        double operate(double a, double b);
    }

    // 기호를 기반으로 Enum 값을 찾는 유틸 메서드
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

## ✅ 2. 개념 정리표 (등장 키워드 해설)

| 용어/키워드 | 개념 설명 | 간단 예시 |
|-------------|-----------|------------|
| `enum` | 고정된 상수 집합을 정의하는 특수한 클래스 | `enum Color { RED, GREEN, BLUE }` |
| `ArithmeticOperator` | 사칙연산을 정의한 enum 이름 | `ArithmeticOperator.PLUS` |
| `symbol` | 연산 기호를 문자열로 저장 | `"+"`, `"-"` |
| `operation` | 연산을 수행하는 인터페이스 변수 | `(a, b) -> a + b` |
| `->` (람다식) | 함수형 프로그래밍 문법. 왼쪽: 매개변수, 오른쪽: 반환값 | `(a, b) -> a + b` |
| `ArithmeticException` | 잘못된 산술 연산 발생 시 예외 | 0으로 나눌 때 등 |
| `IllegalArgumentException` | 잘못된 입력 값이 들어왔을 때 예외 | 연산자가 "+", "-", "*" 가 아닌 경우 |
| `@FunctionalInterface` | 함수형 인터페이스임을 명시. 추상 메서드 1개만 허용 | `double operate(double a, double b);` |
| `interface` | 메서드만 선언된 틀. 구현은 다른 곳에서 | `interface Operation { ... }` |
| `values()` | enum 내부의 모든 상수를 배열로 반환 | `ArithmeticOperator.values()` |
| `fromSymbol()` | 주어진 기호를 기반으로 enum 상수 반환 | `fromSymbol("+") → ArithmeticOperator.PLUS` |

---

## ✅ 3. 보충 설명

### 🔹 enum이란?

- 상수들의 집합을 객체처럼 정의할 수 있는 자료형
- 각 상수마다 생성자와 멤버를 가질 수 있음

```java
enum Direction {
  NORTH("↑"), SOUTH("↓");
  private final String arrow;
  Direction(String arrow) { this.arrow = arrow; }
}
```

---

### 🔹 람다식(Lambda Expression)이란?

Java 8부터 등장한 **간결한 함수 표현 방식**

기존 방식:
```java
new Operation() {
  public double operate(double a, double b) {
    return a + b;
  }
}
```

람다식:
```java
(double a, double b) -> a + b
```

---

### 🔹 fromSymbol 사용 예시

```java
ArithmeticOperator op = ArithmeticOperator.fromSymbol("*");
double result = op.apply(3, 4);  // 3 * 4 = 12.0
```

---

이 문서는 `ArithmeticOperator.java`에 등장한 enum 구조, 함수형 인터페이스, 람다, 예외 처리 등 핵심 요소들을 모두 주석 + 개념으로 정리한 복습 자료입니다.