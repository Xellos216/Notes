# 🐬 SQL 01 - 이름이 있는 동물의 ID

## 📌 문제 설명

`ANIMAL_INS` 테이블에서 이름이 존재하는 동물들의 ID만 조회하세요.  
단, 결과는 `ANIMAL_ID` 오름차순으로 정렬되어야 합니다.

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

## ✅ 풀이 쿼리

```sql
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
ORDER BY ANIMAL_ID;
```

---

## 🧪 실행 예시 (출력 일부)

| ANIMAL_ID |
|-----------|
| A349996   |
| A350276   |
| A350375   |
| A352555   |
| A352713   |

---

## 📝 요약 포인트

- `IS NOT NULL`로 NULL 필터링
- `ORDER BY ANIMAL_ID`로 정렬
- **SELECT 대상은 반드시 `ANIMAL_ID`만 포함해야 함**
