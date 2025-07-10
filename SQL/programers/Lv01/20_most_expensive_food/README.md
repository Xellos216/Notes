# 가격이 제일 비싼 식품의 정보 출력하기

> CodeKata / SQL / Lv01 / Most_Expensive_Food

## 📌 문제 설명

`FOOD_PRODUCT` 테이블에는 여러 식품의 정보가 저장되어 있습니다.  
이 중에서 **가격(PRICE)이 가장 높은 식품**의

- 상품 ID (`PRODUCT_ID`)
- 상품명 (`PRODUCT_NAME`)
- 상품 코드 (`PRODUCT_CD`)
- 식품 분류 (`CATEGORY`)
- 가격 (`PRICE`)

을 조회하는 SQL문을 작성하세요.

---

## ✅ 테이블 구조

| 컬럼명        | 타입        | NULL 허용 |
|---------------|-------------|-----------|
| PRODUCT_ID    | VARCHAR(10) | FALSE     |
| PRODUCT_NAME  | VARCHAR(50) | FALSE     |
| PRODUCT_CD    | VARCHAR(10) | TRUE      |
| CATEGORY      | VARCHAR(10) | TRUE      |
| PRICE         | NUMBER      | TRUE      |

---

## ✅ 정답 SQL

```sql
SELECT
  PRODUCT_ID,
  PRODUCT_NAME,
  PRODUCT_CD,
  CATEGORY,
  PRICE
FROM FOOD_PRODUCT
ORDER BY PRICE DESC
LIMIT 1;
```

---

## 💡 쿼리 해설

- `ORDER BY PRICE DESC`  
  → 가격 높은 순으로 정렬

- `LIMIT 1`  
  → 가장 위의 한 행만 추출 (가장 비싼 식품 1건)

---

## 🚫 왜 아래 쿼리는 오답인가요?

```sql
SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, MAX(PRICE)
FROM FOOD_PRODUCT;
```

### ❌ 문제점

- `MAX(PRICE)`는 **집계 함수**로서 하나의 행을 반환하지만,  
  나머지 컬럼(`PRODUCT_ID`, `PRODUCT_NAME` 등)은 집계되지 않음
- `GROUP BY` 없이 집계 함수와 일반 컬럼을 함께 SELECT할 경우,  
  **MySQL 설정에 따라 에러가 발생하거나, 임의의 행과 결합될 수 있음**
- 원하는 결과는 “최고가를 가진 식품 1개 전체 정보”인데,  
  위 쿼리는 **최고가 금액만 추출**하고, **그 외 컬럼은 임의의 값일 수 있음**

---

## ✅ 실행 결과 예시

| PRODUCT_ID | PRODUCT_NAME | PRODUCT_CD | CATEGORY | PRICE |
|------------|---------------|------------|----------|-------|
| P0051      | 맛있는배추김치  | CD_KC00001 | 김치     | 19000 |

---

## 🧠 학습 포인트

- `LIMIT` + `ORDER BY`를 이용한 최댓값 레코드 추출
- 집계 함수(`MAX()`)와 단일 행 정보 추출의 차이 이해
- `GROUP BY` 없는 `MAX()` 사용의 한계

---

## 🖼 실행 화면 캡처

![실행결과](./Screenshot.png)
