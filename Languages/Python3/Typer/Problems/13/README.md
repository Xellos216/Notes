## 🧠 Problem
자연수 `n`이 주어지면, `n`의 각 자릿수를 더한 값을 반환하는 함수를 작성하시오.

### Constraints
- `n`은 100,000,000 이하의 자연수

### Example
- Input: `n = 123`
- Output: `6`  
  (1 + 2 + 3 = 6)

- Input: `n = 987`
- Output: `24`  
  (9 + 8 + 7 = 24)

---

## 🐍 Python Reference Code

```python
def solution(n):
    answer = 0
    while n > 0:
        answer += n % 10
        n //= 10
    return answer
```
