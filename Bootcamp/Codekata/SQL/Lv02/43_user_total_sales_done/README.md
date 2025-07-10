# 📊 조건에 맞는 사용자와 총 거래금액 조회하기

## 📘 문제 설명

`USED_GOODS_BOARD` 테이블과 `USED_GOODS_USER` 테이블을 조인하여,  
- **거래 상태가 'DONE'인 경우**만 필터링하고  
- **사용자별 총 거래금액이 700000원 이상**인 사용자들을  
- `USER_ID`, `NICKNAME`, `TOTAL_SALES`로 출력하세요.

출력은 `TOTAL_SALES` 기준 오름차순 정렬입니다.

---

## 🧾 테이블 정보

### 📦 USED_GOODS_BOARD

| Column        | Type         | Description     |
|---------------|--------------|-----------------|
| BOARD_ID      | VARCHAR(5)   | 게시글 ID        |
| WRITER_ID     | VARCHAR(50)  | 작성자 ID        |
| TITLE         | VARCHAR(100) | 게시글 제목       |
| CONTENTS      | VARCHAR(1000)| 게시글 내용       |
| PRICE         | NUMBER       | 가격 (원)         |
| CREATED_DATE  | DATE         | 작성일           |
| STATUS        | VARCHAR(10)  | 거래 상태 (SALE, DONE 등) |
| VIEWS         | NUMBER       | 조회수           |

### 👤 USED_GOODS_USER

| Column            | Type          | Description  |
|-------------------|---------------|--------------|
| USER_ID           | VARCHAR(50)   | 회원 ID       |
| NICKNAME          | VARCHAR(100)  | 닉네임        |
| CITY              | VARCHAR(100)  | 도시          |
| STREET_ADDRESS1   | VARCHAR(100)  | 도로명 주소    |
| STREET_ADDRESS2   | VARCHAR(100)  | 상세 주소      |
| TLNO              | VARCHAR(20)   | 전화번호       |

---

## ✅ 정답 SQL

```sql
SELECT
    U.USER_ID,
    U.NICKNAME,
    SUM(B.PRICE) AS TOTAL_SALES
FROM
    USED_GOODS_USER AS U
    LEFT JOIN USED_GOODS_BOARD AS B
    ON B.WRITER_ID = U.USER_ID
WHERE
    B.STATUS = 'DONE'
GROUP BY
    U.USER_ID,
    U.NICKNAME
HAVING
    TOTAL_SALES >= 700000
ORDER BY
    TOTAL_SALES ASC;
```

---

## 🧠 핵심 개념 요약

| 개념 요소 | 설명 |
|-----------|------|
| `LEFT JOIN` | 작성자와 유저 테이블 조인: `WRITER_ID = USER_ID` |
| `WHERE B.STATUS = 'DONE'` | 완료된 거래만 필터링 |
| `SUM(B.PRICE)` | 사용자별 총 거래 금액 계산 |
| `GROUP BY USER_ID, NICKNAME` | 사용자별 집계 |
| `HAVING TOTAL_SALES >= 700000` | 집계 결과를 조건 필터링 |
| `ORDER BY TOTAL_SALES ASC` | 총 거래금액 오름차순 정렬 |

---

## ⚠️ 오답 원인 분석

| 잘못된 부분 | 설명 |
|-------------|------|
| `WHERE` 절에서 `B.STATUS = 'DONE'` 누락 | SALE 상태도 합산됨 |
| `HAVING` 대신 `WHERE`에 `SUM(...)` 사용 | 집계 이후 조건 필터링은 `HAVING`에서 해야 함 |
| `GROUP BY 1` | 가능은 하지만 명시적 컬럼이 더 가독성 높음 |

---

## ✅ 예시 출력 결과

| USER_ID     | NICKNAME | TOTAL_SALES |
|-------------|----------|-------------|
| zkzkdh1     | 후후후   | 700000      |
| dhfkzmf09   | 찐찐     | 860000      |
| sangyoung58 | 보라보라 | 1500000     |

