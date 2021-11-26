char TicTacToeWinner(const vector<vector<char>> & board)
{
     // check same char row first
     char winner = SameRowWinner(board);
     if (winner != ' ')
         return winner;

     // check same char column then
     winner = SameColumnWinner(board);
     if (winner != ' ')
         return winner;

      // check same diagonal
      winner = SameDiagonalWinner(board);
      if (winner != ' ')
         return winner;

      return ' ';
}

// TO DO
char SameColumnWinner(const vector<vector<char>> board) {
    string check;

    for ( int i = 0; i < 3; i++ ) {
        check = "";

        for ( int j = 0; j < 3; j++ ) {
            check = check + board[j][i];
        }

        if ( check == "xxx" ) {
            return 'x';
        }
        else if ( check == "ooo" ) {
            return 'o';
        }
    }

    return ' ';
}

