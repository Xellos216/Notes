# 자연수 뒤집어 배열을 만들기 (ReverseDigitsArray)

## 📈 문제 설명

자연수 `n`을 뒤집어 각 자리 수자를 원소로 가지는 배열 형태로 `return`하세요.

예를 들어 `n = 12345`이면 `[5,4,3,2,1]`을 `return`해야 합니다.

### 제한 조건
- `n`은 10,000,000,000 이하의 자연수

### 입력 예시
| n      | return         |
|--------|----------------|
| 12345  | [5,4,3,2,1]     |

---

## 🦍 Python

```python
def solution(n):
    return [int(digit) for digit in str(n)][::-1]
```

---

## ☕ Java

```java
class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int[] answer = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            answer[i] = str.charAt(str.length() - 1 - i) - '0';
        }
        return answer;
    }
}
```

---

## 📊 요조 비교표

| 언어   | 뒤집어 처리 방식 | 타입 및 점검 방식 | 특징 |
|--------|--------------------------|----------------------|--------|
| Python | [::-1] 자리 바뀌기   | str(n) + int      | 일반적인 연산 |
| Java   | 뒤집어 index 계산      | charAt(i) - '0'   | 다양한 유형 포함 |

