# 17_ReverseDigitsArray

## 🧠 Problem

자연수 `n`을 뒤집어 각 자리 수자를 원소로 가지는 배열 형태로 `return`하세요.

예를 들어 `n = 12345`이면 `[5,4,3,2,1]`을 `return`해야 합니다.

### Constraints
- `n`은 10,000,000,000 이하의 자연수

### Example
| n      | return         |
|--------|----------------|
| 12345  | [5,4,3,2,1]     |

---

## 🐍 Python Reference Code
```python
def solution(n):
    return [int(digit) for digit in str(n)][::-1]
```

