# 🐬 SQL Day12 - 조건에 맞는 회원 수 구하기

## 📌 문제 설명

`USER_INFO` 테이블에는 사용자 정보가 담겨 있으며, 다음과 같은 조건을 만족하는  
회원 수를 구하는 SQL 문을 작성하세요.

- `JOINED` 날짜가 **2021년**에 해당하는 회원
- `AGE`가 **20세 이상 29세 이하**인 회원

이 조건을 모두 만족하는 회원의 수를 출력하세요.

---

## ✅ 테이블 구조 (USER_INFO)

| 컬럼명    | 타입 | NULL 허용 | 설명         |
|-----------|------|-----------|--------------|
| USER_ID   | INT  | ❌        | 사용자 ID     |
| GENDER    | INT  | ✅        | 0=남자, 1=여자 |
| AGE       | INT  | ✅        | 나이          |
| JOINED    | DATE | ❌        | 가입일        |

---

## ✅ 정답 쿼리

```sql
SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE AGE BETWEEN 20 AND 29
  AND JOINED BETWEEN '2021-01-01' AND '2021-12-31';
```

---

## 🧪 실행 예시 (출력 형태)

| USERS |
|-------|
| 3     |

---

## 📝 요약 포인트

- `BETWEEN A AND B`: A 이상 B 이하 범위 포함
- 날짜 범위는 문자열로 비교 가능 (`YYYY-MM-DD`)
- `AGE`가 NULL인 경우는 자동으로 필터링됨 (조건 미충족)
- `JOINED`는 DATE 타입이라 `'2021-12-31'`까지 포함됨

---

## ✅ 참고 사항

- `AGE IS NULL`인 경우 `BETWEEN` 조건에서 자동 제외되므로 따로 처리할 필요 없음
- `JOINED`의 연도만 비교하고 싶다면 `YEAR(JOINED) = 2021`도 가능하지만, 인덱스 활용을 위해 `BETWEEN`을 추천
