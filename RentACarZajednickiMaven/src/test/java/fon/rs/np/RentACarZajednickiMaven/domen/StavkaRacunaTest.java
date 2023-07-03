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

class StavkaRacunaTest {

	private StavkaRacuna stavkaRacuna;
	private Vozilo vozilo;
	private Iznajmljivanje iznajmljivanje;
	private Korisnik korisnik;
	private Racun racun;
	
	private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	@Test
    void testKonstruktorSaSvimParametrima() {
        // Arrange
		Long rbStavke = 1L;
        Mesto mesto = new Mesto(2L, "Kragujevac");
        Korisnik korisnik = new Korisnik(2L, "Marko", "Markovic",1234567890123L,parseDate("2000-05-05"),mesto);
        KategorijaVozila kategorijaVozila = new KategorijaVozila(1L,"limuzina",2000);
        Vozilo vozilo = new Vozilo(10L, "JA-091-RG", "Peugeot", "308",StatusVozila.SLOBODNO, kategorijaVozila);
        Iznajmljivanje iznajmljivanje = new Iznajmljivanje(1L,korisnik, vozilo, new Date(), new Date());
        List<StavkaRacuna> stavke = new ArrayList<>();
        stavke.add(new StavkaRacuna(1L, racun, 1000, 200, 1200, korisnik, vozilo,iznajmljivanje));
        racun = new Racun(1L, new Date(), 1000, 200, 1200, korisnik, stavke);
        Double iznos = 1000.0;
        double PDV = 200;
        double iznosSaPDV = 1200;

        // Act
        StavkaRacuna stavkaRacuna = new StavkaRacuna(rbStavke, racun, iznos, PDV, iznosSaPDV, korisnik, vozilo, iznajmljivanje);

        // Assert
        assertEquals(rbStavke, stavkaRacuna.getRbStavke());
        assertEquals(racun, stavkaRacuna.getRacun());
        assertEquals(iznos, stavkaRacuna.getIznos());
        assertEquals(PDV, stavkaRacuna.getPDV());
        assertEquals(iznosSaPDV, stavkaRacuna.getIznosSaPDV());
        assertEquals(korisnik, stavkaRacuna.getKorisnik());
        assertEquals(vozilo, stavkaRacuna.getVozilo());
        assertEquals(iznajmljivanje, stavkaRacuna.getIznajmljivanje());
    }
	
	 @Test
	    public void testKonstruktorSaIznosomPdvIznosomSaPdv() {
	        double iznos = 1000.0;
	        double PDV = 200.0;
	        double iznosSaPDV = 1200.0;
	        Mesto mesto = new Mesto(2L, "Kragujevac");
	        Korisnik korisnik = new Korisnik(2L, "Marko", "Markovic",1234567890123L,parseDate("2000-05-05"),mesto);
	        KategorijaVozila kategorijaVozila = new KategorijaVozila(1L,"limuzina",2000);
	        Vozilo vozilo = new Vozilo(10L, "JA-091-RG", "Peugeot", "308",StatusVozila.SLOBODNO, kategorijaVozila);
	        Iznajmljivanje iznajmljivanje = new Iznajmljivanje(1L,korisnik, vozilo, new Date(), new Date());

	        StavkaRacuna stavkaRacuna = new StavkaRacuna(iznos, PDV, iznosSaPDV, korisnik, vozilo, iznajmljivanje);

	        assertEquals(iznos, stavkaRacuna.getIznos());
	        assertEquals(PDV, stavkaRacuna.getPDV());
	        assertEquals(iznosSaPDV, stavkaRacuna.getIznosSaPDV());
	        assertEquals(korisnik, stavkaRacuna.getKorisnik());
	        assertEquals(vozilo, stavkaRacuna.getVozilo());
	        assertEquals(iznajmljivanje, stavkaRacuna.getIznajmljivanje());
	    }
	 
	 @Test
	    public void testKonstruktorSaIznosom() {
	        double iznos = 1000.0;

	        StavkaRacuna stavkaRacuna = new StavkaRacuna(iznos);
	        
	        assertEquals(iznos, stavkaRacuna.getIznosSaPDV());
	    }
	
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
        Mesto mesto = new Mesto(2L, "Kragujevac");
        Korisnik korisnik = new Korisnik(2L, "Marko", "Markovic",1234567890123L,parseDate("2000-05-05"),mesto);
        KategorijaVozila kategorijaVozila = new KategorijaVozila(1L,"limuzina",2000);
        Vozilo vozilo = new Vozilo(10L, "JA-091-RG", "Peugeot", "308",StatusVozila.SLOBODNO, kategorijaVozila);
        Iznajmljivanje iznajmljivanje = new Iznajmljivanje(1L,korisnik, vozilo, new Date(), new Date());
        List<StavkaRacuna> stavke = new ArrayList<>();
        stavke.add(new StavkaRacuna(1L, racun, 1000, 200, 1200, korisnik, vozilo,iznajmljivanje));
        racun = new Racun(1L, new Date(), 1000, 200, 1200, korisnik, stavke);
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
        
        String ocekivaniToString = stavkaRacuna.toString();
        
        assertTrue(ocekivaniToString.contains("1000.0"));
        assertTrue(ocekivaniToString.contains("200.0"));
        assertTrue(ocekivaniToString.contains("1200.0"));
        assertTrue(ocekivaniToString.contains("Marko Markovic"));
        assertTrue(ocekivaniToString.contains(vozilo.getStatusVozila().toString()));
        assertTrue(ocekivaniToString.contains(iznajmljivanje.getDatumIznajmljivanja().toString()));
        assertTrue(ocekivaniToString.contains(iznajmljivanje.getDatumVracanja().toString()));
    }
    
    @Test
    public void testSetRbStavkeNegative() {
        
        assertThrows(IllegalArgumentException.class, () -> {
            stavkaRacuna.setRbStavke(-1L);
        });
    }

    @Test
    public void testSetIznosNegativeOrZero() {
        
        assertThrows(IllegalArgumentException.class, () -> {
            stavkaRacuna.setIznos(-100.0);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            stavkaRacuna.setIznos(0.0);
        });
    }

    @Test
    public void testSetPDVNegativeOrZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            stavkaRacuna.setPDV(-10.0);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            stavkaRacuna.setPDV(0.0);
        });
    }

    @Test
    public void testSetIznosSaPDVNegativeOrZero() {
        
        assertThrows(IllegalArgumentException.class, () -> {
            stavkaRacuna.setIznosSaPDV(-1000.0);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            stavkaRacuna.setIznosSaPDV(0.0);
        });
    }

    @Test
    public void testSetKorisnikNedozvoljeneVrednosti() {
        Mesto mesto = new Mesto(2L, "Kragujevac");
        Korisnik korisnik = new Korisnik(0L, "", "",123456L,parseDate("2000-05-05"),mesto);
        
        assertThrows(IllegalArgumentException.class, () -> {
            stavkaRacuna.setKorisnik(korisnik);
        });
    }

    @Test
    public void testSetVoziloNedozvoljeneVrednosti() {
        KategorijaVozila kategorijaVozila = new KategorijaVozila(1L,"limuzina",2000);
        Vozilo vozilo = new Vozilo(0L, "", "", "",StatusVozila.SLOBODNO, kategorijaVozila);
        
        assertThrows(IllegalArgumentException.class, () -> {
            stavkaRacuna.setVozilo(vozilo);
        });
    }

    @Test
    public void testSetIznajmljivanjeNedozvoljeneVrednosti() {
        
        assertThrows(IllegalArgumentException.class, () -> {
            stavkaRacuna.setIznajmljivanje(null);
        });
    }
    
}
