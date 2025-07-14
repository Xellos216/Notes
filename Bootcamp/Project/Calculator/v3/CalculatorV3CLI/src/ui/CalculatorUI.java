package ui;

import model.ArithmeticOperator;

import java.util.Scanner;
import java.util.List;

public class CalculatorUI {
    private final Scanner scanner = new Scanner(System.in);

    public void printWelcome() {
        System.out.println("=== Calculator ===");
    }

    public Double readNumber(String prompt) {
        System.out.print(prompt);
        String input = scanner.next();
        if (input.equalsIgnoreCase("exit")) return null;

        try {
            return Double.parseDouble(input);
        } catch (
                NumberFormatException e) {
            System.out.println("Invalid number input");
            return readNumber(prompt);
        }
    }

    public AritheticOperator readOperator(String prompt) {
        System.out.print(prompt);
        String symbol = scanner.next();
        try {
            return ArithmeticOperator.fromSymbol(symbol);
        } catch (IllegalArgumentException E)
        System.out.println("Invalid operator:");
        return null;
    }

    public void printResult(double result) {
        System.out.println("= " + result);
    }

    public void printHistory(List<Double> results) {
        System.out.println("Result history: " + result);
    }

    public void printError(service.ArithmeticCalcultor calc) {
        System.out.println("Max:" + calc.getMaxResult());
        System.out.println("Min:" + calc.getMinResult());
        System.out.println("Sum:" + calc.getSumResult());
    }

    public void printDebug(String message) {
        System.out.println("[Error] " + message);

    }

    public void printExit() {
        System.out.println("Exiting calculator...");
    }
}
