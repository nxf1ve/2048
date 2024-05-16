public class Board {
    public Block[][] board;
    private int grids;
    public int getGrids() {
        return grids;
    }
    int border = 0;
    public int score = 0;


    public Board( int grids )
    {
        this.grids = grids;
        board = new Block[grids][grids];
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                board[i][j] = new Block();
            }
        }
    }


    public Block[][] getBoard()
    {
        return board;
    }

    public int getScore()
    {
        return score;
    }
    public int getHighBlock()
    {
        int high = board[0][0].getValue();
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                if ( board[i][j].getValue() > high )
                {
                    high = board[i][j].getValue();
                }
            }
        }
        return high;
    }

    public void spawn()
    {
        boolean empty = true;
        while ( empty )
        {
            int row = (int)( Math.random() * grids );
            int col = (int)( Math.random() * grids );
            double x = Math.random();
            if ( board[row][col].getValue() == 0 )
            {
                if ( x < 0.2 )
                {
                    board[row][col] = new Block( 4 );
                    empty = false;
                }
                else
                {
                    board[row][col] = new Block( 2 );
                    empty = false;
                }
            }

        }

    }
    public boolean isBoardFilled() {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getValue() > 0) {
                    count++;
                }
            }
        }
        if (count == grids * grids) {
            return true;
        }
        return false;
    }

    private int checkGameLost4x4() {
        int count = 0;
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                if ( board[i][j].getValue() > 0 )
                {
                    if ( i == 0 && j == 0 )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && j == 3 )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && j == 3 )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && j == 0 )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && ( j == 1 || j == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && ( j == 1 || j == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 0 && ( i == 1 || i == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 3 && ( i == 1 || i == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i][j - 1].getValue()
                                && board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else
                    {
                        if ( board[i][j].getValue() != board[i][j - 1].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    private int checkGameLost5x5() {
        int count = 0;
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                if ( board[i][j].getValue() > 0 )
                {
                    if ( i == 0 && j == 0 )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && j == 4 )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 4 && j == 4 )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 4 && j == 0 )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && ( j == 1 || j == 2 || j ==3 ) )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 4 && ( j == 1 || j == 2 || j == 3 ) )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 0 && ( i == 1 || i == 2 || i == 3 ) )
                    {
                        if ( board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 4 && ( i == 1 || i == 2 || i == 3) )
                    {
                        if ( board[i][j].getValue() != board[i][j - 1].getValue()
                                && board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else
                    {
                        if ( board[i][j].getValue() != board[i][j - 1].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    private int checkGameLost6x6() {
        int count = 0;
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                if ( board[i][j].getValue() > 0 )
                {
                    if ( i == 0 && j == 0 )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && j == 5 )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 5 && j == 5 )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 5 && j == 0 )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && ( j == 1 || j == 2 || j ==3 || j==4 ) )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 5 && ( j == 1 || j == 2 || j == 3 || j == 4 ) )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 0 && ( i == 1 || i == 2 || i == 3 || i == 4 ) )
                    {
                        if ( board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 5 && ( i == 1 || i == 2 || i == 3 || i == 4) )
                    {
                        if ( board[i][j].getValue() != board[i][j - 1].getValue()
                                && board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else
                    {
                        if ( board[i][j].getValue() != board[i][j - 1].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public boolean isGameLost()
    {
        int count = 0;
        switch (grids)
        {
            case 4:
                count = checkGameLost4x4();
                break;
            case 5:
                count = checkGameLost5x5();
                break;
            case 6:
                count = checkGameLost6x6();
                break;
            default:
                break;
        }
        return grids*grids == count;
    }


    public boolean up() {
        boolean moved = false;
        for (int i = 0; i < grids; i++) {
            border = 0;
            for (int j = 0; j < grids; j++) {
                if (board[j][i].getValue() != 0) {
                    if (border <= j) {
                        if (verticalMove(j, i, "up")) {
                            moved = true;
                        }
                    }
                }
            }
        }
        return moved;
    }
    public boolean down() {
        boolean moved = false;
        for (int i = 0; i < grids; i++) {
            border = (grids - 1);
            for (int j = grids - 1; j >= 0; j--) {
                if (board[j][i].getValue() != 0) {
                    if (border >= j) {
                        if (verticalMove(j, i, "down")) {
                            moved = true;
                        }
                    }
                }
            }
        }
        return moved;
    }

    public boolean left() {
        boolean moved = false;
        for (int i = 0; i < grids; i++) {
            border = 0;
            for (int j = 0; j < grids; j++) {
                if (board[i][j].getValue() != 0) {
                    if (border <= j) {
                        if (horizontalMove(i, j, "left")) {
                            moved = true;
                        }
                    }
                }
            }
        }
        return moved;
    }

    public boolean right() {
        boolean moved = false;
        for (int i = 0; i < grids; i++) {
            border = (grids - 1);
            for (int j = (grids - 1); j >= 0; j--) {
                if (board[i][j].getValue() != 0) {
                    if (border >= j) {
                        if (horizontalMove(i, j, "right")) {
                            moved = true;
                        }
                    }
                }
            }
        }
        return moved;
    }

    private boolean verticalMove(int row, int col, String direction) {
        Block initial = board[border][col];
        Block compare = board[row][col];
        boolean moved = false;
        if (initial.getValue() == 0 || initial.getValue() == compare.getValue()) {
            if (row > border || (direction.equals("down") && (row < border))) {
                int addScore = initial.getValue() + compare.getValue();
                if (initial.getValue() != 0) {
                    score += addScore;
                }
                initial.setValue(addScore);
                compare.setValue(0);
                moved = true;
            }
        } else {
            if (direction.equals("down")) {
                border--;
            } else {
                border++;
            }
            moved = verticalMove(row, col, direction);
        }
        return moved;
    }

    private boolean horizontalMove(int row, int col, String direction) {
        Block initial = board[row][border];
        Block compare = board[row][col];
        boolean moved = false;
        if (initial.getValue() == 0 || initial.getValue() == compare.getValue()) {
            if (col > border || (direction.equals("right") && (col < border))) {
                int addScore = initial.getValue() + compare.getValue();
                if (initial.getValue() != 0) {
                    score += addScore;
                }
                initial.setValue(addScore);
                compare.setValue(0);
                moved = true;
            }
        } else {
            if (direction.equals("right")) {
                border--;
            } else {
                border++;
            }
            moved = horizontalMove(row, col, direction);
        }
        return moved;
    }

}
