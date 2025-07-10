# 짝수와 홀수

## 📈 문제 설명
정수 `num`이 짧수일 경우 `"Even"`을 반환하고, 혹수인 경우 `"Odd"`를 반환하는 함수를 작성하세요.

### 제한 조건
- `num`은 int 범위의 정수입니다.
- `0`은 짧수입니다.

### 입력 예시
| num | return |
|-----|--------|
| 3   | "Odd"  |
| 4   | "Even" |

---

## 🦍 Python

```python
def solution(num):
    if num % 2 == 0:
        answer = 'Even'
    elif num % 2 != 0:
        answer = 'Odd'
    return answer
```

---

## ☕ Java

```java
class Solution {
    public String solution(int num) {
        String answer;
        if (num % 2 == 0) {
            answer = "Even";
        } else {
            answer = "Odd";
        }
        return answer;
    }
}
```

---

## 📊 요조 비교표

| 언어    | 조건문 구조         | 반환값 선언 방식 | 문자열 리터럴 |
|---------|---------------------|------------------|----------------|
| Python  | if / elif           | 변수 직접 대입   | `'Even'`, `'Odd'` |
| Java    | if / else           | 변수 선언 후 대입 | `"Even"`, `"Odd"` |

---



