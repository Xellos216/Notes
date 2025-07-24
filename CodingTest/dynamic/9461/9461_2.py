# 테스트 케이스 개수 입력
T = int(input())

# 테스트 케이스마다 N을 입력받아 리스트에 저장
N_list = [int(input()) for _ in range(T)]

# 파도반 수열을 저장할 DP 테이블 (1-indexed)
dp = [0] *101
dp[1] = dp[2] = dp[3] = 1  # 첫 세 항은 1
dp[4] = dp[5] = 2          # 4, 5번째 항은 2

# 6번째 항부터 점화식을 이용해 채움
for i in range(6, 101):
    dp[i] = dp[i - 1] + dp[i - 5]

# 각 테스트 케이스 결과 출력
for N in N_list:
    print(dp[N])

