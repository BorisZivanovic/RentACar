package fon.rs.np.RentACarZajednickiMaven.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacunTest {

	private Racun racun;
    private Korisnik korisnik;
    private List<StavkaRacuna> stavke;
    private Vozilo vozilo;
    private Iznajmljivanje iznajmljivanje;
    private KategorijaVozila kategorijaVozila;
    
    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @BeforeEach
    public void setUp() {
    	Mesto mesto = new Mesto(2L, "Kragujevac");
        korisnik = new Korisnik(2L, "Marko", "Markovic",1234567890123L,parseDate("2000-05-05"),mesto);
        kategorijaVozila = new KategorijaVozila(1L,"limuzina",2000);
        vozilo = new Vozilo(10L, "JA-091-RG", "Peugeot", "308",StatusVozila.SLOBODNO, kategorijaVozila);
        iznajmljivanje = new Iznajmljivanje(1L,korisnik, vozilo, parseDate("2023-09-17"), parseDate("2023-09-25"));
        stavke = new ArrayList<>();
        stavke.add(new StavkaRacuna(1L, racun, 1000, 200, 1200, korisnik, vozilo,iznajmljivanje));
        racun = new Racun(1L, new Date(), 1000, 200, 1200, korisnik, stavke);
    }

    @AfterEach
    public void tearDown() {
        racun = null;
        korisnik = null;
        stavke = null;
        vozilo = null;
        iznajmljivanje = null;
        kategorijaVozila = null;
    }
    
    @Test
    public void testSetId() {
        racun.setId(2L);
        assertEquals(2L, racun.getId());
    }
    
    @Test
    public void testSetDatumIzdavanja() {
        Date newDate = parseDate("2023-07-03");
        racun.setDatumIzdavanja(newDate);
        assertEquals(newDate, racun.getDatumIzdavanja());
    }
    
    @Test
    public void testSetCenaBezPDV() {
        racun.setCenaBezPDV(400.0);
        assertEquals(400.0, racun.getCenaBezPDV());
    }
    
    @Test
    public void testSetPDV() {
        racun.setPDV(25.0);
        assertEquals(25.0, racun.getPDV());
    }
    
    @Test
    public void testSetCenaSaPDV() {
        racun.setCenaSaPDV(350.0);
        assertEquals(350.0, racun.getCenaSaPDV());
    }
    
    @Test
    public void testSetKorisnik() {
        racun.setKorisnik(korisnik);
        assertEquals(korisnik, racun.getKorisnik());
    
    }
    
    @Test
    public void testSetStavkaRacuna() {
        List<StavkaRacuna> newStavke = new ArrayList<>();
        newStavke.add(new StavkaRacuna(1L, racun, 500, 200, 700, korisnik, vozilo, iznajmljivanje));
        racun.setStavkaRacuna(newStavke);
        assertEquals(newStavke, racun.getStavkaRacuna());
    }

    @Test
    public void testSetIdGreska() {
        assertThrows(IllegalArgumentException.class, () -> racun.setId(-1L));
    }

    @Test
    public void testSetDatumIzdavanjaGreska() {
        assertThrows(IllegalArgumentException.class, () -> racun.setDatumIzdavanja(parseDate("2030-01-01"))).getMessage();
    }

    @Test
    public void testSetCenaBezPDVGreska() {
        assertThrows(IllegalArgumentException.class, () -> racun.setCenaBezPDV(-1.0));
    }

    @Test
    public void testSetPDVGreska() {
        assertThrows(IllegalArgumentException.class, () -> racun.setPDV(-1.0));
    }

    @Test
    public void testSetCenaSaPDVGreska() {
        assertThrows(IllegalArgumentException.class, () -> racun.setCenaSaPDV(-1.0));
    }

    @Test
    public void testSetKorisnikGreska() {
    	Mesto mesto1 = new Mesto(2L, "Kragujevac");
        Korisnik noviKorisnik = new Korisnik(0L,"","",123456789123L,parseDate("2000-05-05"),mesto1);
        assertThrows(IllegalArgumentException.class, () -> racun.setKorisnik(noviKorisnik)).getMessage();
    }

    @Test
    public void testSetStavkaRacunaGreska() {
        assertNull(assertThrows(NullPointerException.class, () -> racun.setStavkaRacuna(null)).getMessage());
    }
    
}
