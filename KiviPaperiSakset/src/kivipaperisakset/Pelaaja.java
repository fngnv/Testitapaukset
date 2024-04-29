
package kivipaperisakset;

/**
 *
 * @author Ira Dook
 *
 * Luokka, joka sisältää pelaajan toiminnot
 *
 */
public class Pelaaja {
    private int voitot = 0;      // Voittojen lukumäärä

    /**
     * Metodi, joka arpoo pelaajan valinnan
     * @return pelaajan valinta
     */
    public String teeValinta() {
        String valinta = "";
        int c = (int) (Math.random() * 3);
        switch (c) {
            case 0:
                valinta = ("kivi");
                break;
            case 1:
                valinta = ("paperi");
                break;
            case 2:
                valinta = ("sakset");
                break;
        }
        return valinta;
    }

    /**
     * Metodi kasvattaa voittojen lukumäärää yhdellä
     */
    public void kasvataVoitot() {
        voitot ++;
    }

    /**
     * Metodi palauttaa pelaajan voittojen lukumäärän
     * @return voitettujen pelien määrä
     */
    public int getVoitot() {
        return (voitot);
    }
}
