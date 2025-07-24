# 과일로 만든 아이스크림 고르기

## 📝 문제 설명

다음은 아이스크림 가게의 상반기 주문 정보를 담은 `FIRST_HALF` 테이블과 아이스크림 성분에 대한 정보를 담은 `ICECREAM_INFO` 테이블입니다.

- `FIRST_HALF` 테이블:
  - `SHIPMENT_ID`: 출하 번호
  - `FLAVOR`: 아이스크림 맛
  - `TOTAL_ORDER`: 상반기 총 주문량

- `ICECREAM_INFO` 테이블:
  - `FLAVOR`: 아이스크림 맛 (기본키)
  - `INGREDIENT_TYPE`: 성분 유형 (`sugar_based`, `fruit_based`)

---

## 🎯 목표

상반기 아이스크림 총주문량이 **3,000보다 높으면서**, 성분이 **`fruit_based` (과일)** 인 아이스크림 맛을 조회하세요. 결과는 **총주문량 내림차순**으로 정렬하세요.

---

## ✅ 정답 SQL

```sql
SELECT
    H.FLAVOR
FROM
    FIRST_HALF H
    LEFT JOIN ICECREAM_INFO I ON H.FLAVOR = I.FLAVOR
WHERE
    H.TOTAL_ORDER > 3000
    AND I.INGREDIENT_TYPE = 'fruit_based';
```

---

## 🧪 실행 결과 예시

| FLAVOR     |
|------------|
| strawberry |

---

## 🔍 해설

- `LEFT JOIN`을 통해 아이스크림 맛별로 성분 정보를 결합
- `H.TOTAL_ORDER > 3000` 조건으로 주문량 필터링
- `I.INGREDIENT_TYPE = 'fruit_based'`로 과일 기반 성분 선택
- 맛(`FLAVOR`) 컬럼만 결과로 출력

---

## 📌 Tip

이 문제는 실무에서 **JOIN 후 WHERE로 필터링**하는 상황에서 자주 출제되는 패턴입니다. `LEFT JOIN`과 조건절의 순서, 의미 구분에 익숙해지는 데 유용합니다.