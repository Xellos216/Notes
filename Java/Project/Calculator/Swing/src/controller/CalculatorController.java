package controller;

import view.CalculatorView;

import model.ArithmeticCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class CalculatorController {

    private CalculatorView view;

    private String currentInput = "";
    private String operator = "";
    private double operand1 = 0;
    private boolean resetInput = false;

    public CalculatorController(CalculatorView view) {
        this.view = view;
        attachEventListener();
        view.getHistoryClearButton().addActionListener(e -> view.clearHistory());
    }

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

    private void appendInput(String text) {
        if (resetInput) {
            currentInput = "";     // ← 여기서만 clear
            resetInput = false;
        }

        currentInput += text;

        if (!operator.isEmpty()) {
            view.updateResultLabel(operand1 + " " + operator + " " + currentInput);
        } else {
            view.updateResultLabel(currentInput);
        }
    }



    private void setOperator(String op) {
        if (!currentInput.isEmpty()) {
            operand1 = Double.parseDouble(currentInput);
            operator = op;

            view.updateResultLabel(currentInput + " " + operator);
            resetInput = true;
        }
    }


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
            operator = ""; // ✅ 추가: 연산 후 오퍼레이터 초기화

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

    private void handleBackspace() {
        if (!currentInput.isEmpty() && !resetInput) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            if (currentInput.isEmpty()) currentInput = "0";
            view.updateResultLabel(currentInput);
        }
    }


    private void clearAll() {
        currentInput = "";
        operator = "";
        operand1 = 0;
        view.updateResultLabel("0");
    }


}
