## 🧠 Problem
두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수를 작성하세요.

### Constraints
- a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
- a와 b는 -10,000,000 이상 10,000,000 이하의 정수입니다.
- a와 b의 대소관계는 정해져있지 않습니다.

### Example
- Input: a = 3, b = 5
- Output: 12

---

## 🐍 Python Reference Code

```python
def solution(a, b):
    start = min(a, b)
    end = max(a, b)
    answer = 0
    for i in range(start, end + 1):
        answer += i
    return answer
```

---
---
