# 진료 예약 내역 조회 (취소되지 않은 홍보외과 - 2022-04-13)

## ✅ 문제 요약
- 테이블: `PATIENT`, `DOCTOR`, `APPOINTMENT`
- 조건:
  - 진료과코드(MCDP_CD)가 `'CS'` (홍보외과)
  - 예약일(APNT_YMD)이 `'2022-04-13'`
  - 예약이 취소되지 않음 (APNT_CNCL_YN = 'N')
- 출력 컬럼: 진료예약번호(APNT_NO), 환자이름(PT_NAME), 환자번호(PT_NO), 진료과코드(MCDP_CD), 의사이름(DR_NAME), 예약일시(APNT_YMD)
- 정렬 기준: 예약일시(APNT_YMD) 오름차순

---

## 🧩 사용 테이블 및 주요 컬럼

### PATIENT
| Column    | 설명       |
|-----------|------------|
| PT_NO     | 환자번호   |
| PT_NAME   | 환자이름   |

### DOCTOR
| Column    | 설명       |
|-----------|------------|
| DR_ID     | 의사ID     |
| DR_NAME   | 의사이름   |
| MCDP_CD   | 진료과코드 |

### APPOINTMENT
| Column       | 설명           |
|--------------|----------------|
| APNT_NO      | 진료예약번호   |
| PT_NO        | 환자번호       |
| MCDP_CD      | 진료과코드     |
| MDDR_ID      | 의사ID         |
| APNT_YMD     | 예약일시       |
| APNT_CNCL_YN | 예약취소 여부  |

---

## ✅ 풀이 SQL

```sql
SELECT
    A.APNT_NO,
    P.PT_NAME,
    P.PT_NO,
    A.MCDP_CD,
    D.DR_NAME,
    A.APNT_YMD
FROM APPOINTMENT A
JOIN PATIENT P ON A.PT_NO = P.PT_NO
JOIN DOCTOR D ON A.MDDR_ID = D.DR_ID
WHERE A.APNT_YMD LIKE '2022-04-13%'
  AND A.APNT_CNCL_YN = 'N'
  AND A.MCDP_CD = 'CS'
ORDER BY A.APNT_YMD ASC;
```

---

## ✅ 결과 예시

| APNT_NO | PT_NAME  | PT_NO       | MCDP_CD | DR_NAME | APNT_YMD                  |
|---------|----------|-------------|---------|---------|---------------------------|
| 46      | 오스왈드 | PT22000043  | CS      | 루피    | 2022-04-13 09:00:00.000000 |
| 42      | 문문     | PT22000071  | CS      | 루피    | 2022-04-13 12:30:00.000000 |
| 43      | 바라     | PT22000019  | CS      | 니모    | 2022-04-13 15:30:00.000000 |
