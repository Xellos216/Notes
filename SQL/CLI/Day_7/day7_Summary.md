# 📘 Day_7 Summary: INDEX

## ✅ 1. INDEX 개념 정리

| 항목 | 설명 |
|------|------|
| 정의 | 특정 컬럼의 값을 빠르게 검색하기 위한 자료구조 (보통 B-Tree) |
| 목적 | `WHERE`, `JOIN`, `ORDER BY` 시 검색 속도 향상 |
| 특징 | SELECT 성능 향상 / INSERT·UPDATE·DELETE 시 부하 증가 가능 |
| 비교 | 인덱스 없음 → Full Table Scan / 인덱스 있음 → 빠른 탐색 |

## ✅ 2. 기본 인덱스 실습

```sql
CREATE INDEX idx_users_email ON users(email);
SHOW INDEX FROM users;
EXPLAIN SELECT * FROM users WHERE email = 'hong@example.com';
```

- `type = const`, `key = unique_email`, `rows = 1` → 인덱스 최적 사용 확인
- `idx_users_email`보다 `UNIQUE` 인덱스가 우선 사용됨

## ✅ 3. 복합 인덱스 실습

```sql
CREATE INDEX idx_orders_user_product ON orders_v2(user_id, product_id);
EXPLAIN SELECT * FROM orders_v2 WHERE user_id = 1 AND product_id = 2;
```

- `key = product_id` → 단일 인덱스만 사용됨 (복합 인덱스 미사용)
- `LEFTMOST PREFIX` 원칙 주의: 복합 인덱스는 앞쪽부터 조건 충족해야 효율적

## ✅ 4. 인덱스 제거와 FOREIGN KEY

```sql
DROP INDEX idx_orders_user_product ON orders_v2; -- 실패
-- 이유: FOREIGN KEY 제약조건과 연결됨
```

**해결 흐름:**

```sql
-- 외래 키 제약조건 확인
SELECT CONSTRAINT_NAME
FROM information_schema.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'orders_v2' AND REFERENCED_TABLE_NAME IS NOT NULL;

-- 외래 키 제거
ALTER TABLE orders_v2 DROP FOREIGN KEY orders_v2_ibfk_1;
ALTER TABLE orders_v2 DROP FOREIGN KEY orders_v2_ibfk_2;

-- 인덱스 제거
DROP INDEX idx_orders_user_product ON orders_v2;
```

## ✅ 5. EXPLAIN 결과 해석 요약

| 항목 | 의미 |
|------|------|
| `type` | 접근 방식 (`const` > `ref` > `ALL`) |
| `key` | 실제 사용된 인덱스 이름 |
| `rows` | 예측 스캔 행 수 |
| `filtered` | 필터 조건 통과율 |
| `Extra` | 추가 처리 설명 (`Using where`, `Using index`, 등) |
