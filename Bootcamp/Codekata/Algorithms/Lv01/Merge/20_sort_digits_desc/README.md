# 정수 내림차순으로 배치하기 (sort_digits_desc)

## 📌 문제 설명

함수 `solution`은 정수 `n`을 매개변수로 입력받습니다.  
`n`의 각 자릿수를 **큰 것부터 작은 순서로 정렬**한 새로운 정수를 리턴해주세요.

예를 들어 `n = 118372`이면 `873211`을 반환하면 됩니다.

### 제한 조건

- `n`은 1 이상 8,000,000,000 이하인 자연수입니다.

---

## 🐍 Python

```python
def solution(n):
    return int(''.join(sorted(str(n), reverse=True)))
```

---

## ☕ Java

```java
import java.util.*;

class Solution {
    public long solution(long n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits); // 오름차순 정렬
        StringBuilder sb = new StringBuilder(new String(digits));
        sb.reverse(); // 내림차순으로 뒤집기
        return Long.parseLong(sb.toString());
    }
}
```

---

## 📊 요약 비교표

| 언어   | 정렬 방식             | 변환 방식                       | 특징                      |
|--------|----------------------|--------------------------------|---------------------------|
| Python | `sorted(..., reverse=True)` | `''.join()` 후 `int()` 변환    | 매우 간결하고 직관적         |
| Java   | `Arrays.sort()` 후 `reverse()` | `StringBuilder`, `Long.parseLong()` 사용 | 문자열 조작 구조 명확함 |
