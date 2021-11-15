package controller;

import database.DBaccess;
import database.PuntDAO;
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

        DBaccess dBaccess = new DBaccess(databaseName, mainUser, mainUserPassword);
        dBaccess.openConnection();

        PuntDAO puntDAO = new PuntDAO(dBaccess);
        puntDAO.slaPuntOp(new Punt(4, -2));

        ArrayList<Punt> punten = puntDAO.getPunten();
        for (Punt punt : punten) {
            System.out.println(punt + "\n");
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
