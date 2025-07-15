# 13_SumOfDigits

## 🧠 Problem
자연수 `N`이 주어질 때, `N`의 각 자리수의 합을 구해서 return 하는 `solution` 함수를 만들어 주세요.

### Example
- N = 123 → 1 + 2 + 3 = 6
- N = 987 → 9 + 8 + 7 = 24

### Constraints
- N의 범위: 1 경우 ~ 100,000,000 이하의 자연수

### Example
| N   | answer |
|-----|--------|
| 123 | 6      |
| 987 | 24     |

---

## 🐍 Python Reference Code

```python
# 수학적 방법
def solution(n):
    answer = 0
    while n > 0:
        answer += n % 10  # 가지 마지의 자리 더하기
        n //= 10          # 가지 마지 자리 제거
    return answer

# 문자열 처리
def solution(n):
    answer = 0
    for digit in str(n):
        answer += int(digit)
    return answer
```



