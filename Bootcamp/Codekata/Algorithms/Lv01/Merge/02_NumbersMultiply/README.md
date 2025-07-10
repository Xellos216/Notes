# MultiplyTwoNumbers

두 정수 `num1`, `num2`가 주어졌을 때, 두 수의 곱을 반환하는 문제입니다.\
언어별 기본 문법을 활용하여 동일한 문제를 구현해보는 입문용 문제입니다.

---

## ✅ Problem

- 두 개의 정수 `num1`, `num2`가 주어진다.
- `num1 * num2`의 결과를 반환하는 `solution()` 함수를 작성하라.

### 제한사항

- 0 ≤ num1 ≤ 100
- 0 ≤ num2 ≤ 100

---

## 💡 Solution Logic

가장 단순한 형태의 산술 연산 문제이며, `return num1 * num2;` 형태로 바로 반환 가능합니다.\
**입출량 처리 방식은 언어별 문법에 따라 다르기 때문에** 이를 비교하는 데 활용할 수 있습니다.

---

## 🐍 Python

```python
def solution(num1, num2):
    return num1 * num2

print(solution(3, 4))
print(solution(27, 19))
```

- Python에서는 `print()`만으로 손실게 결과를 확인할 수 있음
- `main()` 함수 없이 실행 가능

---

## ☕ Java

```java
class Solution {
    public int solution(int num1, int num2) {
        return num1 * num2;
    }
}
```

- Java는 클래스 기반 구조 필수
- `public int solution(...)` 메서드로 정의하면 되며
- 여기서도 플랫폼에서 자동으로 테스트 메서드가 붙입니다

---

## 🥪 Sample Test Cases

| num1 | num2 | return |
| ---- | ---- | ------ |
| 3    | 4    | 12     |
| 27   | 19   | 513    |

---


## 📝 Note

- 이 문제는 언어별 **기초 문법 구조 차이**와 **입출량 처리 방식**을 비교하는 데 적합합니다.
- Java에서는 **클래스 선언과 메서드 접근 제어자**가 필요하다는 점이 중요합니다.

