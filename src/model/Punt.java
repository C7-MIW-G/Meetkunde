package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Beschrijft een wiskundig punt
 */
public class Punt {
    private static final double DEFAULT_X_COORDINAAT = 0;
    private static final double DEFAULT_Y_COORDINAAT = 0;

    private double xCoordinaat;
    private double yCoordinaat;

    public Punt(double xCoordinaat, double yCoordinaat) {
        this.xCoordinaat = xCoordinaat;
        this.yCoordinaat = yCoordinaat;
    }

    public Punt() {
        this(DEFAULT_X_COORDINAAT, DEFAULT_Y_COORDINAAT);
    }

    public double getxCoordinaat() {
        return xCoordinaat;
    }

    public double getyCoordinaat() {
        return yCoordinaat;
    }
}
