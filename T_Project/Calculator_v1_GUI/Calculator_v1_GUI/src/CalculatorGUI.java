import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JTextField num1Field = new JTextField(5);
        JTextField num2Field = new JTextField(5);
        JComboBox<String> operatorBox = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        JButton calcButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel("Result: ");

        JPanel panel = new JPanel();
        panel.add(num1Field);
        panel.add(operatorBox);
        panel.add(num2Field);
        panel.add(calcButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);

        calcButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(num1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());
                String op = (String) operatorBox.getSelectedItem();
                int result = 0;

                switch (op) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            resultLabel.setText("Cannot divide by 0");
                            return;
                        }
                        result = num1 / num2;
                        break;
                }
                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException error) {
                resultLabel.setText("Invalid input");
            }
        });

    }
}