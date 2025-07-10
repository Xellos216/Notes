# DATETIME에서 DATE로 형 변환

> CodeKata / SQL / Lv01 / Convert_Datetime_To_Date

## 📌 문제 설명

`ANIMAL_INS` 테이블에는 보호소에 들어온 동물의 정보가 저장되어 있습니다.  
이 테이블에서 `DATETIME` 컬럼에서 날짜 정보(`YYYY-MM-DD`)만 추출하여  
`ANIMAL_ID`, `NAME`, 추출된 날짜를 조회하는 SQL문을 작성하세요.

날짜 컬럼명은 `'날짜'`로 출력해야 합니다.

---

## ✅ 테이블 구조

| 컬럼명         | 타입      | NULL 허용 |
|----------------|-----------|-----------|
| ANIMAL_ID      | VARCHAR   | FALSE     |
| ANIMAL_TYPE    | VARCHAR   | FALSE     |
| DATETIME       | DATETIME  | FALSE     |
| INTAKE_CONDITION | VARCHAR | FALSE     |
| NAME           | VARCHAR   | TRUE      |
| SEX_UPON_INTAKE| VARCHAR   | FALSE     |

---

## ✅ 정답 SQL

```sql
SELECT
  ANIMAL_ID,
  NAME,
  SUBSTR(DATETIME, 1, 10) AS '날짜'
FROM ANIMAL_INS;
```

---

## 💡 쿼리 해설

- `SUBSTR(DATETIME, 1, 10)`  
  → `DATETIME` 형식인 `'YYYY-MM-DD HH:MM:SS'`에서  
     앞 10자리 `'YYYY-MM-DD'`만 잘라냄

- `AS '날짜'`  
  → 출력 시 컬럼명을 '날짜'로 변경

> `DATE_FORMAT()` 또는 `CAST()` 함수도 가능하지만,  
> MySQL에서는 `SUBSTR()` 방식이 간단하며 정답 처리됨

---

## 💻 실행 결과 예시

| ANIMAL_ID | NAME      | 날짜       |
|-----------|-----------|------------|
| A349996   | Sugar     | 2018-01-22 |
| A350276   | Jewel     | 2017-08-13 |
| A350375   | Meo       | 2017-03-06 |
| A352555   | Harley    | 2014-08-08 |
| A352713   | Gia       | 2017-04-13 |

---

## 🧠 학습 포인트

- `DATETIME → DATE` 변환을 문자열 함수로 처리하는 방식
- `AS`를 통한 출력 컬럼명 변경
- `SUBSTR()` 함수 활용

---

## 🖼 실행 화면 캡처

![실행결과](./Screenshot.png)
