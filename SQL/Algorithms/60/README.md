## 🧠 Problem
2022년 1~2월간 상품을 구매한 회원을 기준으로, **연도, 월, 성별별 회원 수**를 집계하세요.  
단, 성별 정보(`GENDER`)가 없는 경우는 제외하고, 결과는 `연도 → 월 → 성별` 오름차순으로 정렬합니다.

예시:
- 2022년 1월: 남성 1명 (USER_ID = 4), 여성 1명 (USER_ID = 1)
- 2022년 2월: 여성 2명 (USER_ID = 5, 6) → 중복 구매해도 1명으로 계산됨

---

## 💾 SQL Query
```sql
SELECT
  YEAR(S.SALES_DATE) AS YEAR,
  MONTH(S.SALES_DATE) AS MONTH,
  I.GENDER,
  COUNT(DISTINCT I.USER_ID) AS USERS
FROM
  USER_INFO I
  JOIN ONLINE_SALE S ON I.USER_ID = S.USER_ID
WHERE
  I.GENDER IS NOT NULL
GROUP BY
  YEAR(S.SALES_DATE),
  MONTH(S.SALES_DATE),
  I.GENDER
ORDER BY
  1, 2, 3;
```

## SQL Keywords 설명

### 🔹 COUNT(DISTINCT)
- 동일한 사용자가 여러 번 구매해도 **1명으로 계산**함
- `회원 수`를 집계할 때 반드시 사용해야 함

### 🔹 GROUP BY
- 연도, 월, 성별을 기준으로 그룹화하여 각각의 회원 수 계산

---

## 문제 풀이 흐름 요약
- 조건: `GENDER IS NOT NULL`
- 날짜 컬럼에서 연도(YEAR), 월(MONTH) 추출
- JOIN을 통해 판매기록과 회원정보 연결
- `GROUP BY`로 연도·월·성별별 집계
- 중복 구매를 제거하기 위해 `COUNT(DISTINCT USER_ID)` 사용
- `ORDER BY`로 결과 정렬

---

## ❌ 오답노트
```sql
COUNT(*) AS USERS  -- ❌ 잘못된 집계
```
- 이 경우 **구매 건수**를 세기 때문에, **동일 회원의 중복 구매도 모두 집계됨**
- 예를 들어 한 명이 한 달에 3건 구매했다면, **3명으로 오인**될 수 있음

따라서 회원 수를 정확히 구하기 위해서는 `COUNT(DISTINCT I.USER_ID)`로 고쳐야 함.
