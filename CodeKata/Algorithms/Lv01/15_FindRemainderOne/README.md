# 남아지가 1이 되는 수 찾기 (FindRemainderOne)

## 📈 문제 설명
자연수 `n`이 주어진다. `n`을 `x`로 나누는 남아지가 1이 되도록 하는 가장 자귀한 자연수 `x`를 찾아 `return` 하는 함수를 구해보세요.
판정은 호심하게 여유로 존재합니다.

### 제한 사항
- 3 ≤ n ≤ 1,000,000

### 입력 예시
| n  | result |
|----|--------|
| 10 | 3      |
| 12 | 11     |

#### 설명
- 10 % 3 = 1, 3보다 자귀한 수에서 조건 마저한 3을 return
- 12 % 11 = 1, 11을 return

---

## 🦍 Python

```python
def solution(n):
    for x in range(2, n):
        if n % x == 1:
            return x
```

---

## 🧱 C

```c
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    for (int x = 2; x < n; x++) {
        if (n % x == 1) {
            return x;
        }
    }
}
```

---

## ☕ Java

```java
class Solution {
    public int solution(int n) {
        for (int x = 2; x < n; x++) {
            if (n % x == 1) {
                return x;
            }
        }
        return -1;
    }
}
```

---

## 🧊 Kotlin

```kotlin
class Solution {
    fun solution(n: Int): Int {
        for (x in 2 until n) {
            if (n % x == 1) {
                return x
            }
        }
        return -1
    }
}
```

---

## 📊 요조 비교표

| 언어    | 남아지 계산       | 남아지가 1인 x  x \uud1b5과 | 비고 |
|---------|------------------|---------------------------|------|
| Python  | range(2, n)      | if n % x == 1            | 간단면, 저장존불 |
| C       | for x=2 to n     | if (n % x == 1)          | 단일 return 가능 |
| Java    | for x=2 to n     | if (n % x == 1)          | 빨리 바꾸기 위해 -1 return 필요 |
| Kotlin  | for (x in 2 until n) | if (n % x == 1)      | 매우 간단면 구조 |

---

