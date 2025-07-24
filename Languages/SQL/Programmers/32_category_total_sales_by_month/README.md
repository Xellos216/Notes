# 카테고리 별 도서 판매량 집계하기

## ✅ 문제 설명

2022년 1월 한 달 동안의 도서 판매 기록을 기준으로,  
도서 카테고리(CATEGORY)별 총 판매량(TOTAL_SALES)을 집계하시오.

- 결과는 카테고리명을 기준으로 오름차순 정렬
- 결과 컬럼: `CATEGORY`, `TOTAL_SALES`

---

## 🧾 사용 테이블

### 📘 BOOK 테이블

| 컬럼명        | 설명              |
|-------------|------------------|
| BOOK_ID     | 도서 ID (기본키)    |
| CATEGORY    | 도서 카테고리       |
| AUTHOR_ID   | 저자 ID           |
| PRICE       | 가격               |
| PUBLISHED_DATE | 출판일자         |

### 📘 BOOK_SALES 테이블

| 컬럼명      | 설명                  |
|------------|----------------------|
| BOOK_ID    | 도서 ID (외래키)        |
| SALES_DATE | 판매 일자              |
| SALES      | 해당 일자 판매 수량       |

---

## 💡 풀이 방법

1. 두 테이블을 `BOOK_ID` 기준으로 조인
2. 판매일자가 `2022-01-01 ~ 2022-01-31` 사이인 행만 필터링
3. `CATEGORY` 별로 그룹화
4. `SALES` 수치를 **합산**하여 `TOTAL_SALES`로 출력
5. `CATEGORY` 기준 오름차순 정렬

---

## ✅ 정답 SQL

```sql
SELECT
  B.CATEGORY,
  SUM(S.SALES) AS TOTAL_SALES
FROM
  BOOK AS B
  JOIN BOOK_SALES AS S ON B.BOOK_ID = S.BOOK_ID
WHERE
  S.SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY
  B.CATEGORY
ORDER BY
  B.CATEGORY ASC;
```

---

## ❌ 오답노트

### 오답 SQL

```sql
SELECT
  B.CATEGORY,
  COUNT(*) AS TOTAL_SALES
FROM
  BOOK AS B
  LEFT JOIN BOOK_SALES AS S ON B.BOOK_ID = S.BOOK_ID
WHERE
  S.SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY
  1
ORDER BY
  1 ASC;
```

### ❗ 오답 원인

| 항목 | 문제점 | 설명 |
|------|--------|------|
| `COUNT(*)` 사용 | ❌ | `판매 수량`이 아니라 `행 개수`를 세어버림 |
| `LEFT JOIN` | ⚠️ | 이번 문제에서는 `INNER JOIN`도 충분히 가능 (조건 필터링이 있으므로) |
| `GROUP BY 1` | ⚠️ | 컬럼 순서로 그룹화 가능하지만, 가독성 위해 `GROUP BY B.CATEGORY`가 더 명확함 |

### 💡 핵심 교훈

- **판매량을 집계할 땐 `COUNT(*)`가 아니라 `SUM(판매 수량 컬럼)`을 사용해야 한다.**
- `JOIN` 후 날짜 필터링 → `GROUP BY` → `집계 함수(SUM)`의 전형적인 흐름을 익혀둘 것.

---

## ✅ 실행 결과 예시

| CATEGORY | TOTAL_SALES |
|----------|-------------|
| 경제     | 16          |
| 인문     | 3           |

---

## 📌 정리

- `COUNT(*)` → **행 수 세기**
- `SUM(컬럼)` → **값의 합 구하기**
- 문제에서 "총 판매량"이라면 `SUM(SALES)`을 의심 없이 선택해야 함
