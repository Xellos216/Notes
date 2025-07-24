
# 오래 보호한 동물 조회하기

## 📌 문제 설명  
보호소에 입소된 동물 중 아직 입양을 가지 못한 동물들을 대상으로,  
가장 오래 보호소에 있었던 동물 3마리의 `이름`과 `보호 시작일(DATETIME)`을 조회하세요.

### 조건
- 입양을 못 간 동물 = `ANIMAL_OUTS`에 대응되는 `DATETIME`이 없는 동물
- 입소 정보는 `ANIMAL_INS` 테이블, 입양 정보는 `ANIMAL_OUTS` 테이블에 있음
- `ANIMAL_ID`를 기준으로 `LEFT JOIN`
- 결과는 `보호 시작일 오름차순` 정렬 후 상위 3건
- 출력 컬럼: `NAME`, `DATETIME`  
  (단, `DATETIME`은 보호 시작일이며, 입양일 아님)

---

## 🧾 예시 테이블 구조

### ANIMAL_INS  
| ANIMAL_ID | ANIMAL_TYPE | DATETIME           | NAME  |
|-----------|-------------|--------------------|-------|
| A441198   | Dog         | 2015-01-29 15:01:00| Shelly|
| A412697   | Dog         | 2016-01-03 16:25:00| Jackie|
| A413789   | Dog         | 2016-04-19 13:28:00| Benji |

### ANIMAL_OUTS  
| ANIMAL_ID | DATETIME            | NAME  |
|-----------|---------------------|-------|
| (없음)    | (없음)              |       |

---

## ✅ 정답 SQL

```sql
SELECT
  I.NAME,
  I.DATETIME AS 'DATETIME'
FROM
  ANIMAL_INS AS I
  LEFT JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE
  O.DATETIME IS NULL
ORDER BY
  I.DATETIME ASC
LIMIT 3;
```

---

## 💡 풀이 포인트

- `LEFT JOIN`을 사용하여 입소 정보는 항상 기준으로 두고, 입양 여부는 `NULL` 여부로 판단
- `WHERE O.DATETIME IS NULL` → 아직 입양되지 않은 동물
- 오래된 순으로 정렬 후 상위 3건 출력
