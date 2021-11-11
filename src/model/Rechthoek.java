package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Beschrijft de figuur rechthoek
 */
public class Rechthoek extends Figuur {
    private static final double DEFAULTWAARDE_LENGTE = 2;
    private static final double DEFAULTWAARDE_BREEDTE = 1;

    private double lengte;
    private double breedte;
    private Punt hoekpuntLinksboven;

    public Rechthoek(double lengte, double breedte, Punt hoekpuntLinksboven, String kleur) {
        super(kleur);
        this.lengte = lengte;
        this.breedte = breedte;
        this.hoekpuntLinksboven = hoekpuntLinksboven;
    }

    public Rechthoek(double lengte, double breedte) {
        this(lengte, breedte, new Punt(), DEFAULT_KLEUR);
    }

    public Rechthoek() {
        this(DEFAULTWAARDE_LENGTE, DEFAULTWAARDE_BREEDTE);
    }

    public static String geefDefinitie() {
        return "Een rechthoek is een vierhoek met vier rechte hoeken.";
    }

    @Override
    public double geefOmtrek() {
        return 2 * (lengte + breedte);
    }

    @Override
    public double geefOppervlakte() {
        return lengte * breedte;
    }

    @Override
    public String toString() {
        return String.format("%s\nLengte: %.4f\nBreedte: %.4f\nHoekpuntLinksboven: %s", super.toString(), this.lengte, this.breedte, this.hoekpuntLinksboven);
    }

    public Punt getHoekpuntLinksboven() {
        return hoekpuntLinksboven;
    }

    public double getLengte() {
        return lengte;
    }

    public double getBreedte() {
        return breedte;
    }
}
