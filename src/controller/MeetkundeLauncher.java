package controller;

import model.Cirkel;
import model.Punt;
import model.Rechthoek;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Spelen met de klassen uit het model
 */
public class MeetkundeLauncher {

    public static void main(String[] args) {

        Cirkel[] mijnCirkelArray = new Cirkel[3];
        mijnCirkelArray[0] = new Cirkel(3, new Punt(1, 4), "groen");
        mijnCirkelArray[1] = new Cirkel();
        mijnCirkelArray[2] = new Cirkel(6);

        for (Cirkel cirkel : mijnCirkelArray) {
            System.out.println(cirkel.geefOmtrek());
            System.out.println(cirkel.geefOppervlakte());
            System.out.println(cirkel.getMiddelpunt().getxCoordinaat());
            System.out.println(cirkel.getMiddelpunt().getyCoordinaat());
            System.out.println(cirkel.vertelOverGrootte());
        }

        System.out.println(Rechthoek.geefDefinitie());
        Rechthoek[] mijnRechthoekArray = new Rechthoek[3];
        mijnRechthoekArray[0] = new Rechthoek(4, 3, new Punt(2,5), "blauw");
        mijnRechthoekArray[1] = new Rechthoek();
        mijnRechthoekArray[2] = new Rechthoek(25, 10);

        for (Rechthoek rechthoek : mijnRechthoekArray) {
            System.out.println(rechthoek.geefOmtrek());
            System.out.println(rechthoek.geefOppervlakte());
            System.out.println(rechthoek.getHoekpuntLinksboven().getxCoordinaat());
            System.out.println(rechthoek.getHoekpuntLinksboven().getyCoordinaat());
            System.out.println(rechthoek.vertelOverGrootte());
        }
    }
}
