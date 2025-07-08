# 🐬 SQL 03 - 중복 제거하기: 이름이 몇 개인지 세기

## 📌 문제 설명

`ANIMAL_INS` 테이블에는 동물 보호소에 들어온 동물들의 정보가 담겨 있습니다.  
이 중 `NAME` 컬럼을 기준으로 **중복되지 않는 이름의 개수**를 구하세요.  
단, `NAME`이 `NULL`인 경우는 제외합니다.

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
SELECT COUNT(DISTINCT NAME) AS count
FROM ANIMAL_INS
WHERE NAME IS NOT NULL;
```

---

## 🧪 실행 예시 (출력 형태)

| count |
|-------|
| 145   |

---

## 📝 요약 포인트

- 중복 제거된 이름 개수를 세기 위해 `COUNT(DISTINCT 컬럼)` 사용
- `NULL`은 이름으로 간주하지 않으므로 `WHERE NAME IS NOT NULL` 필수
- `GROUP BY` 없이도 전체 데이터에 대해 바로 계산 가능

---

## ❌ 오답 노트

```sql
SELECT NAME, COUNT(*) AS total
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY 1;
```

### ❌ 왜 틀렸는가?

- `GROUP BY NAME`은 각 이름별로 몇 번 나왔는지를 세는 쿼리로, **이름별 빈도 수를 출력**함
- 하지만 문제는 "이름이 총 몇 개나 있는지"를 묻고 있음 → `COUNT(DISTINCT NAME)`로 한 줄만 출력해야 함
- `GROUP BY`를 사용하면 결과가 여러 행이 나옴 → 정답 형식에 어긋남
