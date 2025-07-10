# x 만큼 간격이 있는 n개의 수자 (ArithmeticSequence)

## 📈 문제 설명

함수 `solution`은 정수 `x`와 자연수 `n`을 입력 받아, `x`로 시작해 `x`씩 증가하는 수자들을 `n`개 포함한 리스트를 `return`해야 합니다.

### 제한 조건
- `x` : -10000000 이상, 10000000 이하의 정수
- `n` : 1000 이하의 자연수

### 입력 예시

| x  | n | answer           |
|----|---|------------------|
| 2  | 5 | [2, 4, 6, 8, 10]  |
| 4  | 3 | [4, 8, 12]       |
| -4 | 2 | [-4, -8]         |

---

## 🦍 Python

```python
def solution(x, n):
    return [x * i for i in range(1, n + 1)]
```

---

## ☕ Java

```java
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (long)x * (i + 1);
        }
        return answer;
    }
}
```

---

## 📊 요조 비교표

| 언어    | 계산 방식            | 반복수 사용     | 특징                     |
|---------|---------------------------|-------------------|------------------------------|
| Python  | list comprehension       | range(1, n+1)     | 일반적인 구조        |
| Java    | long[] 배열          | for loop          | 유형 확장 필요         |

---

