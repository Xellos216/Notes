# 역순 정렬하기 (SELECT)

> CodeKata / SQL / Day01 / 역순정렬하기

## 📌 문제 설명

`ANIMAL_INS` 테이블은 동물 보호소에 들어온 동물의 정보를 담고 있습니다.

해당 테이블에는 다음과 같은 컬럼이 있습니다:

| 컬럼명             | 타입         | NULL 여부 |
|-------------------|--------------|-----------|
| ANIMAL_ID         | VARCHAR(N)   | NOT NULL  |
| ANIMAL_TYPE       | VARCHAR(N)   | NOT NULL  |
| DATETIME          | DATETIME     | NOT NULL  |
| INTAKE_CONDITION  | VARCHAR(N)   | NOT NULL  |
| NAME              | VARCHAR(N)   | **TRUE**  |
| SEX_UPON_INTAKE   | VARCHAR(N)   | NOT NULL  |

---

## ✅ 문제 요구사항

동물 보호소에 들어온 모든 동물의 이름과 보호 시작일(`DATETIME`)을  
`ANIMAL_ID`의 역순(내림차순)으로 정렬하여 조회하는 SQL문을 작성하세요.

---

## ✅ 정답 쿼리

```sql
SELECT NAME, DATETIME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID DESC;
```

---

## 💻 실행 결과

| NAME    | DATETIME           |
|---------|--------------------|
| Rocky   | 2016-06-07 09:17:00 |
| Shelly  | 2015-01-29 15:01:00 |
| Benji   | 2016-04-19 13:28:00 |
| Jackie  | 2016-01-03 16:25:00 |
| *Sam    | 2016-03-13 11:17:00 |
| ...     | ...                |

👉 전체 결과는 [실행 화면 캡처 참고](./Screenshot.png)

---

## 🧠 학습 포인트

- `ORDER BY` 절에서 **문자형 ID** 기준으로도 정렬 가능
- `DESC` 키워드로 역순 정렬 수행
- `NULL` 값 허용 여부와 결과 포함 범위 주의

---

## 🖼 실행 화면 캡처

![실행결과](./Screenshot.png)
