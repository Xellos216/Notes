import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppGUI extends JFrame {
    private JTextField display;
    private CalculatorV2GUI calculator;

    private int firstNum = 0;
    private char operator = ' ';
    private boolean isOperatorClicked = false;

    public AppGUI() {
        calculator = new CalculatorV2GUI();
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel buttonPanel = createButtonPanel();

        this.setLayout(new BorderLayout());
        this.add(display, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);

        this.setTitle("Calculator V2 GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        this.setVisible(true);
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String button : buttons) {
            JButton btn = new JButton(button);
            btn.setFont(new Font("Arial", Font.PLAIN, 20));
            btn.addActionListener(new ButtonClickListener());
            panel.add(btn);
        }
        return panel;
    }

    // 버튼 클릭 이벤트 처리
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = ((JButton) e.getSource()).getText();

            if ("0123456789".contains(cmd)) {
                if (isOperatorClicked) {
                    display.setText("");
                    isOperatorClicked = false;
                }
                display.setText(display.getText() + cmd);
            } else if ("+-*/".contains(cmd)) {
                firstNum = Integer.parseInt(display.getText());
                operator = cmd.charAt(0);
                isOperatorClicked = true;
            } else if ("=".equals(cmd)) {
                int secondNum = Integer.parseInt(display.getText());
                int result = calculator.calculate(firstNum, secondNum, operator);
                display.setText(String.valueOf(result));
            } else if ("C".equals(cmd)) {
                display.setText("");
                firstNum = 0;
                operator = ' ';
                isOperatorClicked = false;
            }
        }
    }

    public static void main(String[] args) {
        new AppGUI();
    }
}
