-- 1. 유저별 주문 횟수
SELECT user_id, COUNT(*) AS order_count
FROM orders_v2
GROUP BY user_id;

-- 2. 유저별 총 구매 금액
SELECT o.user_id, SUM(p.price * o.quantity) AS total_spent
FROM orders_v2 o
JOIN products p ON o.product_id = p.product_id
GROUP BY o.user_id;

-- 3. HAVING 절 예제
SELECT user_id, COUNT(*) AS order_count
FROM orders_v2
GROUP BY user_id
HAVING COUNT(*) > 1;

-- 4. 유저 이름 + 결제금액
SELECT u.name, SUM(p.price * o.quantity) AS total_spent
FROM orders_v2 o
JOIN users u ON o.user_id = u.id
JOIN products p ON o.product_id = p.product_id
GROUP BY u.name;

-- 5. 총 구매금액 상위 1명
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
