package tictactoe;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.ByteArrayInputStream;
import static org.testng.Assert.assertEquals;

public class InputTest {
    private Input input = new Input();

    @DataProvider(name = "testScanner")
    Object[][] getData1() {
        Object[][] obj = new Object[9][2];
        obj[0][0] = "1";
        obj[0][1] = "1";
        obj[1][0] = "2";
        obj[1][1] = "2";
        obj[2][0] = "3";
        obj[2][1] = "3";
        obj[3][0] = "4";
        obj[3][1] = "4";
        obj[4][0] = "5";
        obj[4][1] = "5";
        obj[5][0] = "6";
        obj[5][1] = "6";
        obj[6][0] = "7";
        obj[6][1] = "7";
        obj[7][0] = "8";
        obj[7][1] = "8";
        obj[8][0] = "9";
        obj[8][1] = "9";
        return obj;
    }

    @Test(dataProvider = "testScanner")
    public void testScanner(String fakeIn, String expected) {
        // creating "fake" System.in , in case without this operation test will be in endless loop, because input data required from console
        ByteArrayInputStream in = new ByteArrayInputStream(fakeIn.getBytes());
        // now System.in, when method scanner called,already have needed data
        System.setIn(in);
        assertEquals(input.scanner(), expected);
        //return System.in to normal
        System.setIn(System.in);
    }

    @DataProvider(name = "testAlias")
    Object[][] getData2() {
        int[] array1 = {0, 0};
        int[] array2 = {0, 1};
        int[] array3 = {0, 2};
        int[] array4 = {1, 0};
        int[] array5 = {1, 1};
        int[] array6 = {1, 2};
        int[] array7 = {2, 0};
        int[] array8 = {2, 1};
        int[] array9 = {2, 2};
        Object[][] obj = new Object[9][2];
        obj[0][0] = "1";
        obj[0][1] = array1;
        obj[1][0] = "2";
        obj[1][1] = array2;
        obj[2][0] = "3";
        obj[2][1] = array3;
        obj[3][0] = "4";
        obj[3][1] = array4;
        obj[4][0] = "5";
        obj[4][1] = array5;
        obj[5][0] = "6";
        obj[5][1] = array6;
        obj[6][0] = "7";
        obj[6][1] = array7;
        obj[7][0] = "8";
        obj[7][1] = array8;
        obj[8][0] = "9";
        obj[8][1] = array9;

        return obj;
    }

    @Test(dataProvider = "testAlias")
    public void testAlias(String actual, int[] expected) {
        assertEquals(input.alias(actual), expected);
    }
}