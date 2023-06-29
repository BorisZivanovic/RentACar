package fon.rs.np.RentACarZajednickiMaven.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class VoziloTest {

	private Vozilo vozilo;

    @BeforeEach
    public void setUp() {
        vozilo = new Vozilo(1L, "BG123456", "Audi", "A3", StatusVozila.SLOBODNO, new KategorijaVozila(1L, "Kategorija", 100.0));
    }

    @AfterEach
    public void tearDown() {
        vozilo = null;
    }

    @Test
    public void testSetId() {
        Long expected = 2L;
        vozilo.setId(expected);
        Long result = vozilo.getId();
        assertEquals(expected, result);
    }
    
    @Test
    public void testSetMarka() {
        String expected = "BMW";
        vozilo.setMarka(expected);
        String result = vozilo.getMarka();
        assertEquals(expected, result);
    }
    
    @Test
    public void testSetModel() {
        String expected = "X5";
        vozilo.setModel(expected);
        String result = vozilo.getModel();
        assertEquals(expected, result);
    }
    
    @Test
    public void testSetStatusVozila() {
        StatusVozila expected = StatusVozila.ZAUZETO;
        vozilo.setStatusVozila(expected);
        StatusVozila result = vozilo.getStatusVozila();
        assertEquals(expected, result);
    }
    
    @Test
    public void testSetKategorijaVozila() {
        KategorijaVozila expected = new KategorijaVozila(2L, "Nova kategorija", 200.0);
        vozilo.setKategorijaVozila(expected);
        KategorijaVozila result = vozilo.getKategorijaVozila();
        assertEquals(expected, result);
    }
    
    @Test
    public void testSetRegistarskiBroj() {
        String expected = "NS654321";
        vozilo.setRegistarskiBroj(expected);
        String result = vozilo.getRegistarskiBroj();
        assertEquals(expected, result);
    }
    
    @Test
    public void testToString() {
        String expected = "BG123456";
        String result = vozilo.toString();
        assertEquals(expected, result);
    }
    
    @ParameterizedTest
    @CsvSource({
            "1,BG123456,Audi,A3,SLOBODNO,1,Kategorija,100.0,1,BG123456,Audi,A3,SLOBODNO,1,Kategorija,100.0,true",
            "1,BG123456,Audi,A3,SLOBODNO,1,Kategorija,100.0,2,BG123456,Audi,A3,SLOBODNO,1,Kategorija,100.0,true",
            "1,BG123456,Audi,A3,SLOBODNO,1,Kategorija,100.0,1,NS654321,BMW,X5,ZAUZETO,2,Nova kategorija,200.0,false"
    })
    public void testEquals(long id1, String registarskiBroj1, String marka1, String model1, String status1, long kategorijaId1,
                           String kategorijaNaziv1, double kategorijaCena1,
                           long id2, String registarskiBroj2, String marka2, String model2, String status2, long kategorijaId2,
                           String kategorijaNaziv2, double kategorijaCena2,
                           boolean expected) {
        Vozilo vozilo1 = new Vozilo(id1, registarskiBroj1, marka1, model1, StatusVozila.valueOf(status1), new KategorijaVozila(kategorijaId1, kategorijaNaziv1, kategorijaCena1));
        Vozilo vozilo2 = new Vozilo(id2, registarskiBroj2, marka2, model2, StatusVozila.valueOf(status2), new KategorijaVozila(kategorijaId2, kategorijaNaziv2, kategorijaCena2));

        boolean result = vozilo1.equals(vozilo2);
        assertEquals(expected, result);
    }
}
    

