package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Beschrijf de eigenschappen van een cirkel
 */
public class Cirkel {
    private static final double GRENSWAARDE_GROOT_FIGUUR = 100.0;
    private static final int DEFAULT_STRAAL = 1;
    private static final String DEFAULT_KLEUR = "roze";

    private double straal;
    private Punt middelpunt;
    private String kleur;

    public Cirkel(double straal, Punt middelpunt, String kleur) {
        setStraal(straal);
        this.middelpunt = middelpunt;
        this.kleur = kleur;
    }

    public Cirkel(double straal) {
        this(straal, new Punt(), DEFAULT_KLEUR);
    }

    public Cirkel() {
        this(DEFAULT_STRAAL);
    }

    public static String geefDefinitie() {
        return "Een cirkel is een verzameling punten, die allemaal dezelfde afstand tot een middelpunt hebben.";
    }

    public double geefOmtrek() {
        return 2 * Math.PI * straal;
    }

    public double geefOppervlak() {
        return Math.PI * straal * straal;
    }

    public String vertelOverGrootte() {
        if (geefOppervlak() > GRENSWAARDE_GROOT_FIGUUR) {
            return "Ik ben groot!!!";
        } else {
            return "Ik ben klein!!!";
        }
    }

    public double getStraal() {
        return straal;
    }

    public void setStraal(double straal) {
        if (straal <= 0) {
            System.out.println("De straal moet positief zijn. De straal wordt nu op 1 gezet.");
            this.straal = 1;
        } else {
            this.straal = straal;
        }
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public Punt getMiddelpunt() {
        return middelpunt;
    }
}
