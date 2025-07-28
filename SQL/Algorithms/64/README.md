## 🧠 Problem
`PLACES` 테이블에는 공간 임대 서비스에 등록된 공간 정보가 담겨 있습니다.  
이 중 **두 개 이상의 공간을 등록한 사용자(HOST_ID)** 를 '헤비 유저'로 정의하고,  
이 헤비 유저가 소유한 공간들의 정보를 다음과 같이 출력하는 SQL을 작성하세요.

- 출력 컬럼: `ID`, `NAME`, `HOST_ID`
- 정렬 기준: `ID` 오름차순

---

## 💾 SQL Query
```sql
SELECT
  ID,
  NAME,
  HOST_ID
FROM
  PLACES
WHERE
  HOST_ID IN (
    SELECT HOST_ID
    FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(*) >= 2
  )
ORDER BY
  ID ASC;
```

---

## SQL Keywords 설명

### 🔹 GROUP BY
- 동일한 HOST_ID별로 그룹을 만든 뒤 공간 개수 집계

### 🔹 HAVING COUNT(*) >= 2
- 그룹별 공간이 2개 이상인 사용자만 필터링 → 헤비 유저 정의

### 🔹 IN (서브쿼리)
- 필터링된 HOST_ID를 기준으로 다시 원본 테이블에서 전체 정보를 추출

### 🔹 ORDER BY
- ID 오름차순으로 결과 정렬

---

## 문제 풀이 흐름 요약

- STEP 1: `GROUP BY HOST_ID`로 사용자별 등록 수 계산
- STEP 2: `HAVING COUNT(*) >= 2`로 헤비 유저 선별
- STEP 3: `IN (서브쿼리)`로 해당 사용자의 전체 공간 정보 조회
- STEP 4: `ORDER BY ID ASC`로 정렬