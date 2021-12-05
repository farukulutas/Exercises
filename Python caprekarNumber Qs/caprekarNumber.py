veri = input("Bir sayı giriniz: ")
result = str( int(pow( int( veri), 2)))
n = len(result)
no1 = 0
no2 = int(result[int(n/2):])

if ( n != 1 and n != 2 and n != 3 ):
    no1 = int(result[0:int(n/2)-1])

result = str(no1 + no2)
print("Result: ", result)
