## 🧠 Problem
`CART_PRODUCTS` 테이블에는 장바구니에 담긴 상품 정보가 담겨 있습니다.  
이 중 **우유(Milk)와 요거트(Yogurt)를 동시에 구입한 장바구니의 ID 목록**을 조회하세요.

- 출력 컬럼: `CART_ID`
- 정렬 기준: `CART_ID` 오름차순

---

## 💾 SQL Query
```sql
SELECT CART_ID
FROM CART_PRODUCTS
WHERE CART_ID IN (
  SELECT CART_ID
  FROM CART_PRODUCTS
  WHERE NAME IN ('Milk', 'Yogurt')
  GROUP BY CART_ID
  HAVING COUNT(DISTINCT NAME) = 2
)
GROUP BY CART_ID
ORDER BY CART_ID ASC;
```

---

## SQL Keywords 설명

### 🔹 IN (서브쿼리)
- 우유 또는 요거트를 담은 장바구니 중, 두 상품 모두 포함한 장바구니만 추출

### 🔹 GROUP BY
- 장바구니 ID별로 묶어서 상품 목록 집계

### 🔹 HAVING COUNT(DISTINCT NAME) = 2
- 동일 장바구니에 'Milk'와 'Yogurt' 두 상품이 모두 존재하는 경우만 필터링

### 🔹 ORDER BY
- 결과를 `CART_ID` 오름차순으로 정렬

---

## 문제 풀이 흐름 요약

- STEP 1: `NAME IN ('Milk', 'Yogurt')` 조건으로 우유/요거트가 담긴 행 선별
- STEP 2: `GROUP BY CART_ID`로 장바구니별로 묶고, `DISTINCT NAME` 개수 확인
- STEP 3: 두 상품 모두 포함된 장바구니만 필터 (`HAVING COUNT(...) = 2`)
- STEP 4: 외부 쿼리에서 해당 장바구니 ID 목록을 조회 및 정렬