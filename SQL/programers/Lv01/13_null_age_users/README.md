# SQL 13 - 나이 정보가 없는 회원 수 구하기 (IS NULL)

> CodeKata / SQL / Day01 / NullAgeUsers

## 📌 문제 설명

`USER_INFO` 테이블에는 사용자들의 성별, 나이, 가입일 정보가 저장되어 있습니다.  
이 중에서 **나이(Age) 정보가 없는 회원의 수**를 구하는 SQL문을 작성하세요.

단, 결과 컬럼명은 반드시 `USERS`로 지정해야 합니다.

---

## ✅ 테이블 구조

| Column name | Type      | Nullable |
|-------------|-----------|----------|
| USER_ID     | INTEGER   | FALSE    |
| GENDER      | TINYINT(1)| TRUE     |
| AGE         | INTEGER   | TRUE     |
| JOINED      | DATE      | FALSE    |

> GENDER는 NULL이거나 0(남성), 1(여성) 중 하나입니다.

---

## ✅ 정답 쿼리

```sql
SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE AGE IS NULL;
```

---

## 💻 실행 결과 예시

예를 들어, `USER_INFO` 테이블이 다음과 같다면:

| USER_ID | GENDER | AGE  | JOINED     |
|---------|--------|------|------------|
| 1       | 1      | 26   | 2021-06-01 |
| 2       | NULL   | NULL | 2021-07-25 |
| 3       | 1      | NULL | 2021-07-30 |
| 4       | 0      | 30   | 2021-08-03 |

→ `AGE IS NULL` 조건을 만족하는 회원은 2명이므로, 출력 결과는 아래와 같습니다:

| USERS |
|-------|
| 2     |

> 실제 채점에서는 더 많은 데이터가 포함되어 있을 수 있습니다.

---

## 🧠 학습 포인트

- `IS NULL` 조건 사용법
- `COUNT(*)` 함수의 기본적인 활용
- 컬럼명 지정 (AS USERS)

---

## 🖼 실행 화면 캡처

![실행결과](./Screenshot.png)
