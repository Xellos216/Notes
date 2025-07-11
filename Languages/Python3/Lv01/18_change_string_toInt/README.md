# 문자열을 정수로 바꾸기 (ChangeStringToInt)

## 📌 문제 설명

문자열 `s`를 숫자로 변환한 결과를 반환하는 함수 `solution`을 완성하세요.

### 제한 조건
- `s`의 길이는 1 이상 5 이하입니다.
- `s`의 맨 앞에는 부호(+,-)가 올 수 있습니다.
- `s`는 부호와 숫자로만 이루어져 있습니다.
- `s`는 `"0"`으로 시작하지 않습니다.

### 입력 예시

| s       | return |
|--------|--------|
| "1234" | 1234   |
| "-1234"| -1234  |

---

## 🐍 Python

```python
def solution(s):
    return int(s)
```

---

## ☕ Java

```java
class Solution {
    public int solution(String s) {
        return Integer.parseInt(s);
    }
}
```

---

## 📊 요약 비교표

| 언어   | 형변환 함수           | 비고              |
|--------|----------------------|-------------------|
| Python | `int(s)`             | 내장 함수 사용     |
| Java   | `Integer.parseInt(s)`| 클래스 메서드 사용 |
