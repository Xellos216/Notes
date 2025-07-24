# 3건 이상 등록한 사용자 정보 조회하기

## ✅ 문제 설명

중고 거래 게시판에 3건 이상 등록한 사용자의 사용자 ID, 닉네임, 전체주소, 전화번호를 조회하는 SQL문을 작성하시오.

- 전체 주소는 `CITY`, `STREET_ADDRESS1`, `STREET_ADDRESS2`를 **띄어쓰기 포함하여 하나의 컬럼으로 합쳐서** 출력
- 전화번호는 `xxx-xxxx-xxxx` 형태로 하이픈(-)을 삽입하여 출력
- 결과는 `USER_ID` 기준으로 **오름차순 정렬**

---

## 🧾 사용 테이블

### 📘 USED_GOODS_BOARD 테이블

| 컬럼명       | 설명         |
|------------|-------------|
| BOARD_ID   | 게시글 ID     |
| WRITER_ID  | 작성자 ID     |
| TITLE      | 게시글 제목    |
| CONTENTS   | 게시글 내용    |
| PRICE      | 가격         |
| CREATED_DATE | 작성일자     |
| STATUS     | 거래상태      |
| VIEWS      | 조회수       |

### 📘 USED_GOODS_USER 테이블

| 컬럼명            | 설명           |
|-----------------|----------------|
| USER_ID         | 회원 ID        |
| NICKNAME        | 닉네임          |
| CITY            | 시/도          |
| STREET_ADDRESS1 | 도로명 주소     |
| STREET_ADDRESS2 | 상세 주소       |
| TLNO            | 전화번호 (숫자열) |

---

## 💡 풀이 방법

1. `USED_GOODS_BOARD`에서 `WRITER_ID` 기준으로 그룹화 후, **3건 이상 작성한 사용자**만 필터링
2. 해당 사용자들과 `USED_GOODS_USER` 테이블을 `USER_ID = WRITER_ID`로 JOIN
3. **전체 주소**는 `CITY + ' ' + STREET_ADDRESS1 + ' ' + STREET_ADDRESS2` 로 구성
4. **전화번호**는 `SUBSTR()`와 `CONCAT()` 또는 `FORMAT()` 등을 활용해 `"01012345678"` → `"010-1234-5678"`로 포맷팅
5. 최종적으로 `USER_ID`, `NICKNAME`, `전체주소`, `전화번호`를 선택하여 **USER_ID 오름차순 정렬**

---

## ✅ 정답 SQL

```sql
SELECT
  U.USER_ID,
  U.NICKNAME,
  CONCAT(U.CITY, ' ', U.STREET_ADDRESS1, ' ', U.STREET_ADDRESS2) AS 전체주소,
  CONCAT(SUBSTRING(U.TLNO, 1, 3), '-', SUBSTRING(U.TLNO, 4, 4), '-', SUBSTRING(U.TLNO, 8)) AS 전화번호
FROM
  USED_GOODS_USER U
  JOIN (
    SELECT WRITER_ID
    FROM USED_GOODS_BOARD
    GROUP BY WRITER_ID
    HAVING COUNT(*) >= 3
  ) B ON U.USER_ID = B.WRITER_ID
ORDER BY
  U.USER_ID ASC;
```

---

## ✅ 실행 결과 예시

| USER_ID   | NICKNAME | 전체주소                         | 전화번호        |
|-----------|----------|----------------------------------|-----------------|
| dhfkzmf09 | 찐찐     | 성남시 분당구 수내로 13 A동 1107호 | 010-5342-2914   |

---

## ❌ 오답노트

### 오답 SQL

```sql
SELECT
  U.USER_ID,
  U.NICKNAME,
  U.CITY,
  U.STREET_ADDRESS1,
  U.STREET_ADDRESS2,
  U.TLNO
FROM
  USED_GOODS_USER U
  JOIN USED_GOODS_BOARD B ON U.USER_ID = B.WRITER_ID
GROUP BY
  U.USER_ID
HAVING
  COUNT(*) >= 3;
```

### ❗ 오답 원인

| 항목 | 문제점 | 설명 |
|------|--------|------|
| 주소 분리 출력 | ❌ | 전체 주소가 하나의 컬럼으로 합쳐지지 않음 |
| 전화번호 형식 | ❌ | 하이픈(-)이 포함되지 않은 원형 문자열 그대로 출력됨 |
| `GROUP BY` 대상 테이블 | ⚠️ | 사용자 테이블 기준으로 그룹화하였으나, 등록 수 집계는 `BOARD` 기준이 더 명확함 |

---

## 📌 정리

- 여러 컬럼을 문자열로 합칠 땐 `CONCAT()` 사용
- 전화번호 포맷 변경은 `SUBSTRING()`으로 슬라이스 후 `-` 삽입
- `GROUP BY` → `HAVING COUNT(*) >= n` 으로 특정 조건 만족 그룹 필터링
