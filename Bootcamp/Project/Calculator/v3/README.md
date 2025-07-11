# 🧮 Java 계산기 프로젝트 (Lv3 - Enum, 제네릭, 스트림 기반 확장)

이 프로젝트는 Java의 고급 문법을 활용하여 **사칙연산 계산기의 구조와 기능을 확장**한 버전입니다.  
Lv2의 클래스 기반 계산기에서 더 나아가 `Enum`, `제네릭`, `람다 & 스트림`을 도입하여 **유연한 데이터 처리 및 통계 기능**까지 구현하였습니다.

---

## ✅ 구현 목표 (Lv3 단계)

- `Enum`을 통해 연산자 기호(+ - * /)를 타입으로 구조화
- `제네릭`을 활용하여 `int`, `double` 등 다양한 숫자 타입 지원
- `람다 & 스트림`을 활용하여 저장된 결과 중 통계적 값(최댓값 등) 추출

---

## 📋 기능 요약

| 기능 | 설명 |
|------|------|
| Enum 연산자 처리 | `ArithmeticOperator` enum으로 연산자 정의 및 처리 |
| 제네릭 계산기 | `T extends Number`를 사용하여 다양한 숫자 타입 처리 |
| 연산 수행 | `calculate(T num1, T num2, ArithmeticOperator op)` 방식 |
| 결과 저장 | 계산 결과를 `List<T>` 형태로 누적 저장 |
| 통계 기능 | 람다 + 스트림으로 저장된 결과 중 최대값 등 추출 |
| 타입 유연성 | int → double 등 다양한 타입 입력 및 계산 처리 가능 |
| 캡슐화 유지 | 결과 리스트는 외부 직접 접근 불가 (Getter 제공) |

---

## 🛠 실행 방법

```bash
javac App.java ArithmeticCalculator.java
java App
```

---

## 💡 실행 예시

```text
=== Calculator Menu===
1. Calculate
2. View saved results
3. View largest result
4. Exit
Enter your choice: 1

Enter first number: 3.5
Enter operator (+, -, *, /): +
Enter second number: 2.5
Result: 6.0

=== Calculator Menu===
3. View largest result
Max result: 6.0
```

---

## 📁 파일 구성

| 파일명 | 설명 |
|--------|------|
| `App.java` | 사용자 입력 및 메뉴 처리 |
| `ArithmeticCalculator.java` | 연산 Enum 정의, 제네릭 연산 수행, 결과 저장/조회 기능 포함 |
| `ArithmeticOperator.java` | 사칙연산 기호와 연산 동작을 Enum으로 구조화 |
| `App_Annotated.md` | App.java 설명 주석 포함 문서 |
| `ArithmeticCalculator_Annotated.md` | 계산기 클래스 설명 주석 포함 문서 |

---

## 🧠 학습 포인트

- Java Enum을 활용한 연산자 타입 구조화
- 제네릭 클래스 설계를 통한 타입 유연성 확보
- 스트림 기반 통계 연산 로직 구현
- 실수(double) 계산 처리 및 타입 자동 판별
- 고급 Java 문법(Enum, 제네릭, 람다, 스트림)의 실전 적용


