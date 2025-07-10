# 흉부외과 또는 일반외과 의사 목록 조회하기

> CodeKata / SQL / Lv01 / Doctor_CS_GS_List

## 📌 문제 설명

`DOCTOR` 테이블에는 병원에 소속된 의사들의 정보가 저장되어 있습니다.  
이 중 **진료과 코드(MCDP_CD)** 가 `'CS'` (흉부외과) 또는 `'GS'` (일반외과)인  
의사들의 `이름(DR_NAME)`, `ID(DR_ID)`, `진료과 코드`, `고용일(HIRE_YMD)`을 조회하세요.

고용일은 `YYYY-MM-DD` 형식으로 출력되도록 가공하고,  
결과는 **고용일 내림차순**, **이름 오름차순**으로 정렬합니다.

---

## ✅ 테이블 구조

| 컬럼명    | 타입     | 설명             |
|-----------|----------|------------------|
| DR_NAME   | VARCHAR  | 의사 이름        |
| DR_ID     | VARCHAR  | 의사 ID          |
| LCNS_NO   | VARCHAR  | 면허번호         |
| HIRE_YMD  | DATE     | 고용일           |
| MCDP_CD   | VARCHAR  | 진료과 코드      |
| TLNO      | VARCHAR  | 전화번호         |

---

## ✅ 정답 SQL

```sql
SELECT
  DR_NAME,
  DR_ID,
  MCDP_CD,
  SUBSTR(HIRE_YMD, 1, 10)
FROM DOCTOR
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS'
ORDER BY HIRE_YMD DESC, DR_NAME ASC;
```

---

## 💡 쿼리 해설

- `WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS'`  
  → 흉부외과 또는 일반외과 의사만 필터링

- `SUBSTR(HIRE_YMD, 1, 10)`  
  → 날짜 포맷을 `YYYY-MM-DD` 형식으로 자름

- `ORDER BY HIRE_YMD DESC, DR_NAME ASC`  
  → 최근 입사자 순 + 이름순 정렬

> 참고: `DATE_FORMAT(HIRE_YMD, '%Y-%m-%d')`도 대안 가능

---

## 💻 실행 결과 예시

| DR_NAME | DR_ID       | MCDP_CD | HIRE_YMD  |
|---------|-------------|---------|-----------|
| 니모     | DR20200012  | CS      | 2020-03-01 |
| 뽀로로   | DR20170123  | GS      | 2017-03-01 |
| 벨      | DR20100039  | GS      | 2010-07-01 |
| 자스민   | DR20100032  | GS      | 2010-03-01 |
| 패티     | DR20090001  | CS      | 2009-07-01 |
| 루피     | DR20090029  | CS      | 2009-03-01 |

---

## 🧠 학습 포인트

- `OR` 조건 필터링
- `SUBSTR()` 활용한 날짜 가공
- 다중 정렬 조건 사용 (`ORDER BY A DESC, B ASC`)

---

## 🖼 실행 화면 캡처

![실행결과](./Screenshot.png)
