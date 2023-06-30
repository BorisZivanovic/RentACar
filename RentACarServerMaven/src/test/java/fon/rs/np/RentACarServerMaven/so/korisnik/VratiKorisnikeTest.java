package fon.rs.np.RentACarServerMaven.so.korisnik;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fon.rs.np.RentACarServerMaven.so.cenovnik.VratiCenovnike;
import fon.rs.np.RentACarZajednickiMaven.domen.Cenovnik;
import fon.rs.np.RentACarZajednickiMaven.domen.Korisnik;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.domen.StavkaCenovnika;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

class VratiKorisnikeTest {

	private VratiKorisnike vratiKorisnike;
	private Odgovor odgovor;
	private OpstiObjekat oo;
	
	@BeforeEach
	public void setUp() {
		vratiKorisnike = new VratiKorisnike();
		odgovor = new Odgovor();
		oo = new Korisnik();
	}
	
	@AfterEach
	public void tearDown() {
		vratiKorisnike =null;
		odgovor = null;
		oo = null;
	}
	
	@Test
	public void vratiKorisnikeTest() {
		
		odgovor = vratiKorisnike.izvrsiTranziciju(oo);
		
		assertTrue(odgovor.isUspesno());
		assertNotNull(odgovor.getOdgovor());
		assertNull(odgovor.getPoruka());
		
		
	}
	
	@Test
	public void vratiKorisnikeTestNeuspesno() {
		
		odgovor = vratiKorisnike.izvrsiTranziciju(new Cenovnik());
		
		assertFalse(odgovor.isUspesno());
		assertNull(odgovor.getOdgovor());
		assertNotNull(odgovor.getPoruka());
		
		
	}

}
