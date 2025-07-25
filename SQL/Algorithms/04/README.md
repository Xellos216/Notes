# 🐬 SQL 04 - 동물의 아이디와 이름

## 📌 문제 설명

`ANIMAL_INS` 테이블에는 동물 보호소에 들어온 동물들의 정보가 담겨 있습니다.  
이 중 모든 동물의 `ANIMAL_ID`와 `NAME`을 조회하되, 결과는 `ANIMAL_ID` 오름차순으로 정렬하세요.

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
ORDER BY ANIMAL_ID ASC;
```

---

## 🧪 실행 예시 (출력 형태)

| ANIMAL_ID | NAME        |
|-----------|-------------|
| A349996   | Sugar       |
| A350276   | Jewel       |
| A350375   | Meo         |
| A352555   | Harley      |
| A352713   | Gia         |
| A352872   | Peanutbutter|
| A353259   | Bj          |

---

## 📝 요약 포인트

- `ORDER BY`를 통해 오름차순 정렬
- `NAME` 컬럼은 `NULL`이어도 포함됨 (조건 없음)
- `SELECT` 절에 두 컬럼을 함께 출력
