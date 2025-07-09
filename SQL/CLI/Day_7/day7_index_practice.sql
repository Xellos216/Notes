-- ✅ users 테이블 인덱스 실습

-- 기본 인덱스 생성
CREATE INDEX idx_users_email ON users(email);

-- 인덱스 확인
SHOW INDEX FROM users;

-- 성능 확인용 쿼리
EXPLAIN SELECT * FROM users WHERE email = 'hong@example.com';

-- 인덱스 제거
DROP INDEX idx_users_email ON users;

-- ✅ orders_v2 테이블 복합 인덱스 실습

-- 복합 인덱스 생성
CREATE INDEX idx_orders_user_product ON orders_v2(user_id, product_id);

-- 성능 확인
EXPLAIN SELECT * FROM orders_v2 WHERE user_id = 1 AND product_id = 2;

-- 외래 키 제약조건 이름 확인
SELECT CONSTRAINT_NAME
FROM information_schema.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'orders_v2' AND REFERENCED_TABLE_NAME IS NOT NULL;

-- 외래 키 제거 (예시용)
ALTER TABLE orders_v2 DROP FOREIGN KEY orders_v2_ibfk_1;
ALTER TABLE orders_v2 DROP FOREIGN KEY orders_v2_ibfk_2;

-- 인덱스 제거
DROP INDEX idx_orders_user_product ON orders_v2;
