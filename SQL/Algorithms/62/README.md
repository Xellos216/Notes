## 🧠 Problem
자동차 대여 기록이 담긴 `CAR_RENTAL_COMPANY_RENTAL_HISTORY` 테이블에서  
대여 시작일이 2022년 9월인 기록들 중, 대여 기간이 30일 이상이면 `장기 대여`,  
그 미만이면 `단기 대여`로 분류하여 `RENT_TYPE` 컬럼을 추가해 조회하시오.  
결과는 `HISTORY_ID` 기준 **내림차순 정렬**되어야 한다.

📌 단, `START_DATE` ~ `END_DATE` 간 날짜 계산 시 **종료일도 포함해야** 함.

---

## 💾 SQL Query
```sql
SELECT
  HISTORY_ID,
  CAR_ID,
  DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE,
  DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE,
  CASE
    WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN '장기 대여'
    ELSE '단기 대여'
  END AS RENT_TYPE
FROM
  CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE
  DATE_FORMAT(START_DATE, '%Y-%m') = '2022-09'
ORDER BY
  HISTORY_ID DESC;
```

---

## SQL Keywords 설명

### 🔹 DATE_FORMAT
- 날짜 컬럼을 지정한 형식의 문자열로 변환
- 여기선 `'%Y-%m'` 형식으로 2022년 9월 필터링, `'%Y-%m-%d'`로 출력 정렬

### 🔹 DATEDIFF
- `DATEDIFF(END, START)`는 두 날짜 사이의 일수 차이
- 종료일 포함이 필요하므로 `+ 1` 필수

### 🔹 CASE
- 조건에 따라 다른 문자열(`장기 대여` 또는 `단기 대여`)을 부여

### 🔹 ORDER BY
- `HISTORY_ID DESC`는 내림차순 정렬

---

## 문제 풀이 흐름 요약

- **STEP 1:** 시작일이 2022년 9월인 데이터만 필터링
- **STEP 2:** `DATEDIFF + 1`로 대여일수 계산
- **STEP 3:** 30일 이상이면 `장기 대여`, 아니면 `단기 대여`
- **STEP 4:** 출력 시 날짜 포맷 통일 및 `HISTORY_ID` 기준 내림차순 정렬