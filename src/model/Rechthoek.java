package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Beschrijft de figuur rechthoek
 */
public class Rechthoek {
    private static final double GRENSWAARDE_GROOT_FIGUUR = 100.0;
    private static final double DEFAULTWAARDE_LENGTE = 2;
    private static final double DEFAULTWAARDE_BREEDTE = 1;
    private static final String DEFAULTWAARDE_KLEUR = "oranje";

    private double lengte;
    private double breedte;
    private Punt hoekpuntLinksboven;
    private String kleur;

    public Rechthoek(double lengte, double breedte, Punt hoekpuntLinksboven, String kleur) {
        this.lengte = lengte;
        this.breedte = breedte;
        this.hoekpuntLinksboven = hoekpuntLinksboven;
        this.kleur = kleur;
    }

    public Rechthoek(double lengte, double breedte) {
        this(lengte, breedte, new Punt(), DEFAULTWAARDE_KLEUR);
    }

    public Rechthoek() {
        this(DEFAULTWAARDE_LENGTE, DEFAULTWAARDE_BREEDTE);
    }

    public static String geefDefinitie() {
        return "Een rechthoek is een vierhoek met vier rechte hoeken.";
    }

    public double geefOmtrek() {
        return 2 * (lengte + breedte);
    }

    public double geefOppervlak() {
        return lengte * breedte;
    }

    public String vertelOverGrootte() {
        if (geefOppervlak() > GRENSWAARDE_GROOT_FIGUUR) {
            return "Ik ben groot!!!";
        } else {
            return "Ik ben klein!!!";
        }
    }

    public Punt getHoekpuntLinksboven() {
        return hoekpuntLinksboven;
    }
}
