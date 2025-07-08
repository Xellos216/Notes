# 🐬 SQL 15 - NULL 처리하기

## 📌 문제 설명

`ANIMAL_INS` 테이블에는 동물 보호소에 들어온 동물들의 정보가 담겨 있습니다.  
이 중 일부 동물은 이름이 없을 수 있으며, 이 경우 사람들에게 안내하기 위해  
**이름이 NULL인 경우에는 "No name"이라는 문자열로 대체해서 출력**해야 합니다.  
또한 결과는 `ANIMAL_ID` 기준 오름차순으로 정렬해야 합니다.

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
  ANIMAL_TYPE,
  IFNULL(NAME, 'No name') AS NAME,
  SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC;
```

---

## 🧪 실행 예시 (출력 형태)

| ANIMAL_TYPE | NAME     | SEX_UPON_INTAKE |
|-------------|----------|-----------------|
| Cat         | Jewel    | Spayed Female   |
| Cat         | Meo      | Neutered Male   |
| Dog         | No name  | Spayed Female   |

---

## 📝 요약 포인트

- `IFNULL(NAME, 'No name')`: NAME이 NULL인 경우 "No name"으로 대체
- `AS NAME`: 출력 컬럼명을 원래대로 유지
- `ORDER BY ANIMAL_ID ASC`: ID 기준으로 정렬

---

## ✅ 참고: 다른 방법

```sql
SELECT 
  ANIMAL_TYPE,
  COALESCE(NAME, 'No name') AS NAME,
  SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC;
```

- `COALESCE()`는 여러 인자 중 **첫 번째 NOT NULL** 값을 선택
- `IFNULL()`은 MySQL 전용, `COALESCE()`는 표준 SQL

