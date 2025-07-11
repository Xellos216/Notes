import math

T = int(input())

for _ in range(T):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())

    dist_sq = (x1 - x2) ** 2 + (y1 - y2) ** 2 # 중심 사이 거리의 제곱
    r_sum_sq = (r1 + r2) ** 2
    r_diff_sq = (r1 - r2) ** 2

    if dist_sq == 0 and r1 == r2:
       print(-1)  # 같은 원
    elif r_diff_sq < dist_sq < r_sum_sq:
       print(2)   # 두 점에서 만남
    elif dist_sq == r_sum_sq or dist_sq == r_diff_sq:
       print(1)   # 외접 또는 내접
    else:
       print(0)   # 만나지 않음
