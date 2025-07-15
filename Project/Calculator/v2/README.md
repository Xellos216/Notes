# 🧮 Java 계산기 프로젝트 (Lv2 - 클래스 기반 계산기)

이 프로젝트는 Java를 사용하여 **클래스를 활용한 CLI 사칙연산 계산기**를 구현한 버전입니다.  
Lv1에서 구현한 절차지향 방식 계산기를 확장하여, `Calculator` 클래스를 통해 연산 기능과 결과 저장 기능을 분리하였습니다.

---

## ✅ 구현 목표 (Lv2 단계)

- `Calculator` 클래스를 생성하여 연산 기능을 메서드로 분리
- 결과를 저장하는 `List<Integer>` 필드를 클래스 내부에 구현
- App 클래스에서는 Calculator 인스턴스를 사용하여 연산 수행
- `App` 클래스가 `Calculator` 클래스의 결과 필드에 직접 접근하지 않도록 캡슐화
- 저장된 결과 중 가장 오래된 항목을 삭제하는 기능 추가

---

## 📋 기능 요약

| 기능 | 설명 |
|------|------|
| 클래스 분리 | `Calculator` 클래스에 연산 및 결과 저장 책임 부여 |
| 연산 수행 | `calculate(int, int, char)` 메서드로 사칙연산 수행 |
| 결과 저장 | 연산 결과를 리스트에 순차 저장 |
| 결과 출력 | 저장된 결과를 App 클래스에서 출력 |
| 결과 삭제 | 가장 오래된 결과 1개 삭제 (FIFO) |
| 캡슐화 | 필드 직접 접근 방지 → Getter 메서드(`getResults`) 제공 |
| 반복 계산 | 계산 기능 내부에서 연속 계산 가능 (`exit` 입력 전까지) |
| 예외 처리 | 숫자 아닌 값 입력 시 예외 처리 (`try-catch`) |

---

## 🛠 실행 방법

```bash
javac App.java CalculatorV2CLI.java
java App
```

---

## 💡 실행 예시

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
```

---

## 📁 파일 구성

| 파일명 | 설명 |
|--------|------|
| `App.java` | 사용자 입력 및 메뉴 처리, Calculator 객체 호출 |
| `CalculatorV2CLI.java` | 연산 기능과 결과 저장 및 삭제 메서드 포함 |
| `App_Annotated.md` | App.java 주석 포함 설명 파일 |
| `CalculatorV2CLI_Annotated.md` | Calculator 클래스 주석 포함 설명 파일 |

---

## 🧠 학습 포인트

- Java 클래스 구조와 메서드 분리 설계
- 컬렉션(List) 활용 및 캡슐화 원칙 이해
- 메서드 호출을 통한 데이터 흐름 이해
- 예외 처리 흐름 (`try-catch`) 실전 적용
- 객체지향 설계의 기초 구조 훈련

---

## 🔜 다음 단계

Lv3에서는 다음 내용을 확장할 예정입니다:

- 실수 계산을 위한 `double` 지원
- Enum을 활용한 연산자 처리
- 결과 파일 저장 및 로딩 기능
- 단위 테스트 및 GUI 버전 확장
