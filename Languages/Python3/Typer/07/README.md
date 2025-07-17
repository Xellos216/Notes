# 07_DivideMultiply

## 🧠 Problem
정수 `num1`과 `num2`가 주어질 때, 
`num1`을 `num2`로 나눈 값에 **1000을 곱한 후 정수 부분**만 반환하는 함수를 작성하시오.

### Example
- Input: `num1 = 3`, `num2 = 2` → Output: `1500` 
- Input: `num1 = 7`, `num2 = 3` → Output: `2333` 
- Input: `num1 = 1`, `num2 = 16` → Output: `62` 

---

## 🐍 Python Reference Code

```python
def solution(num1, num2):
    answer = float(num1) / num2 * 1000
    return int(answer)
```


