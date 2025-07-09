# ✅ CodeKata Day 01 - 두 수의 나눗셈

## 🧠 문제 설명
정수 `num1`과 `num2`가 주어질 때,  
`num1`을 `num2`로 나눈 값에 **1000을 곱한 후 정수 부분**만 반환하는 함수를 작성하시오.

> 예시  
> - 입력: `num1 = 3`, `num2 = 2` → 출력: `1500`  
> - 입력: `num1 = 7`, `num2 = 3` → 출력: `2333`  
> - 입력: `num1 = 1`, `num2 = 16` → 출력: `62`  

---

## 🐍 Python 풀이

```python
def solution(num1, num2):
    answer = float(num1) / num2 * 1000
    return int(answer)
```

---

## 🧱 C 풀이

```c
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int num1, int num2) {
    double answer = (double) num1 / num2 * 1000;
    return answer;
}
```

---

## ☕ Java 풀이

```java
class Solution {
    public int solution(int num1, int num2) {
        double answer = (double)num1 / num2 * 1000;
        return (int)answer;
    }
}
```

---

## 🦘 Kotlin 풀이

```kotlin
class Solution {
    fun solution(num1: Int, num2: Int): Int {
        var answer = num1.toDouble() / num2 * 1000
        return answer.toInt()
    }
}
```

---

## ✅ 요약

| 언어     | 특징 요약 |
|----------|-----------|
| Python   | `float()` + `int()` 변환으로 쉽게 처리 |
| C        | `double` 캐스팅 후 정수 반환 |
| Java     | 명시적 캐스팅 `(double)` 후 `(int)`로 반환 |
| Kotlin   | `toDouble()` / `toInt()`로 명확한 변환 |

---

## 📸 실행 결과

- `python3.png`, `C.png`, `Java.png`, `Kotlin.png` 참고
