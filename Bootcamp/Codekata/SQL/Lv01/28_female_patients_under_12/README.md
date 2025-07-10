# 12세 이하인 여자 환자 목록 출력하기

> CodeKata / SQL / Lv01 / Female_Patients_Under_12

## 📌 문제 설명

`PATIENT` 테이블에는 병원 환자 정보가 담겨 있습니다.  
이 중 **성별이 'W'**이고, **나이가 12세 이하**인 환자들의 정보를 조회하세요.

조회해야 하는 컬럼은 다음과 같습니다:

- 환자명 (`PT_NAME`)
- 환자번호 (`PT_NO`)
- 성별코드 (`GEND_CD`)
- 나이 (`AGE`)
- 전화번호 (`TLNO`) → NULL인 경우 'NONE'으로 출력

정렬 조건:

1. **나이 내림차순**
2. 나이가 같다면 **이름 오름차순**

---

## ✅ 테이블 구조

| 컬럼명   | 타입         | 설명             |
|----------|--------------|------------------|
| PT_NO    | VARCHAR      | 환자번호         |
| PT_NAME  | VARCHAR      | 환자명           |
| GEND_CD  | VARCHAR(1)   | 성별코드 ('M', 'W') |
| AGE      | INTEGER      | 나이             |
| TLNO     | VARCHAR      | 전화번호 (nullable) |

---

## ✅ 정답 SQL

```sql
SELECT
  PT_NAME,
  PT_NO,
  GEND_CD,
  AGE,
  IFNULL(TLNO, 'NONE') AS TLNO
FROM PATIENT
WHERE AGE <= 12 AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME ASC;
```

---

## 💡 쿼리 해설

- `IFNULL(TLNO, 'NONE')`  
  → 전화번호가 없는 경우 'NONE'으로 출력

- `WHERE AGE <= 12 AND GEND_CD = 'W'`  
  → 여자 환자이면서 12세 이하 조건

- `ORDER BY AGE DESC, PT_NAME ASC`  
  → 나이 기준 내림차순, 이름 기준 오름차순

---

## 💻 실행 결과 예시

| PT_NAME | PT_NO       | GEND_CD | AGE | TLNO         |
|---------|-------------|---------|-----|--------------|
| 한나     | PT22000009  | W       | 12  | 01032323117  |

---

## 🧠 학습 포인트

- `IFNULL()`을 활용한 NULL 처리 방식
- 다중 조건 필터링: `AND` 사용
- `ORDER BY` 복합 정렬 기준 사용

---

## 🖼 실행 화면 캡처

![실행결과](./Screenshot.png)
