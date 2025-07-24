# QA

### Q1. DBeaver에서 SQL 스크립트 창 글씨가 너무 작을 때, 어떻게 키울 수 있나요?

**A:**  
다음 경로를 통해 편집기 글꼴을 조정할 수 있습니다:

1. `Window > Preferences` 또는 `DBeaver > Preferences`로 이동
2. `General > Appearance > Colors and Fonts` 클릭
3. `DBeaver Fonts > Monospace font` 선택
4. 원하는 크기로 변경하고 저장

해당 폰트는 **SQL Editor, 결과창, 텍스트 편집기** 등 여러 영역에 적용됩니다.

---

### Q2. DBeaver에서 SQL 자동 들여쓰기(정렬) 단축키는?

**A:**  
SQL 코드 자동 정렬 단축키는 다음과 같습니다:

| 플랫폼 | 단축키 |
|--------|--------|
| Windows/Linux | `Ctrl + Shift + F` |
| macOS         | `Cmd + Shift + F` |

이 기능은 SQL 문법에 맞게 괄호, 들여쓰기, 줄바꿈 등을 자동 정렬해줍니다.  
일부 코드만 선택 후 실행하면 선택된 영역만 정렬됩니다.

**참고 설정 위치:**  
`Preferences > Editors > SQL Editor > SQL Formatting`

---

### Q3. WHERE에서 rating 조건을 안 쓰면 왜 에러가 나나요?

- `WHERE rating`만 쓰면 **불완전한 조건**이라 에러 발생
- `WHERE rating = 1` 같이 **비교 연산자**를 명확히 써야 함
- 또한 `GROUP BY AVG(price)`처럼 **집계함수는 그룹 기준이 될 수 없음**

**✅ 수정 예시**:
```sql
SELECT rating, AVG(price)
FROM food_orders
WHERE rating = 1
GROUP BY rating;
```

---

### Q4. 수량이 1인 주문의 음식 종류별 평균 가격 구하기

```sql
SELECT cuisine_type, quantity, AVG(price) AS avg_price
FROM food_orders
WHERE quantity = 1
GROUP BY cuisine_type
ORDER BY cuisine_type;
```

- `quantity = 1`이라면 GROUP BY 외의 컬럼도 문제 없음

---

### Q5. CASE문에서 에러가 나는 이유?

- 조건절 괄호 미완성
- 큰따옴표(`"`) 사용 → 문자열은 `'`로 감싸야 함

**✅ 수정 예시**:
```sql
CASE
  WHEN (age BETWEEN 10 AND 19 AND gender = 'male') THEN '10대 남성'
```

---

### Q6. 성별로 묶고 나이 오름차순 정렬하려면?

```sql
ORDER BY gender, age;
```

- `GROUP BY`는 묶어서 요약하고 `ORDER BY`는 정렬만 한다는 차이 이해

---

### Q7. GROUP BY를 쓰면 왜 데이터가 줄어드나요?

- `GROUP BY`는 **묶어서 하나로 요약**
- `ORDER BY`는 **데이터 전체 유지하며 정렬만**

---

### Q8. 성별은 내림차순, 나이는 오름차순 정렬?

```sql
ORDER BY gender DESC, age ASC;
```

---

### Q9. CASE문에서 문법 오류 발생한 이유

- `WHEN` 절 끝에 쉼표(,) 쓰면 안 됨
- 작은따옴표/괄호 누락 오류

**✅ 수정 예시**:
```sql
CASE
  WHEN delivery_time > 25 AND delivery_time <= 30 THEN ...
```

---

### Q10. 주소 기준 같은 지역끼리 정렬하려면?

```sql
ORDER BY SUBSTRING(addr, 1, 2), delivery_time;
```

---

### Q11. 배달 수수료가 같은 주문들의 건수를 구하려면?

```sql
SELECT 배달_수수료, COUNT(*) AS 주문_건수
FROM (
  SELECT IF(...) * IF(...) AS 배달_수수료
  FROM food_orders
) AS temp
GROUP BY 배달_수수료;
```

---

### Q12. 서브쿼리 alias에 '따옴표' 쓰면 안 되는 이유?

- `'배달 수수료'` → 문자열
- `배달_수수료` 또는 `AS \`배달 수수료\``처럼 써야 함

---

### Q13. `COUNT(*)`에서 `*`의 의미?

- `COUNT(*)`은 **존재하는 모든 행 수**
- `COUNT(column)`은 **NULL이 아닌 값만 셈**

---

### Q14. 언제 `'문자열'` vs `컬럼명`?

| 예시 | 의미 |
|------|------|
| `'서울'` | 문자열 리터럴 |
| `price` | 컬럼명 |
| `AS \`배달 수수료\`` | 공백 포함된 별칭 (MySQL은 백틱 사용) |

---

### Q15. 배달 지연 여부를 판단하는 조건 만들기

**문제 조건**:
- 주중: 25분 이상이면 '늦음'
- 주말: 30분 이상이면 '늦음'

