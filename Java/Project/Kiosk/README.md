# ☕ Java kiosk Mini Project

이 프로젝트는 Java & Spring 부트캠프의 세 번째 미니 프로젝트로, 
카페 키오스크의 전체 구매 흐름을 콘솔 환경에서 시뮬레이션하는 것을 목표로 합니다. 

---

## 🎯 프로젝트 개요

- **주요 목적**: 카테고리 선택 → 메뉴 선택 → 온도 옵션 → 수량 입력 → 장바구니 담기 → 할인 선택 → 결제까지의 전체 흐름 구현
- **기술 스택**: Java (콘솔 기반), 추후 Spring Boot 기반 웹 버전으로 확장 예정
- **진입점 클래스**: `Main.java`

---

## 🗂 디렉토리 구조

```
src/
└── kiosk/
    ├── Main.java
    ├── model/
    │   ├── CartItem.java
    │   ├── Cart.java
    │   ├── Category.java
    │   ├── Menu.java
    │   └── UserType.java
    ├── service/
    │   └── KioskService.java
    └── util/
        └── InputHandler.java
```

---

## 🧱 핵심 클래스 역할 요약

| 클래스 | 역할 |
|--------|------|
| `Main` | 사용자 흐름 제어: 시작 화면, 카테고리 선택, 메뉴 담기, 결제 등 |
| `Menu` | 메뉴 항목 모델 (이름, 가격, 카테고리 포함) |
| `Category (enum)` | 카테고리 타입 정의 (`COFFEES`, `NON_COFFEES`, `DESSERTS`) |
| `CartItem` | 장바구니 항목 단위 (메뉴 + 수량 + 온도 옵션) |
| `Cart` | 전체 장바구니 관리, 스트림 기반 중복 검사 및 총액 계산 적용 |
| `KioskService` | 기능 전반 로직 처리: 출력, 입력, 장바구니 추가 등 |
| `UserType (enum)` | 사용자 할인 유형 정의 (`CAT`, `DOG`, `IDIOT`) 및 할인율 반환 |
| `InputHandler` | 사용자 입력 처리 및 예외 제어 담당 |

---

## ⚙️ 주요 리팩토링 포인트 (Lambda & Stream)

- **카테고리별 메뉴 필터링**: `filter()` + `collect()`로 구현
- **장바구니 항목 중복 검사 및 수량 누적**: `stream().filter().findFirst().ifPresentOrElse()` 적용
- **총 금액 계산**: `mapToInt() + sum()`으로 간결화
- **명령형에서 함수형 스타일로 전환** → 조건문과 루프 제거, 가독성 향상
- **사용자 할인 로직 분리**: `UserType` enum으로 응집도 향상 및 선택형 할인 정책 도입

---

## 🧩 기능 흐름 요약

1. 카테고리 출력 및 선택  
2. 해당 카테고리 메뉴 출력  
3. (음료류) ICE/HOT 옵션 선택  
4. 수량 입력 및 장바구니 추가  
5. 장바구니 확인, 삭제 또는 결제  
6. 할인 유형 선택 (`CAT`, `DOG`, `IDIOT`) 및 할인율 적용  
7. 결제 완료 or 주문 취소 후 종료  

---

## 🚧 개발 단계

- ✅ 기능 기획 및 역할 기반 클래스 설계
- ✅ Java 콘솔 기반 구현 (Lambda & Stream 적용)
- ✅ 사용자 흐름 및 예외 처리 개선
- 🔜 Spring Boot 기반 MVC 구조 확장 예정

---

## 📚 학습 포인트

- 역할 기반 OOP 설계 및 책임 분산 구조 설계
- 사용자 입력 흐름 및 예외 처리 개선
- MVC 아키텍처로의 확장 대비 구조 설계 훈련
