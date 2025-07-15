# 19_SquareRootJudge

## 🧠 Problem
임의의 양의 정수 `n`에 대해, `n`이 어떤 양의 정수 `x`의 제곱인지 아닌지 판단하려 합니다.  
`n`이 양의 정수 `x`의 제곱이라면 `(x+1)^2`를 반환하고, 그렇지 않다면 `-1`을 반환하는 함수를 완성하세요.

### Constraints
- `n`은 1 이상, 50000000000000 이하인 양의 정수입니다.

### Example
| n   | return |
|-----|--------|
| 121 | 144    |
| 3   | -1     |

### Exaplanation
- 입력값 예 #1: 121은 양의 정수 11의 제곱이므로, (11+1)^2 = 144 반환
- 입력값 예 #2: 3은 양의 정수의 제곱이 아니므로, -1 반환

---

## 🐍 Python Reference Code
```python
def solution(n):
    x = n ** 0.5  # 제곱근
    if x.is_integer():  # 정수인지 판별
        return int((x + 1) ** 2)
    else:
        return -1```


