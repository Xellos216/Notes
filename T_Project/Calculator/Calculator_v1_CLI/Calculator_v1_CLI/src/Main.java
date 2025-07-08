import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the number: ");
            String input1 = scanner.next();

            if (input1.equals("exit")) break;

            System.out.println("Enter an operator (+, -, *, /) : ");
            String op = scanner.next();

            System.out.println("Enter the second number: ");
            String input2 = scanner.next();

            try {
                int num1 = Integer.parseInt(input1);
                int num2 = Integer.parseInt(input2);
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
                            System.out.println("Cannot divide by zero");
                            continue;
                        }
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("Unsupported operator");
                        continue;
                }

                        System.out.println("The result is: " + result);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                }
            }

            System.out.println("Calculator is shutting down");
    }
}