/* 1- Write a function that you can send as many parameters as you want with JavaScript. For each number you send to this function, write whether it is prime or not as the output. (Research topic : condition blocks : if )

Example usage: findPrime(2,5,8,21, 13) findPrime(3,5) */

function findPrime(...numbers) {
    for ( let j = 0; j < numbers.length; j++ ) {
        flag = true;
        for(let i = 2; i <= Math.sqrt(numbers[j]); i++) {
           if(numbers[j] % i === 0) {
              flag = false;
              break;
           }
        }
    
        if ( flag ) {
            console.log(numbers[j] + " is prime!")
        }
        else {
            console.log(numbers[j] + " is not prime!")
        }
    }
}

findPrime(2,5,8,21,13)
findPrime(3,5)

/* 2- Write a program that finds whether two numbers entered as parameters are friend numbers. (Google for friend numbers) */

function friendsNumbers( num1, num2) {
    sum1 = 0
    sum2 = 0
    
    for(let i = 1; i <= num1 / 2; i++) {
        if( num1 % i === 0) {
            sum1 += i
        }
    }

    for(let j = 1; j <= num2 / 2; j++) {
        if( num2 % j == 0) {
            sum2 += j
        }
    }
    
    if ( sum1 == num2 && sum2 == num1 ) {
        console.log( num1 + " and " + num2 + " are friend numbers!")
    }
    else {
        console.log( num1 + " and " + num2 + " are not friend numbers!") 
    }
}

friendsNumbers(220, 284)
friendsNumbers(17296, 18416)
friendsNumbers(1184 ,1210)
friendsNumbers(115,121)

/* 3- Write a program that lists all perfect numbers up to 1000. */

function listPerfectNumbersUpTo( limit) {
    for ( let i = 1; i <= limit; i++ ) {
        sum = 0;
        for ( let j = 1; j < i; j++ ) {
            if ( i % j == 0 ) {
                sum += j
            }
        }
        
        if ( sum == i ) {
            console.log(i + " is perfect number!")
        }
    }
}

listPerfectNumbersUpTo( 1000)

/* 4- Write a program that lists all prime numbers up to 1000. */

result = ""
for ( let j = 2; j < 1000; j++ ) {
    flag = true;
    for(let i = 2; i <= Math.sqrt(j); i++) {
        if( j % i == 0 ) {
            flag = false;
            break;
        }
    }
    
    if ( flag ) {
        result = result + j + " ,"
    }
}

console.log(result)