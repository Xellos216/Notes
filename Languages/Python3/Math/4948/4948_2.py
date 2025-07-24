import sys

# 문제에서 n의 최대값은 123456이므로, 2n까지 고려해 246912까지 소수 판별 필요
MAX = 123456 * 2

# True로 초기화된 소수 판별 배열 (0과 1은 소수가 아님)
is_prime = [True] * (MAX + 1)
is_prime[0] = is_prime[1] = False

# 에라토스테네스의 체 알고리즘으로 소수 판별 배열 구성
for i in range(2, int(MAX**0.5) + 1):
    if is_prime[i]:  # i가 소수이면
       for j in range(i*i, MAX + 1, i):  # i의 배수들은 소수가 아님
           is_prime[j] = False

# 입력이 0이 나올 때가지 반복
while True:
   n = int(sys.stdin.readline())
   if n == 0:
       break


   # n보다 크고 2n 이하인 소수의 개수를 셈
   count = 0
   for i in range(n+1, 2*n+1):
       if is_prime[i]:
          count += 1

   # 결과 출력
   print(count)
