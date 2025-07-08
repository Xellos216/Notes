# ✅ CodeKata Day 01 - 배열의 평균값

## 🧠 문제 설명
정수 배열 `numbers`가 주어질 때,  
배열 `numbers`의 원소 **평균값**을 반환하는 함수를 작성하시오.

> 예시  
> - 입력: `numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]` → 출력: `5.5`  
> - 입력: `numbers = [89, 90, 91, ..., 99]` → 출력: `94.0`  

---

## 🐍 Python 풀이

```python
def solution(numbers):
    answer = 0
    for i in numbers:
        answer += i
    return answer / len(numbers)
```

---

## 🧱 C 풀이

```c
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// numbers_len은 배열 numbers의 길이입니다.
double solution(int numbers[], size_t numbers_len) {
    int sum = 0;
    for (int i = 0; i < numbers_len; i++) {
        sum += numbers[i];
    }
    double answer = (double)sum / numbers_len;
    return answer;
}
```

---

## ☕ Java 풀이

```java
class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            answer += numbers[i];
        }
        return answer / numbers.length;
    }
}
```

---

## 🦘 Kotlin 풀이

```kotlin
class Solution {
    fun solution(numbers: IntArray): Double {
        var answer: Double = 0.0
        for (i in 0 until numbers.size) {
            answer += numbers[i]
        }
        return answer / numbers.size
    }
}
```

---

## ✅ 요약

| 언어     | 특징 요약 |
|----------|-----------|
| Python   | `sum()` 없이 직접 누적 후 평균 계산 |
| C        | `int` 누적 후 `double`로 캐스팅 필요 |
| Java     | `double` 누적 변수 활용 |
| Kotlin   | `Double` 타입 변수 명시적으로 선언 |

---

## 📸 실행 결과

- `python3.png`, `C.png`, `Java.png`, `Kotlin.png` 참고
