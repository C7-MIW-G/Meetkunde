package database;

import model.Punt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Haalt punten uit de database en kan ze wegschrijven
 */
public class PuntDAO extends AbstractDAO{

    public PuntDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public void slaPuntOp(Punt punt) {
        String sql = "INSERT INTO punt VALUES (?, ?);";
        try {
            setupPreparedStatement(sql);
            preparedStatement.setDouble(1, punt.getxCoordinaat());
            preparedStatement.setDouble(2, punt.getyCoordinaat());
            executeManipulateStatement();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }

    public ArrayList<Punt> getPunten() {
        ArrayList<Punt> punten = new ArrayList<>();
        String sql = "SELECT * FROM punt;";

        try {
            setupPreparedStatement(sql);
            ResultSet resultSet = executeSelectStatement();
            while (resultSet.next()) {
                double xCoordinaat = resultSet.getDouble("xcoordinaat");
                double yCoordinaat = resultSet.getDouble("ycoordinaat");
                punten.add(new Punt(xCoordinaat, yCoordinaat));
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }

        return punten;
    }
}
