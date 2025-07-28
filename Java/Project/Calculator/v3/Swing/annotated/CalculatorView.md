# 📘 CalculatorView.java (GUI 구성 클래스) 주석 & 구조 정리

---

## ✅ 1. 전체 코드 (상세 주석 포함)

```java
package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;

// GUI 화면을 구성하는 View 클래스
public class CalculatorView extends JFrame {

    private JLabel resultLabel;  // 결과 출력 라벨

    // 숫자 및 연산 버튼
    private List<JButton> numberButtons = new ArrayList<>();
    private JButton dotButton, clearButton, equalButton;
    private JButton addButton, subtractButton, multiplyButton, divideButton;
    private JButton powerButton, sqrtButton, historyClearButton;

    private JTextArea historyArea;  // 계산 내역 표시 영역

    public CalculatorView() {
        super("Java Swing Calculator");  // 프레임 타이틀 설정
        setSize(400, 500);  // 창 크기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));  // 레이아웃 설정

        // 결과 출력 라벨 구성
        resultLabel = new JLabel("0", SwingConstants.RIGHT);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        resultLabel.setOpaque(true);
        resultLabel.setBackground(Color.WHITE);
        resultLabel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(resultLabel, BorderLayout.NORTH);

        // 버튼 영역 구성
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        addButtons(buttonPanel);
        add(buttonPanel, BorderLayout.CENTER);

        // 계산 내역 영역
        historyArea = new JTextArea(5, 20);
        historyArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyArea);
        add(scrollPane, BorderLayout.SOUTH);

        setupNumpadKeyBindings();  // 키보드 연동
        setVisible(true);
    }

    // 숫자 버튼 생성 후 패널에 추가
    private void addNumberButton(JPanel panel, String text, Font font) {
        JButton btn = new JButton(text);
        btn.setFont(font);
        numberButtons.add(btn);
        panel.add(btn);
    }

    // 일반 버튼 생성 후 패널에 추가
    private JButton createButton(String text, Font font, JPanel panel) {
        JButton btn = new JButton(text);
        btn.setFont(font);
        panel.add(btn);
        return btn;
    }

    public JButton getHistoryClearButton() { return historyClearButton; }
    public void clearHistory() { historyArea.setText(""); }

    private ActionListener backspaceListener;
    public void setBackspaceListener(ActionListener listener) {
        this.backspaceListener = listener;
    }

    // 버튼 구성 정의
    private void addButtons(JPanel panel) {
        Font btnFont = new Font("Arial", Font.PLAIN, 18);

        addNumberButton(panel, "7", btnFont);
        addNumberButton(panel, "8", btnFont);
        addNumberButton(panel, "9", btnFont);
        divideButton = createButton("/", btnFont, panel);

        addNumberButton(panel, "4", btnFont);
        addNumberButton(panel, "5", btnFont);
        addNumberButton(panel, "6", btnFont);
        multiplyButton = createButton("*", btnFont, panel);

        addNumberButton(panel, "1", btnFont);
        addNumberButton(panel, "2", btnFont);
        addNumberButton(panel, "3", btnFont);
        subtractButton = createButton("-", btnFont, panel);

        addNumberButton(panel, "0", btnFont);
        dotButton = createButton(".", btnFont, panel);
        equalButton = createButton("=", btnFont, panel);
        addButton = createButton("+", btnFont, panel);

        clearButton = createButton("C", btnFont, panel);
        powerButton = createButton("^", btnFont, panel);
        sqrtButton = createButton("√", btnFont, panel);
        historyClearButton = createButton("HC", btnFont, panel);
    }

    // 숫자 키패드 입력 바인딩
    private void setupNumpadKeyBindings() {
        JRootPane root = getRootPane();
        InputMap im = root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = root.getActionMap();

        for (int i = 0; i <= 9; i++) {
            final String key = String.valueOf(i);
            im.put(KeyStroke.getKeyStroke("NUMPAD" + i), "numpad_" + key);
            am.put("numpad_" + key, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (JButton btn : numberButtons) {
                        if (btn.getText().equals(key)) {
                            btn.doClick();
                            break;
                        }
                    }
                }
            });

            // 백스페이스 키 연동
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "numpad_backspace");
            am.put("numpad_backspace", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (backspaceListener != null) {
                        backspaceListener.actionPerformed(e);
                    }
                }
            });
        }

        // 연산자 키 연동
        bindKey(im, am, KeyStroke.getKeyStroke("ADD"), addButton);
        bindKey(im, am, KeyStroke.getKeyStroke("SUBTRACT"), subtractButton);
        bindKey(im, am, KeyStroke.getKeyStroke("MULTIPLY"), multiplyButton);
        bindKey(im, am, KeyStroke.getKeyStroke("DIVIDE"), divideButton);
        bindKey(im, am, KeyStroke.getKeyStroke("DECIMAL"), dotButton);

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "numpad_enter");
        am.put("numpad_enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equalButton.doClick();
            }
        });
    }

    // 키와 버튼 바인딩
    private void bindKey(InputMap im, ActionMap am, KeyStroke ks, JButton button) {
        String actionKey = "bind_" + ks.toString();
        im.put(ks, actionKey);
        am.put(actionKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.doClick();
            }
        });
    }

    // 버튼 접근자 메서드
    public List<JButton> getNumberButtons() { return numberButtons; }
    public JButton getDotButton() { return dotButton; }
    public JButton getClearButton() { return clearButton; }
    public JButton getEqualButton() { return equalButton; }
    public JButton getAddButton() { return addButton; }
    public JButton getSubtractButton() { return subtractButton; }
    public JButton getMultiplyButton() { return multiplyButton; }
    public JButton getDivideButton() { return divideButton; }
    public JButton getPowerButton() { return powerButton; }
    public JButton getSqrtButton() { return sqrtButton; }

    public void updateResultLabel(String text) {
        resultLabel.setText(text);
    }

    public void appendToHistory(String text) {
        historyArea.append(text + "\n");
    }
}
```

---

## ✅ 2. 핵심 개념 정리

| 항목 | 설명 | 예시 |
|------|------|------|
| `JFrame` | Swing GUI 창 기본 프레임 | `CalculatorView extends JFrame` |
| `JButton` | 숫자 및 연산자 버튼 생성 | `"7"`, `"+"` 등 |
| `JLabel` | 결과 출력 창 구성 | `updateResultLabel(...)` |
| `JTextArea` | 계산 내역 표시 영역 | `historyArea` |
| `InputMap`, `ActionMap` | 키보드 입력 바인딩 구조 | `KeyStroke`로 `JButton` 실행 |
| `setBackspaceListener()` | 백스페이스 동작 View 외부로 위임 가능 |

---

## ✅ 3. 구성 요약

```text
North: 결과 출력 JLabel
Center: GridLayout 기반 버튼들
South: JTextArea 계산 히스토리
```

---

## ✅ 4. 유지보수 포인트

| 항목 | 설명 |
|------|------|
| View 역할만 집중 | 로직 및 상태 처리 없음 (MVC 원칙 준수) |
| 키보드 입력 대응 | 키패드, 백스페이스, 엔터 등 풍부하게 연동 |
| 백스페이스 커스터마이징 | 외부 컨트롤러 위임 방식으로 유연하게 처리 |
| 버튼 추상화 잘 구성 | `createButton`, `addNumberButton` 등 재사용 구조 우수 |

---

이 클래스는 **Swing 기반 UI 구성 전담 View 계층**으로, 계산기 화면 요소(입력창, 버튼, 결과창, 히스토리)를 정의하며 키보드 입력까지 포괄적으로 처리합니다.
