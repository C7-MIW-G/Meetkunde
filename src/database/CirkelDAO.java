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
public class CirkelDAO extends AbstractDAO {

    public CirkelDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public void slaCirkelOp(Cirkel cirkel) {
        String sql = "INSERT INTO figuur (kleur) VALUES (?);";
        int primaryKey = 0;
        try {
            setupPreparedStatementWithKey(sql);
            preparedStatement.setString(1, cirkel.getKleur());
            preparedStatement.executeUpdate();
            primaryKey = executeInsertStatementWithKey();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }


        String sqlCirkel = "INSERT INTO cirkel (figuurnummer, straal, xcoordinaat, ycoordinaat) VALUES (?, ?, ?, ?);";
        try {
            setupPreparedStatement(sqlCirkel);
            preparedStatement.setInt(1, primaryKey);
            preparedStatement.setDouble(2, cirkel.getStraal());
            preparedStatement.setDouble(3, cirkel.getMiddelpunt().getxCoordinaat());
            preparedStatement.setDouble(4, cirkel.getMiddelpunt().getyCoordinaat());
            executeManipulateStatement();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }
}
