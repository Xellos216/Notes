## 🧠 Problem
array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수 `solution`을 작성하세요. divisor로 나누어 떨어지는 element가 하나도 없다면 배열 `[-1]`을 반환합니다.

### Constraints
- arr은 자연수를 담은 배열입니다.
- divisor는 자연수입니다.
- array는 길이 1 이상의 배열입니다.

### Example
- Input:
  ```python
  arr = [5, 9, 7, 10]
  divisor = 5
  ```
- Output: `[5, 10]`

- Input:
  ```python
  arr = [2, 36, 1, 3]
  divisor = 1
  ```
- Output: `[1, 2, 3, 36]`

- Input:
  ```python
  arr = [3, 2, 6]
  divisor = 10
  ```
- Output: `[-1]`

---

## 🐍 Python Reference Code

### ✅ 리스트 컴프리헨션 사용

```python
def solution(arr, divisor):
    result = [x for x in arr if x % divisor == 0]
    return sorted(result) if result else [-1]
```

### ✅ for문 사용

```python
def solution(arr, divisor):
    result = []

    for x in arr:
        if x % divisor == 0:
            result.append(x)

    if result:
        return sorted(result)
    else:
        return [-1]
```

---
---
