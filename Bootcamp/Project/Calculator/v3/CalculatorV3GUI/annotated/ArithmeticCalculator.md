# 📘 ArithmeticCalculator.java (연산 처리 클래스) 주석 & 구조 정리

---

## ✅ 1. 전체 코드 (상세 주석 포함)

```java
package model;

// 실제 연산을 수행하는 계산기 클래스
public class ArithmeticCalculator {

    // 연산 메서드: operator에 따라 operand1, operand2를 계산
    public static double calculate(double operand1, String operator, Double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return operand1 / operand2;
            case "^":
                return Math.pow(operand1, operand2);  // 거듭제곱
            case "sqrt":
                return Math.sqrt(operand1);  // 제곱근 (단항 연산)
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
```

---

## ✅ 2. 핵심 개념 정리

| 항목 | 설명 | 예시 |
|------|------|------|
| `calculate()` | 연산자 기호에 따라 계산 실행 | `calculate(3, "+", 2)` → 5 |
| `operand1`, `operand2` | 첫 번째, 두 번째 피연산자 | 단항 연산 시 operand2는 `null` |
| `"sqrt"` | 제곱근 연산자, 단항 연산 | `calculate(9, "sqrt", null)` |
| `switch` | 연산자 문자열 분기 처리 | `"+"`, `"*"`, `"^"` 등 |
| `ArithmeticException` | 0 나누기 등 예외 상황 처리 | `/ 0` 발생 시 throw |

---

## ✅ 3. 설계 구조 요약

```text
Controller에서 calculate(...) 호출
   ↓
operator에 따라 switch 분기
   ↓
해당 연산 수행 후 결과 반환
```

---

## ✅ 4. 유지보수 포인트

| 항목 | 설명 |
|------|------|
| 단순 구조 | 로직이 명확해 디버깅 쉬움 |
| 단항 연산 고려 | `"sqrt"` 연산은 operand2 없이 처리 |
| 예외 처리 명확 | 0 나누기, 지원하지 않는 연산자 등 |
| Enum 연계 추천 | `ArithmeticOperator.fromSymbol()`과 통합 시 중복 제거 가능 |

---

이 클래스는 `Controller`에서 전달받은 연산자와 피연산자를 바탕으로 실제 계산을 수행하는 **핵심 연산 모듈**입니다.
