
# 🔍 PRIMARY KEY vs FOREIGN KEY in ICECREAM 테이블 관계

## ✅ 1. 기본키 (Primary Key)

- **정의**: 테이블에서 각 행(row)을 **유일하게 식별**하기 위한 컬럼.
- **조건**: 중복 불가, NULL 불가.

**문제 예시:**
- `FIRST_HALF.FLAVOR`: 출하 정보 테이블의 기본키
- `ICECREAM_INFO.FLAVOR`: 성분 정보 테이블의 기본키

---

## ✅ 2. 외래키 (Foreign Key)

- **정의**: 다른 테이블의 기본키를 참조하여 두 테이블을 연결하는 키.
- **역할**: 테이블 간 관계 설정, 데이터 무결성 유지.

**문제 예시:**
- `ICECREAM_INFO.FLAVOR` → `FIRST_HALF.FLAVOR` 를 참조하는 외래키

→ 성분 정보(`ICECREAM_INFO`)의 FLAVOR 값은 반드시 출하 이력(`FIRST_HALF`)에 존재해야 함

---

## ✅ 3. 이 조건이 중요한 이유

| 이유 | 설명 |
|------|------|
| 조인 조건 | 두 테이블을 `FLAVOR` 기준으로 연결할 수 있음 |
| 무결성 보장 | `ICECREAM_INFO`는 항상 유효한 출하 맛만 포함 |
| 중복 방지 | `FLAVOR`가 각 테이블의 기본키이므로, `JOIN` 시 중복 없음 (1:1 관계) |

---

## ✅ 4. INNER JOIN을 하라는 뜻인가?

**직접적인 강제는 아님.**  
그러나 대부분의 쿼리 목적상 `INNER JOIN`이 자연스럽습니다.

### 🔸 구조 정리

- `ICECREAM_INFO.FLAVOR`는 외래키 → 반드시 `FIRST_HALF`에 존재
- 반대로, `FIRST_HALF`에 있는 `FLAVOR`가 `ICECREAM_INFO`에 **없을 수도 있음**

---

## ✅ 5. 상황별 JOIN 선택 가이드

| 상황 | 추천 JOIN | 이유 |
|------|-----------|------|
| 출하된 맛에 대한 성분 정보만 조회 | `INNER JOIN` | 출하 + 성분 모두 존재하는 행만 |
| 성분 기준으로 출하 정보 조회 | `INNER JOIN` | 성분이 있는 맛에 대해 출하 내역 조회 |
| 출하된 전체 맛을 기준으로 성분 포함 여부 확인 | `LEFT JOIN` | 성분 없는 맛도 NULL로 확인 가능 |

---

## ✅ 요약 비교표

| 용어 | 의미 | 이 문제에서의 예시 |
|------|------|-------------------|
| 기본키 | 각 테이블의 고유 식별자 | `FLAVOR` |
| 외래키 | 다른 테이블의 기본키 참조 | `ICECREAM_INFO.FLAVOR → FIRST_HALF.FLAVOR` |
| 조인 조건 | 테이블 간 연결 기준 | `ON FIRST_HALF.FLAVOR = ICECREAM_INFO.FLAVOR` |

