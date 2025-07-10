# 4948_Syntax.md

## ✅ 등장한 주요 문법 정리 (백준 4948번 - 베르트랑 공준)

---

### 1. sys.stdin.readline()

- **설명**: 입력 속도 향상을 위한 표준 입력 방식
- **용도**: 반복 입력이 많은 경우 input()보다 빠름
- **예시**:
  ```python
  import sys
  n = int(sys.stdin.readline())
  ```

---

### 2. 리스트 초기화 - [True] * (MAX + 1)

- **설명**: 특정 크기만큼 동일한 값으로 리스트 초기화
- **예시**:
  ```python
  is_prime = [True] * (MAX + 1)
  ```

---

### 3. 에라토스테네스의 체

- **개념**: 소수를 빠르게 판별하기 위한 대표 알고리즘
- **원리**:
  - 2부터 시작해 배수들을 전부 제거
  - i*i부터 MAX까지 i씩 증가하며 배수 제거
- **예시**:
  ```python
  for i in range(2, int(MAX**0.5) + 1):
      if is_prime[i]:
          for j in range(i*i, MAX + 1, i):
              is_prime[j] = False
  ```

---

### 4. range(start, end+1)

- **설명**: 숫자 범위 생성. end는 포함되지 않음
- **예시**:
  ```python
  range(n+1, 2*n+1)  # n보다 크고 2n 이하
  ```

---

### 5. while True + break

- **설명**: 무한 루프 생성 후 조건 만족 시 종료
- **예시**:
  ```python
  while True:
      if n == 0:
          break
  ```

---

### 6. print()

- **설명**: 출력 함수
- **용도**: 각 테스트 케이스의 결과 출력
