package model;

public class ArithmeticCalculator {
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
                return Math.pow(operand1, operand2);
            case "sqrt":
                return Math.sqrt(operand1);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
