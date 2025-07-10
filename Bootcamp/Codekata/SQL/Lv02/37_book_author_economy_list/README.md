# 조건에 맞는 도서와 저자 리스트 출력하기

## ✅ 문제 설명

BOOK 테이블과 AUTHOR 테이블을 조인하여,  
`CATEGORY = '경제'`인 도서의 `BOOK_ID`, `AUTHOR_NAME`, `PUBLISHED_DATE`를 출력하시오.

- 출력 형식: `BOOK_ID`, `AUTHOR_NAME`, `PUBLISHED_DATE`
- `PUBLISHED_DATE`는 `YYYY-MM-DD` 형식으로 출력
- 정렬: 출판일(PUBLISHED_DATE) 기준 **오름차순**

---

## 🧾 사용 테이블

### 📘 BOOK

| 컬럼명          | 설명           |
|-----------------|----------------|
| BOOK_ID         | 도서 ID         |
| CATEGORY        | 도서 카테고리   |
| AUTHOR_ID       | 저자 ID         |
| PRICE           | 도서 가격       |
| PUBLISHED_DATE  | 출판일 (DATETIME) |

### 📘 AUTHOR

| 컬럼명       | 설명       |
|--------------|------------|
| AUTHOR_ID    | 저자 ID     |
| AUTHOR_NAME  | 저자 이름   |

---

## 💡 풀이 흐름

1. `BOOK` 테이블과 `AUTHOR` 테이블을 `AUTHOR_ID`로 조인
2. `CATEGORY = '경제'` 조건으로 필터링
3. `DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d')`을 사용하여 날짜 출력 포맷 통일
4. `PUBLISHED_DATE` 기준 오름차순 정렬

---

## ✅ 정답 SQL

```sql
SELECT
  B.BOOK_ID,
  A.AUTHOR_NAME,
  DATE_FORMAT(B.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM
  BOOK AS B
  LEFT JOIN AUTHOR AS A ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE
  B.CATEGORY = '경제'
ORDER BY
  B.PUBLISHED_DATE ASC;
```

---

## ❌ 오답노트

### 오답 SQL 예시

```sql
DATE_FORMAT(B.PUBLISHED_DATE, '%y-%m-%d') AS PUBLISHED_DATE
```

### 문제점

| 항목 | 문제 | 설명 |
|------|------|------|
| `%y` 사용 | ❌ | 두 자리 연도 출력 → `20-01-01`, `21-06-10` 형식 |
| 정답 요구 포맷 | ✅ | 네 자리 연도 → `2020-01-01`, `2021-06-10` 형식 |

`%y` → `21`, `%Y` → `2021`  
→ 문제에서 요구한 `"YYYY-MM-DD"` 형식과 다르기 때문에 오답 처리됨.

---

## ✅ 실행 결과 예시

| BOOK_ID | AUTHOR_NAME | PUBLISHED_DATE |
|---------|--------------|----------------|
| 3       | 김영호       | 2021-02-05     |
| 2       | 홍길동       | 2021-04-11     |

---

## 📌 정리

- 날짜 포맷 출력 시 **문제에서 요구한 포맷에 정확히 맞춰야 정답 처리**됨
- `%Y` (대문자) = 네 자리 연도, `%y` (소문자) = 두 자리 연도
