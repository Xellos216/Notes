T = int(input())
N_list = [int(input()) for _ in range(T)]

# DP 테이블 초기화
dp = [0] * 101
dp[1] = dp[2] = dp[3] = 1
dp[4] = dp[5] = 2

# 점화식에 따라 DP 테이블 채우기
for i in range(6, 101):
    dp[i] = dp[i - 1] + dp[i - 5]

# 각 테스트 케이스에 대해 정답 출력
for N in N_list:
    print(dp[N])

