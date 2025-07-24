# 1149_Syntax.md

## ✅ 주요 문법 정리: RGB거리 (DP 문제)

### 1. 2차원 리스트 입력 받기
```python
cost = [list(map(int, input().split())) for _ in range(n)]
```
- 각 줄에 세 개의 정수가 주어질 때, 이를 n줄만큼 받아서 2차원 리스트로 저장
- `map(int, input().split())` : 한 줄 입력 → 정수로 변환
- `list(...)` : map 객체를 리스트로 변환
- `[ ... for _ in range(n)]` : 위 작업을 n번 반복하여 2차원 리스트 생성

---

### 2. 누적 업데이트 (DP 테이블 갱신)
```python
cost[i][0] += min(cost[i-1][1], cost[i-1][2])
```
- 현재 i번째 집을 빨강(0)으로 칠할 때 최소비용 계산
- 이전 집에서 초록(1) 또는 파랑(2) 중 최소값을 선택해 누적

---

### 3. 최소값 출력
```python
print(min(cost[n-1]))
```
- 마지막 집까지 모두 칠한 후, 마지막 줄에서 최소 비용 출력
