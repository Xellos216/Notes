# 🐾 모든 동물 보호소 기록 조회하기

## 📘 문제 설명

`ANIMAL_INS` 테이블에는 동물 보호소에 들어온 동물들의 정보가 저장되어 있습니다.  
이 테이블에서 **모든 동물의 정보를 조회**하되, **`ANIMAL_ID` 오름차순**으로 정렬하여 출력하세요.

---

## 🧾 테이블 구조: ANIMAL_INS

| Column          | Type       | NULLABLE | Description              |
|------------------|------------|----------|--------------------------|
| ANIMAL_ID        | VARCHAR    | FALSE    | 동물 고유 ID              |
| ANIMAL_TYPE      | VARCHAR    | FALSE    | 동물 종류 (예: Cat, Dog)   |
| DATETIME         | DATETIME   | FALSE    | 보호소 들어온 날짜/시간     |
| INTAKE_CONDITION | VARCHAR    | FALSE    | 입소 당시 상태             |
| NAME             | VARCHAR    | TRUE     | 이름 (없을 수도 있음)       |
| SEX_UPON_INTAKE  | VARCHAR    | FALSE    | 입소 당시 중성화 여부 및 성별 |

---

## ✅ 정답 SQL

```sql
SELECT
  *
FROM
  ANIMAL_INS
ORDER BY
  ANIMAL_ID ASC;
```

---

## 🧠 해설

| 요소 | 설명 |
|------|------|
| `SELECT *` | 모든 컬럼을 조회 |
| `FROM ANIMAL_INS` | 조회 대상 테이블 지정 |
| `ORDER BY ANIMAL_ID ASC` | 동물 ID 기준 오름차순 정렬 |

---

## 🧪 출력 예시

| ANIMAL_ID | ANIMAL_TYPE | DATETIME            | INTAKE_CONDITION | NAME   | SEX_UPON_INTAKE |
|-----------|-------------|---------------------|------------------|--------|-----------------|
| A410684   | Cat         | 2014-06-21 12:25:00 | Normal           | Mitty  | Spayed Female   |
| A412173   | Dog         | 2015-07-28 18:17:00 | Normal           | Jimmince | Neutered Male |

---

## 🔍 참고

- `ANIMAL_ID`는 문자열이지만, 기본적으로 오름차순 정렬 시 사전 순으로 정렬됩니다.
- 정렬 결과가 정확한지 확인하려면 `ORDER BY`절을 꼭 명시하세요.

