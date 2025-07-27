# Chapter01

---

## Q01. Java의 공식 슬로건은 무엇일까요?

a. "Code Once, Run Everywhere"  
b. "Write Once, Run Anywhere"  
c. "Compile Once, Debug Forever"  
d. "Java: The Future of Programming"  

<details>
<summary>✅ 정답 보기</summary>

✔️ **b. "Write Once, Run Anywhere"**  
Java 프로그램은 한 번 작성하면 **운영체제(OS)에 관계없이 JVM에서 실행**될 수 있음을 의미합니다.

</details>

---

## Q02. 바이트코드는 어디에서 실행될까요?

<details>
<summary>✅ 정답 보기</summary>

✔️ **JVM이 해석하고 실행합니다.**

</details>

---

## Q03. Java 프로그램이 컴파일된 후 생성되는 파일의 확장자는 무엇일까요?

<details>
<summary>✅ 정답 보기</summary>

✔️ **.class**  
Javac(Java 컴파일러)가 `.java` 파일을 바이트코드(`.class`)로 변환합니다.

</details>

---

## Q04. Java를 만든 사람은 누구일까요?

a. 빌 게이츠 (Bill Gates)  
b. 제임스 고슬링 (James Gosling)  
c. 귀도 반 로섬 (Guido van Rossum)  
d. 데니스 리치 (Dennis Ritchie)  

<details>
<summary>✅ 정답 보기</summary>

✔️ **b. 제임스 고슬링 (James Gosling)**  
제임스 고슬링은 **Sun Microsystems에서 Java를 개발**했고 "Java의 아버지"로 불립니다.

</details>

---

## Q05. 1바이트(byte)는 몇 비트(bit)일까요?

<details>
<summary>✅ 정답 보기</summary>

✔️ **8비트 입니다.**  
256개(0~255) 개의 데이터를 저장할 수 있습니다.

</details>

---

## Q06. 1비트에 저장할 수 있는 데이터의 수는 몇 개일까요?

<details>
<summary>✅ 정답 보기</summary>

✔️ **2개 입니다.**  
1비트에는 0과 1 중에서 한 가지를 저장할 수 있습니다.

</details>

---

## Q07. 컴퓨터의 주기억장치는 무엇일까요?

a. RAM  
b. HDD  
c. USB 드라이브  

<details>
<summary>✅ 정답 보기</summary>

✔️ **a. 컴퓨터의 주기억장치는 RAM(메모리) 입니다.**

</details>

---

## Q08. 휘발성 메모리는 어떤 특징을 가질까요?

a. 전원이 꺼져도 데이터가 유지된다.  
b. 전원이 꺼지면 데이터가 사라진다.  
c. 데이터를 압축하여 저장한다.  

<details>
<summary>✅ 정답 보기</summary>

✔️ **b. 전원이 꺼지면 작업하던 내용이 사라집니다. 이를 휘발성 이라고 합니다.**

</details>

---

## Q09. 다음 중 올바른 자바 클래스 이름은?

1. Car  
2. myCar  
3. 2ndCar  
4. _Car  

<details>
<summary>✅ 정답 보기</summary>

✔️ **1. Car**  
자바 클래스 이름은 **대문자**로 시작하는 🐫**UpperCamelCase** 스타일이 권장됩니다.

</details>

---

## Q10. 자바 패키지 이름은 일반적으로 어떤 스타일로 사용되는가?

1. CamelCase  
2. snake_case  
3. kebab-case  
4. 소문자로 점(.)을 이용한 계층 구조  

<details>
<summary>✅ 정답 보기</summary>

✔️ **4. 소문자로 점(.)을 이용한 계층 구조**  
자바 패키지 이름은 일반적으로 **소문자**를 사용하며, 계층 구조를 표현하기 위해 **`.`** 을 사용합니다.  
- 예: `com.example.myapp`  
❌ CamelCase (대문자로 시작)나 snake_case (언더스코어 사용), kebab-case (하이픈 사용)는 자바 패키지 명명 규칙에 맞지 않습니다.

</details>

---

## Q11. `testpackage.Car` 클래스를 `Main` 클래스의 `main` 메서드에서 활용하려고 합니다. 올바른 import 방법은?

1. import testpackage.*;  
2. import Main.testpackage.Car;  
3. import testpackage.Car;  
4. import Car;  

<details>
<summary>✅ 정답 보기</summary>

✔️ **3. import testpackage.Car;**

