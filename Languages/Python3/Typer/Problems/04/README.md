# 04_GetBirthYear

## 🧠 Problem
머쓱이는 선생님의 출생연도가 궁금합니다. 2022년 기준 선생님의 나이 `age`가 주어질 때, 
한국식 나이 계산법에 따라 선생님의 **출생 연도**를 반환하는 함수를 작성하시오.

### Constraints
> - 한국식 나이: 태어난 해부터 1살로 계산, 해가 바뀔 때마다 1살씩 증가 
> - 기준 연도는 항상 2022년

### Example
> - Input: `age = 40` → Output: `1983` 
> - Input: `age = 23` → Output: `2000` 

---

## 🐍 Python Reference Code

```python
def solution(age):
    answer = 2022 - (age - 1)
    return answer
```




