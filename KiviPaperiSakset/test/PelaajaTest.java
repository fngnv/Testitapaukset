import kivipaperisakset.Pelaaja;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PelaajaTest {
    @Test
    public void testaaValinta() {
        Pelaaja p = new Pelaaja();
        String valinta = p.teeValinta();
        assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"));
    }

    @Test
    public void testaaVoittojenKasvu() {
        Pelaaja p = new Pelaaja();
        int voitot = p.getVoitot();
        p.kasvataVoitot();
        assertTrue(p.getVoitot() == voitot + 1);
    }
}
