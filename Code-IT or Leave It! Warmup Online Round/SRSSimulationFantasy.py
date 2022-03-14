"""
B - SRS Simulation Fantasy

In short: Total credits and numbers for which credit can be used 
are given. It is required to print how many different ways the 
total credit can be reached. 
"""

import itertools
credit = int(input())
count = 0

numbers = [int(x) for x in input().split()]

for i in range(1, credit+1):
    for com in itertools.combinations_with_replacement(numbers, i):
        if sum(com) == credit:
            count += 1

print(count)