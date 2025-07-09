# 평균 구하기 (GetAverage)

## 📈 문제 설명
정수를 담고 있는 배열 `arr`의 평균값을 `return`하는 함수를 작성하세요.

### 제한 사항
- `arr`은 길이 1 이상, 100 이하의 배열입니다.
- `arr`의 원소는 -10,000 이상 10,000 이하의 정수입니다.

### 입력 예시
| arr       | return |
|-----------|--------|
| [1,2,3,4] | 2.5    |
| [5,5]     | 5      |

---

## 🦍 Python

```python
def solution(arr):
    return sum(arr) / len(arr)
```

---

## 🧱 C

```c
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// arr_len은 배열 arr의 길이입니다.
double solution(int arr[], size_t arr_len) {
    int sum = 0;
    for (size_t i = 0; i < arr_len; i++) {
        sum += arr[i];
    }
    return (double)sum / arr_len;
}
```

---

## ☕ Java

```java
class Solution {
    public double solution(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double)sum / arr.length;
    }
}
```

---

## 🧊 Kotlin

```kotlin
class Solution {
    fun solution(arr: IntArray): Double {
        var sum = 0
        for (i in arr.indices) {
            sum += arr[i]
        }
        return sum.toDouble() / arr.size
    }
}
```

---

## 📊 요조 비교표

| 언어    | 모드폼 계산 | 소수 평균 계산        | 복합 방식 |
|---------|------------------|--------------------------|----------------|
| Python  | sum / len        | 기본 함수로 계산     | 간단면 초시 |
| C       | for + arr[i]     | (double)을 착용한 평균차 | size_t, 유형 명시화 필요 |
| Java    | for + arr[i]     | 식에서 (double) 검증        | 귀름 필요 |
| Kotlin  | for-in + arr[i]  | toDouble()으로 변환         | 그래봄적당 |

---

