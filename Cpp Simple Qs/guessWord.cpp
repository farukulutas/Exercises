#include <iostream>
#include <string>
#include <algorithm>
#include<bits/stdc++.h>

using namespace std;

void wordsPrinted(string str)
{
    string word;
    stringstream iss(str);
    while (iss >> word)
        cout << word << endl;
}

int main()
{
    string words = "";
    string newWord = "";
    bool check = false;

    do {
        cout<<"Enter a guess word:";
        cin >> newWord;
        cout << endl;
        for_each(newWord.begin(), newWord.end(), [](char & c) {
            c = ::tolower(c);
        });
        int found = -1;
        found = words.find(newWord);
        int found2 = -1;
        bool check2 = false;

        if ( found != -1 ) {
            do {
                cout<<"You guessed this before, enter another guess:";
                cin >> newWord;
                cout << endl;
                for_each(newWord.begin(), newWord.end(), [](char & c) {
                   c = ::tolower(c);
                });
                found2 = words.find(newWord);

                if ( found2 != -1 ) {
                    words = words + " " + newWord;
                    check2 = true;
                }
            } while ( !check2 );

            check = true;
        }

        words = words + " " + newWord;
    } while ( !check );

    wordsPrinted(words);

    return 0;
}
