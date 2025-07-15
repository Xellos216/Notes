# 📘 Main.java (V3CLI 실행 진입점) 주석 & 개념 정리

---

## ✅ 1. 전체 코드 (상세 주석 포함)

```java
import service.ArithmeticCalculator;
import model.ArithmeticOperator;
import ui.CalculatorUI;
import util.SafeRunner;

public class Main {
    public static final boolean DEBUG = true;  // 디버그 모드 설정

    public static void main(String[] args) {
        CalculatorUI ui = new CalculatorUI();  // UI 클래스 생성
        ArithmeticCalculator calculator = new ArithmeticCalculator();  // 계산기 로직 객체

        ui.printWelcome();  // 시작 인사 출력

        while (true) {
            // 첫 번째 숫자 입력 (exit 입력 시 종료)
            Double a = ui.readNumber("Enter first number (or 'exit'):");
            if (a == null) break;

            // 연산자 입력 (null일 경우 계속 반복)
            ArithmeticOperator op = null;
            while (op == null) {
                op = ui.readOperator("Enter operator (+, -, *. /, ^, sqrt):");
            }

            // 단항 연산자(sqrt)인 경우 → 두 번째 입력 없이 계산 수행
            if (op.isUnary()) {
                try {
                    double result = calculator.calculate(a, 0, op);
                    ui.printResult(result);  // 결과 출력
                    if (DEBUG) ui.printDebug(calculator);  // 통계 출력
                } catch (Exception e) {
                    ui.printError("Calculation error: " + e.getMessage());
                }
                ui.printHistory(calculator.getResults());  // 히스토리 출력
                continue;
            }

            // 두 번째 숫자 입력
            Double b = ui.readNumber("Enter second number (or 'exit'):");
            if (b == null) break;

            // 계산 및 출력
            try {
                double result = calculator.calculate(a, b, op);
                ui.printResult(result);
                if (DEBUG) ui.printDebug(calculator);
            } catch (Exception e) {
                ui.printError("Calculation error: " + e.getMessage());
            }

            ui.printHistory(calculator.getResults());
        }

        ui.printExit();  // 종료 메시지 출력
    }
}
```

---

## ✅ 2. 개념 정리표

| 키워드/메서드 | 설명 | 예시 |
|---------------|------|------|
| `readNumber()` | 사용자로부터 숫자를 입력받음 | `ui.readNumber(...)` |
| `readOperator()` | 연산자 입력을 Enum으로 반환 | `"+" → ArithmeticOperator.PLUS` |
| `isUnary()` | 단항 연산자 여부 반환 | `sqrt → true` |
| `calculate()` | a, b, op을 받아 연산 수행 | `calculator.calculate(a, b, op)` |
| `printResult()` | 결과 출력 (소수점 5자리) | `"= 3.14159"` |
| `printDebug()` | 최대/최소/합 출력 | `ui.printDebug(...)` |
| `printHistory()` | 누적 결과 리스트 출력 | `ui.printHistory(...)` |

---

## ✅ 3. 구조 흐름 요약

```text
입력(숫자 a)
   ↓
연산자 선택 (잘못 입력시 재시도)
   ↓
단항인가?
 ┌────────────┐
 │  Yes       │────→ 계산 & 출력 → 통계 → 히스토리
 └────┬───────┘
      ↓ No
입력(숫자 b)
   ↓
계산 & 출력 → 통계 → 히스토리
```

---

## ✅ 4. 개선 및 확장 포인트

| 항목 | 설명 |
|------|------|
| 단항/이항 분기 | `isUnary()`로 명확히 나눠 코드 유지 용이 |
| 예외 처리 흐름 | 입력 오류/계산 오류를 별도로 감지하여 사용자 경험 향상 |
| UI/로직 분리 | `CalculatorUI`에서 모든 출력 책임 → 테스트 및 유지보수 용이 |
| DEBUG 모드 제어 | 상수로 디버깅 출력 여부 쉽게 조절 가능 (`true/false`) |

---

이 문서는 `Main.java`의 사용자 흐름 중심 CLI 인터페이스 구성 방식을 상세 주석 및 개념 정리와 함께 문서화한 것입니다.
