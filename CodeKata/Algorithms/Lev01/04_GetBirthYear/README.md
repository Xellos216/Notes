# ✅ CodeKata Day 01 - 나이로 출생연도 구하기

## 🧠 문제 설명
머쓱이는 선생님의 출생연도가 궁금합니다. 2022년 기준 선생님의 나이 `age`가 주어질 때,  
한국식 나이 계산법에 따라 선생님의 **출생 연도**를 반환하는 함수를 작성하시오.

> 조건  
> - 한국식 나이: 태어난 해부터 1살로 계산, 해가 바뀔 때마다 1살씩 증가  
> - 기준 연도는 항상 2022년

> 예시  
> - 입력: `age = 40` → 출력: `1983`  
> - 입력: `age = 23` → 출력: `2000`  

---

## 🐍 Python 풀이

```python
def solution(age):
    answer = 2022 - (age - 1)
    return answer
```

---

## 🧱 C 풀이

```c
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int age) {
    int answer = 2022 - (age - 1);
    return answer;
}
```

---

## ☕ Java 풀이

```java
class Solution {
    public int solution(int age) {
        int answer = 2022 - (age - 1);
        return answer;
    }
}
```

---

## 🦘 Kotlin 풀이

```kotlin
class Solution {
    fun solution(age: Int): Int {
        var answer: Int = 2022 - (age - 1)
        return answer
    }
}
```

---

## ✅ 요약

| 언어     | 특징 요약 |
|----------|-----------|
| Python   | 가장 간단한 구조, 수식 그대로 적용 |
| C        | 정수 수식 사용, 별도 타입 선언 필요 |
| Java     | 클래스 구조 필요, 메서드 정의 명확 |
| Kotlin   | Java와 유사, 타입 명시와 변수 선언 강조 |

---

## 📸 실행 결과

- `python3.png`, `C.png`, `JAVA.png`, `Kotlin.png` 참고
