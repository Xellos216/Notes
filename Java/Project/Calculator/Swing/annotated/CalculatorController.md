# 📘 CalculatorController.java (컨트롤러 클래스) 주석 & 구조 정리

---

## ✅ 1. 전체 코드 (상세 주석 포함)

```java
package controller;

import view.CalculatorView;  // View와 연결
import model.ArithmeticCalculator;  // 연산 처리 클래스

import javax.swing.*;
import java.awt.event.*;

// 사용자 이벤트를 감지하고 처리하는 컨트롤러 클래스
public class CalculatorController {

    private CalculatorView view;  // View 참조
    private String currentInput = "";  // 현재 입력 중인 숫자
    private String operator = "";  // 현재 연산자
    private double operand1 = 0;  // 첫 번째 피연산자
    private boolean resetInput = false;  // 다음 입력 시 초기화 여부

    // 생성자: View를 받아 이벤트 리스너 설정
    public CalculatorController(CalculatorView view) {
        this.view = view;
        attachEventListener();
        view.getHistoryClearButton().addActionListener(e -> view.clearHistory());
    }

    // 버튼 및 키 이벤트 연결
    private void attachEventListener() {
        for (JButton btn : view.getNumberButtons()) {
            String text = btn.getText();
            btn.addActionListener(e -> appendInput(btn.getText()));
        }

        view.getDotButton().addActionListener(e -> appendInput("."));
        view.getClearButton().addActionListener(e -> clearAll());

        view.getAddButton().addActionListener(e -> setOperator("+"));
        view.getSubtractButton().addActionListener(e -> setOperator("-"));
        view.getMultiplyButton().addActionListener(e -> setOperator("*"));
        view.getDivideButton().addActionListener(e -> setOperator("/"));
        view.getPowerButton().addActionListener(e -> setOperator("^"));
        view.getSqrtButton().addActionListener(e -> calculateSqrt());

        view.getEqualButton().addActionListener(e -> evaluate());

        // 백스페이스 키 등록
        view.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
            .put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "backspace");

        view.setBackspaceListener(e -> handleBackspace());

        view.getRootPane().getActionMap().put("backspace", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleBackspace();
            }
        });
    }

    // 숫자 및 점(.) 입력 처리
    private void appendInput(String text) {
        if (resetInput) {
            currentInput = "";
            resetInput = false;
        }

        currentInput += text;

        if (!operator.isEmpty()) {
            view.updateResultLabel(operand1 + " " + operator + " " + currentInput);
        } else {
            view.updateResultLabel(currentInput);
        }
    }

    // 연산자 버튼 클릭 시 처리
    private void setOperator(String op) {
        if (!currentInput.isEmpty()) {
            operand1 = Double.parseDouble(currentInput);
            operator = op;
            view.updateResultLabel(currentInput + " " + operator);
            resetInput = true;
        }
    }

    // = 버튼 클릭 시 계산 수행
    private void evaluate() {
        try {
            if (operator == null || operator.isEmpty()) {
                view.updateResultLabel("No operator");
                return;
            }
            if (currentInput.isEmpty()) {
                view.updateResultLabel("No second number");
                return;
            }

            double operand2 = Double.parseDouble(currentInput);
            double result = ArithmeticCalculator.calculate(operand1, operator, operand2);
            view.updateResultLabel(String.valueOf(result));
            view.appendToHistory(operand1 + " " + operator + " " + operand2 + " = " + result);
            currentInput = String.valueOf(result);
            resetInput = true;
            operator = "";

        } catch (ArithmeticException e) {
            view.updateResultLabel("Arithmetic error: " + e.getMessage());
        } catch (NumberFormatException e) {
            view.updateResultLabel("Invalid number format");
        } catch (IllegalArgumentException e) {
            view.updateResultLabel("Unsupported op: " + operator);
        } catch (Exception e) {
            e.printStackTrace();
            view.updateResultLabel("Unknown error");
        }
    }

    // 제곱근 연산 처리
    private void calculateSqrt() {
        try {
            double operand = Double.parseDouble(currentInput);
            double result = ArithmeticCalculator.calculate(operand, "sqrt", null);
            view.updateResultLabel(String.valueOf(result));
            view.appendToHistory("√" + operand + " = " + result);
            currentInput = String.valueOf(result);
            resetInput = true;
        } catch (Exception e) {
            view.updateResultLabel("error");
        }
    }

    // 백스페이스 입력 처리
    private void handleBackspace() {
        if (!currentInput.isEmpty() && !resetInput) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            if (currentInput.isEmpty()) currentInput = "0";
            view.updateResultLabel(currentInput);
        }
    }

    // 전체 초기화
    private void clearAll() {
        currentInput = "";
        operator = "";
        operand1 = 0;
        view.updateResultLabel("0");
    }
}
```

---

## ✅ 2. 핵심 개념 정리

| 항목 | 설명 | 예시 |
|------|------|------|
| `appendInput()` | 숫자 및 점(.) 입력 시 처리 | `"3"` 입력 시 → `currentInput += "3"` |
| `setOperator()` | 연산자 버튼 클릭 처리 | `"+"`, `"*"` 등 |
| `evaluate()` | `=` 버튼 클릭 → 결과 계산 및 출력 |
| `calculateSqrt()` | 단항 연산 (`sqrt`) 처리 |
| `handleBackspace()` | 백스페이스 키 입력 처리 |
| `resetInput` | 연산 후 새 입력 여부 제어용 boolean |

---

## ✅ 3. 사용자 입력 → 계산 흐름 요약

```text
버튼 클릭 or 키보드 입력
   ↓
appendInput() or setOperator() or evaluate()
   ↓
ArithmeticCalculator.calculate(...) 호출
   ↓
View 업데이트 및 결과 히스토리 저장
```

---

## ✅ 4. 유지보수 포인트

| 항목 | 설명 |
|------|------|
| 이벤트 중심 구조 | Swing의 리스너 구조를 잘 활용 |
| `resetInput` 플래그 | 입력 흐름 제어에 핵심 역할 |
| 예외 처리 | 사용자의 잘못된 입력 및 0 나누기 처리 |
| 키보드 입력 연동 | `KeyStroke`, `ActionMap` 활용 |

---

이 클래스는 **사용자 입력 → 계산 로직 실행 → 결과 출력**이라는 전반적인 흐름을 제어하는 핵심 컨트롤러입니다.
