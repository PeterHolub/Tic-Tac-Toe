package tictactoe;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class StaticTest {

    @DataProvider(name = "testPlayerMove")
    Object[][] getData() {
        //indexes to check for gameField after evoke
        int coords1[] = {0, 0};
        int coords2[] = {1, 0};
        int coords3[] = {2, 1};
        int coords4[] = {2, 2};
        return new Object[][]{
                {"1", 'X', coords1},
                {"4", '0', coords2},
                {"8", 'X', coords3},
                {"9", '0', coords4},

        };
    }


    @Test(dataProvider = "testPlayerMove")
    public void testPlayerMove(String fakeSystemIn, char playerAlias, int coords[]) throws IOException {
        //  variables for indexes assign from coords array
        int coordY ;
        int coordX ;
        // creating "fake" System.in , in case without this operation test will be in endless loop, because input data required from console
        ByteArrayInputStream in = new ByteArrayInputStream(fakeSystemIn.getBytes());
        // now System.in, when method scanner called,already have needed data
        System.setIn(in);
        //evoke of method, add player symbol to gameField array
        Static.playerMove(playerAlias);
//add number of indexes that needed to check
        coordY = coords[0];
        coordX = coords[1];
        Assert.assertEquals(Static.getGameField()[coordY][coordX], playerAlias);
    }
}