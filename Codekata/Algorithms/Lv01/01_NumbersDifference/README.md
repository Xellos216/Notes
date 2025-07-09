# ✅ CodeKata Day 01 - 두 수의 차 구하기

## 🧠 문제 설명
정수 `num1`과 `num2`가 주어질 때, `num1`에서 `num2`를 뺀 값을 반환하는 함수를 작성하시오.

> 예시  
> - 입력: `num1 = 2`, `num2 = 3` → 출력: `-1`  
> - 입력: `num1 = 100`, `num2 = 2` → 출력: `98`  

---

## 🐍 Python 풀이

```python
def solution(num1, num2):
    return num1 - num2
```

---

## 🧱 C 풀이

```c
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int num1, int num2) {
    int answer = num1 - num2;
    return answer;
}

int main() {
    printf("%d\n", solution(2, 3));    // 출력: -1
    printf("%d\n", solution(100, 2));  // 출력: 98
    return 0;
}
```

---

## ☕ Java 풀이

```java
class Solution {
    public int solution(int num1, int num2) {
        return num1 - num2;
    }
}
```

---

## ✅ 요약

| 언어   | 특징 요약 |
|--------|-----------|
| Python | 가장 간결, 테스트 출력도 쉬움 |
| C      | `printf`, `main()` 필요, 타입 명시 |
| Java   | 클래스 기반 구조 필수, `Solution` 클래스만 제출 |

