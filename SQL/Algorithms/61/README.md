## 🧠 Problem
서울에 위치한 식당의 식당 ID, 이름, 음식 종류, 즐겨찾기 수, 주소, 리뷰 평균 점수를 조회하세요.
리뷰 평균 점수는 소수점 셋째 자리에서 반올림하며, 평균 점수가 같다면 즐겨찾기 수를 기준으로 내림차순 정렬하세요.

---

## 💾 SQL Query
```sql
SELECT 
  I.REST_ID,
  I.REST_NAME,
  I.FOOD_TYPE,
  I.FAVORITES,
  I.ADDRESS,
  ROUND(AVG(R.REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO I
  JOIN REST_REVIEW R ON I.REST_ID = R.REST_ID
WHERE I.ADDRESS LIKE '서울%'
GROUP BY I.REST_ID
ORDER BY SCORE DESC, I.FAVORITES DESC;
```

### 🔹 `JOIN`
- `REST_INFO`와 `REST_REVIEW`를 `REST_ID` 기준으로 결합하여 리뷰 정보를 함께 조회

### 🔹 `LIKE`
- 주소가 '서울'로 시작하는 식당만 필터링하기 위해 `LIKE '서울%'` 사용

### 🔹 `AVG`, `ROUND`
- 리뷰 점수의 평균을 계산하고, `ROUND(AVG(...), 2)`로 소수점 둘째 자리까지 반올림

### 🔹 `GROUP BY`
- 식당별 평균 리뷰 점수를 계산하기 위해 식당 ID 기준으로 그룹화

### 🔹 `ORDER BY`
- 평균 점수 내림차순 → 즐겨찾기 수 내림차순 정렬

---

## 문제 풀이 흐름 요약
- `JOIN`으로 리뷰 데이터 결합
- `WHERE`로 서울 지역 필터링
- `GROUP BY`로 식당별 집계
- `ROUND(AVG(...))`로 평균 리뷰 점수 계산
- `ORDER BY`로 점수 및 즐겨찾기 기준 정렬
