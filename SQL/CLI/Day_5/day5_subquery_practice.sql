-- [1] SELECT 절에서 서브쿼리 사용 (비추 / JOIN으로 대체됨)
-- SELECT절 서브쿼리는 MySQL에서 외부 alias 인식 제한으로 실행 어려움

-- [2] FROM 절에서 서브쿼리 사용
SELECT u.name, summary.total_amount
FROM users u
JOIN (
  SELECT o.user_id, SUM(p.price * o.quantity) AS total_amount
  FROM orders_v2 o
  JOIN products p ON o.product_id = p.product_id
  GROUP BY o.user_id
) AS summary
ON u.id = summary.user_id;

-- [3] WHERE 절에서 서브쿼리 사용
SELECT name
FROM products
WHERE product_id IN (
  SELECT product_id
  FROM orders_v2
  WHERE user_id = (
    SELECT id FROM users WHERE name = 'Hong'
  )
);

-- [4] 다양한 비교 연산자 실습

-- (4-1) IN
SELECT DISTINCT name
FROM products
WHERE product_id IN (
  SELECT product_id
  FROM orders_v2
  WHERE user_id IN (
    SELECT id FROM users WHERE age BETWEEN 20 AND 29
  )
);

-- (4-2) EXISTS
SELECT name
FROM products p
WHERE EXISTS (
  SELECT 1
  FROM orders_v2 o
  WHERE o.product_id = p.product_id
);

-- (4-3) = (단일 결과)
SELECT name
FROM products
WHERE price = (
  SELECT MAX(price)
  FROM products
);

-- [5] JOIN vs 서브쿼리 비교

-- (5-1) 서브쿼리 방식
SELECT 
  u.name,
  (SELECT SUM(p.price * o.quantity)
   FROM orders_v2 o
   JOIN products p ON o.product_id = p.product_id
   WHERE o.user_id = u.id) AS total_spent
FROM users u;

-- (5-2) JOIN 방식
SELECT 
  u.name,
  SUM(p.price * o.quantity) AS total_spent
FROM users u
JOIN orders_v2 o ON u.id = o.user_id
JOIN products p ON p.product_id = o.product_id
GROUP BY u.id;