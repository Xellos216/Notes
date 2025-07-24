# 조건에 부합하는 중고거래 상태 조회하기

## ✅ 문제 설명

`USED_GOODS_BOARD` 테이블에서 2022년 10월 5일에 등록된 중고거래 게시물의 게시글 ID, 작성자 ID, 게시글 제목, 가격, 거래상태를 조회하는 SQL문을 작성해주세요.  
거래상태 `STATUS`는 다음과 같이 출력되도록 조건에 맞게 변환합니다:

- `SALE` → `'판매중'`
- `RESERVED` → `'예약중'`
- `DONE` → `'거래완료'`

결과는 게시글 ID (`BOARD_ID`) 기준으로 내림차순 정렬합니다.

---

## ✅ 테이블 구조: `USED_GOODS_BOARD`

| Column name    | Type         | Nullable | 설명             |
|----------------|--------------|----------|------------------|
| BOARD_ID       | VARCHAR(5)   | FALSE    | 게시글 ID        |
| WRITER_ID      | VARCHAR(50)  | FALSE    | 작성자 ID        |
| TITLE          | VARCHAR(1000)| FALSE    | 게시글 제목      |
| CONTENTS       | VARCHAR(1000)| FALSE    | 게시글 내용      |
| PRICE          | NUMBER       | FALSE    | 가격             |
| CREATED_DATE   | DATE         | FALSE    | 게시글 작성일    |
| STATUS         | VARCHAR(10)  | FALSE    | 거래 상태 (SALE, RESERVED, DONE) |
| VIEWS          | NUMBER       | FALSE    | 조회 수          |

---

## ✅ 정답 SQL

```sql
SELECT
  BOARD_ID,
  WRITER_ID,
  TITLE,
  PRICE,
  CASE 
    WHEN STATUS = 'SALE' THEN '판매중'
    WHEN STATUS = 'RESERVED' THEN '예약중'
    WHEN STATUS = 'DONE' THEN '거래완료'
    ELSE '알수없음'
  END AS STATUS
FROM USED_GOODS_BOARD
WHERE CREATED_DATE = '2022-10-05'
ORDER BY BOARD_ID DESC;
```

---

## 🧠 포인트 요약

- `CASE WHEN` 문은 조건별 다중 분기를 처리할 때 적합
- `IF()`는 두 갈래 분기에서만 사용 권장
- `ORDER BY BOARD_ID DESC`로 내림차순 정렬
