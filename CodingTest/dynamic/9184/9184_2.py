import sys
sys.setrecursionlimit(100000)  # 깊은 재귀 허용

# 메모이제이션용 3차원 리스트 (0 ~ 20까지만 저장)
dp = [[[0]*21 for _ in range(21)] for _ in range(21)]

def w(a, b, c):
    if a <= 0 or b <= 0 or c <= 0:
       return 1
    if a > 20 or b > 20 or c > 20:
       return w(20, 20, 20)
    if dp[a][b][c] != 0:
       return dp[a][b][c]  # 저장된 값 재사용
    if a < b and b < c:
       dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
    else:
        dp[a][b][c] = (
          w(a-1, b, c) +
          w(a-1, b-1, c) +
          w(a-1, b, c-1) -
          w(a-1, b-1, c-1)
       )
    return dp[a][b][c]

# 입력 처리
while True:
    a, b, c = map(int, sys.stdin.readline().split())
    if a == -1 and b == -1 and c ==-1:
       break
    print(f"w({a}, {b}, {c}) = {w(a, b, c)}")
