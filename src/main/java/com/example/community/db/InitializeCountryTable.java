package com.example.community.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;

public class InitializeCountryTable {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost/community";
        String user = "hibernate";
        String password = "hibernate";

        try (Connection connection =
                     DriverManager.getConnection(url, user, password)) {

            String countryData = System.getProperty("user.dir") + "/data/countries.txt";

            try (BufferedReader reader = Files.newBufferedReader(Path.of(countryData))) {
                String country;

                while ((country = reader.readLine()) != null) {
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO country (name) VALUES (?);"
                    );
                    statement.setString(1, country);
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
