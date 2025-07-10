# 🪟 GUI Calculator (Swing)

이 프로젝트는 Java의 Swing 라이브러리를 활용하여 구현한 GUI 계산기입니다.  
텍스트 필드, 콤보박스, 버튼을 통해 사용자와 상호작용하며 사칙연산을 수행합니다.

## ✅ 기능

- 두 정수를 입력받아 +, -, *, / 연산 수행
- 0으로 나누기 예외 처리
- 숫자가 아닌 입력 예외 처리
- 결과는 GUI의 라벨에 출력

## 🛠 실행 방법

```bash
javac CalculatorGUI.java
java CalculatorGUI
```

## 💡 사용 예시

- 숫자 2개 입력
- 연산자 선택 (콤보박스)
- [Calculate] 버튼 클릭 → 결과 출력

## 📁 파일 설명

- `CalculatorGUI.java` : 전체 GUI 구현이 포함된 클래스
- `Calculator_GUI_Annotated.md` : 주석이 포함된 상세 코드 설명 문서

## 🔖 학습 포인트

- Java Swing 기초 구성 (JFrame, JPanel, JTextField, JComboBox, JButton, JLabel)
- 레이아웃 구성과 이벤트 처리 (ActionListener)


---

# 🪟 GUI Calculator (Annotated)

```java
import javax.swing.*;  // GUI 컴포넌트 클래스
import java.awt.*;     // 레이아웃 관련
import java.awt.event.*; // 이벤트 처리 관련

public class CalculatorGUI {
    public static void main(String[] args) {
        // 창 생성 및 설정
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // X버튼 누르면 종료
        frame.setSize(300, 200);  // 창 크기 설정

        // 입력창 2개
        JTextField num1Field = new JTextField(5);
        JTextField num2Field = new JTextField(5);

        // 연산자 선택 콤보박스
        JComboBox<String> operatorBox = new JComboBox<>(new String[]{"+", "-", "*", "/"});

        // 계산 버튼
        JButton calcButton = new JButton("Calculate");

        // 결과 출력 라벨
        JLabel resultLabel = new JLabel("Result: ");

        // 컴포넌트를 담을 패널
        JPanel panel = new JPanel();  // 기본 FlowLayout
        panel.add(num1Field);       // 첫 번째 숫자 입력창
        panel.add(operatorBox);     // 연산자 선택
        panel.add(num2Field);       // 두 번째 숫자 입력창
        panel.add(calcButton);      // 계산 버튼
        panel.add(resultLabel);     // 결과 출력

        // 패널을 프레임에 추가하고 보이게 설정
        frame.add(panel);
        frame.setVisible(true);

        // 버튼 클릭 이벤트 정의
        calcButton.addActionListener(e -> {
            try {
                // 입력값을 문자열에서 정수로 변환
                int num1 = Integer.parseInt(num1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());
                String op = (String) operatorBox.getSelectedItem();  // 연산자 추출
                int result = 0;

                // switch로 연산 처리
                switch (op) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/":
                        if (num2 == 0) {
                            // 0으로 나눌 경우 GUI에 메시지 출력
                            resultLabel.setText("Cannot divide by 0");
                            return;
                        }
                        result = num1 / num2; break;
                }

                // 연산 결과 출력
                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                // 숫자가 아닌 값이 들어온 경우 처리
                resultLabel.setText("Invalid input");
            }
        });
    }
}
```
