# 집의 수 입력
n = int(input())

# 각 집을 R, G, B로 칠하는 비용 입력
cost = [list(map(int, input().split())) for _ in range(n)]

# 2번재 집부터 N번째 집까지 비용을 누적 계산
for i in range(1, n):
    # i번째 집을 빨강으로 칠할 경우, 다음 집은 초록 또는 파랑이어야 함
    cost[i][0] += min(cost[i-1][1], cost[i-1][2])
    # 두번째 집이 초록일 경우 세번째는 파랑
    cost[i][1] += min(cost[i-1][0], cost[i-1][2])
    # 이하 생략
    cost[i][2] += min[cost[i-1][0], cost[i-1][1])

# 마지막 집까지 칠했을 때 최소 비용 출력
print(min(cost[n-1]))
