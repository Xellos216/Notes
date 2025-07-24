# 네비게이션 옵션 포함 차량 리스트 조회

## 🧾 문제 설명
자동차 대여 회사의 차량 옵션 정보가 담긴 `CAR_RENTAL_COMPANY_CAR` 테이블에서, 옵션 목록(`OPTIONS`)에 **'네비게이션'** 키워드가 포함된 차량을 조회하는 문제입니다.

- 각 행은 차량 하나를 나타냅니다.
- 옵션 목록은 콤마(`,`)로 구분된 문자열입니다. 예: `"열선시트,네비게이션,후방카메라"`
- '네비게이션'이라는 키워드가 포함된 차량만 조회하며, 차량 ID(CAR_ID)를 기준으로 내림차순 정렬합니다.

---

## 📊 테이블 구조

### CAR_RENTAL_COMPANY_CAR

| Column Name | Type         | Nullable | Description              |
|-------------|--------------|----------|--------------------------|
| CAR_ID      | INTEGER      | FALSE    | 차량 ID (기본키)         |
| CAR_TYPE    | VARCHAR(255) | FALSE    | 차량 종류                |
| DAILY_FEE   | INTEGER      | FALSE    | 일일 대여 요금           |
| OPTIONS     | VARCHAR(255) | FALSE    | 옵션 리스트 (콤마 구분)  |

---

## ✅ 풀이 SQL

```sql
SELECT *
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%네비게이션%'
ORDER BY CAR_ID DESC;
```

---

## 💡 핵심 개념: LIKE와 포함 조건

- `LIKE '%네비게이션%'` : 문자열 안에 **'네비게이션'이 포함된 경우** 참입니다.
- `%`는 와일드카드로, 임의의 길이의 문자들을 의미합니다.
- 예:  
  - `'네비게이션,후방카메라'` → 매칭  
  - `'열선시트,네비게이션'` → 매칭  
  - `'스마트키'` → 매칭 안 됨

---

## 🧪 출력 예시

| CAR_ID | CAR_TYPE | DAILY_FEE | OPTIONS           |
|--------|----------|-----------|-------------------|
| 13     | 승합차   | 144000    | 네비게이션        |

