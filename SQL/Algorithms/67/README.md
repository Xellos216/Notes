## 🧠 Problem

`FIRST_HALF` 테이블과 `JULY` 테이블을 이용하여
7월 아이스크림 총 주문량과 상반기 아이스크림 총 주문량의 합을 구한 다음, 
총 주문량이 큰 순서대로 상위 3개의 맛을 조회하는 SQL을 작성하시오.

  - `FIRST_HALF` 테이블의 `SHIPMENT_ID`는 기본 키입니다.
  - `JULY` 테이블의 `SHIPMENT_ID`는 `FIRST_HALF` 테이블의 `SHIPMENT_ID`를 외래 키로 참조합니다.
  - 같은 맛의 아이스크림이라도 7월에는 다른 출하 번호(`SHIPMENT_ID`)를 가질 수 있습니다.

-----

## 💾 SQL Query

```sql
SELECT
    FLAVOR
FROM
    (SELECT
        FLAVOR,
        SUM(TOTAL_ORDER) AS TOTAL_SALES,
        RANK() OVER (ORDER BY SUM(TOTAL_ORDER) DESC) AS RNK
    FROM
        (SELECT FLAVOR, TOTAL_ORDER FROM FIRST_HALF
        UNION ALL
        SELECT FLAVOR, TOTAL_ORDER FROM JULY) AS CombinedOrders
    GROUP BY FLAVOR
    ) AS RankedFlavors
WHERE RNK <= 3
ORDER BY RNK ASC;
```

-----

## SQL Keywords 설명

### 🔹 `SELECT FLAVOR`

  - 최종적으로 아이스크림 맛(`FLAVOR`)만 출력합니다.

### 🔹 `UNION ALL`

  - `FIRST_HALF` 테이블과 `JULY` 테이블의 `FLAVOR`와 `TOTAL_ORDER` 데이터를 수직으로 결합하여 하나의 임시 테이블(`CombinedOrders`)을 만듭니다.
  - 이 문제는 `SHIPMENT_ID`가 상반기와 7월에 독립적으로 부여될 수 있고, 각 기간의 전체 판매량을 `FLAVOR` 기준으로 합산해야 하므로 `JOIN`보다 `UNION ALL`이 적합합니다.

### 🔹 `SUM(TOTAL_ORDER)`

  - `CombinedOrders` 테이블에서 각 맛(`FLAVOR`)별로 `TOTAL_ORDER`를 합산하여 전체 총 주문량을 계산합니다.

### 🔹 `GROUP BY FLAVOR`

  - `FLAVOR`별로 데이터를 그룹화하여 각 맛의 총 주문량을 계산할 수 있도록 합니다.

### 🔹 `RANK() OVER (ORDER BY SUM(TOTAL_ORDER) DESC) AS RNK`

  - 각 맛의 총 주문량(`SUM(TOTAL_ORDER)`)을 기준으로 내림차순으로 순위를 매깁니다.
  - `RNK`는 순위를 저장하는 컬럼의 별칭입니다. (`RANK`는 MySQL 예약어이므로 다른 별칭을 사용합니다.)

### 🔹 `WHERE RNK <= 3`

  - 계산된 순위(`RNK`)가 3 이하인, 즉 상위 3개의 맛만 필터링합니다.

### 🔹 `ORDER BY RNK ASC`

  - 최종 결과를 순위(`RNK`) 오름차순으로 정렬하여, 1위, 2위, 3위 순으로 출력합니다.

-----

## 문제 풀이 흐름 요약

  - **STEP 1: 데이터 통합**
      - `FIRST_HALF` 테이블의 `FLAVOR`와 `TOTAL_ORDER`를 선택합니다.
      - `JULY` 테이블의 `FLAVOR`와 `TOTAL_ORDER`를 선택합니다.
      - `UNION ALL`을 사용하여 이 두 결과를 하나의 `CombinedOrders` 테이블로 통합합니다.
  - **STEP 2: 맛별 총 주문량 계산 및 순위 부여**
      - `CombinedOrders` 테이블을 `FLAVOR`로 그룹화하여 각 맛의 `TOTAL_ORDER`를 합산합니다.
      - 합산된 `TOTAL_ORDER`를 기준으로 `RANK()` 함수를 사용하여 순위를 부여하고 `RNK`라는 별칭을 지정합니다.
  - **STEP 3: 상위 3개 맛 필터링 및 정렬**
      - `RNK`가 3 이하인 맛들만 선택합니다.
      - 최종 결과를 `RNK` 오름차순으로 정렬하여 출력합니다.
