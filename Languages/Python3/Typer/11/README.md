# 11_EvenOrOdd

## 🧠 Problem
정수 `num`이 짧수일 경우 `"Even"`을 반환하고, 혹수인 경우 `"Odd"`를 반환하는 함수를 작성하세요.

### Constraitns
- `num`은 int 범위의 정수입니다.
- `0`은 짧수입니다.

### Example
|-----|--------|
| num | return |
| 3   | "Odd"  |
| 4   | "Even" |

---

## 🐍 Python Reference Code

```python
def solution(num):
    if num % 2 == 0:
        answer = 'Even'
    elif num % 2 != 0:
        answer = 'Odd'
    return answer
```


