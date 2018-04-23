package tictactoe;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

@SuppressWarnings("Duplicates")
public class MainTest {

    @DataProvider(name = "testMain")
    Object[][] getData1() {

        String[] drawMoves = new String[]{"1", "2", "3", "5", "6", "7", "8", "9"};
        ByteArrayInputStream[] inputStreamsDraw = new ByteArrayInputStream[8];
        String[] xWinMoves = new String[]{"1", "3", "4", "6", "7"};
        ByteArrayInputStream[] inputStreamsXWin = new ByteArrayInputStream[5];

        String[] win0Moves = new String[]{"1", "2", "3", "5", "4", "7", "6", "8"};
        ByteArrayInputStream[] inputStreams0Win = new ByteArrayInputStream[8];

        return new Object[][]{
                {drawMoves, inputStreamsDraw, "Draw!"},
//                {xWinMoves, inputStreamsXWin, "Player X win!", winX},
//                {win0Moves, inputStreams0Win, "Player 0 win!", win0},
        };
    }


    @Test(dataProvider = "testMain")
    public void testMain(String[] resultMoves, ByteArrayInputStream[] inputStreams, String expected) throws IOException {
        Main main = new Main();
        Output output = new Output();
        Messages messages = new Messages();
        int stringArrayIndex = -1;
        int inputStreamIndex = -1;

        //setting instance for "data catch" from System.out.println
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        //reproduction of game logic (similar to Main method in Main class
        while (output.gameStatus(Static.getGameField()) == ' ' && output.canMove(Static.getGameField())) {
            //prefix increment for array's index! Each index from resultMoves must be changed after Player Move simulation as well as InputStream
            ++stringArrayIndex;
            ++inputStreamIndex;

            inputStreams[inputStreamIndex] = new ByteArrayInputStream(resultMoves[stringArrayIndex].getBytes());
            System.setIn(inputStreams[inputStreamIndex]);

            main.playersMovement(Static.PLAYER_ONE_ALIAS);

            if (output.gameStatus(Static.getGameField()) == Static.PLAYER_ONE_ALIAS) {
                System.out.println(messages.getMessages().getProperty("xWin"));
                break;
            }

            ++stringArrayIndex;
            ++inputStreamIndex;

            inputStreams[inputStreamIndex] = new ByteArrayInputStream(resultMoves[stringArrayIndex].getBytes());
            System.setIn(inputStreams[inputStreamIndex]);

            main.playersMovement(Static.PLAYER_TWO_ALIAS);


            if (output.gameStatus(Static.getGameField()) == Static.PLAYER_TWO_ALIAS) {
                System.out.println(messages.getMessages().getProperty("0Win"));
                break;
            }

            if (output.gameStatus(Static.getGameField()) == ' ' && !output.canMove(Static.getGameField())) {
                System.out.println(messages.getMessages().getProperty("draw"));
                break;
            }
        }

        //Writing  all data from System.out.println to variable actual
        String actual = buffer.toString();

//if from all out dataregex find expected value, there will be tru and assigned  to actual (this do for assertEquals proper work)
        if (actual.matches("(?s)(?i).*" + expected + ".*")) {

            actual = expected;
//if false,  actual will get value "Failed " and assigned to actual for assertEquals test fail;
        } else {
            actual = "Failed";
        }

        assertEquals(actual, expected);
        System.setIn(System.in);
        System.setOut(System.out);
    }
}