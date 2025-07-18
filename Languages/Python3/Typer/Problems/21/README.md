## 🧠 Problem
양의 정수 `x`가 하샤드 수라면 `x`의 자릿수의 합으로 `x`가 나누어져야 합니다.  
자연수 `x`를 입력받아 `x`가 하샤드 수인지 아닌지 검사하는 함수를 작성하세요.

### Constraints
- `x`는 1 이상, 10,000 이하인 정수입니다.

### Example
- Input: `10`
- Output: `True`

- Input: `11`
- Output: `False`

---

## 🐍 Python Reference Code

```python
def solution(x):
    digit_sum = sum(int(d) for d in str(x))
    return x % digit_sum == 0
```
---
---
