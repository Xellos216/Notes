# 🐬 SQL 06 - 동일 이름 동물 수 찾기

## 📌 문제 설명

`ANIMAL_INS` 테이블에는 동물 보호소에 들어온 동물들의 정보가 담겨 있습니다.  
이 중 **두 번 이상 사용된 이름**과, 해당 이름이 사용된 **횟수**를 조회하는 SQL 문을 작성하세요.  

조건:
- `NAME`이 NULL인 경우는 제외
- 결과는 `NAME` 기준 오름차순 정렬

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
SELECT NAME, COUNT(*) AS total
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY NAME
HAVING COUNT(*) >= 2
ORDER BY NAME ASC;
```

---

## 🧪 실행 예시 (출력 형태)

| NAME  | total |
|-------|-------|
| Lucy  | 3     |
| Raven | 2     |

---

## 📝 요약 포인트

- `GROUP BY NAME`으로 이름별 그룹핑
- `COUNT(*)`로 이름 등장 횟수 집계
- `HAVING COUNT(*) >= 2`로 2번 이상 등장한 이름만 필터링
- `ORDER BY NAME ASC`로 이름 기준 정렬
- `WHERE NAME IS NOT NULL`로 NULL 제외 (집계 전 조건)

---

## ❌ 오답 노트

```sql
SELECT NAME, COUNT(*) AS total
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY 1
HAVING 2 >= 2
ORDER BY NAME ASC;
```

### ❌ 왜 틀렸는가?

- `HAVING 2 >= 2`는 **항상 참(True)**이 되는 상수 조건 → 필터링 효과 없음
- 모든 이름이 `NAME IS NOT NULL`인 조건만 만족하면 전부 출력됨
- 문제는 "이름이 2번 이상 등장한 경우만"을 요구하므로 `HAVING COUNT(*) >= 2`를 써야 함
