## 🧠 Problem
1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될 때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다.

작업은 다음과 같습니다:

1. 입력된 수가 짝수라면 2로 나눈다.
2. 입력된 수가 홀수라면 3을 곱하고 1을 더한다.
3. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복한다.

단, 입력 수가 1일 경우 0을 리턴하며, 작업을 500번 반복할 때까지 1이 되지 않으면 -1을 리턴합니다.

### Constraints
- 입력된 수 `num`은 1 이상 8,000,000 미만인 자연수입니다.

### Example
- Input: `6`
- Output: `8`

- Input: `16`
- Output: `4`

- Input: `626331`
- Output: `-1`

---

## 🐍 Python Reference Code

```python
def solution(num):
    for i in range(500):
        if num == 1:
            return i
        if num % 2 == 0:
            num = num // 2
        else:
            num = num * 3 + 1
    return -1
```

