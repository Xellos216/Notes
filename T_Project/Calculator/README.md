# 🧮 Java 계산기 프로젝트 (Lv1)

이 프로젝트는 Java를 사용하여 **클래스 없이 구현한 CLI 기반 사칙연산 계산기**입니다.  
단순한 계산뿐 아니라 예외 처리, 반복 실행, 종료 제어까지 포함하고 있습니다.

---

## ✅ 구현 목표 (Lv1 단계)

- `Scanner`를 이용한 사용자 입력 처리
- 정수 두 개와 연산자(+, -, *, /) 입력
- switch 또는 if 문을 활용한 사칙연산 처리
- 잘못된 입력에 대한 예외 처리 (`try-catch`)
- `exit` 입력 시 반복 종료
- 콘솔에 결과 출력

---

## 📋 기능 요약

| 기능 | 설명 |
|------|------|
| 숫자 입력 | 두 정수를 개별 입력받음 |
| 연산자 입력 | `+`, `-`, `*`, `/` 중 하나 입력 |
| 연산 수행 | `switch` 문으로 연산 처리 |
| 예외 처리 | 잘못된 숫자 입력, 0으로 나눌 경우 처리 |
| 반복 실행 | `while(true)` 구조 사용 |
| 종료 | `"exit"` 입력 시 프로그램 종료 |

---

## 🛠 실행 방법

```bash
javac Main.java
java Main
```

---

## 💡 실행 예시

```text
Enter the number: 5
Enter an operator (+, -, *, /) : *
Enter the second number: 3
The result is: 15

Enter the number: exit
Calculator is shutting down
```

---

## 📁 파일 구성

- `Main.java`: 전체 계산 로직을 담은 메인 클래스
- `Calculator_CLI_Annotated.md`: 주석 포함 설명용 코드
- `README_CLI.md`: CLI 전용 README
- `README_GUI.md`: GUI 전용 README

---

## 🧠 학습 포인트

- 자바 기본 문법 복습 (변수, 입력, 조건, 반복)
- 예외 처리 흐름 (`try-catch`)
- 사용자 인터페이스 없는 CLI 입력 흐름 이해
- 점진적 구조 확장을 위한 기반 설계

---

## 🔜 다음 단계

Lv2에서는 클래스를 활용한 객체지향 구조로 전환하고,  
Lv3에서는 Enum, 제네릭, 람다 및 스트림을 적용해 확장된 기능을 구현합니다.

