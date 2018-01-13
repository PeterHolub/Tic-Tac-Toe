package tictactoe;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;

import static org.testng.Assert.*;

public class StaticTest {


    @Test
    public void testPlayerMove() throws NoSuchFieldException {
        // creating "fake" System.in , in case without this operation test will be in endless loop, because input data required from console
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        // now System.in, when method scanner called,already have needed data
        System.setIn(in);
        //Reflection
        Static aStatic = new Static();
        Class clazz = aStatic.getClass();
        Field field = clazz.getDeclaredField("gameField");
        //field.setAccessible(true);

//assertEquals(Static.playerMove('X'),);

    }
}