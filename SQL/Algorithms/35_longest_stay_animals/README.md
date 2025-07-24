# 보호 기간이 가장 길었던 동물(2)

## ✅ 문제 설명

보호소에 입소되었다가 입양된 동물 중,  
**보호소에 가장 오래 머문 동물 2마리**의 `ANIMAL_ID`와 `NAME`을 조회하시오.

- 보호 기간 = `입양일 - 입소일`
- 보호 기간이 긴 순으로 정렬
- 상위 2마리만 조회

---

## 🧾 사용 테이블

### 📘 ANIMAL_INS

| 컬럼명           | 설명             |
|------------------|------------------|
| ANIMAL_ID        | 동물 ID (기본키) |
| DATETIME         | 보호 시작 시각   |
| NAME             | 이름 (nullable)  |

### 📘 ANIMAL_OUTS

| 컬럼명           | 설명             |
|------------------|------------------|
| ANIMAL_ID        | 동물 ID (외래키) |
| DATETIME         | 입양 시각        |
| NAME             | 이름 (nullable)  |

---

## 💡 풀이 흐름

1. `ANIMAL_ID` 기준으로 두 테이블 조인
2. `DATEDIFF(O.DATETIME, I.DATETIME)`을 이용해 보호 기간 계산
3. 보호 기간 긴 순으로 정렬
4. 상위 2개만 출력
5. 출력 컬럼은 `ANIMAL_ID`, `NAME`만

---

## ✅ 정답 SQL

```sql
SELECT
  I.ANIMAL_ID,
  I.NAME
FROM
  ANIMAL_INS AS I
  INNER JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID = O.ANIMAL_ID
ORDER BY
  DATEDIFF(O.DATETIME, I.DATETIME) DESC
LIMIT 2;
```

---

## ❌ 오답노트

### 오답 SQL 예시

```sql
SELECT
  I.ANIMAL_ID,
  I.NAME,
  DATEDIFF(I.DATETIME, O.DATETIME) AS DATEDIFF
...
ORDER BY DATEDIFF ASC
```

### 문제점 정리

| 항목 | 문제점 | 설명 |
|------|--------|------|
| `DATEDIFF` 방향 반대 | ❌ | `입양일 - 입소일`이 아니라 `입소일 - 입양일`로 음수 발생 |
| `DATEDIFF` 컬럼 SELECT에 포함 | ❌ | 문제에서 요구하는 출력 컬럼(`ANIMAL_ID`, `NAME`)에 어긋남 |
| 정렬 방향 | ❌ | `ASC`는 보호 기간 짧은 순 → `DESC`로 고쳐야 정답 |

---

## ✅ 실행 예시

| ANIMAL_ID | NAME       |
|-----------|------------|
| A362707   | Girly Girl |
| A370507   | Emily      |

---

## 📌 정리

- 날짜 차이는 `DATEDIFF(입양일, 입소일)`
- 출력 컬럼이 문제 요구와 정확히 일치해야 정답 처리됨
- `ORDER BY`에 사용한 컬럼이 `SELECT`에 포함되지 않아도 상관없음

