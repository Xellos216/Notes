import java.rmi.server.ExportException;
import java.util.Scanner;
import java.util.Optional;
import java.util.function.Supplier;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();

        System.out.println("=== Calculator ===");

        ArithmeticOperator operator = null;

        while (true) {
            System.out.print("Enter a first number (or 'exit'): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("exit")) break;

            double a;
            try {
                a = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                continue;
            }

            System.out.print("Enter an operator (+, -, *, /): ");
            String operatorSymbol = scanner.next();

            try {
                operator = ArithmeticOperator.fromSymbol(operatorSymbol);
            } catch (Exception e) {
                System.out.println("Invalid operator, Please enter a valid operator (+, -, *, /):");
                continue;
            }

            System.out.print("Enter a second number (or 'exit'): ");
            String input2 = scanner.next();
            if (input2.equalsIgnoreCase("exit")) break;

            double b;
            try {
                b = Double.parseDouble(input2);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                continue;
            }

            try {
                double result = calculator.calculate(a, b, operator);
                System.out.println("= " + result);
            } catch (Exception e) {
                System.out.println("Invalid input" + e.getMessage());
                continue;
            }


            boolean debug = true;
            if (debug) {
                System.out.println("Max: " + safeGet(() -> calculator.getMaxResult()));
                System.out.println("Min: " + safeGet(() -> calculator.getMinResult()));
                System.out.println("Sum: " + calculator.getSumResult());
            }


            System.out.println("List of results: " + calculator.getResults());
            System.out.println();
        }

        System.out.println("Exiting...");
    }

    // safeGet 메서드
    private static String safeGet(Supplier<Optional<Double>> supplier) {
        try {
            return supplier.get()
                    .map(Object::toString)
                    .orElse("N/A");
        } catch (Exception e) {
            return "Error";
        }
    }

    // 예외 방지를 위한 래퍼 함수형 인터페이스
    private static String safeGet(SupplierWithException<Double> supplier) {
        try {
            return String.valueOf(supplier.get());
        } catch (Exception E) {
            return "Invalid input";
        }
    }

    @FunctionalInterface
    interface SupplierWithException<T> {
        T get() throws Exception;
    }
}

