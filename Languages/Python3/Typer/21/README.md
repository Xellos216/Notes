# 21_HarshadNumber

## 🧠 Problem
양의 정수 `x`가 하샤드 수이려면 `x`의 자릿수의 합으로 `x`가 나누어져야 합니다.  
예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어떨어지므로 하샤드 수입니다.  
자연수 `x`를 입력받아 `x`가 하샤드 수인지 아닌지 검사하는 함수를 작성하시오.

### Example
- Input: `x = 18` → Output: `True`
- Input: `x = 11` → Output: `False`

---

## 🐍 Python Reference Code
```python
A2
def solution(x):
    digit_sum = sum(int(d) for d in str(x))
    return x % digit_sum == 0

A2
def solution(x):
    digit_sum = sum(int(d) for d in str(x))

    if x % digit_sum == 0:
        return True
    else:
        return False
```
