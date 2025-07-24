# 인기있는 아이스크림

> CodeKata / SQL / Lv01 / Best_Selling_IceCream

## 📌 문제 설명

`FIRST_HALF` 테이블은 상반기 동안 아이스크림 공장에서 각 아이스크림 맛(`FLAVOR`)에 대해  
출하된 주문 수(`TOTAL_ORDER`)와 출하 번호(`SHIPMENT_ID`) 정보를 담고 있습니다.

이 테이블에서 **가장 인기 있었던 아이스크림 맛**을 아래 기준에 따라 조회하세요:

- 출하량(`TOTAL_ORDER`) 기준으로 내림차순 정렬
- 출하량이 같다면 **출하 번호(`SHIPMENT_ID`) 오름차순** 정렬
- 결과는 **FLAVOR 이름만** 출력

---

## ✅ 테이블 구조

| 컬럼명       | 타입      | NULL 허용 | 설명             |
|--------------|-----------|-----------|------------------|
| SHIPMENT_ID  | INT       | FALSE     | 출하 번호        |
| FLAVOR       | VARCHAR   | FALSE     | 아이스크림 맛     |
| TOTAL_ORDER  | INT       | FALSE     | 총 주문량        |

---

## ✅ 정답 SQL

```sql
SELECT FLAVOR
FROM FIRST_HALF
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID ASC;
```

---

## 💡 쿼리 해설

- `ORDER BY TOTAL_ORDER DESC`  
  → 출하량이 많은 맛을 먼저 보여줌

- `SHIPMENT_ID ASC`  
  → 출하량이 같은 경우, 출하번호 오름차순으로 정렬

- `SELECT FLAVOR`  
  → 맛 이름만 출력

---

## 💻 실행 결과 예시

| FLAVOR          |
|-----------------|
| chocolate       |
| white_chocolate |
| strawberry      |
| vanilla         |
| caramel         |
| peach           |
| mint_chocolate  |

---

## 🧠 학습 포인트

- `ORDER BY`에 복수 기준 적용
- 불필요한 컬럼 제외하고 원하는 컬럼만 출력하는 패턴
- 정렬 기준이 중요한 조회 문제에서의 우선순위 처리

---

## 🖼 실행 화면 캡처

![실행결과](./Screenshot.png)
