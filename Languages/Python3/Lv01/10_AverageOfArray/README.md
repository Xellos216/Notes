# 10_AverageOfArray

## 🧠 Problem
정수 배열 `numbers`가 주어질 때, 
배열 `numbers`의 원소 **평균값**을 반환하는 함수를 작성하시오.

### Example 
- Input: `numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]` → Output: `5.5` 
- Input: `numbers = [89, 90, 91, ..., 99]` → Output: `94.0` 

---

## 🐍 Python Reference Code

```python
def solution(numbers):
    answer = 0
    for i in numbers:
        answer += i
    return answer / len(numbers)
```


