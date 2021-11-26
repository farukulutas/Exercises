#include <iostream>

using namespace std;

void checkPrimeBetween( int lower, int upper) {
    int n = 0;
    int lowerPrime = 0;
    int upperPrime = 0;

    for ( int i = lower; i < upper; i++ ) {
        for ( int j = 2; j <= i / 2; ++j) {
            if ( i % 2 != 0) {
                if ( lowerPrime == 0 ) {
                    lowerPrime = i;
                    n = 1;
                }
                if ( upperPrime == 0 ) {
                    upperPrime = i;
                    n = 2;
                }
            }
        }
    }

    if ( n = 0 ) {
        cout << "There are no prime numbers in the range of [" << lower << ", " << upper << "]" << endl;
    }
    else if ( n = 1 ) {
        cout << "The only prime number in the range of [" << lower << ", " << upper << "] is " << lowerPrime << endl;
    }
    else {
        cout << "In the range of [" << lower << ", " << upper << "]" << endl;
        cout << "Smallest prime number is " << lowerPrime << endl;
        cout << "Biggest prime number is " << upperPrime << endl;
    }
}

int main()
{
    int lower = 0;
    int upper = 0;
    bool isFound = false;

    while ( !isFound ) {
        cout << "Please enter the range limits: ";
        cin >> lower;
        cin >> upper;
        cout << endl;

        if ( lower <= 2 || upper <= 2 ) {
            cout << "Lower bound of the range cannot be smaller than 2" << endl;
        }
        else if ( upper <= lower ) {
            cout << "Lower bound of the range cannot be equal or bigger than the upper bound" << endl;
        }
        else {
            checkPrimeBetween( lower, upper);
        }
    }

    return 0;
}
