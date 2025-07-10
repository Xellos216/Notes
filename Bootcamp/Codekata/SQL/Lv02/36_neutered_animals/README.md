# 보호소에서 중성화된 동물

## ✅ 문제 설명

입소 당시에는 중성화되지 않았지만,  
출소(입양) 당시에는 중성화된 동물을 조회하시오.

- 입소 당시 상태: `SEX_UPON_INTAKE`
- 출소 당시 상태: `SEX_UPON_OUTCOME`
- 두 상태가 다르고, **중성화된 상태로 변경된 경우**만 조회
- 출력: `ANIMAL_ID`, `ANIMAL_TYPE`, `NAME`
- 정렬: `ANIMAL_ID` 오름차순

---

## 🧾 사용 테이블

### 📘 ANIMAL_INS

| 컬럼명             | 설명             |
|--------------------|------------------|
| ANIMAL_ID          | 동물 ID          |
| ANIMAL_TYPE        | 동물 종류         |
| NAME               | 이름             |
| SEX_UPON_INTAKE    | 입소 당시 성별 및 중성화 상태 |

### 📘 ANIMAL_OUTS

| 컬럼명             | 설명             |
|--------------------|------------------|
| ANIMAL_ID          | 동물 ID          |
| SEX_UPON_OUTCOME   | 출소 당시 성별 및 중성화 상태 |

---

## 💡 풀이 흐름

1. `ANIMAL_ID`를 기준으로 `ANIMAL_INS`와 `ANIMAL_OUTS` 조인
2. `SEX_UPON_INTAKE`와 `SEX_UPON_OUTCOME`이 다르고,
3. `SEX_UPON_OUTCOME`이 **'Spayed Female' 또는 'Neutered Male'**인 경우만 필터링
4. `ANIMAL_ID` 기준 오름차순 정렬

---

## ✅ 정답 SQL

```sql
SELECT
  I.ANIMAL_ID,
  I.ANIMAL_TYPE,
  I.NAME
FROM
  ANIMAL_INS AS I
  INNER JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE
  I.SEX_UPON_INTAKE != O.SEX_UPON_OUTCOME
  AND O.SEX_UPON_OUTCOME IN ('Spayed Female', 'Neutered Male')
ORDER BY
  I.ANIMAL_ID ASC;
```

---

## ✅ 실행 예시

| ANIMAL_ID | ANIMAL_TYPE | NAME       |
|-----------|--------------|------------|
| A382192   | Dog          | Maxwell 2  |

---

## 📌 정리

- 단순히 `SEX_UPON_INTAKE != SEX_UPON_OUTCOME` 만으로는 부족함  
  → **"중성화되었는가?"** 를 판별해야 하므로, 출소 상태가 `Spayed` 또는 `Neutered` 인 경우만 선택
- 문자 비교는 정확한 문자열 기준 (`IN` 사용)

