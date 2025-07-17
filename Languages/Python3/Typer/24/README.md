# 24_Find_Kim

## 🧠 Problem
문자열 배열 `seoul`이 주어졌을 때, `"Kim"`이라는 이름이 **몇 번째(index)** 위치에 있는지 찾아서
`"김서방은 x에 있다"`라는 형식의 문자열로 반환하는 함수를 작성하시오.

### Example
- Input: `["Jane", "Kim"]`
- Output: `"김서방은 1에 있다"`

---

## 🐍 Python Reference Code

```python
def solution(seoul):
    x = seoul.index("Kim")  # Kim이 위치한 인덱스를 찾음
    return f"김서방은 {x}에 있다"
```


