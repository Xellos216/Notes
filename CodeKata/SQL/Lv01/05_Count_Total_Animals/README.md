# 🐬 SQL 05 - 동물 수 구하기

## 📌 문제 설명

`ANIMAL_INS` 테이블에는 동물 보호소에 들어온 동물들의 정보가 담겨 있습니다.  
이 테이블을 이용하여 **동물 보호소에 들어온 전체 동물 수**를 구하는 SQL 문을 작성하세요.

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
SELECT COUNT(*) AS count
FROM ANIMAL_INS;
```

---

## 🧪 실행 예시 (출력 형태)

| count |
|-------|
| 200   |

※ 위 숫자는 예시이며, 데이터에 따라 달라질 수 있음.

---

## 📝 요약 포인트

- `COUNT(*)`는 전체 행 수를 셈 (NULL 포함)
- 조건이나 그룹핑 없이 전체 테이블 대상으로 적용
- `AS count`는 결과 컬럼명을 명시적으로 지정

---

## ❌ 오답 노트

```sql
SELECT *, COUNT(*)
FROM ANIMAL_INS
GROUP BY 1;
```

### ❌ 왜 틀렸는가?

- `SELECT *`와 `COUNT(*)`를 같이 쓰면서 `GROUP BY`를 하면 **집계 대상 외의 컬럼들을 GROUP BY에 모두 넣어야 함**
- `GROUP BY 1`은 첫 번째 컬럼(ANIMAL_ID) 기준 그룹 → 결국 각 행마다 1건씩 계산됨
- 이 쿼리는 **전체 개수**가 아니라 **각 행에 대해 '1'을 출력**하는 결과가 됨
- 즉, **집계 함수 사용 시에는 SELECT 대상과 GROUP BY 컬럼이 충돌하지 않도록 주의**

