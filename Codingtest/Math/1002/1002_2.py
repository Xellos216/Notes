# 테스트 케이스 개수 입력
T = int(input())

# 각 테스트 케이스에 대해 반복
for _ in range(T):
    # 두 터렛의 좌표 (x1, y1), 반지름 r1 / (x2, y2), 반지름 r2 입력 받기
    x1, y1, r1, x2, y2, r2 = map(int, input().split())

    # 두 중심 사이 거리의 제곱 (루트를 쓰지 않고 비교만 하기 위함)
    dist_sq = (x1 - x2) ** 2 + (y1 - y2) ** 2

    # 두 반지름의 합의 제곱
    r_sum_sq = (r1 + r2) ** 2

    # 두 반지름의 차의 제곱
    r_diff_sq = (r1 - r2) ** 2

    # 두 원이 완전히 일치하는 경우 (중심도 같고 반지름도 같음)
    if dist_sq == 0 and r1 == r2:
       print(-1) # 무한히 많은 위치 가능

    #두 원이 서로 다른 두 점에서 만나는 경우
    elif r_diff_sq < dist_sq < r_sum_sq:
         print(2) # 교점 1개

    # 두 원이 외접하거나 내접하는 경우 (접점이 1개)
    elif dist_sq == r_sum_sq or dist_sq == r_diff_sq:
         print(1) # 교점 1개

    # 나머지 경우: 원이 서로 만나지 않음
    else:
         print(0) # 교점 없음
