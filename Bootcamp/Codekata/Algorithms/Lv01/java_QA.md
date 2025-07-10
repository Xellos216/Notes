# Java QA 정리

## 🔹 Q1 Java 코드에서 `bad operand types for binary operator` 에러는 왜 발생했나요?

### 🟢 A1
Java에서는 `if (0 < angle < 90)`처럼 Python 스타일의 범위 비교를 사용할 수 없습니다. 각 비교를 **명시적으로** 작성해야 합니다:

### 잘못된 예:
```java
if (0 < angle < 90)
```

### 올바른 예:
```java
if (0 < angle && angle < 90)
```

---

---



## 🔹 Q2 Java에서 변수 초기화를 꼭 해야 하나요?

### 🟢 A2
Java에서는 지역 변수(local variable)는 **초기화하지 않으면 컴파일 에러**가 납니다. `int answer;`만 선언하고 값 할당 없이 사용하면 아래와 같은 에러가 발생합니다:

```text
variable answer might not have been initialized
```

해결 방법: 반드시 초기값을 줘야 함
```java
int answer = 0;
```

---

---



### 🔹 Q3 자바에서 평균 구하기 오류

### 🟢 A3
**오류 코드**
```java
for (double i : numbers)
    answer += i;
```
- i는 `double`로 선언했으나, numbers 배열의 타입은 `int[]` → 형 맞지 않음
- 또는 단순히 `i`를 `int`로 선언하면 됨

---

---



### 🔹 Q4 또 오류 (Java)

### 🟢 A4
**오류**
```java
answer += num;
```
- num이라는 변수가 선언되지 않음

**해결**
- for문에서 i로 index 접근할 경우:
```java
answer += numbers[i];
```

---

---



## 🔹 Q5 자바에서 `return String answer;`는 왜 오류야?

### 🟢 A5
`String answer`는 **선언문**이므로 `return`과 함께 쓸 수 없습니다.

→ 선언은 밖에서 하고, 값만 반환해야 합니다:

```java
String answer;
if (...) {
  answer = "Even";
}
return answer; // OK
```

---

---



## 🔹 Q6 Java에서 평균 구하는 법

### 🟢 A6
Java에는 `sum()` 함수 없음 → for문으로 합 구하기. 배열 길이는 `arr.length`.

```java
public double solution(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    return (double)sum / arr.length;
}
```

---
# Python3 & Java 관련 QA 정리 (QA05~QA06 기반)



### 🔹 Q7 x만큼 간격이 있는 n개의 숫자 (Python3, Java)

### 🟢 A7
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



### 🔹 Q8 자연수 뒤집어 배열로 만들기 (Python3, Java)

### 🟢 A8
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



### 🔹 Q9 문자열을 정수로 변환 (Python3, Java)

### 🟢 A9
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



### 🔹 Q10 제곱수 판별 (Python3, Java)

### 🟢 A10
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

