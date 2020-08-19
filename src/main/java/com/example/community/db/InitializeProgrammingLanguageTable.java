package com.example.community.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InitializeProgrammingLanguageTable {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost/community";
        String user = "hibernate";
        String password = "hibernate";

        try (Connection connection =
                     DriverManager.getConnection(url, user, password)) {

            String countryData = System.getProperty("user.dir") + "/data/programming_languages.txt";

            try (BufferedReader reader = Files.newBufferedReader(Path.of(countryData))) {
                String language;

                while ((language = reader.readLine()) != null) {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO programming_language (name) VALUES (?);"
                    );
                    statement.setString(1, language);
                    statement.executeUpdate();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
