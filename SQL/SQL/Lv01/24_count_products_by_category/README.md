# 🐬 SQL - 카테고리 별 상품 개수 구하기

## 📌 문제 설명

`PRODUCT` 테이블에서 각 상품의 카테고리 코드(즉, `PRODUCT_CODE`의 앞 2자리)를 기준으로  
상품 개수를 집계하고, **카테고리 코드 기준 오름차순 정렬**하여 출력하세요.

---

## ✅ 테이블 구조 (PRODUCT)

| 컬럼명        | 타입        | NULL 허용 | 설명             |
|---------------|-------------|-----------|------------------|
| PRODUCT_ID    | INTEGER     | ❌        | 상품 ID          |
| PRODUCT_CODE  | VARCHAR(N)  | ❌        | 상품 코드 (ex: A1000001) |
| PRICE         | INTEGER     | ❌        | 가격             |

---

## ✅ 정답 쿼리

```sql
SELECT 
  SUBSTRING(PRODUCT_CODE, 1, 2) AS CATEGORY,
  COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY CATEGORY
ORDER BY CATEGORY ASC;
```

---

## 🧪 실행 예시

| CATEGORY | PRODUCTS |
|----------|----------|
| A1       | 2        |
| C3       | 3        |
| K1       | 1        |

---

## 📝 요약 포인트

- `SUBSTRING(PRODUCT_CODE, 1, 2)` → 앞 2자리 추출해 카테고리화
- `GROUP BY CATEGORY` → 그룹별 집계
- `ORDER BY CATEGORY ASC` → 카테고리 이름 기준 정렬
- `COUNT(*)`는 NULL과 관계없이 전체 개수 세기

---
