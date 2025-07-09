# Day 7 – QA 정리 (상세 버전)

이번 학습에서 실습 중 발생했던 주요 질문과 그 해결 과정을 정리했다.

---

## ❓ Q1. 인덱스를 만들었는데 `EXPLAIN` 결과가 그대로인 이유?

**현상**:  
`EXPLAIN SELECT * FROM users WHERE email = 'alice@exaple.com';` 실행 결과가 인덱스를 만들기 전과 동일함

**원인**:  
`alice@exaple.com` 오타로 인해 조건에 매칭되는 데이터가 없어 MySQL 옵티마이저가 인덱스를 사용하지 않음

**해결**:  
실제 존재하는 값(`hong@example.com`)으로 조건을 수정하면 `EXPLAIN` 결과에서 `type = const`, `key = unique_email`이 출력되며 인덱스 사용이 확인됨

---

## ❓ Q2. 인덱스(Index)의 정확한 의미는?

**정의**:  
WHERE, JOIN 조건 등에 자주 쓰이는 컬럼을 빠르게 탐색하기 위한 B-Tree 기반 데이터 구조

**비유**:  
책의 목차처럼, 특정 키워드로 빠르게 jump해서 행(row)의 위치를 찾아주는 역할

---

## ❓ Q3. 인덱스는 WHERE 조건을 빠르게 찾기 위한 구조물인가?

**정답**:  
맞음. 인덱스가 없으면 테이블 전체를 검색해야 하며, 인덱스는 WHERE 조건으로 원하는 row 위치를 빠르게 탐색하게 해줌

---

## ❓ Q4. `SHOW INDEX` 결과에서 어떤 row는 인덱스 이름이 없고 어떤 row는 있는 이유?

**설명**:  
복합 인덱스(`idx_orders_user_product`)는 여러 컬럼을 포함하기 때문에 `SHOW INDEX`에서 각 컬럼이 별도 row로 출력됨

---

## ❓ Q5. `EXPLAIN` 결과에서 `type = const`, `key = unique_email`은 어떤 의미?

**해석**:  
`email = 'hong@example.com'` 처럼 결과가 1건으로 확정되는 조건이 있을 때, MySQL은 가장 빠른 방식(const)으로 실행하며 인덱스를 완전 활용함
