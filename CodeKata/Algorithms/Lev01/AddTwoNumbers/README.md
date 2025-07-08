# ✅ CodeKata Day 01 - 두 수의 합 구하기

## 🧠 문제 설명
정수 `num1`과 `num2`가 주어질 때, `num1 + num2`의 값을 반환하는 함수를 작성하시오.

> 예시  
> - 입력: `num1 = 2`, `num2 = 3` → 출력: `5`  
> - 입력: `num1 = 100`, `num2 = 2` → 출력: `102`  

---

## 🐍 Python 풀이

```python
def solution(num1, num2):
    answer = num1 + num2
    return answer
```

---

## 🧱 C 풀이

```c
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int num1, int num2) {
    int answer = num1 + num2;
    return answer;
}
```

---

## ☕ Java 풀이

```java
class Solution {
    public int solution(int num1, int num2) {
        int answer = num1 + num2;
        return answer;
    }
}
```

---

## 🦘 Kotlin 풀이

```kotlin
class Solution {
    fun solution(num1: Int, num2: Int): Int {
        var answer: Int = num1 + num2
        return answer
    }
}
```

---

## ✅ 요약

| 언어     | 특징 요약 |
|----------|-----------|
| Python   | 한 줄로 간단하게 작성 가능 |
| C        | 타입 명시 필요, 구조 간단 |
| Java     | 클래스 및 메서드 구조 명확 |
| Kotlin   | 변수 타입 명시와 구조 간결함 |

---

## 📸 실행 결과

- `python3.png`, `C.png`, `JAVA.png`, `Kotlin.png` 참고
