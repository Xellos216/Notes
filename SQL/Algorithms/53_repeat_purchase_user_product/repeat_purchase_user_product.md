# 재구매가 일어난 상품과 회원 리스트 구하기

## 🧾 문제 설명

`ONLINE_SALE` 테이블에서 **동일한 회원이 동일한 상품을 재구매**한 경우를 찾아,  
재구매한 회원 ID(`USER_ID`)와 상품 ID(`PRODUCT_ID`)를 출력하는 SQL문을 작성하시오.

- 결과는 `USER_ID` 기준 **오름차순**,  
  동일 회원 내에서는 `PRODUCT_ID` 기준 **내림차순**으로 정렬합니다.

---

## 📘 테이블 구조: ONLINE_SALE

| 컬럼명         | 타입         | NULL 여부 |
|----------------|--------------|-----------|
| ONLINE_SALE_ID | INT          | NOT NULL  |
| USER_ID        | INT          | NOT NULL  |
| PRODUCT_ID     | INT          | NOT NULL  |
| SALES_AMOUNT   | INT          | NOT NULL  |
| SALES_DATE     | DATE         | NOT NULL  |

---

## 💡 풀이 핵심

- **USER_ID와 PRODUCT_ID의 조합**으로 `GROUP BY`
- 각 조합별 `COUNT(*)`를 세서 `HAVING COUNT(*) >= 2` 조건으로 필터링
- 재구매 여부 판별은 "같은 회원이 같은 상품을 2번 이상 구매한 경우"

---

## ✅ 정답 예시 쿼리

```sql
SELECT
  USER_ID,
  PRODUCT_ID
FROM
  ONLINE_SALE
GROUP BY
  USER_ID, PRODUCT_ID
HAVING
  COUNT(*) >= 2
ORDER BY
  USER_ID ASC,
  PRODUCT_ID DESC;
```

---

## 📌 예시

### ONLINE_SALE 테이블

| ONLINE_SALE_ID | USER_ID | PRODUCT_ID | SALES_DATE  |
|----------------|---------|------------|--------------|
| 1              | 1       | 3          | 2022-02-25   |
| 2              | 1       | 4          | 2022-03-01   |
| 3              | 2       | 4          | 2022-03-12   |
| 4              | 3       | 3          | 2022-03-31   |
| 5              | 3       | 3          | 2022-04-03   |
| 6              | 2       | 1          | 2022-04-06   |
| 7              | 1       | 4          | 2022-05-11   |

### → 출력 결과

| USER_ID | PRODUCT_ID |
|---------|-------------|
| 1       | 4           |
| 3       | 3           |

---

## 🧠 개념 정리

- `GROUP BY 1,2`: `USER_ID`, `PRODUCT_ID` 조합으로 그룹화
- `HAVING COUNT(*) >= 2`: 그룹에 속한 행 수가 2개 이상인 경우 (즉, 재구매)
