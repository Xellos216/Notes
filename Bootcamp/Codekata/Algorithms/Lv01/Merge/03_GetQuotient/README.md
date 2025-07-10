# 몫 구하기

## 🧠 문제 설명
정수 `num1`, `num2`가 매개변수로 주어질 때, `num1`을 `num2`로 나눈 **몫**을 반환하는 함수를 작성하시오.

> 예시  
> - 입력: `num1 = 10`, `num2 = 5` → 출력: `2`  
> - 입력: `num1 = 7`, `num2 = 2` → 출력: `3`  

---

## 🐍 Python 풀이

```python
def solution(num1, num2):
    answer = num1 // num2
    return answer
```

---

## ☕ Java 풀이

```java
class Solution {
    public int solution(int num1, int num2) {
        int answer = num1 / num2;
        return answer;
    }
}
```

---

## ✅ 요약

| 언어     | 특징 요약 |
|----------|-----------|
| Python   | `//` 연산자를 사용해 정수 몫 반환 |
| Java     | 기본 int 나눗셈 사용, 클래스 구조 필요 |


---

