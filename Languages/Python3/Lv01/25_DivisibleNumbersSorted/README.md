# 25_DivisibleNumbersSorted

## 🧠 Problem
주어진 배열 `arr`에서 `divisor`로 나누어 떨어지는 모든 숫자만 골라,  
오름차순으로 정렬해 반환하시오.  
단, 나누어 떨어지는 수가 없다면 `[-1]`을 반환합니다.

### Example
- Input: `arr = [5, 9, 7, 10], divisor = 5`  
- Output: `[5, 10]`

---

## 🐍 Python Reference Code

```python
def solution(arr, divisor):
    result = [x for x in arr if x % divisor == 0]
    return sorted(result) if result else [-1]
```

---

## Explanation

###리스트 컴프리헨션

[x for x in arr if x % divisor == 0]

위 코드는 아래의 반복문과 완전히 같은 의미입니다:

result = []
for x in arr:
    if x % divisor == 0:
        result.append(x)

즉, `arr`의 모든 요소 중에서 `divisor`로 나누어떨어지는 `x`만 추출하여
리스트 `result`에 담는 축약 문법입니다.

### sorted 함수
sorted([5, 3, 10])     # 결과: [3, 5, 10]

- `sorted()`는 **정렬된 새 리스트**를 반환하는 함수입니다.
- 기본 정렬은 **오름차순**입니다.
- 원본 리스트를 **수정하지 않고**, 정렬된 복사본을 만들어 줍니다.

### reverse 옵션 사용하기
sorted([5, 3, 10], reverse=True)   # 결과: [10, 5, 3]

- `reverse=True` 옵션을 넣으면 **내림차순** 정렬됩니다.

### 최종 동작 정리
- `[x for x in arr if x % divisor == 0]` : 조건에 맞는 값만 추출
- `sorted(...)` : 결과를 오름차순 정렬
- `if result else [-1]` : 결과가 없다면 `[-1]` 반환
