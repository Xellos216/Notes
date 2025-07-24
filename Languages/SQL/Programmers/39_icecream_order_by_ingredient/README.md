# 성분으로 구분한 아이스크림 총 주문량

## ✅ 문제 설명

상반기 동안 각 아이스크림 **성분 유형(INGREDIENT_TYPE)** 별 총 주문량(`TOTAL_ORDER`)을 계산하시오.

- 두 테이블: `FIRST_HALF`, `ICECREAM_INFO`
- `FLAVOR` 기준으로 JOIN
- 성분 유형(INGREDIENT_TYPE)별로 `SUM(TOTAL_ORDER)` 집계
- 결과는 **총 주문량 오름차순** 정렬
- 컬럼명은 `INGREDIENT_TYPE`, `TOTAL_ORDER`

---

## 🧾 사용 테이블

### 📘 FIRST_HALF

| 컬럼명       | 설명             |
|--------------|------------------|
| SHIPMENT_ID  | 출하 ID          |
| FLAVOR       | 아이스크림 맛     |
| TOTAL_ORDER  | 총 주문 수량      |

### 📘 ICECREAM_INFO

| 컬럼명         | 설명                |
|----------------|---------------------|
| FLAVOR         | 아이스크림 맛        |
| INGREDIENT_TYPE| 성분 유형 (fruit/sugar 등) |

---

## 💡 풀이 흐름

1. `FIRST_HALF`와 `ICECREAM_INFO`를 `FLAVOR` 기준으로 `JOIN`
2. `INGREDIENT_TYPE` 기준으로 `GROUP BY`
3. `SUM(TOTAL_ORDER)`로 집계
4. `ORDER BY TOTAL_ORDER ASC`로 정렬

---

## ✅ 정답 SQL

```sql
SELECT
  I.INGREDIENT_TYPE,
  SUM(F.TOTAL_ORDER) AS TOTAL_ORDER
FROM
  FIRST_HALF AS F
  LEFT JOIN ICECREAM_INFO AS I ON F.FLAVOR = I.FLAVOR
GROUP BY
  I.INGREDIENT_TYPE
ORDER BY
  TOTAL_ORDER ASC;
```

---

## ✅ 실행 예시

| INGREDIENT_TYPE | TOTAL_ORDER |
|------------------|-------------|
| fruit_based      | 5550        |
| sugar_based      | 13400       |

---

## ❌ 주의할 점

- `GROUP BY 1` 또는 `ORDER BY 2` 방식은 정답 처리되나, 가독성과 명확성 위해 **컬럼명을 명시하는 것이 좋음**
- `LEFT JOIN` 또는 `INNER JOIN` 모두 가능하지만, 문제에서는 모든 매칭 가능한 flavor만 존재하므로 `LEFT JOIN` 사용해도 무방

---

## 📌 정리

- `SUM()`과 `GROUP BY`는 항상 세트
- `ORDER BY` 기준 컬럼이 `SELECT`된 컬럼명과 일치해야 함
