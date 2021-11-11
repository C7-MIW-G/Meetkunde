package controller;

import model.*;

import java.util.ArrayList;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Spelen met de klassen uit het model
 */
public class MeetkundeLauncher {

    public static void main(String[] args) {
        Oppervlak oppervlak = new Oppervlak(10, 7);
        oppervlak.voegFiguurToe(new Rechthoek(3, 3, new Punt(0, 7), "rood"));
        oppervlak.voegFiguurToe(new Rechthoek(3, 2, new Punt(0, 4), "geel"));
        oppervlak.voegFiguurToe(new Rechthoek(5, 2, new Punt(0, 2), "groen"));
        oppervlak.voegFiguurToe(new Rechthoek(5, 2, new Punt(3, 7), "paars"));
        oppervlak.voegFiguurToe(new Rechthoek(11, 5, new Punt(5, 7), "oranje"));
        oppervlak.voegFiguurToe(new Rechthoek(5, 8, new Punt(5, 3), "blauw"));

        toonInformatieAlleFiguren(oppervlak.geefFigurenMetGrotereOppervlakte(20));
    }

    public static void toonInformatie(Figuur figuur) {
        System.out.println(figuur.toString());
        System.out.println(figuur.vertelOverGrootte());
    }

    public static void toonInformatieAlleFiguren(ArrayList<Figuur> figuren) {
        for (Figuur figuur : figuren) {
            toonInformatie(figuur);
            System.out.println();
        }
    }
}
