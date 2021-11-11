package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Beschrijft een oppervlak waar meerdere figuren op getoond kunnen worden.
 */
public class Oppervlak {
    private double lengte;
    private double breedte;
    private ArrayList<Figuur> mijnFiguren;

    public Oppervlak(double lengte, double breedte) {
        this.lengte = lengte;
        this.breedte = breedte;
        mijnFiguren = new ArrayList<>();
    }

    public void voegFiguurToe(Figuur figuur) {
        if (figuurPastAlsVormInOppervlak(figuur)) {
            mijnFiguren.add(figuur);
            System.out.println("Dit figuur is toegevoegd");
        } else {
            System.out.println("Dit figuur is te groot");
        }
    }

    public boolean figuurPastAlsVormInOppervlak(Figuur figuur) {
        boolean past = false;

        if (figuur instanceof Rechthoek) {
            if (((Rechthoek) figuur).getLengte() <= lengte && ((Rechthoek) figuur).getBreedte() <= breedte) {
                past = true;
            }
        } else if (figuur instanceof Cirkel){
            if (((Cirkel) figuur).getStraal() <= breedte / 2) {
                past = true;
            }
        }

        return past;
    }

    @Override
    public String toString() {
        String eenReturn = "";

        Collections.sort(mijnFiguren);
        for (Figuur figuur : mijnFiguren) {
            eenReturn += figuur.toString() + "\n\n";
        }

        return eenReturn;
    }

    public ArrayList<Figuur> geefFigurenMetGrotereOppervlakte(double grenswaarde) {
        ArrayList<Figuur> gevraagdeFiguren = new ArrayList<>();

        for (Figuur figuur : mijnFiguren) {
            if (figuur.geefOppervlakte() > grenswaarde) {
                gevraagdeFiguren.add(figuur);
            }
        }

        return gevraagdeFiguren;
    }

    public ArrayList<Figuur> getMijnFiguren() {
        return mijnFiguren;
    }
}
