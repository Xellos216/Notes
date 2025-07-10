# 🧮 CLI Calculator V2 (Class-based)

이 프로젝트는 Java 클래스를 활용하여 구현한 콘솔 기반 계산기 프로그램입니다.  
Lv1 버전에서 구조를 개선하여, `Calculator` 클래스를 별도로 분리하고 연산 결과를 내부적으로 저장·관리하는 기능을 추가하였습니다.

---

## ✅ 주요 기능

- 두 정수와 연산자(+, -, *, /)를 입력받아 사칙연산 수행
- 연산 결과를 `List<Integer>` 형태로 누적 저장
- 저장된 결과 전체 출력 기능
- 가장 오래된 결과 삭제 기능 (FIFO 방식)
- `"exit"` 입력 시 계산 반복 종료
- 잘못된 숫자 및 연산자 입력에 대한 예외 처리

---

## 🛠 실행 방법

```bash
javac App.java CalculatorV2CLI.java
java App
```

---

## 💡 사용 예시

```text
=== Calculator Menu===
1.Calculate
2.Return saved one
3.Remove last result
4.Exit
Enter your choice: 1

Enter first number(or exit): 10
Enter operator (+, -, *, /): *
Enter second number: 3
Result: 30

Enter first number(or exit): exit

=== Calculator Menu===
2.Return saved one
Saved list:
1) 30

3.Remove last result
4.Exit
```

---

## 📁 파일 설명

| 파일명 | 설명 |
|--------|------|
| `App.java` | 메인 실행 클래스 (메뉴, 사용자 입력 처리) |
| `CalculatorV2CLI.java` | 연산 수행, 결과 저장 및 삭제 기능을 담당하는 클래스 |

---

## 🔖 학습 포인트

- Java 클래스와 메서드 분리 설계
- 컬렉션(`List`)을 활용한 결과 저장 및 순차 삭제
- 예외 처리 (`try-catch`, `NumberFormatException`)
- 콘솔 입력 반복 처리 (`Scanner`, `while`)
- 정보 은닉 및 Getter 활용 (캡슐화 원칙 적용)

---

## 📌 향후 확장 아이디어

- `double` 실수 연산 지원
- 결과를 파일로 저장하거나 불러오기
- GUI 기반 계산기 또는 REST API 계산기 버전 확장
- 단위 테스트(JUnit) 추가

---

# 📄 CalculatorV2CLI.java (Annotated Version)

```java
import java.util.ArrayList;
import java.util.List;

public class CalculatorV2CLI {
    // 연산 결과를 저장하는 컬렉션 (외부에서 직접 접근 불가)
    private List<Integer> results = new ArrayList<>();

    // 사칙연산을 수행하는 메서드
    public int calculate(int num1, int num2, char operator) {
        int result = 0;

        // 연산자에 따라 연산 수행
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                // 0으로 나누는 경우 예외 처리
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Cannot divide by zero");
                }
                break;
            default:
                // 지원하지 않는 연산자 처리
                System.out.println("Unsupported operator");
                return 0;
        }

        // 계산된 결과를 리스트에 저장
        results.add(result);
        return result;
    }

    // 가장 오래된 연산 결과를 삭제하는 메서드
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0); // FIFO 방식으로 삭제
        } else {
            System.out.println("No results to remove");
        }
    }

    // Getter: 외부에서 결과 목록을 읽을 수 있도록 제공 (복사본 반환)
    public List<Integer> getResults() {
        return new ArrayList<>(results); // 원본 보호
    }
}
```

---

# 📄 App.java (Annotated Version)

```java
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 사용자 입력을 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // CalculatorV2CLI 클래스의 인스턴스 생성 (연산 기능 담당)
        CalculatorV2CLI calc = new CalculatorV2CLI();

        boolean running = true; // 메인 루프 제어 플래그

        while (running) {
            // 메인 메뉴 출력
            System.out.println("=== Calculator Menu===");
            System.out.println("1.Calculate");
            System.out.println("2.Return saved one");
            System.out.println("3.Remove last result");
            System.out.println("4.Exit");
            System.out.print("Enter your choice: ");

            int menu = sc.nextInt(); // 사용자 메뉴 선택 입력

            switch (menu) {
                case 1:
                    // 계산 기능 반복 루프 (사용자가 'exit' 입력 전까지 계속)
                    while (true) {
                        System.out.print("Enter first number(or exit): ");
                        String input = sc.next(); // 숫자 또는 'exit' 입력

                        // 'exit' 입력 시 계산 루프 종료
                        if (input.equalsIgnoreCase("exit")) {
                            break;
                        }

                        try {
                            // 문자열을 정수로 변환
                            int num1 = Integer.parseInt(input);

                            System.out.print("Enter operator (+, -, *, /): ");
                            char op = sc.next().charAt(0); // 연산자 입력

                            System.out.print("Enter second number: ");
                            int num2 = sc.nextInt(); // 두 번째 숫자 입력

                            // 계산 수행 및 결과 출력
                            int result = calc.calculate(num1, num2, op);
                            System.out.println("Result: " + result);
                        } catch (NumberFormatException e) {
                            // 잘못된 숫자 입력에 대한 예외 처리
                            System.out.println("Invalid input, Please enter a number or 'exit'");
                        }

                        sc.nextLine(); // 버퍼 정리
                    }
                    break;

                case 2:
                    // 저장된 결과 리스트 가져오기
                    List<Integer> results = calc.getResults();

                    // 결과가 비어있을 경우 안내 메시지 출력
                    if (results.isEmpty()) {
                        System.out.println("No results to return");
                    } else {
                        // 저장된 결과 리스트 출력
                        System.out.println("Saved list:");
                        for (int i = 0; i < results.size(); i++) {
                            System.out.println((i + 1) + ") " + results.get(i));
                        }
                    }
                    break;

                case 3:
                    // 가장 오래된 결과 삭제 (FIFO 방식)
                    calc.removeResult();
                    break;

                case 4:
                    // 프로그램 종료
                    running = false;
                    System.out.println("Exiting...");
                    break;
            }
        }

        // Scanner 리소스 정리
        sc.close();
    }
}
```

---
