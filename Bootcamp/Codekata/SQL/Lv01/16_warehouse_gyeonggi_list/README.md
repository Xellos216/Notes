# 경기도에 위치한 식품창고 목록 출력하기

> CodeKata / SQL / Lv01 / Warehouse_Gyeonggi_List

## 📌 문제 설명

`FOOD_WAREHOUSE` 테이블에는 전국 각지의 식품창고 정보가 저장되어 있습니다.  
이 중 **경기도에 위치한 창고**만 골라, 다음 컬럼들을 출력하는 SQL문을 작성하세요.

- `WAREHOUSE_ID`
- `WAREHOUSE_NAME`
- `ADDRESS`
- `FREEZER_YN`: NULL인 경우 'N'으로 대체

결과는 `WAREHOUSE_ID` 오름차순으로 정렬하세요.

---

## ✅ 테이블 구조

| 컬럼명          | 타입         | NULL 허용 |
|-----------------|--------------|------------|
| WAREHOUSE_ID    | VARCHAR      | FALSE      |
| WAREHOUSE_NAME  | VARCHAR      | FALSE      |
| ADDRESS         | VARCHAR      | FALSE      |
| TLNO            | VARCHAR      | TRUE       |
| FREEZER_YN      | VARCHAR(1)   | TRUE       |

---

## ✅ 정답 SQL

```sql
SELECT
  WAREHOUSE_ID,
  WAREHOUSE_NAME,
  ADDRESS,
  IFNULL(FREEZER_YN, 'N') AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE WAREHOUSE_NAME LIKE '%_경기%'
ORDER BY 1 ASC;
```

---

## 💡 쿼리 해설

- `WAREHOUSE_NAME LIKE '%_경기%'`  
  → 창고명에 `'경기'`가 포함된 창고만 필터링  
  → `_`는 언더바 포함 여부를 구분하기 위해 사용된 예시

- `IFNULL(FREEZER_YN, 'N')`  
  → 냉동창고 여부가 NULL인 경우 'N'으로 처리

- `ORDER BY 1 ASC`  
  → 첫 번째 컬럼(=WAREHOUSE_ID) 기준 오름차순 정렬

---

## 💻 실행 결과 예시

| WAREHOUSE_ID | WAREHOUSE_NAME | ADDRESS                             | FREEZER_YN |
|--------------|----------------|-------------------------------------|------------|
| WH0001       | 창고_경기1     | 경기도 안산시 상록구 용담로 141     | Y          |
| WH0003       | 창고_경기2     | 경기도 이천시 마장면 덕평로 811     | N          |
| WH0004       | 창고_경기3     | 경기도 김포시 대곶면 율생중앙로205번길 | N        |

---

## 🧠 학습 포인트

- `LIKE` 구문을 통한 문자열 필터링
- `IFNULL()`로 NULL 처리
- `ORDER BY`로 정렬 기준 지정

---

## 🖼 실행 화면 캡처

![실행결과](./Screenshot.png)
