package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Beschrijf de algemene eigenschappen van een figuur
 */
public abstract class Figuur implements ToelaatbaarInOppervlak, Comparable<Figuur> {
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

    public abstract double geefOmtrek();

    public abstract double geefOppervlakte();

    public String vertelOverGrootte() {
        if (geefOppervlakte() > GRENSWAARDE_GROOT_FIGUUR) {
            return "Ik ben groot!!!";
        } else {
            return "Ik ben klein!!!";
        }
    }

    @Override
    public String toString() {
        return String.format("Kleur: %s\nOmtrek: %.4f\nOppervlakte: %.4f",
                this.kleur, this.geefOmtrek(), this.geefOppervlakte());
    }

    @Override
    public int compareTo(Figuur anderFiguur) {
        if (this.geefOppervlakte() > anderFiguur.geefOppervlakte()) {
            return 1;
        } else if (this.geefOppervlakte() < anderFiguur.geefOppervlakte()) {
            return -1;
        } else {
            return 0;
        }
    }

    public String getKleur() {
        return kleur;
    }
}
