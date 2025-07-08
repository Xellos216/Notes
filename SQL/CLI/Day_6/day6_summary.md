# Day 6 – GROUP BY / HAVING / JOIN / Subquery

이번 학습에서는 SQL의 핵심 개념인 `GROUP BY`, `HAVING`, `JOIN`, 그리고 `서브쿼리(Subquery)`를 결합한 집계 전략을 실습 중심으로 익혔다.

---

## 1. GROUP BY 기본 구조

- `GROUP BY`는 특정 컬럼을 기준으로 행을 묶고, 묶인 그룹에 대해 집계 함수(COUNT, SUM, AVG 등)를 적용할 때 사용한다.
- 예를 들어, 유저별 주문 횟수를 구하거나, 상품 카테고리별 평균 가격을 계산할 때 사용된다.

**기본 형식:**
```sql
SELECT 그룹기준컬럼, 집계함수
FROM 테이블명
GROUP BY 그룹기준컬럼;
```

---

## 2. WHERE vs HAVING

- `WHERE`: GROUP BY **이전**, 개별 행을 필터링
- `HAVING`: GROUP BY **이후**, 집계된 결과(그룹)에 조건을 걸 때 사용

| 구문   | 필터 대상     | 적용 시점  |
|--------|----------------|-------------|
| WHERE  | 개별 행       | GROUP BY 이전 |
| HAVING | 그룹 결과     | GROUP BY 이후 |

**예시 비교:**
```sql
-- WHERE: 주문 수량 2개 이상만 필터링
SELECT user_id, COUNT(*) 
FROM orders_v2
WHERE quantity >= 2
GROUP BY user_id;

-- HAVING: 주문 횟수가 2번 이상인 유저만 필터링
SELECT user_id, COUNT(*) 
FROM orders_v2
GROUP BY user_id
HAVING COUNT(*) >= 2;
```

---

## 3. GROUP BY + JOIN

- 여러 테이블을 JOIN한 후, 원하는 기준으로 그룹화하여 집계할 수 있다.
- 실무에서 매우 자주 사용되는 패턴으로, 예를 들어 유저별 총 결제 금액을 구할 때 사용한다.

```sql
SELECT u.name, SUM(p.price * o.quantity) AS total_spent
FROM orders_v2 o
JOIN users u ON o.user_id = u.id
JOIN products p ON o.product_id = p.product_id
GROUP BY u.name;
```

---

## 4. GROUP BY + Subquery

- 집계 결과를 서브쿼리로 감싼 뒤, 그 결과에 대해 정렬/필터링/JOIN 등을 다시 수행할 수 있다.
- 특히 "총 구매 금액이 가장 많은 유저 찾기", "Top 3 유저" 등의 상황에서 유용하다.

```sql
SELECT u.name, sub.total_spent
FROM (
  SELECT o.user_id, SUM(p.price * o.quantity) AS total_spent
  FROM orders_v2 o
  JOIN products p ON o.product_id = p.product_id
  GROUP BY o.user_id
) AS sub
JOIN users u ON sub.user_id = u.id
ORDER BY sub.total_spent DESC
LIMIT 1;
```

---

## 5. 실무 전략 요약

- 단일 테이블 분석: `GROUP BY` + 집계함수
- 조건 필터링이 필요하면: `WHERE`, 또는 집계값 조건엔 `HAVING`
- 상세 정보(이름 등) 붙이려면: `JOIN` 사용
- 상위 n개 추출, 비교 분석이 필요하면: `서브쿼리`와 `ORDER BY`, `LIMIT` 조합

실무에서 이 네 가지를 적절히 조합하면 대부분의 통계/리포트 SQL을 구성할 수 있다.
