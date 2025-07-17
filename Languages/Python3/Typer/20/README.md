# 20_SortDigitsDesc

## 🧠 Problem
함수 `solution`은 정수 `n`을 매개변수로 입력받습니다.
`n`의 각 자릿수를 **큰 것부터 작은 순서로 정렬**한 새로운 정수를 리턴해주세요.

### Example
`n = 118372` 일 경우 `873211`이 반환되어야 합니다.

### Constraints
- `n`은 1 이상 8,000,000,000 이하인 자연수입니다.

---

## 🐍 Python Reference Code

```python
def solution(n):
    return int(''.join(sorted(str(n), reverse=True)))
```


