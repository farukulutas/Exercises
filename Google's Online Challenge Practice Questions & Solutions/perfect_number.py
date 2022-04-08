def Solve(N):
    # Write your code here
    sum = 0
    
    # sum the perfect divisors
    for i in range(1,N):
        if N % i == 0:
            sum += i
            
    # if sum equal to number
    if sum == N:
        return "YES" 

    return "NO"

T = int(input())
for _ in range(T):
    N = int(input())
    out_ = Solve(N)
    print (out_)