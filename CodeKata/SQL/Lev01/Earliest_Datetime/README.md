# 🐬 SQL Day08 - 보호소에 가장 먼저 들어온 시간

## 📌 문제 설명

`ANIMAL_INS` 테이블에서 **가장 먼저 보호소에 들어온 동물의 DATETIME**을 조회하세요.  
단, 결과는 한 건만 출력되어야 하며 가장 오래된 시간이 출력되어야 합니다.

---

## ✅ 테이블 구조 (ANIMAL_INS)

| 컬럼명           | 타입        | NULL 허용 |
|------------------|-------------|------------|
| ANIMAL_ID        | VARCHAR(N)  | ❌ |
| ANIMAL_TYPE      | VARCHAR(N)  | ❌ |
| DATETIME         | DATETIME    | ❌ |
| INTAKE_CONDITION | VARCHAR(N)  | ❌ |
| NAME             | VARCHAR(N)  | ✅ |
| SEX_UPON_INTAKE  | VARCHAR(N)  | ❌ |

---

## ✅ 정답 쿼리

```sql
SELECT DATETIME
FROM ANIMAL_INS
ORDER BY DATETIME ASC
LIMIT 1;
```

---

## 🧪 실행 예시 (출력 형태)

| DATETIME           |
|--------------------|
| 2013-10-14 15:38:00 |

---

## 📝 요약 포인트

- `ORDER BY DATETIME ASC`를 통해 오래된 시간 순으로 정렬
- `LIMIT 1`로 가장 먼저 들어온 한 행만 선택
- 조건이 없으므로 `WHERE` 절은 사용하지 않음

---

## ✅ 참고 사항

- `ORDER BY 1`도 가능하긴 하지만 가독성 측면에서 컬럼명을 명시하는 것이 좋음
