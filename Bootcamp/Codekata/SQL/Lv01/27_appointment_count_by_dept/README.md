# 진료과별 5월 예약 환자 수 조회하기

> CodeKata / SQL / Lv01 / Appointment_Count_By_Dept

## 📌 문제 설명

`APPOINTMENT` 테이블에는 병원 진료 예약 정보가 담겨 있습니다.  
이 중 **2022년 5월**에 예약된 환자 수를 진료과 코드(`MCDP_CD`)별로 집계하고,  
결과는 다음 기준으로 정렬하여 조회하세요:

- **예약 수 오름차순**
- 예약 수가 같으면 **진료과 코드 오름차순**

---

## ✅ 테이블 구조

| 컬럼명         | 타입        | 설명                        |
|----------------|-------------|-----------------------------|
| APNT_YMD       | TIMESTAMP   | 예약일자                    |
| APNT_NO        | NUMBER(5)   | 예약번호                    |
| PT_NO          | VARCHAR(10) | 환자번호                    |
| MCDP_CD        | VARCHAR(6)  | 진료과 코드                 |
| MDDR_ID        | VARCHAR(10) | 의사 ID                     |
| APNT_CNCL_YN   | VARCHAR(1)  | 예약 취소 여부(Y/N)         |
| APNT_CNCL_YMD  | DATE        | 예약 취소일자               |

---

## ✅ 정답 SQL

```sql
SELECT
  MCDP_CD AS "진료과코드",
  COUNT(*) AS "5월예약건수"
FROM APPOINTMENT
WHERE APNT_YMD BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY MCDP_CD
ORDER BY COUNT(*) ASC, MCDP_CD ASC;
```

---

## 💡 쿼리 해설

- `WHERE APNT_YMD BETWEEN '2022-05-01' AND '2022-05-31'`  
  → 5월 한 달 동안의 예약만 필터링

- `GROUP BY MCDP_CD`  
  → 진료과 코드 기준으로 집계

- `COUNT(*)`  
  → 각 진료과 코드별 예약 수 계산

- `ORDER BY COUNT(*) ASC, MCDP_CD ASC`  
  → 예약 수 기준 오름차순, 동일하면 코드 기준 오름차순 정렬

> `ORDER BY 2 ASC, 1 ASC`도 가능하나, 가독성 측면에서는 컬럼명을 명시하는 방식이 더 좋습니다.

---

## 💻 실행 결과 예시

| 진료과코드 | 5월예약건수 |
|------------|-------------|
| GS         | 2           |
| CS         | 3           |
| OS         | 5           |

---

## 🧠 학습 포인트

- `GROUP BY`와 `COUNT(*)`를 통한 집계 쿼리 작성
- 날짜 필터링: `BETWEEN '2022-05-01' AND '2022-05-31'`
- `ORDER BY`로 다중 정렬 기준 설정

---

## 🖼 실행 화면 캡처

![실행결과](./Screenshot.png)
