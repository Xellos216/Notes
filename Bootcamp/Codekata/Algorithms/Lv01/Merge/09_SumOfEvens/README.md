# 짝수의 합

## 🧠 문제 설명
정수 `n`이 주어질 때, `n` 이하의 **짝수**를 모두 더한 값을 반환하는 함수를 작성하시오.

> 예시  
> - 입력: `n = 10` → 출력: `30` (2 + 4 + 6 + 8 + 10)  
> - 입력: `n = 4` → 출력: `6` (2 + 4)

---

## 🐍 Python 풀이

```python
def solution(n):
    answer = 0
    for i in range(2, n + 1, 2):
        answer += i
    return answer
```

---

## ☕ Java 풀이

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i += 2) {
            answer += i;
        }
        return answer;
    }
}
```

---

## ✅ 요약

| 언어     | 특징 요약 |
|----------|-----------|
| Python   | `range(start, end, step)` 문법으로 짝수 순회 |
| Java     | `i += 2`로 짝수만 순회하여 효율적 |

---

