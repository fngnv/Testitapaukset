package kivipaperisakset;

/**
 *
 * @author Ira Dook
 *
 * Ohjelman pääluokka, joka käynnistää pelin
 */
public class Peli {

    public static void main(String args[]) {
        // Luodaan peli ja pelataan
        PelinLogiikka peli = new PelinLogiikka(new Pelaaja(), new Pelaaja());
        peli.pelaa();
    }
}
