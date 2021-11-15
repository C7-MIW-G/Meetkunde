package controller;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Spelen met de klassen uit het model
 */
public class MeetkundeLauncher {
    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PREFIX_CONNECTION_URL = "jdbc:mysql://localhost:3306/";
    private static final String CONNECTION_SETTINGS = "?useSSL=false" +
            "&allowPublicKeyRetrieval=true" +
            "&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false" +
            "&serverTimezone=UTC";

    public static void main(String[] args) {
        String databaseName = "Figuren";
        String mainUser = "userFiguren";
        String mainUserPassword = "userFigurenPW";

        String connectionURL = PREFIX_CONNECTION_URL + databaseName + CONNECTION_SETTINGS;
        Connection connection = null;
        try {
            Class.forName(MYSQL_DRIVER);
            connection = DriverManager.getConnection(connectionURL, mainUser, mainUserPassword);
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Driver niet gevonden.");
        } catch (SQLException sqlException) {
            System.out.println("SQL Exception: " + sqlException.getMessage());
        }

        if (connection != null) {
            System.out.println("De verbinding is gemaakt!");
            String sql = "SELECT * FROM punt WHERE xcoordinaat > 0;";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    double xCoordinaat = resultSet.getDouble("xcoordinaat");
                    double yCoordinaat = resultSet.getDouble("ycoordinaat");
                    System.out.println(new Punt(xCoordinaat, yCoordinaat));
                }
                connection.close();
            } catch (SQLException sqlException) {
                System.out.println(sqlException);
            }

        }
    }

    public static void toonInformatie(Figuur figuur) {
        System.out.println(figuur.toString());
        System.out.println(figuur.vertelOverGrootte());
    }

    public static void toonInformatieAlleFiguren(ArrayList<Figuur> figuren) {
        for (Figuur figuur : figuren) {
            toonInformatie(figuur);
            System.out.println();
        }
    }
}
