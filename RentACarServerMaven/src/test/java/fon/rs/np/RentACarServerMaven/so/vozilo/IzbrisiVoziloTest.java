package fon.rs.np.RentACarServerMaven.so.vozilo;

import static org.junit.jupiter.api.Assertions.*;

import javax.net.ssl.SSLEngineResult.Status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fon.rs.np.RentACarServerMaven.so.korisnik.IzbrisiKorisnika;
import fon.rs.np.RentACarZajednickiMaven.domen.Cenovnik;
import fon.rs.np.RentACarZajednickiMaven.domen.KategorijaVozila;
import fon.rs.np.RentACarZajednickiMaven.domen.Korisnik;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.domen.StatusVozila;
import fon.rs.np.RentACarZajednickiMaven.domen.Vozilo;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

class IzbrisiVoziloTest {

	private IzbrisiVozilo izbrisiVozilo;
	private Odgovor odgovor;
	private OpstiObjekat oo;
	private KategorijaVozila kategorijaVozila;
	
	@BeforeEach
	void setUp() throws Exception {
		izbrisiVozilo = new IzbrisiVozilo();
		odgovor = new Odgovor();
		kategorijaVozila = new KategorijaVozila(3L, "Hecbek", 2000);
		
		oo = new Vozilo(1L, "BG12345", "Peugeot", "208", StatusVozila.SLOBODNO, kategorijaVozila);
	}

	@AfterEach
	void tearDown() throws Exception {
		izbrisiVozilo = null;
		odgovor = null;
		oo = null;
	}

	@Test
	public void izbrisiVoziloTest() {
		odgovor = izbrisiVozilo.izvrsiTranziciju(oo);
		
		assertTrue(odgovor.isUspesno());
		assertNull(odgovor.getOdgovor());


		
	}
	
	
	  @Test public void izbrisiKorisnikaTestNeuspesno() { 
		  
		  odgovor = izbrisiVozilo.izvrsiTranziciju(new Cenovnik());
	  
		  assertFalse(odgovor.isUspesno()); 
		  assertNotNull(odgovor.getPoruka());
	  
	  }
	 

}
