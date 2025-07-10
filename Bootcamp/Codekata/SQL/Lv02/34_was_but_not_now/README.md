# 있었는데요 없었습니다

## ✅ 문제 설명

보호소 관리 시스템에서 일부 동물의 **입양일자가 입소일자보다 빠르게 잘못 입력**된 사례가 있습니다.  
이때, **입양일(OUT)보다 입소일(IN)이 더 늦은 동물**의 ID와 이름을 조회해야 합니다.

- `ANIMAL_INS.DATETIME > ANIMAL_OUTS.DATETIME` 조건
- 보호 시작일 기준 **오름차순 정렬**

---

## 🧾 사용 테이블

### 📘 ANIMAL_INS

| 컬럼명        | 설명             |
|---------------|------------------|
| ANIMAL_ID     | 동물 ID (기본키)   |
| ANIMAL_TYPE   | 동물 종류          |
| DATETIME      | 보호 시작 시각     |
| INTAKE_CONDITION | 입소 당시 상태 |
| NAME          | 이름 (nullable)   |
| SEX_UPON_INTAKE | 입소 시 성별     |

### 📘 ANIMAL_OUTS

| 컬럼명         | 설명               |
|----------------|--------------------|
| ANIMAL_ID      | 동물 ID (외래키)     |
| ANIMAL_TYPE    | 동물 종류            |
| DATETIME       | 입양 시각           |
| NAME           | 이름 (nullable)     |
| SEX_UPON_OUTCOME| 입양 시 성별        |

---

## 💡 풀이 흐름

1. `ANIMAL_ID` 기준으로 두 테이블을 조인
2. 입양일(OUT)이 입소일(IN)보다 빠른 조건만 필터링
3. 해당 동물의 ID와 이름 조회
4. 입소일 기준 오름차순 정렬

---

## ✅ 정답 SQL

```sql
SELECT
  I.ANIMAL_ID,
  I.NAME
FROM
  ANIMAL_INS AS I
  LEFT JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE
  I.DATETIME > O.DATETIME
ORDER BY
  I.DATETIME ASC;
```

---

## ✅ 실행 결과 예시 (예시 테이블 기준)

| ANIMAL_ID | NAME     |
|-----------|----------|
| A350276   | Jewel    |

---

## 📌 정리

- 날짜/시간 비교는 `DATETIME`끼리 비교 가능
- `LEFT JOIN`을 통해 모든 입소 기록 기준으로 입양 정보를 비교
- 조건문에서 `IN > OUT` 형태는 **입력이 더 늦게 되었음을 의미**함
- `ORDER BY`는 보호소 입소일 기준 오름차순

---

## ❗ 주의할 점

- `I.DATETIME > O.DATETIME` 조건이 핵심이며, 반대로 쓰면 의미가 완전히 바뀜
- 반드시 `JOIN`을 이용해 두 테이블을 연결한 뒤 조건 비교해야 함
