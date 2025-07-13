# 🛒 식품 분류별 가장 비싼 식품 정보 조회하기

## 📘 문제 설명

`FOOD_PRODUCT` 테이블에서 **식품 분류(CATEGORY)** 별로  
**가장 비싼 식품의 분류, 가격, 이름**을 조회하는 SQL문을 작성하세요.

- 대상 CATEGORY: `"과자"`, `"국"`, `"김치"`, `"식용유"`만
- 결과 정렬 기준: **가격(PRICE) 내림차순**

---

## 🧾 테이블 구조: FOOD_PRODUCT

| Column        | Type        | Description     |
|---------------|-------------|-----------------|
| PRODUCT_ID    | VARCHAR(10) | 상품 ID         |
| PRODUCT_NAME  | VARCHAR(50) | 상품명           |
| PRODUCT_CD    | VARCHAR(10) | 상품 코드        |
| CATEGORY      | VARCHAR(10) | 식품 분류        |
| PRICE         | NUMBER      | 가격 (숫자)       |

---

## ❌ 잘못된 풀이 예시

```sql
SELECT
  CATEGORY,
  MAX(PRICE) AS MAX_PRICE,
  PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE CATEGORY IN ("과자", "국", "김치", "식용유")
GROUP BY CATEGORY
ORDER BY PRICE DESC;
```

### 😱 문제점

- `GROUP BY CATEGORY`만 했는데 `PRODUCT_NAME`은 **그룹 기준도, 집계 함수도 아님**
- `MAX(PRICE)`는 맞지만, `PRODUCT_NAME`은 **해당 가격의 상품이 아닐 수도 있음**
- MySQL에서는 허용되지만, **정답 보장이 안 되는 비표준 동작**

---

## ✅ 정답 방법 1: 서브쿼리 + 튜플 조건

```sql
SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) IN (
    SELECT CATEGORY, MAX(PRICE)
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ("과자", "국", "김치", "식용유")
    GROUP BY CATEGORY
)
ORDER BY PRICE DESC;
```

- `(CATEGORY, PRICE)`가 **해당 분류의 최고가**인 행만 추출
- 단점: **최고가가 중복되면 여러 개 나올 수 있음**

---

## ✅ 정답 방법 2: ROW_NUMBER() 윈도우 함수 (MySQL 8.0 이상)

```sql
SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM (
  SELECT *,
         ROW_NUMBER() OVER (
             PARTITION BY CATEGORY
             ORDER BY PRICE DESC
         ) AS RN
  FROM FOOD_PRODUCT
  WHERE CATEGORY IN ("과자", "국", "김치", "식용유")
) ranked
WHERE RN = 1
ORDER BY PRICE DESC;
```

### 🔍 핵심 개념

| 키워드 | 설명 |
|--------|------|
| `PARTITION BY CATEGORY` | 식품 분류별로 묶기 |
| `ORDER BY PRICE DESC`   | 그룹 내에서 가격순 정렬 |
| `ROW_NUMBER()`          | 각 그룹에서 1번, 2번... 순서 부여 |
| `WHERE RN = 1`          | 각 분류에서 **가장 비싼 제품 1개**만 선택 |

---

## 🧠 요약 비교

| 방법 | 특징 | 중복 허용 | 정확성 | 추천 |
|------|------|------------|--------|------|
| GROUP BY + MAX | 가장 간단 | ❌ | ❌ | ❌ |
| 서브쿼리 + IN | 안정적 | ✅ | ✅ | ✅ |
| ROW_NUMBER() | 가장 정확 | ❌ | ✅ | ✅✅ (MySQL 8+ 권장) |

