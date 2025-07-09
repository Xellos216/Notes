## Day6 문법 정리 - 백준 9184번 '신나는 함수 실행'

문제 유형: 동적 계획법 1 (재귀 + 메모이제이션)

---

### ✅ 1. `sys.setrecursionlimit()`
```python
import sys
sys.setrecursionlimit(100000)
```
- 기본 재귀 깊이 제한(약 1000)을 사용자가 직접 증가시킬 수 있음
- 깊은 재귀 호출이 필요한 문제에서 오류 방지를 위해 사용

---

### ✅ 2. 3차원 리스트 생성 (`dp = [[[0]*21 ... ]`)
```python
dp = [[[0]*21 for _ in range(21)] for _ in range(21)]
```
- `dp[a][b][c]` 구조의 3차원 리스트 생성
- 각 축의 크기: 21 (0~20 포함)
- 메모이제이션 용도로 사용 → 동일한 함수 호출 결과 저장

---

### ✅ 3. 함수 정의 및 재귀 호출
```python
def w(a, b, c):
    if a <= 0 or b <= 0 or c <= 0:
        return 1
    if a > 20 or b > 20 or c > 20:
        return w(20, 20, 20)
    ...
```
- 함수 내에서 자신을 다시 호출하는 구조 → 재귀 함수
- 특정 조건에 따라 다른 방식으로 분기되며 계산됨

---

### ✅ 4. 무한 입력 처리 + 종료 조건
```python
while True:
    a, b, c = map(int, input().split())
    if a == -1 and b == -1 and c == -1:
        break
```
- `while True:`: 무한 반복 구조
- `map(int, input().split())`: 한 줄 입력을 정수 3개로 나눔
- 종료 조건으로 `-1 -1 -1` 입력 시 반복 종료

---

### ✅ 5. 문자열 포맷 출력
```python
print(f"w({a}, {b}, {c}) = {w(a, b, c)}")
```
- f-string 사용 → 변수 값을 문자열 안에 쉽게 삽입 가능
- 예: `w(1, 1, 1) = 2`

---

### ✅ 6. 조건문 분기
```python
if a < b and b < c:
    dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
else:
    dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
```
- 중첩된 조건문에 따라 재귀 호출 방식이 달라짐
- 조건에 따라 재귀 분할 방식이 다른 것이 핵심

