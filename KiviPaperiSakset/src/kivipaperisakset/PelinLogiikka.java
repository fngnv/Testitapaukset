package kivipaperisakset;

/**
 *
 * @author Vera F
 *
 * Luokka, joka sisältää pelin logiikan
 */
public class PelinLogiikka {
    private Pelaaja p1;
    private Pelaaja p2;
    private boolean peliLoppui = false;
    private int pelatutPelit = 0;
    private int tasapelit = 0;
    private String p1Valinta;
    private String p2Valinta;
    private int maxVoitot = 3;

    public PelinLogiikka(Pelaaja p1, Pelaaja p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Metodi, joka käynnistää pelin, ja simuloi pelikierroksia,
     * kunnes jompikumpi pelaajista saavuttaa 3 voittoa
     */
    public void pelaa() {
        while(!peliLoppui) {
            pelatutPelit ++;
            System.out.println("Erä: "
                    + pelatutPelit + " =====================\n");

            teeValinta();
            tarkistaVoittaja();
            tulostaTilanne();
            tarkistaPeliLoppui();
        }
    }

    /**
     * Metodi, joka arpoo pelaajille valinnat ja tulostaa ne
     */
    private void teeValinta() {
        p1Valinta = p1.teeValinta();
        p2Valinta = p2.teeValinta();

        System.out.println("Pelaaja 1: " + p1Valinta);
        System.out.println("Pelaaja 2: " + p2Valinta);
    }

    /**
     * Metodi, joka tarkistaa kumpi pelaajista voittaa kierroksen heidän valintansa prusteella
     * Metodi ottaa huomioon myös tasapelin mahdollisuuden
     */
    private void tarkistaVoittaja() {
        if ((p1Valinta.equals("kivi")) && (p2Valinta.equals("paperi"))) {
            System.out.println("\n\t\t\t Pelaaja 2 voittaa \n");
            p2.kasvataVoitot();
        } else if ((p1Valinta.equals("paperi")) && (p2Valinta.equals("kivi"))) {
            p1.kasvataVoitot();
            System.out.println("\n\t\t\t Pelaaja 1 voittaa \n");
        } else if ((p1Valinta.equals("kivi")) && (p2Valinta.equals("sakset"))) {
            p1.kasvataVoitot();
            System.out.println("\n\t\t\t Pelaaja 1 voittaa \n");
        } else if ((p1Valinta.equals("sakset")) && (p2Valinta.equals("kivi"))) {
            p2.kasvataVoitot();
            System.out.println("\n\t\t\t Pelaaja 2 voittaa \n");
        } else if ((p1Valinta.equals("sakset")) && (p2Valinta.equals("paperi"))) {
            p1.kasvataVoitot();
            System.out.println("\n\t\t\t Pelaaja 1 voittaa \n");
        } else if ((p1Valinta.equals("paperi")) && (p2Valinta.equals("sakset"))) {
            p2.kasvataVoitot();
            System.out.println("\n\t\t\t Pelaaja 2 voittaa \n");
        }
        if (p1Valinta == p2Valinta) {
            tasapelit++;
            System.out.println("\n\t\t\t Tasapeli \n");
        }
    }

    /**
     * Metodi, joka tulostaa molempien pelaajien voitot ja tasapelien lukumäärän
     */
    private void tulostaTilanne() {
        System.out.println("Tasapelien lukumäärä: "
                + tasapelit);
        System.out.println("Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
        System.out.println("Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.");
    }

    /**
     * Metodi, joka tarkistaa onko jompikumpi pelaajista saavuttanut 3 voittoa, jollon peli loppuu
     */
    private void tarkistaPeliLoppui() {
        if ((p1.getVoitot() >= maxVoitot) || (p2.getVoitot() >= maxVoitot)) {
            peliLoppui = true;
            System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
        }
    }
}
