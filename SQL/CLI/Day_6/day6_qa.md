# Day 6 – QA 정리 (상세 버전)

이번 학습에서 실습 중 발생했던 주요 질문과 그 해결 과정을 정리했다.

---

## ❓ Q1. orders_v2 테이블에서 price가 없는데 SUM이 안 되는 이유?

**현상**:  
`SELECT SUM(price) FROM orders_v2;` 실행 시 "Unknown column 'price'" 오류 발생

**원인**:  
orders_v2 테이블에는 `price` 컬럼이 존재하지 않음. 가격 정보는 `products` 테이블에 있음.

**해결**:  
`orders_v2`와 `products` 테이블을 `JOIN`한 후 `products.price * quantity`로 계산해야 함.

---

## ❓ Q2. 테이블의 컬럼 구조를 CLI에서 확인하는 방법?

**방법**:
```sql
DESC 테이블명;
-- 또는
SHOW COLUMNS FROM 테이블명;
```

또는,
```sql
SELECT * FROM 테이블명 LIMIT 5;
```
로 직접 데이터 일부를 조회하며 확인할 수도 있음.

---

## ❓ Q3. WHERE 절과 HAVING 절의 차이는 정확히 무엇인가?

| 항목     | WHERE 절               | HAVING 절                    |
|----------|-------------------------|-------------------------------|
| 적용 시점 | GROUP BY 이전           | GROUP BY 이후                 |
| 대상     | 개별 행 (raw record)    | 그룹 결과 (aggregated group) |
| 예시     | quantity > 1            | COUNT(*) > 1                 |

---

## ❓ Q4. JOIN 뒤에 INNER, LEFT를 명시하지 않아도 되는 이유?

**설명**:  
`JOIN`은 SQL에서 `INNER JOIN`과 동일하게 작동함. 즉, 양쪽 테이블에 매칭되는 데이터만 추출됨.

**예시**:
```sql
-- 동일한 결과
SELECT * FROM A JOIN B ON 조건;
SELECT * FROM A INNER JOIN B ON 조건;
```

**추가 참고**:
- `LEFT JOIN`: 왼쪽 테이블 기준으로 모두 출력
- `RIGHT JOIN`: 오른쪽 테이블 기준으로 모두 출력
- `FULL OUTER JOIN`: 양쪽 전체 포함 (MySQL에서는 직접 지원 안 함)

---

## ❓ Q5. 서브쿼리 사용 시 JOIN 순서가 바뀌는 이유?

**현상**:  
서브쿼리를 먼저 작성하고, 그 결과에 대해 JOIN하거나 정렬해야 하는 구조가 낯설게 느껴짐.

**이유**:  
서브쿼리는 먼저 실행되어 **임시 테이블처럼 작동**함.  
따라서 JOIN, ORDER BY는 바깥 쿼리에서 처리하는 것이 논리적으로 맞음.

**정리**:
- 안쪽 서브쿼리: 집계 수행 (`GROUP BY`, `SUM`, `COUNT` 등)
- 바깥쪽 쿼리: 필터링, 정렬, JOIN 등 추가 조작
