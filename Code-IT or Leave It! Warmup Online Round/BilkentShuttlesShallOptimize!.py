"""
C - Bilkent Shuttles Shall Optimize!

You are given information about the total number of stops, the 
number of students at each stop, and what time the students are 
at the stop. An optimization question that asks to print the 
maximum number of students you can carry, provided that they stop 
by each stop once before the deadline.

Also, you can pick up passengers from only one stop per hour.
"""

numOfStations = int(input())

students = []
deadlines = []
usedIndexes = []

total = 0
count = 0

for i in range(0,numOfStations):
    line = input()
    line = line.split()
    value1 = line[1]
    value1 = int(value1)
    value2 = line[2]
    value2 = int(value2)

    deadlines.append(value1)
    students.append(value2)

maxDeadline = max(deadlines)

# note that sorted by 1 to n
zipped_lists = zip(students, deadlines)
sorted_zipped_lists = sorted(zipped_lists)

tuples = zip(*sorted_zipped_lists)
students, deadlines = [ list(tuple) for tuple in  tuples]

for st in reversed( students):
    if ( count == maxDeadline ):
        break
    
    for dl in range( deadlines[students.index(st)], 0, -1):
        if ( dl not in usedIndexes):
            total = total + st
            usedIndexes.append( dl)
            count += 1
            break

print(total)