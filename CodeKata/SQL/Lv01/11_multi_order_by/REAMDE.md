# SQL 11 - 여러 기준으로 정렬하기 (ORDER BY 다중 조건)

> CodeKata / SQL / Day01 / MultiOrderBy

## 📌 문제 설명

`ANIMAL_INS` 테이블에는 보호소에 들어온 동물의 정보가 담겨 있습니다.

이 테이블에서 동물의 `ANIMAL_ID`, `NAME`, `DATETIME`을 다음 조건에 따라 정렬하여 조회하는 SQL문을 작성하세요:

1. **이름(NAME)을 알파벳 오름차순(ASC)으로 정렬**
2. **이름이 같은 경우, 보호 시작일(`DATETIME`)이 늦은 순서(내림차순 DESC)로 정렬**

---

## ✅ 예시 테이블

| ANIMAL_ID | ANIMAL_TYPE | DATETIME            | INTAKE_CONDITION | NAME  | SEX_UPON_INTAKE |
|-----------|--------------|---------------------|------------------|-------|-----------------|
| A349996   | Cat          | 2018-01-22 14:32:00 | Normal           | Sugar | Neutered Male   |
| A350276   | Cat          | 2017-08-13 13:50:00 | Normal           | Jewel | Spayed Female   |
| A396810   | Dog          | 2016-08-22 16:13:00 | Injured          | Raven | Spayed Female   |
| A410668   | Cat          | 2015-11-19 13:41:00 | Normal           | Raven | Spayed Female   |

---

## ✅ 정답 쿼리

```sql
SELECT
  ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME ASC, DATETIME DESC;
```

---

## 💻 실행 결과

| ANIMAL_ID | NAME  | DATETIME            |
|-----------|-------|---------------------|
| A350276   | Jewel | 2017-08-13 13:50:00 |
| A396810   | Raven | 2016-08-22 16:13:00 |
| A410668   | Raven | 2015-11-19 13:41:00 |
| A349996   | Sugar | 2018-01-22 14:32:00 |

---

## 🧠 학습 포인트

- `ORDER BY` 절에서 **여러 기준으로 정렬**하는 방법
- `ASC` (오름차순), `DESC` (내림차순) 키워드의 조합 사용
- 문자열과 날짜형 정렬의 동작 차이

---

## 🖼 실행 화면 캡처

![실행결과](./Screenshot.png)
