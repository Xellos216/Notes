package chapter1.io;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            System.out.println("안녕");
            System.out.println("Java");

            System.out.print("안녕");
            System.out.print("Java\n");

            // 개행문자 포함 출력
            System.out.print("안녕\n");
            System.out.println("Java");

            // 입력(Scanner)
            // 스캐너 객체를 스캐너형 박스(scanner)
            Scanner scanner = new Scanner(System.in);

            // 문자열 입력받기
            System.out.print("좋아하는 문장을 입력하세요: ");
            String sentence = scanner.nextLine();
            System.out.println("sentence = " + sentence);

            // 정수형(int, long) 입력받기
            System.out.print("정수(int)를 입력하세요: ");
            int intBox = scanner.nextInt();
            System.out.println("intBox = " + intBox);

            System.out.print("정수(long)를 입력하세요: ");
            long longBox = scanner.nextLong();
            System.out.println("longBox = " + longBox);

            // 소수점
            System.out.print("소수점(double 입력하세요: ");
            double doubleBox = scanner.nextDouble();
            System.out.println("doubleBox = " + doubleBox);

        }

}
