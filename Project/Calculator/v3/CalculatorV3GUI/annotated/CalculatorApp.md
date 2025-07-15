# 📘 CalculatorApp.java (Main 클래스) 주석 & 구조 정리

---

## ✅ 1. 전체 코드 (상세 주석 포함)

```java
package app;  // 애플리케이션 진입점 패키지

import view.CalculatorView;  // View 계층 (GUI)
import controller.CalculatorController;  // Controller 계층

public class CalculatorApp {
    public static void main(String[] args) {
        // Swing GUI는 반드시 EDT(Event Dispatch Thread)에서 실행해야 함
        javax.swing.SwingUtilities.invokeLater(() -> {
            CalculatorView view = new CalculatorView();  // View 생성
            new CalculatorController(view);  // Controller에 View 주입
        });
    }
}
```

---

## ✅ 2. 핵심 개념 정리

| 항목 | 설명 | 예시 |
|------|------|------|
| `main()` | Java 애플리케이션 시작 지점 | `public static void main(...)` |
| `invokeLater()` | Swing에서 GUI 생성은 EDT에서 실행해야 안전 | `SwingUtilities.invokeLater(...)` |
| `CalculatorView` | GUI 화면 요소 담당 클래스 | 입력창, 버튼 등 |
| `CalculatorController` | 버튼 클릭 등의 이벤트 처리 담당 | 연산자 전달 및 계산 로직 |

---

## ✅ 3. 설계 구조 요약 (MVC 연결 흐름)

```text
main() → invokeLater()
   ↓
CalculatorView 생성 → 화면 구성
   ↓
CalculatorController 생성 → 이벤트 핸들러 등록
```

---

## ✅ 4. 유지보수 포인트

| 항목 | 설명 |
|------|------|
| `View`, `Controller` 모듈화 | UI와 로직을 분리해 테스트와 유지보수가 용이 |
| `invokeLater()` | Swing GUI 규칙을 잘 따름 (EDT 미사용 시 UI 버그 발생 가능) |

---

이 클래스는 전체 GUI 계산기 프로그램의 진입점 역할을 하며, `CalculatorView`와 `CalculatorController`를 연결하는 **부트스트랩 역할**을 담당합니다.
