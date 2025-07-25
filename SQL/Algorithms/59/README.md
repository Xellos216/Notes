## 🧠 Problem
2022년 10월 16일 기준으로 자동차 대여 이력을 조회하여, 해당 날짜에 **대여중**인 자동차는 `"대여중"`으로, 그 외 자동차는 `"대여 가능"`으로 표시한 후 `CAR_ID` 기준 내림차순으로 정렬하여 조회하는 문제입니다.

---

## 💾 SQL Query
```sql
SELECT
  CAR_ID,
  CASE
    WHEN MAX(CASE
               WHEN '2022-10-16' BETWEEN START_DATE AND END_DATE
               THEN 1 ELSE 0
             END) = 1 THEN '대여중'
    ELSE '대여 가능'
  END AS AVAILABILITY
FROM
  CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY
  CAR_ID
ORDER BY
  CAR_ID DESC;
```

---

## SQL Keywords 설명

### 🔹 CASE WHEN
- 조건에 따라 값을 다르게 분기 처리
- 여기선 `2022-10-16`이 대여기간 사이에 있는지를 판단

### 🔹 MAX
- 각 `CAR_ID` 별로 `"대여중"` 조건이 **한 번이라도 참이면** `MAX(1)`이 되어 `"대여중"`으로 분류
- 없으면 `MAX(0)`이 되어 `"대여 가능"`

### 🔹 GROUP BY
- 자동차 ID별로 대여 상태를 하나의 행으로 요약
- `GROUP BY CAR_ID`로 묶지 않으면 여러 대여 기록이 그대로 출력됨

---

## 문제 풀이 흐름 요약

- **조건 판단**: `'2022-10-16'` 날짜가 대여 시작일과 종료일 사이에 있는지를 판별
- **CASE문으로 상태 분류**: 대여중이면 1, 아니면 0으로 표기
- **MAX 집계**: 하나라도 대여중인 기록이 있으면 대여중으로 판단
- **GROUP BY**로 자동차 단위로 묶음
- **ORDER BY**로 자동차 ID를 내림차순 정렬

---

## 🧨 오답 노트

```sql
SELECT
  CAR_ID,
  CASE
    WHEN START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16' THEN '대여중'
    ELSE '대여 가능'
  END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;
```

### ❌ 문제점
- `GROUP BY CAR_ID`로 묶었지만, 동일 `CAR_ID`에 여러 대여 기록이 존재할 경우 해당 조건이 **불명확하게 적용됨**
- 대여중과 대여 가능이 함께 있을 때 정확한 판별이 되지 않음
- `CASE` 문이 집계 함수 없이 개별행 기준으로만 동작 → `GROUP BY` 와 논리적 충돌

### ✅ 해결 방법
- `MAX(CASE ...)` 구조를 사용해 **대여중 조건이 존재하는지 여부만** 체크
- 복수의 대여 기록이 있어도 최종 상태를 정확히 추론 가능