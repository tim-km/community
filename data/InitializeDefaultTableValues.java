import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class InitializeDefaultTableValues {

    private static String URL;
    private static String USER;
    private static String PASS;

    private static void initializeTable(String table) {

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASS)) {

            String countryData = table + ".txt";

            try (BufferedReader reader = Files.newBufferedReader(Path.of(countryData))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    // all tables have default column name
                    //noinspection SqlResolve
                    String query = "INSERT INTO " + table + " (name) VALUES (?)";

                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, line);
                    statement.executeUpdate();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("../src/main/resources/application.properties"));
            URL = properties.getProperty("spring.datasource.url");
            USER = properties.getProperty("spring.datasource.username");
            PASS = properties.getProperty("spring.datasource.password");
        } catch (IOException e) {
            e.printStackTrace();
        }

        initializeTable("country");
        initializeTable("programming_language");
        initializeTable("spoken_language");
        System.out.println(">>> OK");
    }
}
