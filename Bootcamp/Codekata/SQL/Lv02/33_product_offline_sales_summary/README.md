# 상품 별 오프라인 매출 구하기

## ✅ 문제 설명

각 상품(Product)의 오프라인 판매 이력을 활용해  
**상품 코드(PRODUCT_CODE)** 별 총 매출(SALES)을 구하시오.

- 매출 = 판매수량(SALES_AMOUNT) × 상품가격(PRICE)
- 조건: 오프라인 판매 이력이 있는 상품만 포함 (`SALES_AMOUNT >= 1`)
- 결과 컬럼: `PRODUCT_CODE`, `SALES`
- 정렬: `SALES` 내림차순, `PRODUCT_CODE` 오름차순

---

## 🧾 사용 테이블

### 📘 PRODUCT

| 컬럼명        | 설명           |
|-------------|----------------|
| PRODUCT_ID  | 상품 고유 ID    |
| PRODUCT_CODE| 상품 코드       |
| PRICE       | 단가(가격)      |

### 📘 OFFLINE_SALE

| 컬럼명         | 설명              |
|----------------|------------------|
| OFFLINE_SALE_ID| 판매 고유 ID      |
| PRODUCT_ID     | 상품 ID (외래키)  |
| SALES_AMOUNT   | 판매 수량         |
| SALES_DATE     | 판매 일자         |

---

## 💡 풀이 흐름

1. `PRODUCT_ID`를 기준으로 두 테이블을 `JOIN`
2. `SALES_AMOUNT >= 1` 조건으로 필터링
3. 매출 = `PRICE * SALES_AMOUNT` 계산
4. `PRODUCT_CODE` 별로 `SUM()`으로 총 매출 합산
5. `ORDER BY`로 정렬

---

## ✅ 정답 SQL

```sql
SELECT
  P.PRODUCT_CODE,
  SUM(P.PRICE * O.SALES_AMOUNT) AS SALES
FROM
  PRODUCT AS P
  LEFT JOIN OFFLINE_SALE AS O ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE
  O.SALES_AMOUNT >= 1
GROUP BY
  P.PRODUCT_CODE
ORDER BY
  SALES DESC, P.PRODUCT_CODE ASC;
```

---

## ❌ 오답노트

### ❗ SELECT에서 `SUM()`을 생략한 경우

```sql
SELECT
  P.PRODUCT_CODE,
  P.PRICE * O.SALES_AMOUNT AS SALES  -- ❌ 여기에서 SUM이 빠짐
...
```

### 🔎 왜 오답인가?

| 항목 | 문제점 | 설명 |
|------|--------|------|
| `SUM()` 생략 | ❌ | 하나의 거래(`PRICE * SALES_AMOUNT`)만 계산하고 끝남 |
| 집계 누락 | ❌ | 같은 상품 코드의 여러 판매 이력을 합산하지 못함 |
| GROUP BY 효과 무력화 | ❌ | `GROUP BY`가 있어도 SUM 없이 묶인 결과가 하나만 리턴됨 |

### 💡 핵심 교훈

- **총 매출**을 구할 때는 반드시 `SUM(PRICE * SALES_AMOUNT)`을 써야 함
- `GROUP BY`는 `SUM()`, `COUNT()` 같은 집계 함수와 함께 써야 의미가 있음

---

## ✅ 실행 결과 예시

| PRODUCT_CODE | SALES  |
|--------------|--------|
| C3000002     | 126000 |
| A1000011     | 90000  |
| A1000045     | 16000  |

---

## 📌 정리

- **GROUP BY만 써선 안 되고**, 원하는 값의 누적/합산을 위해 반드시 `SUM()` 사용
- `GROUP BY`와 `집계 함수(SUM, COUNT, AVG...)`는 항상 세트로 생각할 것
