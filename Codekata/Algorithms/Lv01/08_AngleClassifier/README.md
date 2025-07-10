# 각도기

## 🧠 문제 설명
각에서 `0도 초과 90도 미만`은 예각,  
`90도`는 직각, `90도 초과 180도 미만`은 둔각,  
`180도`는 평각으로 분류됩니다.

정수 `angle`이 주어질 때,
- 예각이면 1
- 직각이면 2
- 둔각이면 3
- 평각이면 4  
를 return 하도록 함수를 구현하시오.

---

## 🐍 Python 풀이

```python
def solution(angle):
    if 0 < angle < 90:
        answer = 1
    elif angle == 90:
        answer = 2
    elif 90 < angle < 180:
        answer = 3
    elif angle == 180:
        answer = 4
    return answer
```

---

## ☕ Java 풀이

```java
class Solution {
    public int solution(int angle) {
        int answer = 0;
        if (0 < angle && angle < 90) {
            answer = 1;
        } else if (angle == 90) {
            answer = 2;
        } else if (90 < angle && angle < 180) {
            answer = 3;
        } else if (angle == 180) {
            answer = 4;
        }
        return answer;
    }
}
```

---

## ✅ 요약

| 언어     | 특징 요약 |
|----------|-----------|
| Python   | `elif` 구조로 간결하게 작성 가능 |
| Java     | 모든 조건 `else if` 분기문으로 명시 |

---