**✅ 정답 예시**:
```sql
SELECT
  order_id AS '주문 번호',
  day_of_the_week AS '주문 시기',
  delivery_time AS '배달 시간',
  CASE
    WHEN day_of_the_week = 'Weekday' AND delivery_time >= 25 THEN '늦음'
    WHEN day_of_the_week = 'Weekend' AND delivery_time >= 30 THEN '늦음'
    ELSE '정상'
  END AS '지연 여부'
FROM food_orders;
```

---

### Q16. GROUP BY vs ORDER BY 개념 정리

### 차이점 요약

| 항목           | GROUP BY                          | ORDER BY                   |
|----------------|-----------------------------------|----------------------------|
| 목적           | 행을 그룹핑 (집계 목적)          | 결과 정렬                 |
| 주로 함께 쓰는 것 | COUNT, SUM, AVG 등 집계 함수     | ASC/DESC                  |
| 사용 위치       | SELECT 이후, ORDER BY 이전        | 쿼리 맨 마지막            |
| 결과 변화       | 행 수 줄어듦                      | 행 순서만 바뀜            |

### 확인용 문제
`food_orders` 테이블에서 각 음식점별 평균 주문 금액을 구하고, 그 결과를 평균 금액 높은 순으로 정렬하는 쿼리를 작성하시오.

---

### Q17. count(*)은 뭘 세는가? 그룹별 합계는?

### 개념
- `count(*)`: 그룹 내 **전체 행 수**
- 특정 컬럼을 기준으로 집계하려면:  
  - `count(distinct restaurant_name)`
  - `sum(quantity)`

### 예시 쿼리
```sql
select cuisine_type,
       count(distinct restaurant_name) as num_of_restaurants,
       sum(quantity) as total_quantity
from food_orders
group by cuisine_type;
```

---

### Q18. case + group + substr로 수수료율 계산 쿼리 검수

### 문제점
- 외부 SELECT에서 서브쿼리 alias 컬럼명 오타 있음
  - `addr` → `ad`
  - `count_ad` → 실제 컬럼명과 불일치

### 수정된 쿼리
```sql
select
    ad,
    total_quantity,
    count_ad,
    case
        when count_ad >= 5 and total_quantity >= 30 then 0.005
        when count_ad >= 5 and total_quantity <  30 then 0.008
        when count_ad <  5 and total_quantity >= 30 then 0.01
        when count_ad <  5 and total_quantity <  30 then 0.02
    end as rate
from (
    select substr(addr, 1, 2) as ad,
           sum(quantity) as total_quantity,
           count(distinct restaurant_name) as count_ad
    from food_orders
    group by ad
) a;
```

---

### Q19. JOIN 쓸 때 ORDER BY 안 되는 이유?

- `;` 세미콜론이 **중간에 잘못 들어감**
- `;`는 쿼리 종료를 의미하므로, 이후 `order by`는 **두 번째 쿼리로 인식되어 문법 오류 발생**

✅ 수정 쿼리:
```sql
select ...
from food_orders a
left join customers b on a.customer_id = b.customer_id
order by b.age asc;
```

---

### Q20. 세미콜론 `;` 꼭 써야 하나요?

### 요약
| 상황 | `;` 필요 여부 |
|------|----------------|
| 쿼리 하나 실행 | ❌ 생략 가능 |
| 여러 쿼리 실행 또는 스크립트 | ✅ 필수 |

- 한 줄짜리 실행에는 생략 가능하지만,
- 습관적으로 붙여두는 것이 **스크립트화 시 안전**

---

### Q21. DISTINCT의 역할은?

- 결과에서 **중복된 행 전체(row)** 를 제거
- `DISTINCT name` → 이름이 같은 행만 제거가 아니라, **전체 컬럼 조합이 중복**일 때만 제거됨

---

### Q22. 왜 메인 쿼리에서는 `f.price` 안 써도 되는가?

- 서브쿼리에서 만든 컬럼은 **별칭 테이블(a)의 컬럼**
- 메인 쿼리에서는 그 컬럼을 그냥 `price`, `sale`처럼 사용할 수 있음 (필요 시 `a.price`도 가능)

---

### Q23. 식당별 평균 주문 금액과 평균 연령을 기반으로 Segmentation 하기

### 조건
- 평균 금액 기준:  
  `<= 5천`, `<=1만`, `<=3만`, `초과`
- 평균 나이 기준:  
  `20대 이하`, `30대`, `40대`, `50대 이상`

### 정답 쿼리
```sql
select *
from (
  select
    restaurant_name,
    case 
      when price <= 5000 then 'price_5000'
      when price <= 10000 then 'price_10000'
      when price <= 30000 then 'price_30000'
      else 'price_over'
    end as price_group,
    case 
      when age < 30 then 'age_20'
      when age between 30 and 39 then 'age_30'
      when age between 40 and 49 then 'age_40'
      else 'age_50'
    end as age_group
  from (
    select
      f.restaurant_name,
      avg(f.price) as price,
      avg(c.age) as age
    from food_orders f
    inner join customers c on f.customer_id = c.customer_id
    group by f.restaurant_name
  ) a
) final
where age_group is not null
order by restaurant_name;
```

---