- ❌ `testpackage.*`는 모든 클래스를 import 하므로 `Car`만 사용할 수는 없습니다. 필요하지 않은 클래스까지 Import가 되기 때문입니다.  
- ❌ 패키지 구조는 `testpackage.Car` 형태로 접근해야 하며 `Main`은 패키지명이 아닙니다.  
- ✅ 특정 클래스를 명확하게 import 하는 방식입니다.  
- ❌ `import Car`는 패키지명이 없으면 기본 패키지에서 찾으려 하지만, `Car` 클래스는 `testpackage`에 있기 때문에 찾을 수 없습니다.

</details>

---

## Q12. 변수 이름으로 사용할 수 없는 것은?

1. true  
2. car123  
3. myCar  
4. _car  

<details>
<summary>✅ 정답 보기</summary>

✔️ **1. true**  
Java의 예약어(`true`, `int`, `if`, `class` 등)는 변수 이름으로 사용할 수 없습니다.

</details>

---

## Q13. 변수 이름을 만들 때 올바른 규칙은?

1. 변수 이름은 숫자로 시작할 수 있다.  
2. 변수 이름에는 공백(띄어쓰기)이 포함될 수 있다.  
3. 변수 이름에는 특수문자(@, #, !)를 사용할 수 있다.  
4. 변수 이름은 영문자, 숫자, 언더스코어(`_`), `$` 만 사용할 수 있다.  

<details>
<summary>✅ 정답 보기</summary>

✔️ **4. 변수 이름은 영문자(a-z, A-Z), 숫자(0-9), `_`, `$` 만 사용 가능**

- ❌ 숫자로 시작할 수 없음! → `1stPlace` (오류)  
- ❌ 띄어쓰기 포함 불가! → `my car` (오류)  
- ❌ 특수문자 사용 불가! → `@car`, `car#name`, `speed!limit` (오류)

</details>

---

## Q14. 다음 중 변수 이름으로 사용해도 되는 것은?

1. myVariable  
2. int  
3. 1stPlace  
4. hello-world  

<details>
<summary>✅ 정답 보기</summary>

✔️ **1. myVariable**  
변수 이름은 첫 글자는 소문자 그리고 카멜케이스를 사용하는 것이 권장됩니다.

</details>

---

## Q15. 같은 이름을 가진 변수를 같은 중괄호 `{}` 안에 생성할 수 있을까요?

<details>
<summary>✅ 정답 보기</summary>

❌ **같은 중괄호 안에서 불가능**

```java
{
    int number = 10;
    int number = 20;  // 오류! 같은 블록에서 같은 이름의 변수 선언 불가
}
```

✅ **해결 방법: 변수명을 다르게 하거나, 값을 바꿀 때는 `=` 를 사용!**

```java
{
    int number = 10;
    number = 20;  // 올바른 코드 (값만 변경)
}
```

</details>

---

## Q16. 다음 코드의 출력 결과는?

```java
System.out.println("Java\nis\nfun!");
```

<details>
<summary>✅ 정답 보기</summary>

```
Java
is
fun!
```

`\n` 은 개행 문자이므로 각 단어가 한 줄씩 출력됩니다.

</details>

---

## Q17. 이름과 나이 입력받아 출력하는 프로그램 작성

> 새로운 클래스(`.java`)를 만들어서 진행하세요.

```java
import java.util.Scanner;

public class UserInfoPrinter {
    public static void main(String[] args) {
        // TODO: 사용자로부터 이름을 입력받기

        // TODO: 사용자로부터 나이를 입력받기

        // TODO: 입력받은 값 출력
    }
}
```

### 💡 예상 출력 예시:
```
이름을 입력하세요: gygim
나이를 입력하세요: 20

출력 결과:
이름: gygim
나이: 20
```

<details>
<summary>✅ 정답 보기</summary>

```java
import java.util.Scanner;

public class UserInfoPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: 사용자로부터 이름을 입력받기
        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();

        // TODO: 사용자로부터 나이를 입력받기
        System.out.print("나이를 입력하세요: ");
        int age = scanner.nextInt();

        // TODO: 입력받은 값 출력
        System.out.println("\n출력 결과:");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
    }
}
```

</details>

## Q18. 산술 연산자 문제

두 개의 정수 `a`, `b`가 주어졌을 때  
두 수의 **합, 차, 곱, 나누기, 나머지** 연산 결과를 변수에 저장한 후 출력하는 프로그램을 작성하세요.

```java
public class Main {
    public static void main(String[] args) {
        int a; // 값 할당 필요
        int b; // 값 할당 필요

        // 1. 더하기
        // 2. 빼기
        // ...
    }
}
```

### 💡 예상 출력:
```
덧셈 결과: 19
뺄셈 결과: 11
곱셈 결과: 60
나눗셈 결과: 3
나머지 결과: 3
```

<details>
<summary>✅ 정답 보기</summary>

```java
public class Main {
    public static void main(String[] args) {
        int a = 15;
        int b = 4;

        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        int quotient = a / b;
        int remainder = a % b;

        System.out.println("덧셈 결과: " + sum);
        System.out.println("뺄셈 결과: " + difference);
        System.out.println("곱셈 결과: " + product);
        System.out.println("나눗셈 결과: " + quotient);
        System.out.println("나머지 결과: " + remainder);
    }
}
```

</details>

---

## Q19. 비교 연산자 문제

두 개의 정수 `x`, `y`가 주어졌을 때 아래 조건을 비교하는 프로그램을 작성하세요:

- `x > y`  
- `x < y`  
- `x == y`  
- `x != y`

```java
public class Main {
    public static void main(String[] args) {
        // ...
    }
}
```

### 💡 예상 출력:
```
x가 y보다 큰가? false
x가 y보다 작은가? true
x와 y가 같은가? false
x와 y가 다른가? true
```

<details>
<summary>✅ 정답 보기</summary>

```java
public class Main {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        boolean isGreater = x > y;
        boolean isSmaller = x < y;
        boolean isEqual = x == y;
        boolean isNotEqual = x != y;

        System.out.println("x가 y보다 큰가? " + isGreater);
        System.out.println("x가 y보다 작은가? " + isSmaller);
        System.out.println("x와 y가 같은가? " + isEqual);
        System.out.println("x와 y가 다른가? " + isNotEqual);
    }
}
```

</details>

## Q20. 두 문자열이 같은지 비교할 수 있는 프로그램 만들기

입력된 두 개의 문자열 `str1`, `str2`를 비교한 결과를 `result` 변수에 저장하고 출력하세요.  
- 문자열 비교는 `.equals()` 사용

```java
public class Main {
    public static void main(String[] args) {
        // TODO: 사용자로부터 두 문자열 입력받기
        // TODO: 비교 후 결과를 result에 저장
        // TODO: 결과 출력
    }
}
```

### 💡 예상 출력:
```
첫 번째 문자열을 입력하세요: Java
두 번째 문자열을 입력하세요: Java
두 문자열이 같은가요? true
```

<details>
<summary>✅ 정답 보기</summary>

```java
import java.util.Scanner;

public class StringComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 문자열을 입력하세요: ");
        String str1 = scanner.nextLine();

        System.out.print("두 번째 문자열을 입력하세요: ");
        String str2 = scanner.nextLine();

        boolean result = str1.equals(str2);

        System.out.println("두 문자열이 같은가요? " + result);
    }
}
```

</details>

## Q21. 신호등 색상을 입력하면 안내 메시지를 출력하는 프로그램 만들기

새로운 클래스 `TrafficLight.java`를 생성해서 작성하세요.

### ✅ 처리해야 할 조건

1. `"초록불"` → `"건너세요!"` 출력  
2. `"노란불"` → `"주의하세요!"` 출력  
3. `"빨간불"` → `"멈추세요!"` 출력  
4. 그 외 입력 → `"잘못된 입력입니다."` 출력

```java
import java.util.Scanner;

public class TrafficLight {
    public static void main(String[] args) {
        // ...
    }
}
```

### 💡 예상 출력 예시

```
신호등 색상을 입력하세요 (초록불, 노란불, 빨간불): 초록불
건너세요!

신호등 색상을 입력하세요 (초록불, 노란불, 빨간불): 노란불
주의하세요!

신호등 색상을 입력하세요 (초록불, 노란불, 빨간불): 빨간불
멈추세요!

신호등 색상을 입력하세요 (초록불, 노란불, 빨간불): 파란불
잘못된 입력입니다.
```

---

<details>
<summary>✅ 정답 보기</summary>

```java
import java.util.Scanner;

public class TrafficLight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("신호등 색상을 입력하세요 (초록불, 노란불, 빨간불): ");
        String light = scanner.nextLine(); // 사용자 입력 받기

        // 조건문 처리
        if (light.equals("초록불")) {
            System.out.println("건너세요!");
        } else if (light.equals("노란불")) {
            System.out.println("주의하세요!");
        } else if (light.equals("빨간불")) {
            System.out.println("멈추세요!");
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}
```

</details>

## Q22. 입력한 숫자의 구구단 출력하기

사용자로부터 **2~9 사이**의 숫자를 입력받아 해당 단의 구구단을 출력하세요.  
사용자가 3을 입력하면 3단을 출력해야 합니다.  
👉 `for` 또는 `while` 문을 자유롭게 활용하세요.

```java
import java.util.Scanner;

public class Gugudan {
    public static void main(String[] args) {
        // ...
    }
}
```

### 💡 출력 예시:
```
출력할 구구단 단수를 입력하세요 (2~9): 3
==== 3단 ====
3 x 1 = 3
3 x 2 = 6
3 x 3 = 9
...
3 x 9 = 27
```

<details>
<summary>✅ 정답 보기</summary>

```java
import java.util.Scanner;

public class Gugudan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("출력할 구구단 단수를 입력하세요 (2~9): ");
        int dan = scanner.nextInt();

        // 2~9 사이 숫자인지 확인
        if (dan < 2 || dan > 9) {
            System.out.println("2에서 9 사이의 숫자를 입력하세요!");
        } else {
            System.out.println("==== " + dan + "단 ====");
            for (int i = 1; i <= 9; i++) {
                System.out.println(dan + " x " + i + " = " + (dan * i));
            }
        }
    }
}
```

</details>

---

## Q23. 2단부터 9단까지 구구단 출력 (중첩 for문 활용)

2단부터 9단까지 전체 구구단을 출력하는 프로그램을 작성하세요.

```java
public class GugudanAll {
    public static void main(String[] args) {
        // ...
    }
}
```

### 💡 출력 예시:
```
==== 2단 ====
2 x 1 = 2
2 x 2 = 4
...
2 x 9 = 18

==== 3단 ====
3 x 1 = 3
...
==== 9단 ====
9 x 9 = 81
```

<details>
<summary>✅ 정답 보기</summary>

```java
public class GugudanAll {
    public static void main(String[] args) {

        for (int dan = 2; dan <= 9; dan++) { // 2단부터 9단까지 반복
            System.out.println("==== " + dan + "단 ====");

            for (int i = 1; i <= 9; i++) { // 1~9까지 곱하기
                System.out.println(dan + " x " + i + " = " + (dan * i));
            }

            System.out.println(); // 단 간격을 띄우기
        }
    }
}
```

</details>

## Q23. 1차원 배열에서 짝수만 출력하기

아래의 정수 배열이 주어졌을 때 **짝수만 출력**하세요.

배열 예시: `{3, 4, 7, 10, 15, 20}`

```java
public class EvenNumberFinder {
    public static void main(String[] args) {
        // ...
    }
}
```

### 💡 예상 출력:
```
짝수: 4 10 20
```

<details>
<summary>✅ 정답 보기</summary>

```java
public class EvenNumberFinder {
    public static void main(String[] args) {
        int[] numbers = {3, 4, 7, 10, 15, 20};

        System.out.print("짝수: ");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                System.out.print(numbers[i] + " ");
            }
        }
    }
}
```

</details>

---

## Q25. 1차원 배열의 누적합 구하기

배열 예시: `{2, 5, 8}`

```java
public class PrefixSum {
    public static void main(String[] args) {
        // ...
    }
}
```

### 💡 예상 출력:
```
누적합: 15
```

<details>
<summary>✅ 정답 보기</summary>

```java
public class PrefixSum {
    public static void main(String[] args) {
        int[] numbers = {2, 5, 8};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println("누적합: " + sum);
    }
}
```

</details>

---

## Q26. 2차원 배열에서 검은돌(`true`)의 좌표 `(x, y)` 찾기

배열 예시:

```java
boolean[][] board = {
    {true, false},
    {false, true}
};
```

```java
public class BlackStoneFinder {
    public static void main(String[] args) {
        // ...
    }
}
```

### 💡 예상 출력:
```
검은돌(●) 위치: (0,0)
검은돌(●) 위치: (1,1)
```

<details>
<summary>✅ 정답 보기</summary>

```java
public class BlackStoneFinder {
    public static void main(String[] args) {
        boolean[][] board = {
            {true, false},
            {false, true}
        };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]) {
                    System.out.println("검은돌(●) 위치: (" + i + "," + j + ")");
                }
            }
        }
    }
}
```

</details>
