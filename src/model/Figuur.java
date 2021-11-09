package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Beschrijf de algemene eigenschappen van een figuur
 */
public class Figuur {
    protected static final double GRENSWAARDE_GROOT_FIGUUR = 100.0;
    protected static final String DEFAULT_KLEUR = "groen";

    protected String kleur;

    public Figuur(String kleur) {
        this.kleur = kleur;
    }

    public Figuur() {
       this(DEFAULT_KLEUR);
    }

    public static String geefDefinitie() {
        return "Een figuur is een verzameling punten.";
    }

    public double geefOmtrek() {
        return 0;
    }

    public double geefOppervlak() {
        return 0;
    }

    public String vertelOverGrootte() {
        if (geefOppervlak() > GRENSWAARDE_GROOT_FIGUUR) {
            return "Ik ben groot!!!";
        } else {
            return "Ik ben klein!!!";
        }
    }
}
