# 🐬 SQL 10 - 어린 동물 찾기

## 📌 문제 설명

`ANIMAL_INS` 테이블에서 **'Aged'가 아닌 동물**들의 `ANIMAL_ID`와 `NAME`을 조회하세요.  
즉, `INTAKE_CONDITION`이 'Aged'가 아닌 동물만 출력해야 하며, 결과는 `ANIMAL_ID` 기준 오름차순 정렬되어야 합니다.

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
WHERE INTAKE_CONDITION != 'Aged'
ORDER BY ANIMAL_ID;
```

---

## 🧪 실행 예시 (출력 형태)

| ANIMAL_ID | NAME     |
|-----------|----------|
| A365172   | Diablo   |
| A367012   | Miller   |
| A381217   | Cherokee |

---

## 📝 요약 포인트

- 문자열 비교는 `!=` 연산자 사용
- `IS NOT`은 NULL 비교 전용 → 문자열 비교에서는 오류 발생
- `ORDER BY ANIMAL_ID`로 오름차순 정렬

---

## ❌ 오답 노트

```sql
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION IS NOT 'Aged';
```

### ❌ 왜 틀렸는가?

- `IS NOT`은 **NULL 비교 전용 문법**
- `'Aged'`는 문자열이므로, **`!=` 또는 `NOT =`** 을 써야 함
- 이 쿼리는 구문 오류 발생: `Unknown syntax near ''Aged''`

---

## ✅ 대체 가능한 정답 예시

```sql
-- NOT 연산자 사용
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE NOT INTAKE_CONDITION = 'Aged'
ORDER BY ANIMAL_ID;
