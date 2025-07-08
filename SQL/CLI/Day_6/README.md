# SQL 예습 Day 6 요약

이번 Day 6 학습에서는 SQL의 집계 관련 핵심 기능인 `GROUP BY`, `HAVING`, `JOIN`, 그리고 `서브쿼리(Subquery)`를 실제 테이블(`users`, `products`, `orders_v2`)을 사용해 실습했다.

## ✅ 학습 주제 및 흐름

1. **GROUP BY**  
   - 특정 컬럼 기준으로 그룹화하고 집계 함수 적용
   - 유저별 주문 수, 상품 카테고리별 평균 가격 등

2. **HAVING 절과 WHERE 절의 차이점**  
   - WHERE: 개별 행 필터링
   - HAVING: 그룹 결과 필터링

3. **JOIN + GROUP BY 조합**  
   - 여러 테이블을 JOIN한 뒤, 원하는 기준으로 그룹화
   - 유저 이름 + 총 결제금액 같이 실무에서 매우 흔한 패턴

4. **서브쿼리 + GROUP BY 결합**  
   - 집계 결과를 서브쿼리로 감싼 후 정렬·LIMIT·JOIN 등 2차 가공
   - 예: 총 구매금액이 가장 높은 유저 찾기

5. **실무 전략 요약**  
   - WHERE vs HAVING 구분
   - JOIN 후 집계 흐름 숙지
   - 서브쿼리 활용한 상위 추출 등

---

## 🧪 실습 테이블

- `users`: 유저 정보 (id, name)
- `products`: 상품 정보 (product_id, name, price, category)
- `orders_v2`: 주문 정보 (order_id, user_id, product_id, quantity, order_date)

---

## 🔍 실습 목표

- CLI 환경에서 집계 쿼리를 정확히 실행
- JOIN → GROUP BY → HAVING → 서브쿼리 흐름 파악
- 실무 SQL 분석 구조를 직접 실습을 통해 익히기

---

## 💡 학습 성과

- `GROUP BY`, `HAVING`, `JOIN` 기본기 확립
- 서브쿼리 흐름 이해 → 정렬, LIMIT 조합 가능
- 실무 리포트 쿼리 작성 전략 감 잡음
