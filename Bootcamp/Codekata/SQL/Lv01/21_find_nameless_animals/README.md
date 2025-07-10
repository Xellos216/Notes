# 이름이 없는 동물의 아이디

> CodeKata / SQL / Lv01 / Find_Nameless_Animals

## 📌 문제 설명

`ANIMAL_INS` 테이블에는 보호소에 들어온 동물의 정보가 저장되어 있습니다.  
이 중 **이름이 없는 동물**, 즉 `NAME` 값이 `NULL`인 경우를 찾아  
해당 동물의 `ANIMAL_ID`만 조회하세요.

단, 결과는 **ID 오름차순**으로 정렬되어야 합니다.

---

## ✅ 테이블 구조

| 컬럼명           | 타입      | NULL 허용 |
|------------------|-----------|-----------|
| ANIMAL_ID        | VARCHAR   | FALSE     |
| ANIMAL_TYPE      | VARCHAR   | FALSE     |
| DATETIME         | DATETIME  | FALSE     |
| INTAKE_CONDITION | VARCHAR   | FALSE     |
| NAME             | VARCHAR   | TRUE      |
| SEX_UPON_INTAKE  | VARCHAR   | FALSE     |

---

## ✅ 정답 SQL

```sql
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL
ORDER BY 1 ASC;
```

---

## 💡 쿼리 해설

- `WHERE NAME IS NULL`  
  → 이름이 없는 동물만 필터링

- `ORDER BY 1 ASC`  
  → 첫 번째 컬럼(=ANIMAL_ID)을 오름차순 정렬

> `IS NULL` 조건은 `= NULL`로는 작동하지 않으며, 반드시 `IS NULL` 사용

---

## 💻 실행 결과 예시

| ANIMAL_ID |
|-----------|
| A368930   |

---

## 🧠 학습 포인트

- `NULL` 값 판별은 `IS NULL` / `IS NOT NULL` 사용
- `ORDER BY`에서 숫자 인덱스를 활용하는 방식 (`ORDER BY 1`)
- 조건 필터링과 정렬을 조합하여 출력값을 조절하는 기본 SQL 패턴

---

## 🖼 실행 화면 캡처

![실행결과](./Screenshot.png)
