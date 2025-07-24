n = int(input())

# n이 1이나 2일 때도 대비해서 넉넉하게 공간 확보
dp = [0] * (n + 2)
dp[1] = 1 # 길이 1: '1'
dp[2] = 2 # 길이 2: '11', '00'

# 점화식 dp[n] = dp[n-1] + dp[n-2]
for i in range(3, n + 1):
    dp[i] = (dp[i - 1] + dp[i - 2]) % 15746

# 결과 출력
print(dp[n])
