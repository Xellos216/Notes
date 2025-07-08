# 🖥️ CLI Calculator

이 프로젝트는 Java를 사용하여 구현한 콘솔 기반 계산기 프로그램입니다.  
간단한 사칙연산 기능을 제공하며, 사용자 입력을 받아 반복적으로 계산을 수행합니다.

## ✅ 기능

- 두 정수를 입력받아 +, -, *, / 연산 수행
- 0으로 나누기 예외 처리
- 잘못된 숫자 입력에 대한 예외 처리
- "exit" 입력 시 종료

## 🛠 실행 방법

```bash
javac Main.java
java Main
```

## 💡 사용 예시

```text
Enter the number: 5
Enter an operator (+, -, *, /) : *
Enter the second number: 3
The result is: 15
```

## 📁 파일 설명

- `Main.java` : 계산기 전체 로직이 포함된 진입점 클래스
- `Calculator_CLI_Annotated.md` : 상세한 주석이 포함된 코드 설명 문서

## 🔖 학습 포인트

- Scanner를 이용한 입력 처리
- 반복문과 조건문 (`while`, `switch`)
- 예외 처리 (`try-catch`)

---

# 🖥️ CLI Calculator (Annotated)

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // "exit"이 입력되기 전까지 반복 실행
        while (true) {
            System.out.print("Enter the number: ");
            String input1 = scanner.next();  // 첫 번째 숫자 또는 "exit" 입력 받기

            // 종료 조건
            if (input1.equals("exit")) break;

            System.out.print("Enter an operator (+, -, *, /) : ");
            String op = scanner.next();  // 연산자 입력

            System.out.print("Enter the second number: ");
            String input2 = scanner.next();  // 두 번째 숫자 입력

            try {
                // 문자열 입력을 정수로 변환
                int num1 = Integer.parseInt(input1);
                int num2 = Integer.parseInt(input2);
                int result = 0;

                // 연산자에 따라 조건 분기
                switch (op) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/":
                        if (num2 == 0) {
                            // 0으로 나눌 경우 예외 메시지 출력 후 다음 반복
                            System.out.println("Cannot divide by zero");
                            continue;
                        }
                        result = num1 / num2; break;
                    default:
                        // 지원하지 않는 연산자 입력 시 경고
                        System.out.println("지원하지 않는 연산자입니다.");
                        continue;
                }

                // 정상 결과 출력
                System.out.println("The result is: " + result);
            } catch (NumberFormatException e) {
                // 정수가 아닌 입력이 들어왔을 때 처리
                System.out.println("Please enter a valid number");
            }
        }

        // 프로그램 종료 메시지
        System.out.println("Calculator is shutting down");
    }
}
```
