# 🖥️ GUI Calculator V2 (Swing-based)

이 프로젝트는 Java Swing을 활용하여 제작한 **그래픽 사용자 인터페이스(GUI) 기반 계산기 프로그램**입니다.  
CLI 기반 V2 구조(`CalculatorV2CLI`)를 참고하여, 연산 로직은 별도의 클래스(`CalculatorV2GUI`)로 분리하고, 버튼 기반 입력 UI를 구성하였습니다.

---

## ✅ 주요 기능

- 숫자 및 연산자 버튼을 클릭하여 사칙연산 수행
- 계산 결과를 상단의 `Display` 필드에 출력
- 연산자는 `+`, `-`, `*`, `/` 네 가지를 지원
- 결과는 내부적으로 `List<Integer>`에 저장됨
- `C` 버튼으로 현재 입력 초기화
- 잘못된 입력이나 0 나누기 연산은 콘솔에 오류 출력
- View와 연산 Logic 클래스를 분리하여 구조화

---

## 🛠 실행 방법

```bash
# 컴파일
javac CalculatorV2GUI.java AppGUI.java

# 실행
java AppGUI
```

※ IntelliJ에서도 Run Configuration을 통해 `AppGUI`를 실행할 수 있습니다.

---

## 🖱️ 사용 방법

1. 숫자 버튼을 클릭하여 첫 번째 숫자를 입력
2. 연산자 버튼(`+`, `-`, `*`, `/`) 중 하나 클릭
3. 두 번째 숫자 입력 후 `=` 버튼 클릭
4. 결과가 상단 Display에 표시됨
5. `C` 버튼으로 입력 초기화 가능

---

## 📁 파일 설명

| 파일명 | 설명 |
|--------|------|
| `AppGUI.java` | GUI 전체 구성 및 버튼 이벤트 처리 (View + Controller) |
| `CalculatorV2GUI.java` | 실제 계산 및 결과 저장 로직을 담당하는 클래스 (Model) |

---

## 🔖 학습 포인트

- Java Swing을 활용한 GUI 설계 (`JFrame`, `JPanel`, `JButton`, `JTextField`)
- 버튼 클릭 이벤트 처리 (`ActionListener`)
- 연산 로직과 화면 로직 분리 (간이 MVC 구조)
- 상태 관리 (`firstNum`, `operator`, `isOperatorClicked`)
- 컬렉션(`List`)을 활용한 연산 결과 저장
- GUI 애플리케이션에서의 예외 처리 기초

---

## 📌 향후 확장 아이디어 (V3 목표)

- `double` 실수 연산 지원 (`.` 버튼 추가 및 자료형 변경)
- 입력된 수식 전체를 표시하는 기능 (`7 + 3 = 10`)
- 연산 결과 히스토리 리스트 출력 (`JTextArea` 또는 `JList`)
- 연산 오류(`0 나누기`, 잘못된 연산자 등)를 GUI로 안내 (`JOptionPane`)
- View / Controller / Model을 완전히 분리한 MVC 구조화
- 키보드 입력 지원 (`KeyListener`)
- 단위 테스트(JUnit) 작성

---

## ✅ 버전 히스토리

| 버전 | 설명 |
|------|------|
| V1 | 단일 클래스 기반 CLI 계산기 |
| V2 | 클래스 분리 구조 CLI 계산기 |
| V3 | 실수 연산, 히스토리, 예외 처리 확장 예정 |
