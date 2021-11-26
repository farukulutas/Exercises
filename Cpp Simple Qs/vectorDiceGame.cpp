Dice::Dice() {
    int dice = -1;
    while ( dice >= 2 && dice <= 100 )
        int dice = (int)(rand() % 100) + 1;

    mySides = dice;
    myRollCount = 0;
}

Dice::roll() {
    vector<Dice> dices;

    for ( int k = 0; k < 5; k++ ) {
        Dice d;
        dices.push_back(d);
    }

    int sum = 0;
    int totalSides = 0;
    int result = 0;

    for ( int i = 0; i < 5; i++ ) {
        for ( int j = 0; j < 3; j++ ) {
            result = (int) (rand() % dices[i].mySides);
            sum += result;
            cout << "Rolling " << dices[i].mySides << " sided dice: " << result << " came up." << endl;
        }

        totalSides += dices[i].mySides;
    }

    cout << "Sum of rolls: " << sum;
    cout << "Total number of sides: " << totalSides;
}
