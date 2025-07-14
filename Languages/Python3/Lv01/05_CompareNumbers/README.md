# 숫자 비교하기

## 🧠 문제 설명
정수 `num1`과 `num2`가 주어질 때, 두 수가 **같으면 1**, 다르면 **-1**을 반환하는 함수를 작성하시오.

> 예시  
> - 입력: `num1 = 2`, `num2 = 3` → 출력: `-1`  
> - 입력: `num1 = 11`, `num2 = 11` → 출력: `1`  
> - 입력: `num1 = 7`, `num2 = 99` → 출력: `-1`  

---

## 🐍 Python 풀이

```python
def solution(num1, num2):
    if num1 == num2:
        answer = 1
    else:
        answer = -1
    return answer
```



