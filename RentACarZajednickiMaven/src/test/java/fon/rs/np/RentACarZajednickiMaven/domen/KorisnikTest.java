package fon.rs.np.RentACarZajednickiMaven.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KorisnikTest {

	private Korisnik korisnik;
    private Mesto mesto;

    @BeforeEach
    void setUp() {
        Long id = 1L;
        String ime = "Marko";
        String prezime = "Markovic";
        Long jmbg = 1234567890123L;
        String datumRodjenjaStr = "1990-01-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date datumRodjenja = null;
        try {
            datumRodjenja = sdf.parse(datumRodjenjaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mesto = new Mesto(1L, "Beograd");

        korisnik = new Korisnik(id, ime, prezime, jmbg, datumRodjenja, mesto);
    }

    @AfterEach
    void tearDown() {
        korisnik = null;
        mesto = null;
    }
    
    @Test
    void testKonstruktorSaSvimAtributima() {
        Long id = korisnik.getId();
        String ime = korisnik.getIme();
        String prezime = korisnik.getPrezime();
        Long jmbg = korisnik.getJMBG();
        Date datumRodjenja = korisnik.getDatumRodjenja();
        Mesto mesto = korisnik.getMesto();

        assertNotNull(korisnik);
        assertEquals(id, korisnik.getId());
        assertEquals(ime, korisnik.getIme());
        assertEquals(prezime, korisnik.getPrezime());
        assertEquals(jmbg, korisnik.getJMBG());
        assertEquals(datumRodjenja, korisnik.getDatumRodjenja());
        assertEquals(mesto, korisnik.getMesto());
    }
    
    @Test
    void testKonstruktorSaImenomIPrezimenom() {
        String ime = "Ana";
        String prezime = "Anic";
        Long jmbg = 9876543210987L;
        Date datumRodjenja = korisnik.getDatumRodjenja();

        Korisnik korisnik = new Korisnik(ime, prezime, jmbg, datumRodjenja, mesto);

        assertNotNull(korisnik);
        assertNull(korisnik.getId());
        assertEquals(ime, korisnik.getIme());
        assertEquals(prezime, korisnik.getPrezime());
        assertEquals(jmbg, korisnik.getJMBG());
        assertEquals(datumRodjenja, korisnik.getDatumRodjenja());
        assertEquals(mesto, korisnik.getMesto());
    }
    
    @Test
    void testSetId() {
        Long id = 2L;

        korisnik.setId(id);

        assertEquals(id, korisnik.getId());
    }
    
    @Test
    void testSetIme() {
        String ime = "Petar";

        korisnik.setIme(ime);

        assertEquals(ime, korisnik.getIme());
    }
    
    @Test
    void testSetPrezime() {
        String prezime = "Petrovic";

        korisnik.setPrezime(prezime);

        assertEquals(prezime, korisnik.getPrezime());
    }
    
    @Test
    void testSetJMBG() {
        Long jmbg = 9876543210987L;

        korisnik.setJMBG(jmbg);

        assertEquals(jmbg, korisnik.getJMBG());
    }
    
    @Test
    void testSetDatumRodjenja() {
        String datumRodjenjaStr = "1995-05-05";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date datumRodjenja = null;
        try {
            datumRodjenja = sdf.parse(datumRodjenjaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        korisnik.setDatumRodjenja(datumRodjenja);

        assertEquals(datumRodjenja, korisnik.getDatumRodjenja());
    }

    @Test
    void testSetMesto() {
        Mesto novoMesto = new Mesto(2L, "Novi Sad");

        korisnik.setMesto(novoMesto);

        assertEquals(novoMesto, korisnik.getMesto());
    }
    
    @Test
    void testToString() {
        Korisnik korisnik = new Korisnik("Marko", "Markovic");
        String expectedString = "Marko Markovic";
        String actualString = korisnik.toString();
        assertEquals(expectedString, actualString);
    }
    
    @ParameterizedTest
    @CsvSource({
        "1, Marko, Markovic, 1, Marko, Markovic, true",
        "2, Janko, Jankovic, 2, Janko, Jankovic, true"
    })
    void testEquals(Long id1, String ime1, String prezime1, Long id2, String ime2, String prezime2, boolean expected) {
        Korisnik korisnik1 = new Korisnik(id1, ime1, prezime1);
        Korisnik korisnik2 = new Korisnik(id2, ime2, prezime2);

        boolean result = korisnik1.equals(korisnik2);

        assertEquals(expected, result);
    }
    

    
}
