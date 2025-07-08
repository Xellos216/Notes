# ✅ CodeKata Day 01 - 숫자 비교하기

## 🧠 문제 설명
정수 `num1`과 `num2`가 주어질 때, 두 수가 **같으면 1**, 다르면 **-1**을 반환하는 함수를 작성하시오.

> 예시  
> - 입력: `num1 = 2`, `num2 = 3` → 출력: `-1`  
> - 입력: `num1 = 11`, `num2 = 11` → 출력: `1`  
> - 입력: `num1 = 7`, `num2 = 99` → 출력: `-1`  

---

## 🐍 Python 풀이

```python
def solution(num1, num2):
    if num1 == num2:
        answer = 1
    else:
        answer = -1
    return answer
```

---

## 🧱 C 풀이

```c
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int num1, int num2) {
    int answer;
    if(num1 == num2) {
        answer = 1;
    } else {
        answer = -1;
    }
    return answer;
}
```

---

## ☕ Java 풀이

```java
class Solution {
    public int solution(int num1, int num2) {
        int answer;
        if (num1 == num2) {
            answer = 1;
        } else {
            answer = -1;
        }
        return answer;
    }
}
```

---

## 🦘 Kotlin 풀이

```kotlin
class Solution {
    fun solution(num1: Int, num2: Int): Int {
        return if (num1 == num2) 1 else -1
    }
}
```

---

## ✅ 요약

| 언어     | 특징 요약 |
|----------|-----------|
| Python   | 조건문 구조 간단, `==` 연산자 사용 |
| C        | `if-else` 구조, 명시적 변수 선언 |
| Java     | 클래스 구조 필수, `if-else` 명확 작성 |
| Kotlin   | `if-else` 한 줄로 반환 가능 |

---

## 📸 실행 결과

- `python3.png`, `C.png`, `JAVA.png`, `Kotlin.png` 참고
