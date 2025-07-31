## 🧠 Problem
`USED_GOODS_BOARD` 테이블과 `USED_GOODS_FILE` 테이블을 이용하여
**조회수가 가장 높은 중고거래 게시물의 첨부파일 경로**를 조회하는 SQL을 작성하시오.

- 첨부파일 경로(`FILE_PATH`)는 다음 형식으로 출력:
  `/home/grep/src/{BOARD_ID}/{FILE_ID}{FILE_NAME}.{FILE_EXT}`
- 해당 게시물은 **조회수가 가장 높은 게시물** 1개이며,
- 해당 게시물의 첨부파일이 여러 개일 경우 모두 출력
- 결과는 `FILE_ID` 기준 내림차순 정렬

---

## 💾 SQL Query
```sql
SELECT
  CONCAT('/home/grep/src/', B.BOARD_ID, '/', F.FILE_ID, F.FILE_NAME, '.', F.FILE_EXT) AS FILE_PATH
FROM
  USED_GOODS_BOARD B
JOIN
  USED_GOODS_FILE F ON B.BOARD_ID = F.BOARD_ID
WHERE
  B.VIEWS = (
    SELECT MAX(VIEWS)
    FROM USED_GOODS_BOARD
  )
ORDER BY
  F.FILE_ID DESC;
```

---

## 💾 SQL Query, Rank() 사용
```sql
WITH RankedBoards AS (
  SELECT
    B.BOARD_ID,
    F.FILE_ID,
    F.FILE_NAME,
    F.FILE_EXT,
    RANK() OVER (ORDER BY B.VIEWS DESC) AS RANKING
  FROM
    USED_GOODS_BOARD B
  JOIN
    USED_GOODS_FILE F ON B.BOARD_ID = F.BOARD_ID
)
SELECT
  CONCAT('/home/grep/src/', BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT) AS FILE_PATH
FROM
  RankedBoards
WHERE
  RANKING = 1
ORDER BY
  FILE_ID DESC;
```

---

## SQL Keywords 설명

### 🔹 CONCAT
- 문자열 이어 붙이기 함수. 파일 경로 구성에 사용됨

### 🔹 MAX(VIEWS)
- `USED_GOODS_BOARD` 테이블에서 최대 조회수 추출

### 🔹 JOIN
- 첨부파일 정보(`USED_GOODS_FILE`)와 게시물 정보(`USED_GOODS_BOARD`) 연결

### 🔹 WHERE B.VIEWS = (SELECT MAX(...))
- 조회수가 가장 높은 게시물 1개 필터링

### 🔹 ORDER BY F.FILE_ID DESC
- 첨부파일 ID 기준으로 내림차순 정렬

---

## 문제 풀이 흐름 요약

- STEP 1: `USED_GOODS_BOARD`에서 가장 조회수가 높은 게시물 추출
- STEP 2: 해당 게시물과 연결된 `USED_GOODS_FILE`을 JOIN으로 가져옴
- STEP 3: `CONCAT`로 첨부파일 경로를 생성
- STEP 4: `FILE_ID DESC`로 정렬



