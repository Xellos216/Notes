# 🐬 SQL - 중성화 여부 파악하기

## 📌 문제 설명

`ANIMAL_INS` 테이블에는 동물 보호소에 들어온 동물들의 정보가 담겨 있습니다.  
이 중 `SEX_UPON_INTAKE` 컬럼을 활용해 **중성화 여부를 파악**하고,  
- `Neutered Male` 또는 `Spayed Female` → 'O'  
- 그 외의 값 → 'X'  
로 표기한 결과를 출력하는 SQL 문을 작성하세요.

출력 항목은 다음과 같습니다:
- `ANIMAL_ID`
- `NAME`
- 중성화 여부 (`O` 또는 `X`) — 컬럼명: `중성화`

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
SELECT
  ANIMAL_ID,
  NAME,
  CASE
    WHEN SEX_UPON_INTAKE = 'Neutered Male' THEN 'O'
    WHEN SEX_UPON_INTAKE = 'Spayed Female' THEN 'O'
    ELSE 'X'
  END AS '중성화'
FROM ANIMAL_INS;
```

---

## 🧪 실행 예시

| ANIMAL_ID | NAME      | 중성화 |
|-----------|-----------|--------|
| A355753   | Elijah    | O      |
| A373219   | Ella      | O      |
| A382192   | Maxwell 2 | X      |

---

## 📝 요약 포인트

- `CASE WHEN` 문으로 문자열 조건 처리
- `'Neutered Male'`, `'Spayed Female'`만 중성화로 간주
- 나머지는 모두 `'X'` 처리
- 결과 컬럼명은 한글 `'중성화'` 로 명시

---

