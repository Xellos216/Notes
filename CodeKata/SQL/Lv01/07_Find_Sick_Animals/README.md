# 🐬 SQL 07 - 아픈 동물 찾기

## 📌 문제 설명

`ANIMAL_INS` 테이블에서 `INTAKE_CONDITION`이 `'Sick'`인 동물들의 `ANIMAL_ID`와 `NAME`을 조회하세요.  
결과는 `ANIMAL_ID` 기준 **오름차순**으로 정렬해야 합니다.

---

## ✅ 테이블 구조 (ANIMAL_INS)

| 컬럼명           | 타입        | NULL 허용 |
|------------------|-------------|------------|
| ANIMAL_ID        | VARCHAR(N)  | ❌ |
| ANIMAL_TYPE      | VARCHAR(N)  | ❌ |
| DATETIME         | DATETIME    | ❌ |
| INTAKE_CONDITION | VARCHAR(N)  | ❌ |
| NAME             | VARCHAR(N)  | ✅ |
| SEX_UPON_INTAKE  | VARCHAR(N)  | ❌ |

---

## ✅ 정답 쿼리

```sql
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'Sick'
ORDER BY ANIMAL_ID;
```

---

## 🧪 실행 예시 (출력 형태)

| ANIMAL_ID | NAME     |
|-----------|----------|
| A367012   | Miller   |
| A381217   | Cherokee |

---

## 📝 요약 포인트

- 문자열 비교 시 반드시 작은 따옴표 `'Sick'` 사용
- 조건은 `WHERE` 절에서 수행
- 정렬은 `ORDER BY ANIMAL_ID ASC` (기본 오름차순)

---

## ❌ 오답 노트

```sql
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = Sick;
```

### ❌ 왜 틀렸는가?

- `Sick`에 따옴표가 없어서 SQL은 이것을 **컬럼 이름**으로 해석하려고 시도함
- `"Unknown column 'Sick'"` 에러 발생
- 문자열 비교 시에는 반드시 `'Sick'`처럼 **작은 따옴표로 감싸야 함**
