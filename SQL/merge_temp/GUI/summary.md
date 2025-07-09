# SQL Summary: Beginner to Advanced

이 요약은 SQL 입문부터 실무형 데이터 분석까지 다룬 내용을 주차별로 정리한 문서입니다. 
각 주차는 실습 위주의 예제를 중심으로, 핵심 함수와 쿼리 구조를 익히는 데 집중합니다.

---

## SQL 기본 문법과 조건 필터링

- SQL 기본 구조 학습: `SELECT`, `FROM`, `WHERE`
- 조건 필터링: `=`, `<>`, `>`, `<`, `BETWEEN`, `IN`, `LIKE`
- 논리 연산자: `AND`, `OR`, `NOT`
- 컬럼 선택 및 `AS`를 이용한 별칭 부여
- 실습 예시:
  - 특정 고객 정보 조회: `SELECT * FROM customers WHERE age = 21;`
  - 특정 문자열 포함 필터링: `WHERE name LIKE '김%'`
  - 복수 조건 조합 필터링: `WHERE cuisine_type = 'Korean' AND price >= 30000`

---

## 집계 함수, 그룹화, 정렬

- 집계 함수 학습: `SUM`, `AVG`, `COUNT`, `MIN`, `MAX`
- 그룹화 처리: `GROUP BY`
- 결과 정렬: `ORDER BY`
- 실습 예시:
  - 음식 종류별 총 주문 금액: `SELECT cuisine_type, SUM(price) FROM food_orders GROUP BY cuisine_type`
  - 음식점별 최대 주문금액 정렬: `GROUP BY restaurant_name ORDER BY MAX(price) DESC`
  - 조건 필터링과 집계 조합: `WHERE price >= 30000`

---

## 문자 가공과 조건 분기 처리

- 문자열 함수: `REPLACE`, `SUBSTRING`, `CONCAT`
- 조건문: `IF`, `CASE`를 통한 세그먼트 구분
- 타입 변환: `CAST(... AS DECIMAL/CHAR)`
- 실습 예시:
  - 이메일 도메인 분리: `SUBSTRING(email, LOCATE('@', email))`
  - 지역 정보 추출: `SUBSTRING(addr, 1, 2)`
  - 사용자 분류: `CASE WHEN age BETWEEN 10 AND 19 THEN ... END`

---

## Subquery & Join을 활용한 연산

- Subquery 개념 및 중첩 구조 활용
- Join을 통한 테이블 간 데이터 결합: `LEFT JOIN`, `INNER JOIN`
- 실습 예시:
  - 음식점 평균 단가 계산 후 수수료율 적용:
    ```sql
    SELECT restaurant_name, price_per_plate * ratio AS fee
    FROM (SELECT ...) a
    ```
  - 고객 나이 기반 할인율 적용:
    ```sql
    a.price * ((b.age - 50) * 0.005) AS discount_price
    ```
  - 그룹 기준 세분화: 연령대·금액대 기준 분류 쿼리

---

## 고급 SQL - 이상치 처리, 피벗, 윈도우 함수

- 이상값 및 NULL 처리: `IF`, `COALESCE`, `CASE`
- 피벗 테이블 구현: `IF + MAX` 조합을 통한 행 → 열 변환
- 윈도우 함수 사용법:
  - `RANK() OVER(PARTITION BY ...)`
  - `SUM() OVER(...)`로 누적합 및 비율 계산
- 날짜 처리:
  - 날짜 포맷 변경: `DATE_FORMAT(DATE(date), '%Y-%m')`
  - 특정 조건 필터링: `WHERE DATE_FORMAT(date, '%m') = '03'`
- 실습 예시:
  - 연령대 및 성별별 주문건수 피벗화
  - 시간대별 주문건수 통계 집계

---

## 📌 실습 특징

- CLI + GUI 병행 실습 (MySQL + DBeaver)
- 실무 데이터 기반 응용력 향상 중심
- 사용자 세그먼트, 수수료 계산, 할인율 적용 등 다양한 시나리오 실습 포함

---
