# SQL 예습 Day 7 요약

이번 Day 7 학습에서는 SQL 쿼리의 성능 최적화를 위한 INDEX(인덱스)의 개념과 동작 방식을 `users`, `orders_v2` 테이블을 중심으로 실습했다.

## ✅ 학습 주제 및 흐름

1. **INDEX 개념 정리**
   - 인덱스의 역할: 검색 속도 향상
   - 동작 구조: 주로 B-Tree 기반

2. **기본 인덱스 실습**
   - CREATE INDEX, SHOW INDEX, EXPLAIN으로 인덱스 사용 여부 확인
   - UNIQUE 인덱스와 일반 인덱스의 차이 확인

3. **복합 인덱스 실습**
   - 복수 컬럼 기준 인덱스 생성
   - LEFTMOST PREFIX 원칙 체험
   - 단일 인덱스와 복합 인덱스의 우선순위 비교

4. **인덱스 제거 실습**
   - DROP INDEX
   - FOREIGN KEY와 연결된 인덱스 제거 실패 → 제약조건 먼저 제거

5. **EXPLAIN 결과 분석**
   - type, key, rows, Extra 등 주요 항목 해석법 숙지

---

## 🧪 실습 테이블

- `users`: 유저 정보 (id, name, email)
- `orders_v2`: 주문 정보 (order_id, user_id, product_id, quantity, order_date)

---

## 🔍 실습 목표

- 인덱스가 성능에 미치는 영향을 직접 테스트
- 복합 인덱스 조건 충족 여부에 따른 성능 차이 분석
- `EXPLAIN` 결과를 통해 실행 계획을 해석하는 능력 배양

---

## 💡 학습 성과

- 단일 및 복합 인덱스의 생성, 사용 여부 확인
- 옵티마이저의 쿼리 실행 전략 이해 (`type = const`, `ref` 등)
- 인덱스 제거와 제약조건의 관계 이해
