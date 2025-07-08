# SQL 14 - 가장 비싼 상품 구하기 (MAX)

> CodeKata / SQL / Day01 / MaxPrice

## 📌 문제 설명

`PRODUCT` 테이블에는 판매 중인 상품 정보가 저장되어 있습니다.  
이 중에서 가장 **높은 판매가(PRICE)** 를 가진 상품의 금액을 출력하는 SQL문을 작성하세요.

단, 결과 컬럼명은 반드시 `MAX_PRICE`로 지정해야 합니다.

---

## ✅ 테이블 구조

| Column name   | Type        | Nullable |
|---------------|-------------|----------|
| PRODUCT_ID    | INTEGER     | FALSE    |
| PRODUCT_CODE  | VARCHAR(8)  | FALSE    |
| PRICE         | INTEGER     | FALSE    |

> 상품코드는 8자리이며, 앞 2자리는 카테고리 코드입니다.

---

## ✅ 정답 쿼리

```sql
SELECT MAX(PRICE) AS MAX_PRICE
FROM PRODUCT;
```

---

## 💻 실행 결과 예시

예를 들어 `PRODUCT` 테이블이 다음과 같다면:

| PRODUCT_ID | PRODUCT_CODE | PRICE  |
|------------|---------------|--------|
| 1          | A1000001      | 10000  |
| 2          | A2000005      | 9000   |
| 3          | C1000006      | 22000  |

→ 가장 비싼 상품의 가격은 22,000원이므로, 출력 결과는 다음과 같습니다:

| MAX_PRICE |
|-----------|
| 22000     |

---

## 🧠 학습 포인트

- `MAX()` 함수로 최댓값 추출하기
- 별칭 지정: `AS MAX_PRICE`
- 집계 함수는 단일 컬럼에 대해 동작함

---

## 🖼 실행 화면 캡처

![실행결과](./Screenshot.png)
