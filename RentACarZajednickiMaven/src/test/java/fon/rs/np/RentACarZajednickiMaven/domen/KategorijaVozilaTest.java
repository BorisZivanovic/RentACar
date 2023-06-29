package fon.rs.np.RentACarZajednickiMaven.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KategorijaVozilaTest {

	private KategorijaVozila kategorija;
    
    @BeforeEach
    public void setUp() {
        kategorija = new KategorijaVozila(1L, "Limuzina", 100.0);
    }
    
    @AfterEach
    public void tearDown() {
        kategorija = null;
    }
    
    @Test
    public void testSetId() {
        Long expected = 2L;
        kategorija.setId(expected);
        Long result = kategorija.getId();
        assertEquals(expected, result);
    }
    
    @Test
    public void testSetNaziv() {
        String expected = "Kupe";
        kategorija.setNaziv(expected);
        String result = kategorija.getNaziv();
        assertEquals(expected, result);
    }
    
    @Test
    public void testSetCena() {
        double expected = 150.0;
        kategorija.setCena(expected);
        double result = kategorija.getCena();
        assertEquals(expected, result, 0.0);
    }
    
    @Test
    public void testToString() {
        String expected = "Limuzina";
        String result = kategorija.toString();
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 'limuzina', 1000.0, 1, 'limuzina', 1000.0, true",
            "1, 'limuzina', 1000.0, 2, 'kupe', 2000.0, false",
            "2, 'kupe', 2000.0, 1, 'limuzina', 1000.0, false",
            "2, 'kupe', 2000.0, 2, 'kupe', 2000.0, true",
    })
    void testEquals(Long id1, String naziv1, double cena1, Long id2, String naziv2, double cena2, Boolean res) {
        KategorijaVozila kategorija1 = new KategorijaVozila(id1, naziv1, cena1);
        KategorijaVozila kategorija2 = new KategorijaVozila(id2, naziv2, cena2);

        assertEquals(res, kategorija1.equals(kategorija2));
    }
}
    

