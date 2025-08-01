## 1번. 배열 처리 메서드 만들기

정수 배열을 받아 짝수만 골라내어 그 합계를 반환하는 `sumEvenNumbers` 메서드를 완성하세요.

<details>
<summary> ❓ 문제 보기</summary>
<pre><code class="language-java">
public class ArrayProcessor {

    public int sumEvenNumbers(int[] numbers) {
        // TODO: 이 메서드를 완성하세요.
        // 1. 합계를 저장할 변수를 선언하세요.
        // 2. 반복문을 사용해 배열의 모든 요소를 확인하세요.
        // 3. 현재 요소가 짝수인지 확인하는 조건문을 작성하세요.
        // 4. 짝수라면 합계 변수에 더하세요.
        // 5. 반복문이 끝나면 최종 합계를 반환하세요.

        return 0; // 임시 반환 값
    }

    public static void main(String[] args) {
        ArrayProcessor processor = new ArrayProcessor();
        int[] numbers = {10, 3, 22, 5, 17, 8};
        int result = processor.sumEvenNumbers(numbers);
        System.out.println("짝수들의 합: " + result); // 예상 결과: 40
    }
}
</code></pre>
</details>

## 2번. 클래스와 생성자 설계

책을 표현하는 `Book` 클래스에서 생성자와 정보 출력 메서드를 완성하세요.

<details>
<summary> ❓ 문제 보기</summary>
<pre><code class="language-java">
public class Book {
    // 필드 (속성)
    String title;
    String author;
    int price;

    // 생성자
    public Book(/* TODO: 올바른 매개변수를 선언하세요 */) {
        // TODO: 매개변수로 받은 값들을 사용해 클래스의 필드를 초기화하세요.
        // 'this' 키워드를 사용해야 합니다.
    }

    // 메서드
    public void printInfo() {
        // TODO: "제목: [title], 저자: [author], 가격: [price]원" 형식으로 출력하세요.
    }

    public static void main(String[] args) {
        // TODO: 여기에 Book 객체를 생성하고 printInfo() 메서드를 호출하는 코드를 작성하세요.
        // 예: Book myBook = new Book("자바의 정석", "남궁성", 30000);
    }
}
</code></pre>
</details>

## 3번. 상속과 메서드 오버라이딩

`Shape` 추상 클래스를 상속받는 `Circle`과 `Rectangle` 클래스에서 `getArea()` 메서드를 재정의하여 각 도형의 넓이를 구하세요.

<details>
<summary> ❓ 문제 보기</summary>
<pre><code class="language-java">
// 수정할 필요 없는 추상 클래스
abstract class Shape {
    abstract double getArea(); // 넓이를 구하는 추상 메서드
}

class Circle /* TODO: 상속 구현 */ {
    private double radius; // 반지름

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        // TODO: 원의 넓이를 계산하여 반환하는 코드를 작성하세요.
        // 원 넓이 공식: 3.14 * 반지름 * 반지름
        return 0;
    }
}

class Rectangle /* TODO: 상속 구현 */ {
    private double width;  // 가로
    private double height; // 세로

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        // TODO: 사각형의 넓이를 계산하여 반환하는 코드를 작성하세요.
        // 사각형 넓이 공식: 가로 * 세로
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        // TODO: 하위(자식) 클래스인 Circle과 Rectangle의 인스턴스를 상위(부모) 클래스인 Shape 타입의 참조 변수로 참조할 수 있도록 수정해주세요.
        Circle circle = new Circle(10);       // 반지름 10
        Rectangle rectangle = new Rectangle(5, 8); // 가로 5, 세로 8

        System.out.println("원의 넓이: " + circle.getArea()); // 예상 결과: 314.0
        System.out.println("사각형의 넓이: " + rectangle.getArea()); // 예상 결과: 40.0
    }
}
</code></pre>
</details>

## 4번. 참조 변수와 객체 간의 상호작용

`Team` 클래스에 `Player` 객체를 추가하고, 소속된 선수 명단을 출력하는 `printPlayerList`와 추가하는 `addPlayer`메서드를 완성하세요.

<details>
<summary> ❓ 문제 보기</summary>
<pre><code class="language-java">
import java.util.ArrayList;

// 수정할 필요 없는 Player 클래스
class Player {
    String name;
    public Player(String name) { this.name = name; }
}

class Team {
    String teamName;
    /* TODO: 올바른 타입의 필드(속성) 선언 변수명은 playerList; */ 

    public Team(String teamName) {
        this.teamName = teamName;
        /* TODO: 위에서 선언한 playerList 필드 초기화 */
    }

    public void addPlayer(/* TODO: 올바른 매개변수를 선언하세요 */) {
        // TODO: 매개변수로 받은 player 객체를 playerList에 추가하세요.
    }

    public void printPlayerList() {
        // TODO: 반복문을 사용하여 playerList에 있는 모든 선수의 이름을 출력하세요.
    }
}

public class BaseballManager {
    public static void main(String[] args) {
        // 팀 생성
        Team myTeam = new Team("드림팀");

        // 선수 생성 (야구 선수로 변경)
        Player player1 = new Player("오타니");
        Player player2 = new Player("김혜성");

        // 팀에 선수 추가 TODO: Team의 addPlayer 메서드 완성후 아래 주석을 해제해주세요.
        // myTeam.addPlayer(player1);
        // myTeam.addPlayer(player2);

        // 팀 선수 목록 출력
        myTeam.printPlayerList(); // 예상 결과: 오타니, 김혜성 출력
    }
}
</code></pre>
</details>

## 5번. 간단한 은행 입출금 시스템

`Account` 클래스의 입출금 메서드와 `Bank` 클래스의 계좌 찾기 메서드를 완성하여 간단한 은행 시스템 로직을 구현하세요.

<details>
<summary> ❓ 문제 보기</summary>
<pre><code class="language-java">
import java.util.ArrayList;

class Account {
    String accountNumber;
    int balance;

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(int amount) {
        // TODO: 현재 잔액(balance)에 입금액(amount)을 더하세요.
    }

    public void withdraw(int amount) {
        // TODO: 출금액이 잔액보다 작거나 같을 경우에만 잔액에서 출금액을 빼세요.
    }
}

class Bank {
    List<Account> accounts = new ArrayList<>();

    public Account findAccount(String accountNumber) {
        // TODO: 반복문을 사용하여 accounts 리스트에서
        // 매개변수로 받은 accountNumber와 일치하는 Account 객체를 찾아 반환하세요.
        // 만약 일치하는 계좌가 없다면 null을 반환하세요.
        return null;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.accounts.add(new Account("111-222", 10000));
        bank.accounts.add(new Account("333-444", 50000));

        Account foundAccount = bank.findAccount("111-222");

        if (foundAccount != null) {
            foundAccount.deposit(5000);
            foundAccount.withdraw(3000);
            System.out.println("계좌 " + foundAccount.accountNumber + "의 최종 잔액: " + foundAccount.balance); // 예상 결과: 12000
        }
    }
}
</code></pre>
</details>
