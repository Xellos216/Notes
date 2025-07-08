# 12 - 이름에 el이 들어가는 개 찾기 (LIKE + COLLATE)

> CodeKata / SQL / Day01 / DogNameContainsEl

## 📌 문제 설명

할머니가 기르던 개의 이름에 **'el'이 들어간다**고 합니다.  
보호소에 들어온 동물 중에서,

- **동물 종류가 'Dog'**이며,
- **이름(NAME)에 'el'이 들어가는 동물**

의 `ANIMAL_ID`, `NAME`을 조회하세요.  
단, **대소문자는 구분하지 않으며**, 결과는 **이름 오름차순 정렬**로 출력합니다.

---

## ✅ 테이블 구조

| Column name       | Type         | Nullable |
|-------------------|--------------|----------|
| ANIMAL_ID         | VARCHAR(N)   | FALSE    |
| ANIMAL_TYPE       | VARCHAR(N)   | FALSE    |
| DATETIME          | DATETIME     | FALSE    |
| INTAKE_CONDITION  | VARCHAR(N)   | FALSE    |
| NAME              | VARCHAR(N)   | TRUE     |
| SEX_UPON_INTAKE   | VARCHAR(N)   | FALSE    |

---

## ✅ 정답 쿼리

```sql
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'Dog'
  AND NAME LIKE '%el%' COLLATE utf8_general_ci
ORDER BY NAME;
```

---

## 💬 COLLATE utf8_general_ci란?

- `COLLATE`는 **문자열 비교 시 사용하는 정렬 방식(대소문자 민감도 포함)** 을 정의합니다.
- `utf8_general_ci`는 다음과 같은 의미입니다:
  - `utf8`: UTF-8 문자 인코딩
  - `general`: 일반적인 언어 기준 정렬
  - `ci`: **Case Insensitive (대소문자 구분 안 함)**

> → `'Elijah'`, `'maxwELl'`, `'sHELly'` 등도 모두 `LIKE '%el%'`에 **매칭됨**

---

## 💻 실행 결과 예시

| ANIMAL_ID | NAME      |
|-----------|-----------|
| A355753   | Elijah    |
| A382192   | Maxwell 2 |

---

## 🧠 학습 포인트

- `LIKE '%문자열%'` 조건으로 부분 문자열 필터링
- MySQL의 기본 `LIKE`는 **대소문자 구분** → `COLLATE`로 해결
- `ORDER BY`는 문제 요구사항에 맞게 항상 확인 필요

---

## 🖼 실행 화면 캡처

![실행결과](./Screenshot.png)
