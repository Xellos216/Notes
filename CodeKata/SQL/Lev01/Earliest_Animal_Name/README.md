# 🐬 SQL Day07 - 상위 1개 레코드 (가장 먼저 들어온 동물)

## 📌 문제 설명

`ANIMAL_INS` 테이블에서 **가장 먼저 보호소에 들어온 동물의 이름**을 조회하세요.  
단, `DATETIME`이 가장 빠른(오래된) 순으로 판단하며, 결과는 한 건만 출력해야 합니다.

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
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME ASC
LIMIT 1;
```

---

## 🧪 실행 예시 (출력 형태)

| NAME  |
|-------|
| Jack  |

※ 가장 먼저 들어온 동물의 이름이 출력됨 (데이터에 따라 값은 달라질 수 있음)

---

## 📝 요약 포인트

- 가장 오래된 시간 → `ORDER BY DATETIME ASC`
- 상위 1건 → `LIMIT 1`
- 조건이 따로 없으므로 `WHERE`는 불필요

---

## ❌ 오답 노트

```sql
SELECT NAME
FROM ANIMAL_INS
WHERE CURDATE()
LIMIT 1;
```

### ❌ 왜 틀렸는가?

- `CURDATE()`는 현재 날짜를 반환하는 함수로, 단독으로 `WHERE` 절에서 사용할 수 없음
- `WHERE CURDATE()`는 조건이 아니라 단순한 날짜 반환 → SQL 실행 오류 발생
- 원하는 건 "날짜가 가장 빠른 한 행"이므로 `ORDER BY DATETIME`을 활용해야 함
