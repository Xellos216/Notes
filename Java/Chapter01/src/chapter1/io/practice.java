package chapter1.io;

import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("");
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("나이를 입력하세요: ");
        String age = sc.nextLine();
        System.out.println("");
        System.out.println("[ 출력결과 ]");
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);

    }
}
