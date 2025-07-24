# 💸 가격대 별 상품 개수 구하기

## 📘 문제 설명

`PRODUCT` 테이블에서 상품 가격(`PRICE`)을 기준으로 1만 원 단위로 구간을 나누고, 각 가격대별 상품 개수를 구하세요.

- 0~9999원: 0 구간
- 10000~19999원: 10000 구간
- 20000~29999원: 20000 구간
- ...
- 80000~89999원: 80000 구간

출력 컬럼은 `PRICE_GROUP`, `PRODUCTS`이며, `PRICE_GROUP` 기준 오름차순 정렬합니다.

---

## 🧾 테이블 구조: PRODUCT

| Column         | Type     | Description     |
|----------------|----------|------------------|
| PRODUCT_ID     | INTEGER  | 상품 ID          |
| PRODUCT_CODE   | VARCHAR  | 상품 코드        |
| PRICE          | INTEGER  | 가격 (원)         |

---

## ✅ 방법 1: CASE WHEN + BETWEEN

```sql
SELECT
  CASE
    WHEN PRICE BETWEEN 10000 AND 19999 THEN 10000
    WHEN PRICE BETWEEN 20000 AND 29999 THEN 20000
    WHEN PRICE BETWEEN 30000 AND 39999 THEN 30000
    WHEN PRICE BETWEEN 40000 AND 49999 THEN 40000
    WHEN PRICE BETWEEN 50000 AND 59999 THEN 50000
    WHEN PRICE BETWEEN 60000 AND 69999 THEN 60000
    WHEN PRICE BETWEEN 70000 AND 79999 THEN 70000
    WHEN PRICE BETWEEN 80000 AND 89999 THEN 80000
  END AS PRICE_GROUP,
  COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY 1
ORDER BY 1 ASC;
```

- 범위를 명시적으로 구분할 수 있어 **유연성**은 높지만 **코드 길이**는 길어짐.

---

## ✅ 방법 2: `DIV` 연산자 사용

```sql
SELECT
  (PRICE DIV 10000) * 10000 AS PRICE_GROUP,
  COUNT(*) AS PRODUCTS
FROM PRODUCT
WHERE PRICE BETWEEN 10000 AND 89999
GROUP BY 1
ORDER BY 1 ASC;
```

### 📌 `DIV`란?
- 정수 나눗셈 연산자
- 예: `17000 DIV 10000` → `1`
- `* 10000`으로 다시 구간 기준값으로 복원

---

## ✅ 방법 3: `FLOOR()` 함수 사용

```sql
SELECT
  FLOOR(PRICE / 10000) * 10000 AS PRICE_GROUP,
  COUNT(*) AS PRODUCTS
FROM PRODUCT
WHERE PRICE BETWEEN 10000 AND 89999
GROUP BY 1
ORDER BY 1 ASC;
```

### 📌 `FLOOR()`란?
- 소수점 이하 **버림** 함수
- 예: `FLOOR(17.999) = 17`
- `PRICE / 10000` → 가격 구간의 몫 → `* 10000`으로 구간 시작값 도출

---

## 🧪 예시 데이터

| PRODUCT_ID | PRICE |
|------------|-------|
| 1          | 10000 |
| 2          | 9000  |
| 3          | 22000 |
| 4          | 15000 |
| 5          | 30000 |
| 6          | 17000 |

### 예시 결과:

| PRICE_GROUP | PRODUCTS |
|-------------|----------|
| 0           | 1        |
| 10000       | 3        |
| 20000       | 1        |
| 30000       | 1        |

---

## 🧠 요점 비교 정리

| 방법 | 장점 | 단점 |
|------|------|------|
| CASE WHEN | 세밀한 커스터마이징 가능 | 길고 유지보수 불편 |
| DIV | 간단하고 빠름 | 정수 나눗셈 특화 (MySQL 전용) |
| FLOOR | 범용 SQL 함수로 사용 가능 | `DIV`보다 약간 느릴 수 있음 |

---

## ✅ 추천

- **단순 등간격 구간 분류**라면 `DIV` 또는 `FLOOR()` 방식 적극 추천
- **특정 예외 구간이 있다면 `CASE WHEN` 방식 사용**
