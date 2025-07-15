# 09_SumOfEvens

## 🧠 Problem
정수 `n`이 주어질 때, `n` 이하의 **짝수**를 모두 더한 값을 반환하는 함수를 작성하시오.

### Example 
- Input: `n = 10` → Output: `30` (2 + 4 + 6 + 8 + 10) 
- Input: `n = 4` → Output: `6` (2 + 4)

---

## 🐍 Python Reference Code

```python
def solution(n):
    answer = 0
    for i in range(2, n + 1, 2):
        answer += i
    return answer
```


