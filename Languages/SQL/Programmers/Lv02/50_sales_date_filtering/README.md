# 📅 5월 식품들의 총매출 조회 쿼리 - 날짜 필터링 방식 비교

## 📘 문제 설명

`FOOD_PRODUCT`와 `FOOD_ORDER` 테이블을 이용하여  
**2022년 5월에 생산된 상품들의 총매출(TOTAL_SALES)** 을  
상품 ID, 상품명과 함께 조회하고,  
총매출 기준으로 내림차순 정렬하세요.

---

## 🧾 테이블 구조 요약

### FOOD_PRODUCT

| 컬럼명       | 설명     |
|--------------|----------|
| PRODUCT_ID   | 제품 ID  |
| PRODUCT_NAME | 제품명   |
| PRICE        | 단가     |

### FOOD_ORDER

| 컬럼명       | 설명         |
|--------------|--------------|
| PRODUCT_ID   | 제품 ID (FK) |
| AMOUNT       | 주문 수량     |
| PRODUCE_DATE | 생산일       |

---

## ✅ 최종 정답 쿼리 (권장 방식)

```sql
SELECT
  P.PRODUCT_ID,
  P.PRODUCT_NAME,
  SUM(P.PRICE * O.AMOUNT) AS TOTAL_SALES
FROM
  FOOD_PRODUCT AS P
  INNER JOIN FOOD_ORDER AS O ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE
  O.PRODUCE_DATE >= '2022-05-01'
  AND O.PRODUCE_DATE < '2022-06-01'
GROUP BY
  P.PRODUCT_ID, P.PRODUCT_NAME
ORDER BY
  TOTAL_SALES DESC,
  P.PRODUCT_ID ASC;
```

---

## 🔍 잘못된 시도 예시와 비교

### ❌ 오답 예시

```sql
WHERE O.PRODUCE_DATE LIKE '2022-05-%d'
```

| 문제점 | 설명 |
|--------|------|
| `%d` 는 `LIKE`에서 의미 없음 | `%d`는 `DATE_FORMAT()` 안에서만 쓰는 포맷 문자 |
| 결과 없음 | `'2022-05-%d'`라는 문자열과 정확히 일치하는 값 없음 |

---

### ✅ 문자열 비교 방식 (가능은 하지만 권장 X)

```sql
WHERE O.PRODUCE_DATE LIKE '2022-05-%'
```

- `'2022-05-'`로 시작하는 날짜 (ex: 2022-05-01, 2022-05-28 등) 필터링
- 단점: DATE → STRING 암시적 변환 → **성능 저하**

---

### ✅ 날짜 범위 필터링 방식 (권장)

```sql
WHERE O.PRODUCE_DATE >= '2022-05-01'
  AND O.PRODUCE_DATE < '2022-06-01'
```

- 가장 안전하고 성능도 좋음
- `BETWEEN '2022-05-01' AND '2022-05-31'`도 가능하지만  
  **시작일 포함 / 종료일 포함 여부**에서 혼란 있을 수 있으므로  
  위와 같은 **[이상, 미만] 방식이 권장**

---

## 🧠 요약

| 방식                          | 추천도 | 설명 |
|-------------------------------|--------|------|
| `LIKE '2022-05-%'`           | ⚠️     | 암시적 변환으로 느릴 수 있음 |
| `LIKE '2022-05-%d'`          | ❌     | 잘못된 문자열 |
| `BETWEEN '2022-05-01' AND ...` | ✅     | 정확하나 포함 기준 주의 |
| `>= '2022-05-01' AND < '2022-06-01'` | ✅✅ | 가장 명확하고 안정적인 방식 |

