# 🐬 SQL - 고양이와 개는 몇 마리 있을까?

## 📌 문제 설명

`ANIMAL_INS` 테이블에는 동물 보호소에 들어온 동물들의 정보가 담겨 있습니다.  
이 중 `ANIMAL_TYPE`이 같은 동물끼리 묶어 몇 마리씩 있는지 세어,  
**동물 타입별 개체 수**를 출력하는 SQL 문을 작성하세요.

단, 결과는 `ANIMAL_TYPE`을 기준으로 오름차순 정렬해야 합니다.

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
SELECT ANIMAL_TYPE, COUNT(*) AS count
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE ASC;
```

---

## 🧪 실행 예시

| ANIMAL_TYPE | count |
|-------------|-------|
| Cat         | 2     |
| Dog         | 1     |

---

## 📝 요약 포인트

- `GROUP BY ANIMAL_TYPE`으로 동물 종류별로 묶기
- `COUNT(*)`를 통해 각 그룹의 행 수를 세기
- `ORDER BY ANIMAL_TYPE ASC`로 결과 정렬

---

