## 🧠 Problem

`BOOK` 테이블, `AUTHOR` 테이블, `BOOK_SALES` 테이블을 이용하여
**2022년 1월의 도서 판매 데이터를 기준**으로 **저자 별, 카테고리 별 매출액**을 조회하는 SQL을 작성하시오.

  - 매출액(`TOTAL_SALES`)은 `판매량 * 판매가`로 계산하여 출력합니다.
  - 출력할 리스트는 `저자 ID (AUTHOR_ID)`, `저자명 (AUTHOR_NAME)`, `카테고리 (CATEGORY)`, `매출액 (TOTAL_SALES)`입니다.
  - 결과는 `저자 ID` 기준 오름차순으로, `저자 ID`가 같다면 `카테고리`를 내림차순 정렬하여 출력합니다.

-----

## 💾 SQL Query

```sql
SELECT
    A.AUTHOR_ID,
    A.AUTHOR_NAME,
    B.CATEGORY,
    SUM(BS.SALES * B.PRICE) AS TOTAL_SALES
FROM
    BOOK_SALES BS
JOIN
    BOOK B ON BS.BOOK_ID = B.BOOK_ID
JOIN
    AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE
    BS.SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY
    A.AUTHOR_ID,
    A.AUTHOR_NAME,
    B.CATEGORY
ORDER BY
    A.AUTHOR_ID ASC,
    B.CATEGORY DESC;
```

-----

## SQL Keywords 설명

### 🔹 SUM(BS.SALES \* B.PRICE) AS TOTAL\_SALES

  - `BOOK_SALES` 테이블의 `SALES`(판매량)와 `BOOK` 테이블의 `PRICE`(판매가)를 곱한 값을 각 그룹별로 합산하여 `TOTAL_SALES`라는 별칭으로 매출액을 계산합니다.

### 🔹 JOIN

  - `BOOK_SALES`, `BOOK`, `AUTHOR` 세 테이블을 연결하여 필요한 모든 정보를 가져옵니다.
      - `BOOK_SALES`와 `BOOK`은 `BOOK_ID`를 기준으로 조인됩니다.
      - `BOOK`과 `AUTHOR`는 `AUTHOR_ID`를 기준으로 조인됩니다.

### 🔹 WHERE BS.SALES\_DATE BETWEEN '2022-01-01' AND '2022-01-31'

  - 판매일(`SALES_DATE`)이 2022년 1월 1일부터 2022년 1월 31일 사이인 데이터만 필터링합니다.

### 🔹 GROUP BY A.AUTHOR\_ID, A.AUTHOR\_NAME, B.CATEGORY

  - `저자 ID`, `저자명`, `카테고리` 별로 데이터를 그룹화하여 그룹별 총 매출액을 계산할 수 있도록 합니다.

### 🔹 ORDER BY A.AUTHOR\_ID ASC, B.CATEGORY DESC

  - 결과를 `저자 ID` 기준으로 오름차순 정렬하고, `저자 ID`가 같을 경우 `카테고리` 기준으로 내림차순 정렬합니다.

-----

## 문제 풀이 흐름 요약

  - STEP 1: `BOOK_SALES`, `BOOK`, `AUTHOR` 테이블을 조인하여 판매, 도서, 저자 정보를 결합합니다.
  - STEP 2: `WHERE` 절을 사용하여 2022년 1월의 판매 데이터만 필터링합니다.
  - STEP 3: `SUM(BS.SALES * B.PRICE)`를 사용하여 각 판매 건의 매출액을 계산하고, 이를 `저자 ID`, `저자명`, `카테고리` 별로 `GROUP BY`하여 합산합니다.
  - STEP 4: `SELECT` 절에서 `AUTHOR_ID`, `AUTHOR_NAME`, `CATEGORY`, `TOTAL_SALES`를 선택합니다.
  - STEP 5: `ORDER BY` 절을 사용하여 `AUTHOR_ID` 오름차순, `CATEGORY` 내림차순으로 최종 결과를 정렬합니다.
