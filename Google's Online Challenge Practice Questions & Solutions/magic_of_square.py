def magic_of_square (N, A_i):
    # Write your code here
    # create list N,2 sized
    sum_list = [[ 0 for x in range(2)] for y in range(N)]

    # sum of non_squared array
    sum_list[0][0] = A_i[0]

    # sum of squared array
    sum_list[0][1] = A_i[0] * A_i[0]

    # max of them
    max_sum = max(sum_list[0][0], sum_list[0][1])
    
    # loop for iterate through whole array and find maximum sub array's summation
    for i in range(1,N):
        sum_list[i][0] = max(A_i[i], sum_list[i-1][0] + A_i[i])
        sum_list[i][1] = max(A_i[i] * A_i[i], sum_list[i-1][1] + A_i[i])
        sum_list[i][1] = max(sum_list[i][1], sum_list[i-1][0] + A_i[i] * A_i[i])
        max_sum = max(max_sum, sum_list[i][1])
        max_sum = max(max_sum, sum_list[i][0])

    return max_sum

N = int(input())
A_i = list(map(int, input().split()))

out_ = magic_of_square(N, A_i)
print (out_)