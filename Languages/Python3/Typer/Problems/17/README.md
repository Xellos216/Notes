## 🧠 Problem
자연수 `n`을 뒤집어 각 자릿수를 원소로 가지는 배열 형태로 반환하는 함수를 작성하시오.

### Constraints
- `n`은 10,000,000,000 이하의 자연수

### Example
- Input: `n = 12345`
- Output: `[5, 4, 3, 2, 1]`

---

## 🐍 Python Reference Code

```python
def solution(n):
    return [int(digit) for digit in str(n)][::-1]
```
