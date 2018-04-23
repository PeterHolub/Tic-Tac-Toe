package tictactoe;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Messages {

    public Properties getMessages() throws IOException {
        // Get the inputStream
        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream("messages.properties");

        Properties properties = new Properties();

        // load the inputStream using the Properties
        properties.load(inputStream);

        return properties;
    }
}




