# 📘 App.java (최종 개선본) 주석 & 개념 정리

---

## ✅ 1. 전체 코드 (상세 주석 포함)

```java
import java.rmi.server.ExportException;
import java.util.Scanner;
import java.util.Optional;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // 사용자 입력 받기
        ArithmeticCalculator calculator = new ArithmeticCalculator();  // 계산기 객체 생성

        System.out.println("=== Calculator ===");

        ArithmeticOperator operator = null;  // 연산자 변수 선언

        while (true) {
            System.out.print("Enter a first number (or 'exit'): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("exit")) break;

            double a;
            try {
                a = Double.parseDouble(input);  // 문자열을 double로 변환
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                continue;
            }

            System.out.print("Enter an operator (+, -, *, /): ");
            String operatorSymbol = scanner.next();

            try {
                operator = ArithmeticOperator.fromSymbol(operatorSymbol);  // 기호로 연산자 찾기
            } catch (Exception e) {
                System.out.println("Invalid operator, Please enter a valid operator (+, -, *, /):");
                continue;
            }

            System.out.print("Enter a second number (or 'exit'): ");
            String input2 = scanner.next();
            if (input2.equalsIgnoreCase("exit")) break;

            double b;
            try {
                b = Double.parseDouble(input2);  // 문자열을 double로 변환
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                continue;
            }

            try {
                double result = calculator.calculate(a, b, operator);  // 계산 수행
                System.out.println("= " + result);  // 결과 출력
            } catch (Exception e) {
                System.out.println("Invalid input" + e.getMessage());
                continue;
            }

            // 결과 디버깅 출력
            boolean debug = true;
            if (debug) {
                System.out.println("Max: " + safeGet(() -> calculator.getMaxResult()));
                System.out.println("Min: " + safeGet(() -> calculator.getMinResult()));
                System.out.println("Sum: " + calculator.getSumResult());
            }

            System.out.println("List of results: " + calculator.getResults());
            System.out.println();
        }

        System.out.println("Exiting...");
    }

    // Optional을 반환하는 계산 결과를 안전하게 출력하는 메서드
    private static String safeGet(Supplier<Optional<Double>> supplier) {
        try {
            return supplier.get()
                    .map(Object::toString)
                    .orElse("N/A");
        } catch (Exception e) {
            return "Error";
        }
    }

    // 예외를 던질 수 있는 계산식에 대한 안전한 출력 메서드
    private static String safeGet(SupplierWithException<Double> supplier) {
        try {
            return String.valueOf(supplier.get());
        } catch (Exception E) {
            return "Invalid input";
        }
    }

    // 예외를 던질 수 있는 함수형 인터페이스 정의
    @FunctionalInterface
    interface SupplierWithException<T> {
        T get() throws Exception;
    }
}
```

---

## ✅ 2. 개념 정리표 (등장 키워드 해설)

| 키워드/구문 | 설명 | 예시 |
|-------------|------|------|
| `Scanner` | 사용자 입력을 받을 때 사용하는 클래스 | `new Scanner(System.in)` |
| `next()` | 단어(토큰) 단위로 입력 받음 | `scanner.next()` |
| `Double.parseDouble()` | 문자열을 실수로 변환 | `"3.14" → 3.14` |
| `try-catch` | 예외 발생 가능성 있는 코드 보호 | `try { ... } catch (Exception e) { ... }` |
| `NumberFormatException` | 숫자 파싱 실패 시 발생하는 예외 | `Double.parseDouble("abc")` |
| `ArithmeticOperator.fromSymbol()` | 연산자 기호로 Enum 객체 추출 | `"+" → ArithmeticOperator.PLUS` |
| `Optional` | 값이 있을 수도, 없을 수도 있는 컨테이너 객체 | `Optional.of(3.0)` |
| `Supplier<T>` | 값을 공급(리턴)하는 함수형 인터페이스 | `() -> 5.0` |
| `map()` | Optional 내부 값 변환 | `Optional.of(3.0).map(v -> v + 1)` |
| `orElse()` | 값 없을 때 기본값 반환 | `.orElse("N/A")` |
| `SupplierWithException<T>` | 예외를 던질 수 있는 Supplier 인터페이스 | 사용자 정의 |

---

## ✅ 3. 구조 요약

```text
사용자 입력 → 연산자 파싱 → 숫자 파싱 → 계산 수행
   ↓            ↓            ↓           ↓
 String     fromSymbol()   parseDouble()   calculate()
```

---

## ✅ 4. 개선 사항 및 확장 가능성

| 항목 | 설명 |
|------|------|
| `safeGet` 중복 | `Optional` 기반 버전 하나만 남기고 통합 가능 |
| 디버깅 모드 `debug` | true/false 설정을 통해 전체 로그 출력 제어 가능 |
| 연산 기록 | `calculator.getResults()`를 활용해 히스토리 저장 가능 |

---

이 문서는 App.java의 최종 완성된 구조를 중심으로, 사용자 입력 처리 → 연산자 해석 → 예외 처리 → 결과 출력 → 디버깅까지 전체 흐름을 모두 정리한 문서입니다.