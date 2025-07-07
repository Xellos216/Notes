# JOIN vs 서브쿼리 비교 정리

## ✅ 기본 비교

| 항목 | `JOIN` | `서브쿼리` |
|------|--------|------------|
| **기본 개념** | 여러 테이블을 **한 줄에 병합**하여 조회 | 다른 쿼리 안에 포함된 **중첩 쿼리** |
| **사용 위치** | `FROM`, `ON`, `WHERE`, `SELECT` 등 | 주로 `WHERE`, `SELECT`, `FROM` 내부 |
| **성능** | 인덱스가 잘 잡히면 일반적으로 빠름 | 작은 데이터에는 무방, 큰 데이터엔 느려질 수 있음 |
| **가독성** | 명확한 테이블 관계 표현에 유리 | 간단한 조건 필터링에는 깔끔함 |
| **유형** | `INNER JOIN`, `LEFT JOIN`, `RIGHT JOIN`, 등 | `IN`, `EXISTS`, `=`, `SELECT 절`, `FROM 절` 등 |
| **대표 예시** | 유저와 주문 테이블을 조인하여 이름과 구매 내역 조회 | 특정 조건(예: 가장 비싼 상품)으로 필터링 |
| **주의사항** | `JOIN` 후 `GROUP BY` 필수인 경우 있음 | `SELECT` 절에서는 MySQL 버전에 따라 외부 alias 인식 제한 있음 |

---

## ✅ 언제 어떤 걸 써야 할까?

| 상황 | 추천 방식 | 이유 |
|------|------------|------|
| **두 테이블을 연결해 데이터를 함께 보고 싶을 때** | `JOIN` | 관계형 데이터 활용에 최적 |
| **특정 조건 만족 여부만 확인하고 싶을 때** | `EXISTS`, `IN` 서브쿼리 | 짧고 직관적 |
| **단일 값 비교** (예: MAX, MIN) | `=` 서브쿼리 | 계산 대상이 하나일 때 적합 |
| **외부 테이블과 관계 없는 단독 필터** | 서브쿼리 | 간결함 유지 |
| **여러 조건을 동시에 계산하거나 요약해야 할 때** | `JOIN + GROUP BY` | 통계, 집계 연산에 최적 |

---

## ✅ 예시 비교

### 1. 서브쿼리 예시

```sql
SELECT name
FROM products
WHERE price = (SELECT MAX(price) FROM products);
```

### 2. JOIN 예시

```sql
SELECT u.name, p.name AS product_name
FROM users u
JOIN orders_v2 o ON u.id = o.user_id
JOIN products p ON p.product_id = o.product_id;
```