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
        return new Object[][]{
                {positiveCaseArray1,true},
                {positiveCaseArray2,true},
                {negativeCaseArray1,false},
                {negativeCaseArray2,false},};}

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

        return new Object[][]{
                {positiveCaseArray1,'X'},
                {positiveCaseArray2,'0'},
                {negativeCaseArray1,' '},
                {negativeCaseArray2,' '},};}

    @Test(dataProvider = "testGameStatus")
    public void testGameStatus(char[][] array, char expected) {
        assertEquals(output.gameStatus(array), expected);
    }
}