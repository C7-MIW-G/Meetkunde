package controller;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Spelen met de klassen uit het model
 */
public class MeetkundeLauncher {

    public static void main(String[] args) {
        ArrayList<String> regelsUitBestand = new ArrayList<>();
        File rechthoekenBestand = new File("resources/Rechthoek.csv");
        try {
            Scanner bestandsScanner = new Scanner(rechthoekenBestand);
            while (bestandsScanner.hasNextLine()) {
                regelsUitBestand.add(bestandsScanner.nextLine());
            }
        } catch (FileNotFoundException nietGevonden) {
            System.out.println("Het bestand is niet gevonden bestandsnaam: " + rechthoekenBestand.toString());
        }

        if (regelsUitBestand.size() > 0) {
            ArrayList<Rechthoek> rechthoeken = new ArrayList<>();
            for (String regelMetRechthoek : regelsUitBestand) {
                String[] regelArray = regelMetRechthoek.split(",");

                double lengte = Double.parseDouble(regelArray[0]);
                double breedte = Double.parseDouble(regelArray[1]);
                double xCoordinaat = Double.parseDouble(regelArray[2]);
                double yCoordinaat = Double.parseDouble(regelArray[3]);
                String kleur = regelArray[4];

                rechthoeken.add(new Rechthoek(lengte, breedte, new Punt(xCoordinaat, yCoordinaat), kleur));
            }

            for (Rechthoek rechthoek : rechthoeken) {
                System.out.println(rechthoek + "\n");
            }
        }
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
