# SQL 예습 Day_5: 서브쿼리(Subquery)

## ✅ 오늘의 목표
서브쿼리는 SQL 쿼리 안에 또 다른 쿼리를 포함하는 구조로, 복잡한 조건을 처리하거나 집계 결과를 활용할 수 있게 해준다.  
실무에서 `JOIN`과 함께 가장 자주 쓰이는 고급 SQL 기법 중 하나다.

---

## 🧩 서브쿼리란?

> 하나의 쿼리 내부에서 **또 다른 SELECT 쿼리**를 사용하는 방식

- `SELECT` 절에서 사용 → 특정 값을 가져와 출력
- `FROM` 절에서 사용 → 결과를 가상 테이블처럼 활용
- `WHERE` 절에서 사용 → 조건에 해당하는 행만 필터링
- 다양한 연산자와 함께 사용: `IN`, `EXISTS`, `=`, `>`, 등

---

## 1️⃣ SELECT 절에서 사용하는 서브쿼리

🔸 **사용 예 (이론상)**

```sql
SELECT 
  (SELECT name FROM users WHERE users.id = o.user_id) AS user_name,
  (SELECT name FROM products WHERE products.product_id = o.product_id) AS product_name,
  o.quantity
FROM orders_v2 o;
```

🔸 **실습 결과:**  
MySQL에서는 `SELECT` 절 내부 서브쿼리에서 외부 alias(`o.user_id`)를 사용할 때 오류 발생함.  
👉 실무에서도 **JOIN 방식으로 대체**하는 것이 일반적.

---

## 2️⃣ FROM 절에서 사용하는 서브쿼리

🔸 **사용 예**

```sql
SELECT u.name, summary.total_amount
FROM users u
JOIN (
  SELECT o.user_id, SUM(p.price * o.quantity) AS total_amount
  FROM orders_v2 o
  JOIN products p ON o.product_id = p.product_id
  GROUP BY o.user_id
) AS summary
ON u.id = summary.user_id;
```

🔸 **해석**  
- `orders_v2`와 `products`를 먼저 JOIN해서 사용자별 구매 총액(`SUM`)을 계산
- 그 결과를 `summary`라는 가상 테이블로 만든 뒤, `users`와 다시 JOIN

🔸 **결과 예**
| name | total_amount |
|------|--------------|
| Hong | 1250000      |
| BOB  | 45000        |

---

## 3️⃣ WHERE 절에서 사용하는 서브쿼리

🔸 **사용 예**

```sql
SELECT name
FROM products
WHERE product_id IN (
  SELECT product_id
  FROM orders_v2
  WHERE user_id = (
    SELECT id FROM users WHERE name = 'Hong'
  )
);
```

🔸 **해석**
- 'Hong'의 사용자 ID를 찾고
- 그 사람이 주문한 `product_id`를 추출
- 해당 상품의 이름을 `products`에서 조회

🔸 **결과 예**
```
노트북
마우스
```

---

## 4️⃣ 다양한 연산자와 서브쿼리

### (1) `IN`

```sql
SELECT DISTINCT name
FROM products
WHERE product_id IN (
  SELECT product_id
  FROM orders_v2
  WHERE user_id IN (
    SELECT id FROM users WHERE age BETWEEN 20 AND 29
  )
);
```

→ 20대 사용자가 주문한 상품

---

### (2) `EXISTS`

```sql
SELECT name
FROM products p
WHERE EXISTS (
  SELECT 1
  FROM orders_v2 o
  WHERE o.product_id = p.product_id
);
```

→ 주문 이력이 있는 상품만 조회

---

### (3) `=` 단일 결과

```sql
SELECT name
FROM products
WHERE price = (
  SELECT MAX(price)
  FROM products
);
```

→ 가장 비싼 상품 출력 (예: '노트북')

---

## 5️⃣ JOIN vs 서브쿼리 비교 실습

### (1) 서브쿼리 방식

```sql
SELECT 
  u.name,
  (SELECT SUM(p.price * o.quantity)
   FROM orders_v2 o
   JOIN products p ON o.product_id = p.product_id
   WHERE o.user_id = u.id) AS total_spent
FROM users u;
```

### (2) JOIN 방식

```sql
SELECT 
  u.name,
  SUM(p.price * o.quantity) AS total_spent
FROM users u
JOIN orders_v2 o ON u.id = o.user_id
JOIN products p ON p.product_id = o.product_id
GROUP BY u.id;
```

---

## 📌 실습에서 배운 점

- **MySQL에서 SELECT 절 서브쿼리는 외부 alias 사용 시 제한이 있음**
- **FROM 절 서브쿼리는 집계 결과를 다룰 때 매우 유용함**
- **WHERE 절 서브쿼리는 단순 조건 필터링에 적합함**
- **JOIN은 다중 테이블 결합에 최적, 성능 면에서 서브쿼리보다 일반적으로 유리함**
- **상황에 맞게 JOIN과 서브쿼리를 선택하는 전략이 중요함**

---

## 🧠 어려웠던 이유 & 팁

서브쿼리는 쿼리 안에 쿼리가 들어가 있기 때문에 **처음에는 읽는 순서가 헷갈리고**,  
`FROM`, `WHERE`, `JOIN`에서의 문맥 차이를 익히는 데 시간이 걸림.

> 🔸 팁: **안쪽부터 해석하라!**  
> 서브쿼리는 항상 안쪽 쿼리를 먼저 실행한다고 생각하고 읽는 것이 핵심.

---