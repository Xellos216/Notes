# 입양 시각 구하기 - 시간대별 입양 건수

## ✅ 문제 요약

- `ANIMAL_OUTS` 테이블에서 DATETIME 컬럼을 기준으로,
- **09시부터 19시까지** 각 시간대별 입양 건수를 구하라.
- 결과는 시간 오름차순 정렬할 것.

---

## ✅ 정답 SQL (방법 1: CASE WHEN + TIME BETWEEN)

```sql
SELECT
  CASE
    WHEN TIME(DATETIME) BETWEEN '09:00:00' AND '09:59:59' THEN 9
    WHEN TIME(DATETIME) BETWEEN '10:00:00' AND '10:59:59' THEN 10
    WHEN TIME(DATETIME) BETWEEN '11:00:00' AND '11:59:59' THEN 11
    WHEN TIME(DATETIME) BETWEEN '12:00:00' AND '12:59:59' THEN 12
    WHEN TIME(DATETIME) BETWEEN '13:00:00' AND '13:59:59' THEN 13
    WHEN TIME(DATETIME) BETWEEN '14:00:00' AND '14:59:59' THEN 14
    WHEN TIME(DATETIME) BETWEEN '15:00:00' AND '15:59:59' THEN 15
    WHEN TIME(DATETIME) BETWEEN '16:00:00' AND '16:59:59' THEN 16
    WHEN TIME(DATETIME) BETWEEN '17:00:00' AND '17:59:59' THEN 17
    WHEN TIME(DATETIME) BETWEEN '18:00:00' AND '18:59:59' THEN 18
    WHEN TIME(DATETIME) BETWEEN '19:00:00' AND '19:59:59' THEN 19
  END AS HOUR,
  COUNT(*) AS COUNT
FROM ANIMAL_OUTS
WHERE TIME(DATETIME) BETWEEN '09:00:00' AND '19:59:59'
GROUP BY HOUR
ORDER BY HOUR ASC;
```

---

## ✅ 정답 SQL (방법 2: HOUR 함수 이용 + 간단 WHERE)

```sql
SELECT
  HOUR(DATETIME) AS HOUR,
  COUNT(*) AS COUNT
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) BETWEEN 9 AND 19
GROUP BY HOUR
ORDER BY HOUR ASC;
```

---

## ✅ 왜 두 방식 모두 같은 결과를 출력하는가?

| 항목 | 방식 1 (CASE + TIME) | 방식 2 (HOUR 함수) |
|------|----------------------|---------------------|
| 비교 방식 | DATETIME에서 시간 부분 추출 후 구간 비교 | DATETIME을 HOUR로 변환 후 정수 범위 비교 |
| 집계 방식 | 1시간 단위로 직접 조건 분기 | HOUR() 결과를 그룹핑 기준으로 사용 |
| 결과 | 동일한 시간대 기준으로 COUNT | 동일 |

→ 결국 **모든 DATETIME 값의 시(hour)만이 그룹핑 기준**이므로, 내부 로직이 달라도 **09시 ~ 19시 범위에서 그룹핑된 결과는 동일하게 나옴**.

---

## 🧠 오답노트: 자주 발생한 실수 정리

### 1. `GROUP BY 1`, `ORDER BY 1` 사용 시 혼란
- `1`은 첫 번째 SELECT 컬럼을 의미하지만, **명시적 칼럼명 사용 권장** (`GROUP BY HOUR`)
- 실수로 GROUP BY 절이 `1`인데 SELECT 절이 `CASE ... END AS HOUR`면, 정렬 기준이 불명확해짐.

### 2. `BETWEEN`에서 값 타입 불일치
- `TIME(DATETIME) BETWEEN '10:00:00' AND '10:59:59'` ← 문자열과 TIME 비교는 가능
- 하지만 `BETWEEN 9 AND '10:59:59'` 와 같은 잘못된 혼합형식은 오류 발생

### 3. `CASE` 사용 시 `ELSE` 생략
- 일부 데이터가 09~19시에 해당되지 않으면 `NULL`로 출력됨
- `ELSE`를 넣거나 `WHERE`절로 미리 걸러주는 방식으로 해결 필요

### 4. `HOUR(DATETIME)` 직접 그룹핑할 경우, 불필요한 CASE문 작성
- HOUR 함수 자체가 그룹핑 기준으로 충분하므로, 단순한 경우 `CASE`는 생략 가능

---

## 🔚 마무리 팁

- `시간대별 건수`를 구할 때는 `HOUR(DATETIME)` 또는 `TIME(DATETIME)`을 적극 활용할 것
- **정렬 문제**가 생기면 항상 `GROUP BY`와 `ORDER BY` 기준 컬럼이 일치하는지 확인
- CASE WHEN 절은 그룹핑이 아닌 **값 변경 목적**일 때만 사용하도록 구분하자
