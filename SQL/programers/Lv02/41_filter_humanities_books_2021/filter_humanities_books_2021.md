# 📚 조건에 맞는 도서 리스트 출력하기

## 📘 문제 설명

`BOOK` 테이블에서 다음 조건을 만족하는 도서 목록을 출력하는 SQL문을 작성하세요.

- 출판 연도: **2021년**
- 도서 카테고리: **'인문'**
- 출력 컬럼: `BOOK_ID`, `PUBLISHED_DATE` (출판일을 `YYYY-MM-DD` 형식으로 변환)
- 정렬 기준: **출판일 오름차순**

---

## 🧾 테이블 구조: BOOK

| Column name     | Type         | Nullable | Description     |
|------------------|--------------|-----------|------------------|
| BOOK_ID          | INTEGER      | FALSE     | 도서 ID          |
| CATEGORY         | VARCHAR(n)   | FALSE     | 도서 분류 (예: 경제, 인문, 소설 등) |
| AUTHOR_ID        | INTEGER      | FALSE     | 저자 ID          |
| PRICE            | INTEGER      | FALSE     | 판매가 (원)       |
| PUBLISHED_DATE   | DATE         | FALSE     | 출판일            |

---

## ✅ 정답 SQL

```sql
SELECT
    BOOK_ID,
    DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM
    BOOK
WHERE
    YEAR(PUBLISHED_DATE) = '2021'
    AND CATEGORY = '인문'
ORDER BY
    PUBLISHED_DATE ASC;
```

---

## 🧪 예시 데이터

| BOOK_ID | CATEGORY | AUTHOR_ID | PRICE  | PUBLISHED_DATE |
|---------|----------|-----------|--------|----------------|
| 1       | 인문     | 1         | 10000  | 2020-01-01     |
| 2       | 경제     | 1         | 10000  | 2021-02-05     |
| 3       | 인문     | 2         | 15000  | 2021-10-24     |
| 4       | 인문     | 3         | 13000  | 2021-03-15     |

---

## 🟢 예시 출력 결과

| BOOK_ID | PUBLISHED_DATE |
|---------|----------------|
| 4       | 2021-03-15     |
| 3       | 2021-10-24     |

---

## 🧠 요점 정리

- `YEAR(PUBLISHED_DATE) = '2021'` 로 연도 조건 필터링
- `CATEGORY = '인문'` 으로 카테고리 조건 필터링
- `DATE_FORMAT(..., '%Y-%m-%d')` 로 날짜 형식 변경
- `ORDER BY PUBLISHED_DATE ASC`로 출판일 오름차순 정렬
