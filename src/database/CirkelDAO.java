package database;

import model.Cirkel;
import model.Rechthoek;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Haalt Cirkels uit de database en kan ze wegschrijven
 */
public class CirkelDAO {

    private DBaccess dBaccess;

    public CirkelDAO(DBaccess dBaccess) {
        this.dBaccess = dBaccess;
    }

    public void slaCirkelOp(Cirkel cirkel) {
        String sql = "INSERT INTO figuur (kleur) VALUES (?);";
        int primaryKey = 0;
        try {
            PreparedStatement preparedStatement = dBaccess.getConnection()
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cirkel.getKleur());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                primaryKey = resultSet.getInt(1);
                System.out.printf("De toegevoegde sleutel is %d\n", primaryKey);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }


        String sqlCirkel = "INSERT INTO cirkel (figuurnummer, straal, xcoordinaat, ycoordinaat) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sqlCirkel);
            preparedStatement.setInt(1, primaryKey);
            preparedStatement.setDouble(2, cirkel.getStraal());
            preparedStatement.setDouble(3, cirkel.getMiddelpunt().getxCoordinaat());
            preparedStatement.setDouble(4, cirkel.getMiddelpunt().getyCoordinaat());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }
}
