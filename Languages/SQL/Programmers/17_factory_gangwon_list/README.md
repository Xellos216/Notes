# 강원도에 위치한 생산공장 목록 출력하기

> CodeKata / SQL / Lv01 / Factory_Gangwon_List

## 📌 문제 설명

`FOOD_FACTORY` 테이블에서 **강원도에 위치한 식품공장**의  
- 공장 ID (`FACTORY_ID`)
- 공장 이름 (`FACTORY_NAME`)
- 주소 (`ADDRESS`)

를 조회하는 SQL문을 작성하세요.  
결과는 **공장 ID 오름차순**으로 정렬되어야 합니다.

---

## ✅ 테이블 구조

| 컬럼명        | 타입     | NULL 허용 |
|---------------|----------|------------|
| FACTORY_ID    | VARCHAR  | FALSE      |
| FACTORY_NAME  | VARCHAR  | FALSE      |
| ADDRESS       | VARCHAR  | FALSE      |
| TLNO          | VARCHAR  | TRUE       |

---

## ✅ 정답 SQL

```sql
SELECT
  FACTORY_ID,
  FACTORY_NAME,
  ADDRESS
FROM FOOD_FACTORY
WHERE ADDRESS LIKE '강원도%'
ORDER BY 1 ASC;
```

---

## 💡 쿼리 해설

- `ADDRESS LIKE '강원도%'`  
  → 주소가 '강원도'로 시작하는 공장만 필터링

- `ORDER BY 1 ASC`  
  → 첫 번째 컬럼(FACTORY_ID) 기준 오름차순 정렬

---

## 💻 실행 결과 예시

| FACTORY_ID | FACTORY_NAME | ADDRESS                               |
|------------|--------------|----------------------------------------|
| FT19980003 | (주)맛있는라면 | 강원도 정선군 남면 칠현로 679           |
| FT20100003 | (주)맛있는음료 | 강원도 원주시 문막읍 문막공단길 154      |
| FT20100004 | (주)맛있는국   | 강원도 평창군 봉평면 진조길 227-35       |

---

## 🧠 학습 포인트

- `LIKE '강원도%'`로 시작 문자열 조건 설정
- `ORDER BY`와 컬럼 순서 숫자 사용 (`ORDER BY 1`)
- `WHERE` 절 필터링 기준의 명확한 사용

---

## 🖼 실행 화면 캡처

![실행결과](./Screenshot.png)
