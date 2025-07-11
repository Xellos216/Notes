# 🧮 CLI Calculator V3 (Enum + Stream 기반 실수 계산기)

이 프로젝트는 Java의 열거형(enum), 람다식, 함수형 인터페이스, Stream API 등을 활용한 고급 구조의 콘솔 기반 계산기입니다.  
V2 버전의 구조를 확장하여 `double` 실수 계산, 연산자 클래스로 분리된 설계, 예외 안전 처리, 누적 결과 요약 기능 등을 포함합니다.

---

## ✅ 주요 기능

- 두 실수와 연산자(+, -, *, /)를 입력받아 사칙연산 수행
- 잘못된 숫자 또는 연산자 입력 시 예외 메시지 출력
- 연산 결과를 리스트에 저장하여 누적 관리
- 저장된 결과 중 **최대값**, **최소값**, **총합** 출력
- `"exit"` 입력 시 계산 반복 종료
- 디버깅용 결과 로그 출력 지원 (`debug = true`)

---

## 🛠 실행 방법

```bash
javac App.java ArithmeticCalculator.java ArithmeticOperator.java
java App
```

---

## 💡 사용 예시

```text
=== Calculator ===
Enter a first number (or 'exit'): 10
Enter an operator (+, -, *, /): *
Enter a second number (or 'exit'): 3
= 30.0
Max: 30.0
Min: 30.0
Sum: 30.0
List of results: [30.0]
```

---

## 📁 파일 설명

| 파일명 | 설명 |
|--------|------|
| `App.java` | 메인 실행 클래스 (입력 처리, 연산 실행, 결과 출력) |
| `ArithmeticCalculator.java` | 연산 수행 및 결과 누적/요약 기능 담당 클래스 |
| `ArithmeticOperator.java` | 연산자(+,-,*,/) 정의 및 람다식 기반 연산 실행 Enum |

---

## 🧩 구조 다이어그램

```
App.java
  ├─ 입력 처리 (Scanner)
  ├─ ArithmeticOperator.fromSymbol()
  ├─ ArithmeticCalculator.calculate(a, b, operator)
  ├─ 결과 출력 (최대/최소/합계)
  └─ 결과 리스트 출력
```

---

## 🔖 학습 포인트

- Enum을 활용한 연산자 정의 및 람다식 기반 연산 처리
- Stream API를 활용한 집계 (`max()`, `min()`, `sum()`)
- Optional과 Supplier를 활용한 안전한 예외 처리
- 사용자 입력에 대한 반복 구조와 유효성 검증
- 메서드 분리와 예외 감지 함수형 구조 설계

---

## 📌 향후 확장 아이디어

- 결과를 파일로 저장 및 로드
- 단위 테스트 (JUnit) 및 로깅 기능 추가
- 사용자 입력 UI 개선 (메뉴 기반 선택 구조)
- REST API 형태로 서버 확장
- GUI 계산기 버전 구현

---

## 🧾 주석 및 개념 정리 파일

- [`arithmetic_calculator_comment.md`](./arithmetic_calculator_comment.md)
- [`arithmetic_operator_comment.md`](./arithmetic_operator_comment.md)
- [`app_final_comment.md`](./app_final_comment.md)

각 파일에는 전체 소스 코드의 주석과 함께 등장한 주요 키워드 및 개념 설명이 포함되어 있습니다.