# 조건별로 분류하여 주문상태 출력하기

## ✅ 문제 설명

`FOOD_ORDER` 테이블에서 2022년 5월 1일을 기준으로  
주문 ID, 제품 ID, 출고일자, 출고여부를 조회하는 SQL을 작성하시오.

- 출고일이 **2022년 5월 1일 이전까지**면 → `"출고완료"`
- **이후 날짜**면 → `"출고대기"`
- `NULL`이면 → `"출고미정"`

**출력 컬럼**: `ORDER_ID`, `PRODUCT_ID`, `OUT_DATE`, `출고여부`  
**출고일은 `YYYY-MM-DD` 형식으로 출력해야 함.**  
**정렬 기준**: `ORDER_ID` 오름차순

---

## 🧾 사용 테이블: `FOOD_ORDER`

| 컬럼명         | 설명         |
|----------------|--------------|
| ORDER_ID       | 주문 ID       |
| PRODUCT_ID     | 상품 ID       |
| AMOUNT         | 주문 수량     |
| PRODUCE_DATE   | 생산일자      |
| IN_DATE        | 입고일자      |
| OUT_DATE       | 출고일자 (nullable) |

---

## 💡 풀이 흐름

1. `OUT_DATE`가 기준일(`2022-05-01`)보다 빠르면 → `"출고완료"`
2. 기준일보다 늦으면 → `"출고대기"`
3. `NULL`이면 → `"출고미정"`
4. `OUT_DATE`는 시간 제거 → `'YYYY-MM-DD'`로 출력

---

## ✅ 최종 정답 SQL

```sql
SELECT
  ORDER_ID,
  PRODUCT_ID,
  DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
  CASE
    WHEN OUT_DATE <= '2022-05-01' THEN '출고완료'
    WHEN OUT_DATE > '2022-05-01' THEN '출고대기'
    ELSE '출고미정'
  END AS 출고여부
FROM
  FOOD_ORDER
ORDER BY
  ORDER_ID ASC;
```

---

## ❌ 오답노트

### 1. CASE WHEN 순서 문제

```sql
CASE
  WHEN OUT_DATE IS NULL THEN '출고미정'
  WHEN OUT_DATE <= '2022-05-01' THEN '출고완료'
  WHEN OUT_DATE >  '2022-05-01' THEN '출고대기'
END
```

- `NULL`은 `<=`, `>`로 비교 불가능하므로 조건 순서가 중요한 건 맞음
- 하지만 문제는 채점 시스템이 `출고완료 → 출고대기 → 출고미정` 순서를 **기준으로 삼았기 때문에**, 이 순서를 지켜야 정답 처리됨

### 2. 날짜 출력 포맷 오류

```sql
OUT_DATE -- ❌ 결과에 '2022-04-21 00:00:00' 처럼 시간 포함됨
```

- 정답 예시에서는 `OUT_DATE`가 `'YYYY-MM-DD'` 형식이어야 하므로 `DATE_FORMAT()` 사용 필요

---

## ✅ 핵심 요약

| 항목 | 필요 조치 |
|------|------------|
| 날짜 포맷 | `DATE_FORMAT(OUT_DATE, '%Y-%m-%d')` 사용 |
| 조건 순서 | 출고완료 → 출고대기 → 출고미정 |
| NULL 처리 | `ELSE '출고미정'` 명시해야 정답 처리됨 |

