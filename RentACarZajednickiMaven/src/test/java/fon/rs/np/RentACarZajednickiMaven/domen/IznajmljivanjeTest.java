package fon.rs.np.RentACarZajednickiMaven.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IznajmljivanjeTest {

	   private Iznajmljivanje iznajmljivanje;
    
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
	void setUp() throws Exception {
        iznajmljivanje = new Iznajmljivanje();
	}

	@AfterEach
	void tearDown() throws Exception {
		   iznajmljivanje = null;
	}

	 @Test
	    public void testKonstruktorSaId() {
	        Long id = 1L;
	        Mesto mesto = new Mesto(2L, "Kragujevac");
	        Korisnik noviKorisnik = new Korisnik(2L,"Petar","Petrovic",1234567891234L,new Date(),mesto);
	        KategorijaVozila kategorijaVozila = new KategorijaVozila(2L, "limuzina", 2000);
	        Vozilo novoVozilo = new Vozilo(2L,"NS123","Audi","A7",StatusVozila.SLOBODNO,kategorijaVozila);
	        Date datumIznajmljivanja = parseDate("2023-09-10");
	        Date datumVracanja = new Date();

	        Iznajmljivanje iznajmljivanje = new Iznajmljivanje(id, noviKorisnik, novoVozilo, datumIznajmljivanja, datumVracanja);

	        assertEquals(id, iznajmljivanje.getId());
	        assertEquals(noviKorisnik, iznajmljivanje.getKorisnik());
	        assertEquals(novoVozilo, iznajmljivanje.getVozilo());
	        assertEquals(datumIznajmljivanja, iznajmljivanje.getDatumIznajmljivanja());
	        assertEquals(datumVracanja, iznajmljivanje.getDatumVracanja());
	    }
	
	 @Test
	    public void testKonstruktorBezId() {
	        Mesto mesto = new Mesto(2L, "Kragujevac");
	        Korisnik korisnik = new Korisnik(2L,"Petar","Petrovic",1234567891234L,new Date(),mesto);
	        KategorijaVozila kategorijaVozila = new KategorijaVozila(2L, "limuzina", 2000);
	        Vozilo vozilo = new Vozilo(2L,"NS123","Audi","A7",StatusVozila.SLOBODNO,kategorijaVozila);
	        Date datumIznajmljivanja = parseDate("2023-09-11");
	        Date datumVracanja = parseDate("2023-10-11");

	        Iznajmljivanje iznajmljivanje = new Iznajmljivanje(korisnik, vozilo, datumIznajmljivanja, datumVracanja);

	        assertNull(iznajmljivanje.getId());
	        assertEquals(korisnik, iznajmljivanje.getKorisnik());
	        assertEquals(vozilo, iznajmljivanje.getVozilo());
	        assertEquals(datumIznajmljivanja, iznajmljivanje.getDatumIznajmljivanja());
	        assertEquals(datumVracanja, iznajmljivanje.getDatumVracanja());
	    }
	 
	 @Test
	    public void testKonstruktorSaIdIDatumima() {
	        Long id = 1L;
	        Date datumIznajmljivanja = new Date();
	        Date datumVracanja = new Date();

	        Iznajmljivanje iznajmljivanje = new Iznajmljivanje(id, datumIznajmljivanja, datumVracanja);

	        assertEquals(id, iznajmljivanje.getId());
	        assertNull(iznajmljivanje.getKorisnik());
	        assertNull(iznajmljivanje.getVozilo());
	        assertEquals(datumIznajmljivanja, iznajmljivanje.getDatumIznajmljivanja());
	        assertEquals(datumVracanja, iznajmljivanje.getDatumVracanja());
	    }
	 
	@Test
    void testSetId() {
        
		Long id = 1L;
        iznajmljivanje.setId(id);
        assertEquals(id, iznajmljivanje.getId());
    }
	
	@Test
    public void testSetKorisnik() {
		Mesto mesto = new Mesto(2L, "Kragujevac");
        Korisnik noviKorisnik = new Korisnik(2L,"Petar","Petrovic",1234567891234L,new Date(),mesto);
        iznajmljivanje.setKorisnik(noviKorisnik);
        assertEquals(noviKorisnik, iznajmljivanje.getKorisnik());
    }
	
	@Test
    public void testSetVozilo() {
		KategorijaVozila kategorijaVozila = new KategorijaVozila(2L, "limuzina", 2000);
        Vozilo novoVozilo = new Vozilo(2L,"NS123","Audi","A7",StatusVozila.SLOBODNO,kategorijaVozila);
        iznajmljivanje.setVozilo(novoVozilo);
        assertEquals(novoVozilo, iznajmljivanje.getVozilo());
    }
	
	 @Test
	    public void testSetDatumIznajmljivanja() throws ParseException {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date noviDatumIznajmljivanja = sdf.parse("2023-09-01");
	        iznajmljivanje.setDatumIznajmljivanja(noviDatumIznajmljivanja);
	        assertEquals(noviDatumIznajmljivanja, iznajmljivanje.getDatumIznajmljivanja());
	    }
	 
	 @Test
	    public void testSetDatumVracanja() throws ParseException {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date noviDatumVracanja = sdf.parse("2023-19-09");
	        iznajmljivanje.setDatumVracanja(noviDatumVracanja);
	        assertEquals(noviDatumVracanja, iznajmljivanje.getDatumVracanja());
	    }
	 
	 @Test
	    public void testSetIdNegative() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            Iznajmljivanje iznajmljivanje = new Iznajmljivanje();
	            iznajmljivanje.setId(-1L);
	        });
	    }

	    @Test
	    public void testSetKorisnikNull() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            Iznajmljivanje iznajmljivanje = new Iznajmljivanje();
	            iznajmljivanje.setKorisnik(null);
	        });
	    }

	    @Test
	    public void testSetKorisnikInvalidProperties() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            Iznajmljivanje iznajmljivanje = new Iznajmljivanje();
	            Mesto mesto = new Mesto(2L, "Kragujevac");
	            iznajmljivanje.setKorisnik(new Korisnik(0L, "", "", 0L, parseDate("2000-09-01"), mesto)); // Podešavanje neispravnih svojstava korisnika
	        });
	    }

	    @Test
	    public void testSetVoziloNull() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            Iznajmljivanje iznajmljivanje = new Iznajmljivanje();
	            iznajmljivanje.setVozilo(null);
	        });
	    }

	    @Test
	    public void testSetVoziloInvalidProperties() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            Iznajmljivanje iznajmljivanje = new Iznajmljivanje();
	            KategorijaVozila kategorijaVozila = new KategorijaVozila(1l, "Beograd", 1000);
	            iznajmljivanje.setVozilo(new Vozilo(0L, "", "", "", StatusVozila.SLOBODNO, kategorijaVozila));
	        });
	    }

	    @Test
	    public void testSetDatumIznajmljivanjaPastDate() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            Iznajmljivanje iznajmljivanje = new Iznajmljivanje();
	            iznajmljivanje.setDatumIznajmljivanja(parseDate("2020-01-01")); // Datum iz prošlosti
	        });
	    }

	    @Test
	    public void testSetDatumVracanjaNull() {
	        assertThrows(NullPointerException.class, () -> {
	            Iznajmljivanje iznajmljivanje = new Iznajmljivanje();
	            iznajmljivanje.setDatumVracanja(null);
	        });
	    }
	 
}
