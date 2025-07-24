# 🍽️ 즐겨찾기가 가장 많은 식당 정보 조회하기

## 📘 문제 설명

`REST_INFO` 테이블에서 **음식 종류별로 즐겨찾기 수가 가장 많은 식당의 정보**를 조회하세요.  
- 출력: `FOOD_TYPE`, `REST_ID`, `REST_NAME`, `FAVORITES`  
- 음식 종류(`FOOD_TYPE`)를 기준으로 내림차순 정렬합니다.

---

## 🧾 테이블 구조: REST_INFO

| Column       | Type        | Description         |
|--------------|-------------|---------------------|
| REST_ID      | VARCHAR(5)  | 식당 고유 ID         |
| REST_NAME    | VARCHAR(50) | 식당 이름            |
| FOOD_TYPE    | VARCHAR(20) | 음식 종류            |
| VIEWS        | NUMBER      | 조회 수              |
| FAVORITES    | NUMBER      | 즐겨찾기 수          |
| PARKING_LOT  | VARCHAR(1)  | 주차장 유무           |
| ADDRESS      | VARCHAR(100)| 주소                |
| TEL          | VARCHAR(100)| 전화번호             |

---

## ✅ 잘못된 풀이 예시 (오답)

```sql
SELECT
  FOOD_TYPE,
  REST_ID,
  REST_NAME,
  MAX(FAVORITES) AS FAVORITES
FROM REST_INFO
GROUP BY FOOD_TYPE;
```

### ❌ 왜 오답인가?

- `MAX(FAVORITES)`는 맞지만, `REST_ID`, `REST_NAME`은 **그 최대값에 해당하는 행에서 가져온 것이 아님**
- MySQL의 비표준 허용으로 "그룹 내 아무 행"에서 끌어온 것
- 정확한 매칭이 보장되지 않음 → 논리 오류

---

## ✅ 정답 방법 1: 서브쿼리 + (FOOD_TYPE, MAX)

```sql
SELECT *
FROM REST_INFO
WHERE (FOOD_TYPE, FAVORITES) IN (
    SELECT FOOD_TYPE, MAX(FAVORITES)
    FROM REST_INFO
    GROUP BY FOOD_TYPE
)
ORDER BY FOOD_TYPE DESC;
```

- **장점**: 비교적 간단
- **단점**: 즐겨찾기 수가 같은 식당이 여러 개면 **모두 나옴**

---

## ✅ 정답 방법 2: `ROW_NUMBER()` 윈도우 함수 이용 (MySQL 8.0 이상)

```sql
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM (
    SELECT *,
           ROW_NUMBER() OVER (
               PARTITION BY FOOD_TYPE
               ORDER BY FAVORITES DESC
           ) AS RN
    FROM REST_INFO
) AS ranked
WHERE RN = 1
ORDER BY FOOD_TYPE DESC;
```

### 🧠 핵심 설명

| 요소 | 의미 |
|------|------|
| `PARTITION BY FOOD_TYPE` | 음식 종류별로 그룹을 나눔 |
| `ORDER BY FAVORITES DESC` | 각 그룹 내에서 즐겨찾기 수 기준으로 내림차순 정렬 |
| `ROW_NUMBER()` | 정렬된 순서대로 1, 2, 3... 순번을 매김 |
| `WHERE RN = 1` | 각 음식 종류별로 **가장 즐겨찾기 수가 높은 식당 1개**만 선택 |

이 방법은 **중복 없이 정확히 1개**씩 추출하므로, **그룹별 최대값 1개 레코드** 추출에 최적화된 방식입니다.

---

## 🧪 예시 결과

| FOOD_TYPE | REST_ID | REST_NAME   | FAVORITES |
|-----------|---------|-------------|-----------|
| 한식      | 00001   | 은돼지식당  | 734       |
| 일식      | 00002   | 하이가쯔네  | 230       |
| 분식      | 00008   | 애플우스    | 151       |
| 양식      | 00003   | 따띠따띠뜨  | 102       |
| 중식      | 00015   | 만정        | 20        |

---

## 🔍 요약

| 방식         | 정확도 | 중복제거 | 설명 |
|--------------|--------|-----------|------|
| GROUP BY + MAX | ❌ 낮음 | 불완전    | 비표준 동작 발생 가능 |
| 서브쿼리 + IN | ✅ 보통 | ❌ 일부 중복 가능 | 간단하지만 중복 가능 |
| ROW_NUMBER() | ✅ 높음 | ✅ 완벽 | **정답에 가장 적합** |

