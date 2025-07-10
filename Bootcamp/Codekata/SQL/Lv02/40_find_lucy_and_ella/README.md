# 루시와 엘라 찾기

## ✅ 문제 설명

`ANIMAL_INS` 테이블에서 이름(`NAME`)이 다음 6가지 중 하나인 동물의  
`ANIMAL_ID`, `NAME`, `SEX_UPON_INTAKE`를 조회하시오.

> 이름 목록: Lucy, Ella, Pickle, Rogan, Sabrina, Mitty

- 결과는 `ANIMAL_ID` 기준 **오름차순** 정렬

---

## 🧾 사용 테이블

### 📘 ANIMAL_INS

| 컬럼명            | 설명                      |
|-------------------|---------------------------|
| ANIMAL_ID         | 동물 ID                   |
| NAME              | 동물 이름 (nullable)       |
| SEX_UPON_INTAKE   | 입소 시 중성화 여부 상태   |

---

## 💡 풀이 흐름

1. `NAME` 컬럼에 대해 다중 조건 검색
2. `WHERE NAME IN (...)` 구문 사용하면 더 깔끔함
3. 출력 컬럼: `ANIMAL_ID`, `NAME`, `SEX_UPON_INTAKE`
4. 정렬: `ORDER BY ANIMAL_ID ASC`

---

## ✅ 정답 SQL

```sql
SELECT
  ANIMAL_ID,
  NAME,
  SEX_UPON_INTAKE
FROM
  ANIMAL_INS
WHERE
  NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY
  ANIMAL_ID ASC;
```

---

## ❌ 오답노트

### 오답 코드 예시

```sql
WHERE
  NAME = 'Lucy' OR
  NAME = 'Ella' OR
  ...
```

- `IN`을 쓰지 않고 `OR` 조건을 나열해도 작동은 하지만,
- 문제 채점 시스템이나 가독성 측면에서 **`IN` 구문 사용을 더 선호**할 수 있음
- SQL 성능상도 `IN`이 더 적절함

---

## ✅ 실행 예시

| ANIMAL_ID | NAME    | SEX_UPON_INTAKE |
|-----------|---------|-----------------|
| A373219   | Ella    | Spayed Female   |
| A377750   | Lucy    | Spayed Female   |

---

## 📌 정리

- `WHERE NAME IN (...)` 형태는 `OR` 다중 조건을 간결하게 표현
- 오름차순 정렬 기준은 `ORDER BY ANIMAL_ID ASC`
