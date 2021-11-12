package controller;

import java.time.LocalDate;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Spelen met tijd
 */
public class TijdsLauncher {

    public static void main(String[] args) {
        LocalDate vandaag = LocalDate.now();
        System.out.println(vandaag);

        LocalDate beginVan2021 = LocalDate.parse("2021-01-01");
        if(vandaag.plusDays(50).isAfter(LocalDate.parse("2021-12-25"))) {
            System.out.println("Kerst is al geweest, je bent te laat");
        } else {
            System.out.println("Wees gerust je hebt nog tijd!");
        }
    }


}
