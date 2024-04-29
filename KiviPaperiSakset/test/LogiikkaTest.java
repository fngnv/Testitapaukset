import kivipaperisakset.Pelaaja;
import kivipaperisakset.PelinLogiikka;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LogiikkaTest {
    private PelinLogiikka pelinLogiikka;
    private Pelaaja p1;
    private Pelaaja p2;

    @Test
    public void testPelaaja1Voittaa() {
        p1 = new PelaajaStub("kivi");
        p2 = new PelaajaStub("sakset");
        pelinLogiikka = new PelinLogiikka(p1, p2);
        // Run the method under test
        pelinLogiikka.pelaa();

        // Verify that the correct methods were called on the stub objects
        assertEquals(3, p1.getVoitot());
        assertEquals(0, p2.getVoitot());
    }

    @Test
    public void testPelaaja2Voittaa() {
        p1 = new PelaajaStub("paperi");
        p2 = new PelaajaStub("sakset");
        pelinLogiikka = new PelinLogiikka(p1, p2);
        // Run the method under test
        pelinLogiikka.pelaa();

        // Verify that the correct methods were called on the stub objects
        assertEquals(0, p1.getVoitot());
        assertEquals(3, p2.getVoitot());
    }

    // Stub class for Pelaaja
    class PelaajaStub extends Pelaaja {
        private String valinta;

        PelaajaStub(String valinta) {
            this.valinta = valinta;
        }

        @Override
        public String teeValinta() {
            return valinta;
        }
    }


}
