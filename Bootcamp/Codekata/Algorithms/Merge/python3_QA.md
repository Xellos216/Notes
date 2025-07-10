# Python3 QA 정리

## 🔹 Q1 Python에서 정수와 실수 연산은 어떻게 처리되나요?

### 🟢 A1
Python은 동적 타입 언어이기 때문에 정수(`int`)와 실수(`float`)가 함께 연산되면 자동으로 실수로 형 변환됩니다.

### 예시:
```python
result = 5 / 2  # 2.5 (자동으로 float)
```

---

---



---

### 🔹 Q2 도와줘 (Python에서 평균 코드가 안 됨)

### 🟢 A2
**오류**
```python
for i range(0, n+1):
```
- `for i in range(...)`가 되어야 함. `in` 빠짐.

**평균 계산 정답 예시**
```python
def solution(numbers):
    return sum(numbers) / len(numbers)
```

---

---



---

## 🔹 Q3 왜 홀수는 되고 짝수는 안 된 거지?

### 🟢 A3
Python 코드에서 `//` 연산자는 **정수 나눗셈(몫)**입니다. 짝수 여부를 판단할 때는 `num % 2 == 0`처럼 **나머지 연산자 `%`**를 사용해야 정확히 판별됩니다.

```python
# 잘못된 코드
if num // 2 == 0:  # 짝수 판단 X

# 올바른 코드
if num % 2 == 0:
    return 'Even'
else:
    return 'Odd'
```

---

---



---

## 🔹 Q4 자릿수 합 구하기 문제, Python에서 어떻게 푸는지 감이 안 잡힘

### 🟢 A4
정수 n의 자릿수를 모두 더하는 문제는 다음 두 가지 방법으로 해결 가능:

### 방법 1: 문자열 변환
```python
def solution(n):
    return sum(int(d) for d in str(n))
```

### 방법 2: 수학적 분해
```python
def solution(n):
    answer = 0
    while n > 0:
        answer += n % 10
        n //= 10
    return answer
```

---

---



---

### 🔹 Q5 x만큼 간격이 있는 n개의 숫자 (Python3, Java)

### 🟢 A5
**Python3**

```python
def solution(x, n):
    return [x * i for i in range(1, n + 1)]
```

**Java**

```java
public class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (long)x * (i + 1);
        }
        return answer;
    }
}
```

---

---



---

### 🔹 Q6 자연수 뒤집어 배열로 만들기 (Python3, Java)

### 🟢 A6
**Python3**

```python
def solution(n):
    return [int(d) for d in str(n)][::-1]
```

**Java**

```java
public class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            answer[i] = s.charAt(s.length() - 1 - i) - '0';
        }
        return answer;
    }
}
```

---

---



---

### 🔹 Q7 문자열을 정수로 변환 (Python3, Java)

### 🟢 A7
**Python3**

```python
def solution(s):
    return int(s)
```

**Java**

```java
public class Solution {
    public int solution(String s) {
        return Integer.parseInt(s);
    }
}
```

---

---



---

### 🔹 Q8 제곱수 판별 (Python3, Java)

### 🟢 A8
**Python3**

```python
def solution(n):
    x = n ** 0.5
    if x.is_integer():
        return int((x + 1) ** 2)
    return -1
```

**Java**

```java
public class Solution {
    public long solution(long n) {
        double x = Math.sqrt(n);
        if (x == (long)x) {
            return (long)Math.pow(x + 1, 2);
        }
        return -1;
    }
}
```

---

---

