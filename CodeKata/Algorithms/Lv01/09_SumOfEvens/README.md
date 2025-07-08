# ✅ CodeKata Day 01 - 짝수의 합

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

## 🧱 C 풀이

```c
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    for (int i = 1; i <= n; i++) {
        if (i % 2 == 0) {
            answer += i;
        }
    }
    return answer;
}
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

## 🦘 Kotlin 풀이

```kotlin
class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        for(i in 2..n step 2){
            answer += i
        }
        return answer
    }
}
```

---

## ✅ 요약

| 언어     | 특징 요약 |
|----------|-----------|
| Python   | `range(start, end, step)` 문법으로 짝수 순회 |
| C        | `if (i % 2 == 0)`으로 짝수 판단 |
| Java     | `i += 2`로 짝수만 순회하여 효율적 |
| Kotlin   | `for (i in 2..n step 2)`로 명확한 짝수 순회 |

---

## 📸 실행 결과

- `python3.png`, `C.png`, `Java.png`, `Kotlin.png` 참고
