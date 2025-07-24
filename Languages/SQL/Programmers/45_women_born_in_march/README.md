# 👩‍💻 3월에 태어난 여성 회원 목록 출력하기

## 📘 문제 설명

`MEMBER_PROFILE` 테이블에서 다음 조건을 만족하는 회원의 정보를 조회하세요.

- 생일이 **3월**인 회원
- **성별이 여성 ('W')**
- **전화번호(TLNO)가 NULL이 아닌 경우만 출력**
- 출력 컬럼: `MEMBER_ID`, `MEMBER_NAME`, `GENDER`, `DATE_OF_BIRTH`
- 생일은 `'YYYY-MM-DD'` 포맷으로 출력
- 정렬 기준: `MEMBER_ID` 오름차순

---

## 🧾 테이블 구조: MEMBER_PROFILE

| Column         | Type    | Nullable | Description     |
|----------------|---------|----------|-----------------|
| MEMBER_ID      | VARCHAR | FALSE    | 회원 ID          |
| MEMBER_NAME    | VARCHAR | FALSE    | 이름             |
| TLNO           | VARCHAR | TRUE     | 전화번호         |
| GENDER         | VARCHAR | FALSE    | 성별 (M/W)       |
| DATE_OF_BIRTH  | DATE    | TRUE     | 생년월일 (DATE)  |

---

## ✅ 정답 SQL

```sql
SELECT
  MEMBER_ID,
  MEMBER_NAME,
  GENDER,
  DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
FROM
  MEMBER_PROFILE
WHERE
  MONTH(DATE_OF_BIRTH) = 3
  AND GENDER = 'W'
  AND TLNO IS NOT NULL
ORDER BY
  MEMBER_ID ASC;
```

---

## 📌 함수 설명: `MONTH()`

- `MONTH(date_column)`은 날짜 컬럼에서 **월(month)** 값을 정수(1~12)로 추출합니다.
- 예:  
  - `MONTH('1993-03-16')` → `3`  
  - `MONTH('1992-11-04')` → `11`

→ 따라서 `MONTH(DATE_OF_BIRTH) = 3` 조건을 사용하면 생일이 **3월**인 행만 필터링할 수 있습니다.

---

## 🧪 예시 데이터

| MEMBER_ID            | MEMBER_NAME | TLNO           | GENDER | DATE_OF_BIRTH |
|----------------------|-------------|----------------|--------|---------------|
| seoyeons@naver.com   | 박서연      | 01076482209    | W      | 1993-03-16     |
| yoonsy94@gmail.com   | 윤서연      | NULL           | W      | 1994-03-19     |

### ➤ 출력 결과

| MEMBER_ID            | MEMBER_NAME | GENDER | DATE_OF_BIRTH |
|----------------------|-------------|--------|----------------|
| seoyeons@naver.com   | 박서연      | W      | 1993-03-16     |

---

## 🧠 요약 정리

- `MONTH()`를 활용하면 **DATE 타입에서 특정 월만 필터링**할 수 있음
- 문자열 LIKE 대신 `MONTH(DATE_OF_BIRTH) = 3` 사용이 더 명확하고 성능도 좋음
- `TLNO IS NOT NULL` 조건 누락 주의

