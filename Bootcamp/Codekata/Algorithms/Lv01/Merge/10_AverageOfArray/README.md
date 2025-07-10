# 배열의 평균값

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

## ✅ 요약

| 언어     | 특징 요약 |
|----------|-----------|
| Python   | `sum()` 없이 직접 누적 후 평균 계산 |
| Java     | `double` 누적 변수 활용 |

---

