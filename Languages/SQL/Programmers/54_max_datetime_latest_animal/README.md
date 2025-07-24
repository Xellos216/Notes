
# 가장 최근에 들어온 동물의 보호 시작일 구하기

## 문제 설명

`ANIMAL_INS` 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다.  
이 테이블의 구조는 다음과 같으며, 각 열의 의미는 아래와 같습니다.

| Column           | Type        | Nullable | 설명 |
|------------------|-------------|----------|------|
| ANIMAL_ID        | VARCHAR(N)  | FALSE    | 동물의 ID |
| ANIMAL_TYPE      | VARCHAR(N)  | FALSE    | 동물의 종류 (예: Dog, Cat) |
| DATETIME         | DATETIME    | FALSE    | 보호 시작일 |
| INTAKE_CONDITION | VARCHAR(N)  | FALSE    | 입소 당시 상태 |
| NAME             | VARCHAR(N)  | TRUE     | 동물의 이름 |
| SEX_UPON_INTAKE  | VARCHAR(N)  | FALSE    | 성별 및 중성화 상태 |

---

## 목표

가장 최근에 동물 보호소에 들어온 동물이 언제 입소했는지를 조회하는 SQL문을 작성하세요.

---

## 예시

| ANIMAL_ID | ANIMAL_TYPE | DATETIME            | INTAKE_CONDITION | NAME     | SEX_UPON_INTAKE |
|-----------|-------------|---------------------|------------------|----------|-----------------|
| A399552   | Dog         | 2013-10-14 15:38:00 | Normal           | Jack     | Neutered Male   |
| A379998   | Dog         | 2013-10-23 11:42:00 | Normal           | Disciple | Intact Male     |

결과: `2013-10-23 11:42:00`

---

## 정답 SQL

```sql
SELECT
    MAX(DATETIME) AS "시간"
FROM
    ANIMAL_INS;
```
