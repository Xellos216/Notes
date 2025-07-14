# 약수의 합 (SumOfDivisors)

## 📈 문제 설명
정수 `n`을 입력받아 `n`의 약수를 모두 더하는 값을 return하는 함수 `solution`을 구해보세요.

### 제한 사항
- `n` 은 0 이상 30,000이하의 정수입니다.

### 입력 예시
| n  | return |
|----|--------|
| 12 | 28     |
| 5  | 6      |

#### 설명
- 12의 약수: 1, 2, 3, 4, 6, 12 → 모두 더하면 28
- 5의 약수: 1, 5 → 모두 더하면 6

---

## 🦍 Python

```python
def solution(n):
    answer = 0
    for i in range(1, n + 1):
        if n % i == 0:
            answer += i
    return answer
```


