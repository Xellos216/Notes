
## 문제: 없어진 기록 찾기

두 테이블 `ANIMAL_INS`, `ANIMAL_OUTS` 가 주어졌을 때,
보호소에 들어온 기록은 존재하지만, 나간 기록이 존재하지 않는 동물들의 ID와 이름을 출력하는 SQL문을 작성하시오.

### 테이블 구조

#### ANIMAL_INS
| Column Name        | Type       | Nullable |
|--------------------|------------|----------|
| ANIMAL_ID          | VARCHAR(N) | FALSE    |
| ANIMAL_TYPE        | VARCHAR(N) | FALSE    |
| DATETIME           | DATETIME   | FALSE    |
| INTAKE_CONDITION   | VARCHAR(N) | FALSE    |
| NAME               | VARCHAR(N) | TRUE     |
| SEX_UPON_INTAKE    | VARCHAR(N) | FALSE    |

#### ANIMAL_OUTS
| Column Name         | Type       | Nullable |
|---------------------|------------|----------|
| ANIMAL_ID           | VARCHAR(N) | FALSE    |
| ANIMAL_TYPE         | VARCHAR(N) | FALSE    |
| DATETIME            | DATETIME   | FALSE    |
| NAME                | VARCHAR(N) | TRUE     |
| SEX_UPON_OUTCOME    | VARCHAR(N) | FALSE    |

### 풀이

- LEFT JOIN 을 사용하여 `ANIMAL_OUTS` 기준으로 `ANIMAL_INS` 를 조인
- 보호소에 들어온 기록이 없는 경우를 찾기 위해 `INS.DATETIME IS NULL` 조건 사용

```sql
SELECT
    O.ANIMAL_ID,
    O.NAME
FROM
    ANIMAL_OUTS O
    LEFT JOIN ANIMAL_INS I ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE
    I.DATETIME IS NULL;
```

### 해설

- `LEFT JOIN` 을 사용하면 오른쪽 테이블(`ANIMAL_INS`)의 값이 없을 경우 `NULL`이 채워짐.
- 따라서 보호소에 들어온 기록이 없는 동물을 찾기 위해서는 `I.DATETIME IS NULL` 조건을 사용.
- `O.ANIMAL_ID`, `O.NAME` 만 출력.
