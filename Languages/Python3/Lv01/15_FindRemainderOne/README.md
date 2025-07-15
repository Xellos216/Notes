# 15_FindRemainderOne

## 🧠 Problem

자연수 `n`이 주어집니다.
`n`을 어떤 자연수 `x`로 나누었을 때 **나머지가 1이 되는 가장 작은 x**를 찾아 반환하세요.
해는 항상 존재합니다.

---

### Constraints
- 3 ≤ n ≤ 1,000,000

---

### Example

| n  | result |
|----|--------|
| 10 | 3      |
| 12 | 11     |

#### Explanation
- `10 % 3 = 1` → 3보다 작은 수 중 조건을 만족하는 수 없음 → **3 반환**
- `12 % 11 = 1` → 11보다 작은 수 중 조건을 만족하는 수 없음 → **11 반환**

---

## 🐍 Python Reference Code

```python
def solution(n):
    for x in range(2, n):
        if n % x == 1:
            return x
```


