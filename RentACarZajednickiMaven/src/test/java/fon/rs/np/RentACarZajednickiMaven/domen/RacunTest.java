package fon.rs.np.RentACarZajednickiMaven.domen;

import static org.junit.jupiter.api.Assertions.*;

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
    
    @BeforeEach
    public void setUp() {
        korisnik = new Korisnik(2L, "Marko", "Markovic");
        kategorijaVozila = new KategorijaVozila("limuzina");
        iznajmljivanje = new Iznajmljivanje(korisnik, vozilo, new Date(), new Date());
        stavke = new ArrayList<>();
        vozilo = new Vozilo(10L, "JA-091-RG", "Peugeot", "308",StatusVozila.SLOBODNO, kategorijaVozila);
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
        Date newDate = new Date();
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
        Korisnik newKorisnik = new Korisnik(3L, "Janko", "Jankovic");
        racun.setKorisnik(newKorisnik);
        assertEquals(newKorisnik, racun.getKorisnik());
    
    }
    
    @Test
    public void testSetStavkaRacuna() {
        List<StavkaRacuna> newStavke = new ArrayList<>();
        newStavke.add(new StavkaRacuna(1L, racun, 500, 200, 700, korisnik, vozilo, iznajmljivanje));
        racun.setStavkaRacuna(newStavke);
        assertEquals(newStavke, racun.getStavkaRacuna());
    }

}
