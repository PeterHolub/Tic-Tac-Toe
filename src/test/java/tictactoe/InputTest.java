package tictactoe;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.assertEquals;

public class InputTest {
    private Input input = new Input();

    @DataProvider(name = "testScanner")
    Object[][] getData1() {
        return new Object[][]{
                {"1","1"},
                {"2","2"},
                {"3","3"},
                {"4","4"},
                {"5","5"},
                {"6","6"},
                {"7","7"},
                {"8","8"},
                {"9","9"},};
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
        return new Object[][]{
                {"1", array1},
                {"2", array2},
                {"3", array3},
                {"4", array4},
                {"5", array5},
                {"6", array6},
                {"7", array7},
                {"8", array8},
                {"9", array9},};
    }

    @Test(dataProvider = "testAlias")
    public void testAlias(String actual, int[] expected) {
        assertEquals(input.alias(actual), expected);
    }
}