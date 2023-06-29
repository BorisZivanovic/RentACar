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
	   private Korisnik korisnik;
	   private Vozilo vozilo;
	   private Date datumIznajmljivanja;
	   private Date datumVracanja;
    
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
		 korisnik = new Korisnik("Marko", "Markovic");
         vozilo = new Vozilo("ABC123");
         datumIznajmljivanja = parseDate("2023-06-25");
         datumVracanja = parseDate("2023-06-27");
        iznajmljivanje = new Iznajmljivanje(korisnik, vozilo, datumIznajmljivanja, datumVracanja);
	}

	@AfterEach
	void tearDown() throws Exception {
		   iznajmljivanje = null;
	       korisnik = null;
	       vozilo = null;
	       datumIznajmljivanja = null;
	       datumVracanja = null;
	}

	@Test
    void testSetId() {
        
		Long id = 1L;
        iznajmljivanje.setId(id);
        assertEquals(id, iznajmljivanje.getId());
    }
	
	@Test
    public void testSetKorisnik() {
        Korisnik noviKorisnik = new Korisnik("Petar", "Petrovic");
        iznajmljivanje.setKorisnik(noviKorisnik);
        assertEquals(noviKorisnik, iznajmljivanje.getKorisnik());
    }
	
	@Test
    public void testSetVozilo() {
        Vozilo novoVozilo = new Vozilo("NS5678CD");
        iznajmljivanje.setVozilo(novoVozilo);
        assertEquals(novoVozilo, iznajmljivanje.getVozilo());
    }
	
	 @Test
	    public void testSetDatumIznajmljivanja() throws ParseException {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date noviDatumIznajmljivanja = sdf.parse("2023-02-01");
	        iznajmljivanje.setDatumIznajmljivanja(noviDatumIznajmljivanja);
	        assertEquals(noviDatumIznajmljivanja, iznajmljivanje.getDatumIznajmljivanja());
	    }
	 
	 @Test
	    public void testSetDatumVracanja() throws ParseException {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date noviDatumVracanja = sdf.parse("2023-02-07");
	        iznajmljivanje.setDatumVracanja(noviDatumVracanja);
	        assertEquals(noviDatumVracanja, iznajmljivanje.getDatumVracanja());
	    }
	 
}
