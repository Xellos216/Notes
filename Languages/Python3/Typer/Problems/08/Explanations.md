## Syntax

## 🔹 사용된 문법 설명

### 🔹 조건문 `if-elif`
- 특정 값의 범위나 조건에 따라 분기 처리
- 예:
```python
if 0 < angle < 90:
    return 1
elif angle == 90:
    return 2
```

### 🔹 논리 비교 연산자 `<`, `==`
- `<` : 작은 경우
- `==` : 같은 경우
- 복합 조건도 가능: `0 < angle < 90`

---

## 🔍 예시

```python
angle = 70
# 0 < 70 < 90 → 예각 → return 1

angle = 91
# 90 < 91 < 180 → 둔각 → return 3

angle = 180
# angle == 180 → 평각 → return 4
```
