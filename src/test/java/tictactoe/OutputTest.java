package tictactoe;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OutputTest {
    private Output output = new Output();

    @DataProvider(name = "testCanMove")
    Object[][] getData1() {
        char[][] positiveCaseArray1 =
                {{'*', '*', '*'},
                        {'*', '*', '*'},
                        {'*', '*', '*'}};
        char[][] positiveCaseArray2 =
                {{'*', '0', '*'},
                        {'*', '*', 'X'},
                        {'X', '0', '*'}};
        char[][] negativeCaseArray1 =
                {{'X', '0', 'X'},
                        {'0', '0', 'X'},
                        {'*', 'X', '0'}};
        char[][] negativeCaseArray2 =
                {{'X', 'X', '0'},
                        {'0', '0', 'X'},
                        {'X', '0', 'X'}};
        Object[][] obj = new Object[4][2];
        obj[0][0] = positiveCaseArray1;
        obj[0][1] = true;
        obj[1][0] = positiveCaseArray2;
        obj[1][1] = true;
        obj[2][0] = negativeCaseArray1;
        obj[2][1] = false;
        obj[3][0] = negativeCaseArray2;
        obj[3][1] = false;

        return obj;
    }

    @Test(dataProvider = "testCanMove")
    public void testCanMove(char[][] array, boolean expected) {
        //loop for make value more than 7 to make logic work to check fields (number 5 because we invoke setter 2 times by test provider)
        for (int i = 0; i < 5; i++) {
            Static.setNumberOfmoves();
        }
        assertEquals(output.canMove(array), expected);
    }

    @DataProvider(name = "testGameStatus")
    Object[][] getData2() {
        char[][] positiveCaseArray1 =
                {{'X', '0', '*'},
                        {'X', '0', '*'},
                        {'X', '*', '*'}};
        char[][] positiveCaseArray2 =
                {{'X', '0', '0'},
                        {'X', '0', 'X'},
                        {'0', 'X', '*'}};
        char[][] negativeCaseArray1 =
                {{'*', '*', '*'},
                        {'*', '*', '*'},
                        {'*', '*', '*'}};
        char[][] negativeCaseArray2 =
                {{'X', '0', 'X'},
                        {'0', '0', 'X'},
                        {'*', 'X', '0'}};

        Object[][] obj = new Object[4][2];
        obj[0][0] = positiveCaseArray1;
        obj[0][1] = 'X';
        obj[1][0] = positiveCaseArray2;
        obj[1][1] = '0';
        obj[2][0] = negativeCaseArray1;
        obj[2][1] = ' ';
        obj[3][0] = negativeCaseArray2;
        obj[3][1] = ' ';

        return obj;
    }

    @Test(dataProvider = "testGameStatus")
    public void testGameStatus(char[][] array, char expected) {
        assertEquals(output.gameStatus(array), expected);
    }
}