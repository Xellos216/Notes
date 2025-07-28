## 🧠 Problem
`CAR_RENTAL_COMPANY_RENTAL_HISTORY` 테이블에서  
평균 대여 기간이 7일 이상인 자동차들의 `CAR_ID`와  
소수점 첫째 자리까지 반올림한 평균 대여 기간(`AVERAGE_DURATION`)을 출력하시오.  

결과는 평균 대여 기간 기준 내림차순 정렬하고,  
평균 기간이 같을 경우 `CAR_ID` 기준으로 내림차순 정렬하시오.

---

## 💾 SQL Query
```sql
SELECT
  CAR_ID,
  ROUND(AVG(DATEDIFF(END_DATE, START_DATE) + 1), 1) AS AVERAGE_DURATION
FROM
  CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY
  CAR_ID
HAVING
  AVG(DATEDIFF(END_DATE, START_DATE) + 1) >= 7
ORDER BY
  AVERAGE_DURATION DESC,
  CAR_ID DESC;
```

---

## SQL Keywords 설명

### 🔹 DATEDIFF
- 두 날짜 차이를 일수로 계산 (`END_DATE - START_DATE`)
- 기본적으로 **종료일 불포함** → `+ 1` 필요

### 🔹 AVG
- 그룹별 평균 계산 함수

### 🔹 ROUND(..., 1)
- 소수 첫째 자리까지 반올림

### 🔹 HAVING
- `GROUP BY` 이후 집계 결과에 조건 걸 때 사용 (`AVG(...) >= 7`)

### 🔹 ORDER BY
- `AVERAGE_DURATION DESC`, 같을 경우 `CAR_ID DESC`

---

## 문제 풀이 흐름 요약

- STEP 1: `DATEDIFF + 1`을 통해 실제 대여 일수 계산
- STEP 2: `AVG(...)`로 평균 대여 일수 구함
- STEP 3: `HAVING`으로 평균 7일 이상만 필터링
- STEP 4: `ROUND(..., 1)`로 소수 첫째 자리 반올림하여 출력
- STEP 5: `AVERAGE_DURATION → CAR_ID` 순서로 내림차순 정렬
