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
<summary>📌 정답 (어려웠다면 확인 후 다시 한 번 작성해보세요!)</summary>

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