### Q24. `if(rating <> 'Not given', rating, null)`에서 `<>`는 뭐예요?
- `<>`는 SQL에서 '같지 않다'는 비교 연산자입니다. (`!=`와 동일한 의미)
- 즉, `rating`이 `'Not given'`이 **아닌 경우에만** 해당 값을 그대로 사용하고, 그렇지 않으면 `null`로 처리하여 평균에서 제외합니다.
```sql
avg(if(rating <> 'Not given', rating, null))
```

---

### Q25. `coalesce(b.age, 20)`는 어떤 용도인가요?
- `COALESCE()` 함수는 **NULL 값을 다른 기본값으로 대체**해주는 함수입니다.
- 위 예시에서는 `b.age`가 NULL이면 20으로 대체합니다.
```sql
coalesce(b.age, 20) AS "null 제거"
```
- 실무에서는 평균 계산이나 필터링 시 NULL로 인한 왜곡을 방지하기 위해 자주 사용합니다.

---

### Q26. `IF`와 `CASE WHEN`은 어떻게 다르나요?
- `IF(조건, 참일 때, 거짓일 때)`는 MySQL 전용의 간단한 조건문입니다.
- `CASE WHEN`은 SQL 표준 문법이며, 여러 조건을 처리할 수 있어 범용성과 가독성이 좋습니다.

예시 비교:
```sql
-- IF
IF(age >= 20, '성인', '미성년')

-- CASE WHEN
CASE 
  WHEN age < 13 THEN '어린이'
  WHEN age < 20 THEN '청소년'
  ELSE '성인'
END
```

---

### Q27. `count(1)`은 정확히 어떤 걸 세나요?
- `count(1)`은 해당 그룹에 **존재하는 모든 행의 개수**를 셉니다.
- `1`은 그냥 고정 상수로, 실제 어떤 컬럼 값을 세는 건 아닙니다.
- `count(*)`와 거의 동일하지만, `count(column)`과는 다릅니다 (`NULL` 제외 여부 차이).

---

### Q28. `GROUP BY`를 지우면 왜 1행만 나올까요?
- `GROUP BY`를 하지 않으면 모든 데이터가 하나의 그룹으로 간주됩니다.
- 따라서 `COUNT()` 같은 집계함수는 전체 행을 대상으로 한 번만 계산되어 **1행만 출력**됩니다.

---

### Q29. `MAX(IF(...))`에서 `MAX`는 왜 필요한가요?
- `IF(age = 10, cnt, 0)`은 해당 조건을 만족하는 값만 남깁니다.
- 하지만 `GROUP BY cuisine_type` 후에도 `age` 값이 여러 개 존재할 수 있으므로,
  - 조건에 맞는 **값 1개만 출력하려면 반드시 집계함수 `MAX()`를 감싸야** 합니다.
- 이 구조는 **Pivot View를 만들 때 표준처럼 사용**됩니다.

---

### Q30. `count(1)`이 셀렉트문에서 어떤 역할을 하나요?
- `GROUP BY gender, age_group`으로 그룹이 나뉘었을 때,
- `count(1)`은 **그 그룹에 속한 모든 행의 수**를 세는 것입니다.
- `1`은 그냥 "행 존재"를 의미하며, 컬럼 값을 직접 세는 게 아닙니다.

---

### Q31. `GROUP BY`와 `COUNT()`는 항상 같이 써야 하나요?
- `GROUP BY` 없이도 `COUNT()`는 사용할 수 있습니다.
```sql
SELECT COUNT(*) FROM orders;
```
- 이건 전체 행 수를 집계하며 1행만 나옵니다.
- 반대로 그룹별로 집계하려면 반드시 `GROUP BY`가 필요합니다.

---

### Q32. Pivot 쿼리 해석: `MAX(IF(gender = 'male', cnt_order, 0))`는 무슨 의미인가요?
- "현재 그룹 안에서 gender가 'male'이면 cnt_order 값을 가져오고, 아니면 0으로 대체한 다음,
  해당 값들 중 **최댓값 하나만 출력하라**는 의미입니다."
- 피벗 테이블에서 **행을 열로 변환**할 때 자주 사용하는 구문입니다.

---

### Q33. 음식 타입 × 연령대 Pivot View는 어떻게 만드나요?
- 내부 쿼리에서 `cuisine_type + age`로 주문건수를 집계하고,
- 외부 쿼리에서 각 age 구간별로 `IF(age = 10, cnt, 0)` 조건으로 나누고 `MAX()`로 열로 펼칩니다.

핵심 구조:
```sql
SELECT cuisine_type,
  MAX(IF(age=10, cnt, 0)) AS "10대",
  MAX(IF(age=20, cnt, 0)) AS "20대",
  ...
FROM (SELECT ...) t
GROUP BY cuisine_type
```

---

### Q34. 숙제 쿼리에서 `MAX`는 정확히 왜 필요한가요?
- `GROUP BY cuisine_type` 이후에도 내부적으로는 여러 `age` 값이 존재함
- `IF(age=10, cnt, 0)`은 조건에 해당하는 행을 여러 개 만들 수 있음
- **그래서 `MAX()`로 해당 그룹 내 값 중 하나만 가져와 열(Column)에 고정하는 것**

---