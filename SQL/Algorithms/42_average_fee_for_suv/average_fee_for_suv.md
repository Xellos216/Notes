# 🚗 평균 일일 대여 요금 구하기 (SUV)

## 📘 문제 설명

`CAR_RENTAL_COMPANY_CAR` 테이블에서 **자동차 종류가 'SUV'인 차량들의 평균 일일 대여 요금**을 구하는 SQL문을 작성하세요.  
단, 결과는 **소수 첫 번째 자리에서 반올림**하고, 컬럼명은 `AVERAGE_FEE`로 출력해야 합니다.

---

## 🧾 테이블 구조

| 컬럼명      | 타입          | NULL 허용 |
|-------------|---------------|------------|
| CAR_ID      | INTEGER       | FALSE      |
| CAR_TYPE    | VARCHAR(255)  | FALSE      |
| DAILY_FEE   | INTEGER       | FALSE      |
| OPTIONS     | VARCHAR(255)  | FALSE      |

- `CAR_TYPE` 값은 '세단', 'SUV', '승합차', '트럭', '리무진' 중 하나
- `OPTIONS`는 쉼표로 구분된 문자열

---

## 📌 예시

예시 테이블:

| CAR_ID | CAR_TYPE | DAILY_FEE | OPTIONS                             |
|--------|----------|-----------|--------------------------------------|
| 1      | 세단     | 16000     | 가족시트,열선시트,후방카메라         |
| 2      | SUV      | 14000     | 스마트키,네비게이션,열선시트         |
| 3      | SUV      | 22000     | 주차감지센서,후방카메라,가족시트     |

- SUV 차량의 DAILY_FEE: 14000, 22000
- 평균: (14000 + 22000) / 2 = 18000.0

정답 출력:

| AVERAGE_FEE |
|-------------|
| 18000       |

---

## ✅ 정답 SQL

```sql
SELECT ROUND(AVG(DAILY_FEE)) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV';
```

- `AVG()`로 평균 구하고
- `ROUND()`로 소수 첫째 자리에서 반올림

---

## 🔄 참고: 평균을 정수로 변환하는 다양한 방법

| 방식        | 사용 함수              | 소수점 처리 방식       | 예시 결과 |
|-------------|------------------------|--------------------------|-----------|
| 버림        | `FLOOR()`              | 소수점 아래 버림        | 93727     |
| 올림        | `CEIL()`               | 소수점 올림             | 93728     |
| 반올림      | `ROUND()`              | 소수 첫째 자리 반올림   | 93727/93728 |
| 정수 캐스팅 | `CAST(... AS INT)`     | 소수점 절삭 (버림)      | 93727     |

---

## 📂 기타 참고 SQL 예시

```sql
-- FLOOR() 사용: 소수점 이하 버림
SELECT FLOOR(AVG(DAILY_FEE)) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV';

-- CEIL() 사용: 소수점 올림
SELECT CEIL(AVG(DAILY_FEE)) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV';

-- CAST를 통한 정수 변환
SELECT CAST(AVG(DAILY_FEE) AS UNSIGNED) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV';
```

---

## 🧠 요점 정리

- `AVG()` 함수는 소수점 포함 → 정수로 출력하려면 `ROUND()`, `FLOOR()`, `CAST()` 등 사용
- 문제에서 **반올림 요구** → `ROUND()` 사용
