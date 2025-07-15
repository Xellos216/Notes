# 12_GetAverage

## 🧠 Problem
정수를 담고 있는 배열 `arr`의 평균값을 `return`하는 함수를 작성하세요.

### Constraints
- `arr`은 길이 1 이상, 100 이하의 배열입니다.
- `arr`의 원소는 -10,000 이상 10,000 이하의 정수입니다.

### Example
| arr       | return |
|-----------|--------|
| [1,2,3,4] | 2.5    |
| [5,5]     | 5      |

---

## 🐍 Python Reference Code

```python
def solution(arr):
    return sum(arr) / len(arr)
```


