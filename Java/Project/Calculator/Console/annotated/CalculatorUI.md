# 📘 CalculatorUI.java (입력/출력 담당 클래스) 주석 & 개념 정리

---

## ✅ 1. 전체 코드 (상세 주석 포함)

```java
package ui;

import model.ArithmeticOperator;
import java.util.Scanner;
import java.util.List;

public class CalculatorUI {
    private final Scanner scanner = new Scanner(System.in);  // 사용자 입력용 스캐너

    public void printWelcome() {
        System.out.println("=== Calculator ===");  // 시작 메시지
    }

    // 숫자 입력 처리 메서드 (문자 입력 → 재귀 호출)
    public Double readNumber(String prompt) {
        System.out.print(prompt);
        String input = scanner.next();
        if (input.equalsIgnoreCase("exit")) return null;

        try {
            return Double.parseDouble(input);  // 문자열 → double 변환
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input");
            return readNumber(prompt);  // 잘못된 입력 → 재입력 요청
        }
    }

    // 연산자 입력 처리 메서드
    public ArithmeticOperator readOperator(String prompt) {
        System.out.print(prompt);
        String symbol = scanner.next();
        try {
            return ArithmeticOperator.fromSymbol(symbol);  // 입력 기호 → Enum 변환
        } catch (IllegalArgumentException E) {
            System.out.println("Invalid operator:");
        }
        return null;
    }

    // 결과 출력 (소수점 5자리 고정)
    public void printResult(double result) {
        System.out.println(String.format("= %.5f", result));
    }

    // 히스토리 출력
    public void printHistory(List<Double> results) {
        System.out.println();
        System.out.println("[ History ] ");
        System.out.print("[ ");
        for (int i = 0; i < results.size(); i++) {
            System.out.print(String.format("%.5f", results.get(i)));
            if (i < results.size() - 1) System.out.print(", ");
        }
        System.out.println(" ]");
        System.out.println();
    }

    // 통계 정보 출력
    public void printDebug(service.ArithmeticCalculator calc) {
        System.out.println();
        System.out.println("[ Stats from previous results ]");
        System.out.println("Max result: " + String.format("%.5f", calc.getMaxResult()));
        System.out.println("Min result: " + String.format("%.5f", calc.getMinResult()));
        System.out.println("Sum of all results: " + String.format("%.5f", calc.getSumResult()));
    }

    // 오류 메시지 출력
    public void printError(String message) {
        System.out.println("[Error] " + message);
    }

    // 종료 메시지 출력
    public void printExit() {
        System.out.println("Exiting calculator...");
    }
}
```

---

## ✅ 2. 핵심 개념 정리

| 항목 | 설명 | 예시 |
|------|------|------|
| `Scanner` | 사용자 입력 수신 객체 | `new Scanner(System.in)` |
| `readNumber()` | 숫자 입력 처리, 재귀로 유효성 검사 | `"3.5"` → `3.5` |
| `readOperator()` | 연산자 입력 처리 → Enum으로 변환 | `"+" → ArithmeticOperator.PLUS` |
| `String.format("%.5f")` | 출력 시 소수점 5자리 고정 | `"= 3.14159"` |
| `printHistory()` | 결과 누적 리스트 출력 | `[ 3.00000, 7.48121 ]` |
| `printDebug()` | Max / Min / Sum 자동 출력 | 통계용 |

---

## ✅ 3. 출력 흐름 요약

```text
[입력] readNumber / readOperator
   ↓
[출력] printResult
   ↓
[디버깅] printDebug (조건부)
   ↓
[이력] printHistory
```

---

## ✅ 4. 확장 및 개선 포인트

| 항목 | 설명 |
|------|------|
| 출력 포맷 일관성 | 모든 숫자 출력은 `%.5f`로 통일 |
| 재귀 입력 처리 | `readNumber()`는 잘못된 입력 시 재귀로 재요청 |
| UI 책임 분리 | 계산 로직과 완전히 분리된 순수 출력/입력 클래스 |
| 테스트 용이 | 입출력이 분리되어 단위 테스트 설계 쉬움 |
| 향후 GUI 확장 시 | UI 전환 시 이 클래스를 교체하거나 확장 가능함 |

---

이 문서는 `CalculatorUI.java`의 사용자 입력 및 출력 책임, 구조 흐름, 그리고 향후 확장 포인트를 중심으로 주석 정리한 문서입니다.
