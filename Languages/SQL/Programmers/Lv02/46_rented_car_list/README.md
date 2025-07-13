# 🚗 대여 기록이 존재하는 자동차 리스트 구하기

## 📘 문제 설명

`CAR_RENTAL_COMPANY_CAR`, `CAR_RENTAL_COMPANY_RENTAL_HISTORY` 테이블을 이용하여 다음 조건을 만족하는 자동차 ID 리스트를 조회하세요.

- 자동차 종류(`CAR_TYPE`)가 **'세단'**
- **2022년 10월 1일 이후**에 **대여를 시작한 기록이 존재**
- 결과는 `CAR_ID` 기준으로 **내림차순 정렬**

---

## 🧾 테이블 구조

### CAR_RENTAL_COMPANY_CAR

| Column     | Type    | Description       |
|------------|---------|-------------------|
| CAR_ID     | INTEGER | 자동차 ID          |
| CAR_TYPE   | TEXT    | 자동차 종류         |
| DAILY_FEE  | INTEGER | 일일 대여 요금      |
| OPTIONS    | TEXT    | 옵션 (콤마로 구분)   |

### CAR_RENTAL_COMPANY_RENTAL_HISTORY

| Column     | Type    | Description     |
|------------|---------|-----------------|
| HISTORY_ID | INTEGER | 대여 이력 ID      |
| CAR_ID     | INTEGER | 자동차 ID         |
| START_DATE | DATE    | 대여 시작일       |
| END_DATE   | DATE    | 대여 종료일       |

---

## ✅ 정답 SQL

```sql
SELECT
  C.CAR_ID
FROM
  CAR_RENTAL_COMPANY_CAR AS C
  LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
  ON C.CAR_ID = H.CAR_ID
WHERE
  C.CAR_TYPE = '세단'
  AND H.START_DATE >= '2022-10-01'
GROUP BY
  C.CAR_ID
ORDER BY
  C.CAR_ID DESC;
```

---

## ⚠️ 주의할 점

| 항목 | 설명 |
|------|------|
| JOIN 조건 | 두 테이블을 `CAR_ID` 기준으로 조인해야 함 |
| 날짜 조건 | `'2022-10-01'` 이상만 필터링 |
| GROUP BY | 중복 대여 이력 제거용 |
| 정렬 기준 | `CAR_ID` 기준 내림차순 (`DESC`) |

---

## 🧪 예시 데이터

### CAR 테이블

| CAR_ID | CAR_TYPE | DAILY_FEE |
|--------|----------|-----------|
| 1      | 세단     | 16000     |
| 2      | SUV      | 14000     |
| 3      | 세단     | 22000     |
| 4      | 세단     | 12000     |

### RENTAL_HISTORY 테이블

| HISTORY_ID | CAR_ID | START_DATE |
|------------|--------|-------------|
| 2          | 3      | 2022-10-03   |
| 5          | 1      | 2022-10-10   |

→ 조건을 만족하는 CAR_ID는 **1번, 3번** → 출력: `3`, `1`

---

## 🧠 요약

- 조인 조건과 날짜 필터링을 동시에 고려해야 함
- `GROUP BY`는 동일 CAR_ID가 여러 번 대여된 경우 중복 제거 목적
- 날짜 비교는 문자열이 아닌 DATE 타입 기준으로 정확히 비교
