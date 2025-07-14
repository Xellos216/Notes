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


