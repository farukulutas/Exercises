"""
A - Some Geek Problems

Shortcut: The player at the end of each line is the winner, 
it needs to be printed.
"""

number = int(input())

for i in range(0,number):
    line = input()
    print(line.split()[-1])