# 1149 - RGB거리

## ✅ 문제 설명
N개의 집이 일렬로 있을 때, 각 집은 빨강(R), 초록(G), 파랑(B) 중 하나로 칠해야 한다.  
단, **이웃한 집은 같은 색으로 칠할 수 없다.**  
각 집을 색칠하는 비용이 주어졌을 때, **전체 비용의 최소값을 구하는 문제**.

---

## ✅ 입력
- 첫 줄: 집의 수 N (2 ≤ N ≤ 1,000)
- 둘째 줄부터 N개의 줄: 각 집을 빨강, 초록, 파랑으로 칠하는 비용

---

## ✅ 출력
- 모든 집을 규칙에 맞게 칠했을 때의 최소 비용

---

## ✅ 알고리즘 분류
- **동적 계획법 (Dynamic Programming)**

---

## ✅ 풀이 흐름 요약
1. `cost[i][j]` 형태의 2차원 리스트 생성 (j: 0=R, 1=G, 2=B)
2. i번째 집을 j색으로 칠할 때 최소비용 =  
   `cost[i][j] += min( cost[i-1][k] )`  
   단, `k != j`
3. 최종 최소 비용은 `min(cost[N-1])`

---

## ✅ 예시
```
입력:
3
26 40 83
49 60 57
13 89 99

출력:
96
```
