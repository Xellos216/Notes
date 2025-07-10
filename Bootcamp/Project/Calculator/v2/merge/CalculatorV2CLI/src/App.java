import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorV2CLI calc = new CalculatorV2CLI(); // 기존 클래스 사용

        boolean running = true;
        while (running) {
            // 메뉴 출력 및 사용자 입력 대기
            System.out.println("=== Calculator Menu===");
            System.out.println("1.Calculate");
            System.out.println("2.Return saved one");
            System.out.println("3.Remove last result");
            System.out.println("4.Exit");
            System.out.print("Enter your choice: ");
            int menu = sc.nextInt(); // 사용자 입력

            switch (menu) {
                case 1:
                    while (true) {
                        System.out.print("Enter first number(or exit): ");
                        String input = sc.next();

                        if (input.equalsIgnoreCase("exit")) {
                            break; // 계산 루프 종료 -> 메인 메뉴로
                        }
                        try {
                            int num1 = Integer.parseInt(input);

                            System.out.print("Enter operator (+, -, *, /): ");
                            char op = sc.next().charAt(0);
                            System.out.print("Enter second number: ");
                            int num2 = sc.nextInt();

                            int result = calc.calculate(num1, num2, op);
                            System.out.println("Result: " + result);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, Please enter a number or 'exit'");
                        }
                        sc.nextLine(); // flush buffer
                    }
                    break;

                case 2:
                    List<Integer> results = calc.getResults();
                    if (results.isEmpty()) {
                        System.out.println("No results to return");
                    } else {
                        System.out.println("Saved list:");
                        for (int i = 0; i < results.size(); i++) {
                            System.out.println((i + 1) + ") " + results.get(i));
                        }
                    }
                    break;

                case 3:
                    calc.removeResult(); // FIFO 방식으로 맨 앞의 결과 삭제
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;
            }
        }
        sc.close();
    }
}
