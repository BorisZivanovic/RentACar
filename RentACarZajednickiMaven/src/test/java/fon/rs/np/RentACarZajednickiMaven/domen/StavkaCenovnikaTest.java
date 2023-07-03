package fon.rs.np.RentACarZajednickiMaven.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StavkaCenovnikaTest {

	private StavkaCenovnika stavka;

    @BeforeEach
    public void setUp() {
        Cenovnik cenovnik = new Cenovnik(1L, "Cenovnik 1", "Opis cenovnika 1");
        stavka = new StavkaCenovnika(1L, "Stavka 1", "Opis stavke 1", 100.0, cenovnik);
    }

    @AfterEach
    public void tearDown() {
        stavka = null;
    }
	
    @Test
    public void testSetId() {
        Long expectedId = 2L;
        stavka.setId(expectedId);
        Long actualId = stavka.getId();
        assertEquals(expectedId, actualId);
    }
    
    @Test
    public void testSetNaziv() {
        String expectedNaziv = "Stavka 2";
        stavka.setNaziv(expectedNaziv);
        String actualNaziv = stavka.getNaziv();
        assertEquals(expectedNaziv, actualNaziv);
    }
    
    @Test
    public void testSetOpis() {
        String expectedOpis = "Opis stavke 2";
        stavka.setOpis(expectedOpis);
        String actualOpis = stavka.getOpis();
        assertEquals(expectedOpis, actualOpis);
    }
    
    @Test
    public void testSetCena() {
        double expectedCena = 200.0;
        stavka.setCena(expectedCena);
        double actualCena = stavka.getCena();
        assertEquals(expectedCena, actualCena, 0.001);
    }

    @Test
    public void testSetCenovnik() {
        Cenovnik expectedCenovnik = new Cenovnik(2L, "Cenovnik 2", "Opis cenovnika 2");
        stavka.setCenovnik(expectedCenovnik);
        Cenovnik actualCenovnik = stavka.getCenovnik();
        assertEquals(expectedCenovnik, actualCenovnik);
    }

    @Test
    public void testToString() {
        String expectedString = "Cenovnik 1 - Stavka 1";
        String actualString = stavka.toString();
        assertEquals(expectedString, actualString);
    }
    
    @Test
    void setId_NegativanId_Izuzetak() {
        StavkaCenovnika stavka = new StavkaCenovnika();

        assertThrows(IllegalArgumentException.class, () -> stavka.setId(-1L));
    }

    @Test
    void setNaziv_KraciNull() {
        StavkaCenovnika stavka = new StavkaCenovnika();

        assertThrows(NullPointerException.class, () -> stavka.setNaziv(null));
    }
    
    @Test
    void setNaziv_KraciOdDvaKaraktera_Izuzetak() {
        StavkaCenovnika stavka = new StavkaCenovnika();

        assertThrows(IllegalArgumentException.class, () -> stavka.setNaziv("S"));
    }

    @Test
    void setOpis_KraciNull() {
        StavkaCenovnika stavka = new StavkaCenovnika();

        assertThrows(NullPointerException.class, () -> stavka.setNaziv(null));
    }
    
    @Test
    void setOpis_KraciOdDvaKaraktera_Izuzetak() {
        StavkaCenovnika stavka = new StavkaCenovnika();

        assertThrows(IllegalArgumentException.class, () -> stavka.setOpis("O"));
    }

    @Test
    void setCena_NegativnaCena_Izuzetak() {
        StavkaCenovnika stavka = new StavkaCenovnika();

        assertThrows(IllegalArgumentException.class, () -> stavka.setCena(-1000.0));
    }

    @Test
    void setCenovnik_NullCenovnik_Izuzetak() {
        StavkaCenovnika stavka = new StavkaCenovnika();

        assertThrows(IllegalArgumentException.class, () -> stavka.setCenovnik(null));
    }

    @Test
    void setCenovnik_CenovnikBezId_Izuzetak() {
        StavkaCenovnika stavka = new StavkaCenovnika();
        Cenovnik cenovnik = new Cenovnik(0L, "", "Opis cenovnika");

        assertThrows(IllegalArgumentException.class, () -> stavka.setCenovnik(cenovnik));
    }

    @Test
    void setCenovnik_CenovnikBezNaziva_Izuzetak() {
        StavkaCenovnika stavka = new StavkaCenovnika();
        Cenovnik cenovnik = new Cenovnik(1L, "", "Opis cenovnika");

        assertThrows(IllegalArgumentException.class, () -> stavka.setCenovnik(cenovnik));
    }

    @Test
    void setCenovnik_CenovnikBezOpisa_Izuzetak() {
        StavkaCenovnika stavka = new StavkaCenovnika();
        Cenovnik cenovnik = new Cenovnik(1L, "Cenovnik", "");

        assertThrows(IllegalArgumentException.class, () -> stavka.setCenovnik(cenovnik));
    }
    
}
