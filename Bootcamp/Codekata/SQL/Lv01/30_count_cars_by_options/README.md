# 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기

> CodeKata / SQL / Lv01 / Count_Cars_By_Options

## 📌 문제 설명

`CAR_RENTAL_COMPANY_CAR` 테이블에는 렌터카 회사의 자동차 정보가 저장되어 있습니다.  
이 중 자동차 옵션(`OPTIONS`)에 아래 **3가지 중 하나 이상**이 포함된 경우:

- 통풍시트
- 열선시트
- 가족시트

이 조건을 만족하는 자동차를 **종류별(CAR_TYPE)** 로 나누어 몇 대인지(`CARS`) 출력하는 SQL을 작성하세요.  
결과는 **자동차 종류 오름차순**으로 정렬합니다.

---

## ✅ 테이블 구조

| 컬럼명     | 타입          | NULL 허용 | 설명            |
|------------|---------------|------------|-----------------|
| CAR_ID     | INTEGER       | FALSE      | 차량 ID         |
| CAR_TYPE   | VARCHAR(255)  | FALSE      | 차량 종류       |
| DAILY_FEE  | INTEGER       | FALSE      | 일일 요금       |
| OPTIONS    | VARCHAR(255)  | FALSE      | 옵션 (','로 구분된 문자열) |

---

## ✅ 정답 SQL

```sql
SELECT
  CAR_TYPE,
  COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%통풍시트%'
   OR OPTIONS LIKE '%열선시트%'
   OR OPTIONS LIKE '%가족시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE ASC;
```

---

## 💡 쿼리 해설

- `OPTIONS LIKE '%키워드%'`는 문자열 안에 특정 키워드가 포함되어 있는지를 검사
- `OR` 조건으로 여러 키워드 중 하나라도 포함된 경우를 필터링
- `GROUP BY CAR_TYPE`으로 종류별 개수를 구함
- `ORDER BY CAR_TYPE ASC`로 알파벳순 정렬

---

## 🚫 오답 노트: 잘못된 첫 번째 시도

```sql
WHERE
  OPTIONS LIKE "%시트%"
```

### ❌ 문제점

- `%시트%`는 `"통풍시트", "열선시트", "가족시트"` **모두를 포함하는** 문자열을 찾는 것이 아님
- `'시트'`라는 공통 키워드가 포함된 다른 옵션까지 걸릴 수 있어 **정확하지 않음**
- 문제에서 요구한 건 **명확하게 3가지 키워드 중 하나라도 포함된 경우** → 각각 `LIKE` 해야 함

---

## 💻 실행 결과 예시

| CAR_TYPE | CARS |
|----------|------|
| SUV      | 3    |
| 리무진   | 1    |
| 세단     | 4    |
| 트럭     | 3    |

---

## 🧠 학습 포인트

- 문자열 리스트 안에서 **정확한 키워드** 필터링은 각각 `LIKE '%키워드%'`로 처리
- `OR` 조건을 조합하여 "하나라도 포함" 조건 구현
- `GROUP BY + COUNT(*)` 구조로 집계 쿼리 작성

---

## 🖼 실행 화면 캡처

![실행결과](./Screenshot.png)
