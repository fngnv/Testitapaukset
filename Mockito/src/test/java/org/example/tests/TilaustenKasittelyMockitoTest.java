package org.example.tests;

import org.example.Asiakas;
import org.example.Tuote;
import org.example.IHinnoittelija;
import org.example.Tilaus;
import org.example.TilaustenKäsittely;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TilaustenKasittelyMockitoTest {
    @Mock
    IHinnoittelija hinnoittelijaMock;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testaaAlle100() {
        // Arrange
        float alkusaldo = 100.0f;
        float listaHinta = 50.0f;
        float alennus = 20.0f;
        float alennus5 = alennus + 5.0f;
        float loppuSaldo = alkusaldo - (listaHinta * (1 - alennus / 100));
        Asiakas asiakas = new Asiakas(alkusaldo);
        Tuote tuote = new Tuote("TDD in Action", listaHinta);

        // Mock behavior
        when(hinnoittelijaMock.getAlennusProsentti(asiakas, tuote)).thenAnswer(invocation -> {
            if (tuote.getHinta() >= 100) {
                return alennus5;
            } else {
                return alennus;
            }
        });

        // Act
        TilaustenKäsittely kasittelija = new TilaustenKäsittely();
        kasittelija.setHinnoittelija(hinnoittelijaMock);
        kasittelija.käsittele(new Tilaus(asiakas, tuote));

        // Assert
        assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
        verify(hinnoittelijaMock, atLeastOnce()).aloita();
        verify(hinnoittelijaMock, times(2)).getAlennusProsentti(asiakas, tuote);
        verify(hinnoittelijaMock, atLeastOnce()).lopeta();
    }

    @Test
    public void testaa100() {
        // Arrange
        float alkusaldo = 100.0f;
        float listaHinta = 100.0f;
        float alennus = 20.0f;
        float alennus5 = alennus + 5.0f;
        float loppuSaldo5 = alkusaldo - (listaHinta * (1 - alennus5 / 100));
        Asiakas asiakas = new Asiakas(alkusaldo);
        Tuote tuote = new Tuote("TDD in Action", listaHinta);

        // Mock behavior
        when(hinnoittelijaMock.getAlennusProsentti(asiakas, tuote)).thenAnswer(invocation -> {
            if (tuote.getHinta() >= 100) {
                return alennus5;
            } else {
                return alennus;
            }
        });

        // Act
        TilaustenKäsittely kasittelija = new TilaustenKäsittely();
        kasittelija.setHinnoittelija(hinnoittelijaMock);
        kasittelija.käsittele(new Tilaus(asiakas, tuote));

        // Assert
        assertEquals(loppuSaldo5, asiakas.getSaldo(), 0.001);
        verify(hinnoittelijaMock, atLeastOnce()).aloita();
        verify(hinnoittelijaMock, times(2)).getAlennusProsentti(asiakas, tuote);
        verify(hinnoittelijaMock, atLeastOnce()).lopeta();
    }

}
