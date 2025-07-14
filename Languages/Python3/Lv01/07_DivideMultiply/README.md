# 두 수의 나눗셈

## 🧠 문제 설명
정수 `num1`과 `num2`가 주어질 때,  
`num1`을 `num2`로 나눈 값에 **1000을 곱한 후 정수 부분**만 반환하는 함수를 작성하시오.

> 예시  
> - 입력: `num1 = 3`, `num2 = 2` → 출력: `1500`  
> - 입력: `num1 = 7`, `num2 = 3` → 출력: `2333`  
> - 입력: `num1 = 1`, `num2 = 16` → 출력: `62`  

---

## 🐍 Python 풀이

```python
def solution(num1, num2):
    answer = float(num1) / num2 * 1000
    return int(answer)
```


