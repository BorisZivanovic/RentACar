package fon.rs.np.RentACarZajednickiMaven.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StavkaRacunaTest {

	private StavkaRacuna stavkaRacuna;
	private Vozilo vozilo;
	private Iznajmljivanje iznajmljivanje;
	private Korisnik korisnik;

    @BeforeEach
    public void setUp() {
        stavkaRacuna = new StavkaRacuna();
        vozilo = new Vozilo();
        iznajmljivanje = new Iznajmljivanje();
        korisnik = new Korisnik();
    }

    @AfterEach
    public void tearDown() {
        stavkaRacuna = null;
    }
    
    @Test
    public void testirajSetRbStavke() {
        Long ocekivaniRbStavke = 1L;
        stavkaRacuna.setRbStavke(ocekivaniRbStavke);

        assertEquals(ocekivaniRbStavke, stavkaRacuna.getRbStavke());
    }
	
    @Test
    public void testirajSetRacun() {
        Racun racun = new Racun(1L);
        stavkaRacuna.setRacun(racun);

        assertEquals(racun, stavkaRacuna.getRacun());
    }
    
    @Test
    public void testirajSetIznos() {
        Double ocekivaniIznos = 100.0;
        stavkaRacuna.setIznos(ocekivaniIznos);

        assertEquals(ocekivaniIznos, stavkaRacuna.getIznos());
    }
    
    @Test
    public void testirajToString() {
        Long rbStavke = 1L;
        Racun racun = new Racun(1L);
        Double iznos = 1000.0;
        double PDV = 200;
        double iznosSaPDV = 1200;
        
        stavkaRacuna.setRbStavke(rbStavke);
        stavkaRacuna.setRacun(racun);
        stavkaRacuna.setIznos(iznos);
        stavkaRacuna.setPDV(PDV);
        stavkaRacuna.setIznosSaPDV(iznosSaPDV);
        stavkaRacuna.setKorisnik(korisnik);
        stavkaRacuna.setIznajmljivanje(iznajmljivanje);
        stavkaRacuna.setVozilo(vozilo);

        String ocekivaniToString = "1000.0 200.0 1200.0 null null null null null";
        assertEquals(ocekivaniToString, stavkaRacuna.toString());
    }
    
}
