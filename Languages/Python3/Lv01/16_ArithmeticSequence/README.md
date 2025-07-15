# 16_ArithmeticSequence

## 🧠 Problem
함수 `solution`은 정수 `x`와 자연수 `n`을 입력 받아, `x`로 시작해 `x`씩 증가하는 수자들을 `n`개 포함한 리스트를 `return`해야 합니다.

### Constraints
- `x` : -10000000 이상, 10000000 이하의 정수
- `n` : 1000 이하의 자연수

### Example
| x  | n | answer           |
|----|---|------------------|
| 2  | 5 | [2, 4, 6, 8, 10]  |
| 4  | 3 | [4, 8, 12]       |
| -4 | 2 | [-4, -8]         |

---

## 🐍 Python Reference Code
```python
def solution(x, n):
    return [x * i for i in range(1, n + 1)]
```


