package fon.rs.np.RentACarServerMaven.so.cenovnik;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fon.rs.np.RentACarZajednickiMaven.domen.Cenovnik;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.domen.StavkaCenovnika;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;



class VratiCenovnikeTest {

	private VratiCenovnike vratiCenovnike;
	private Odgovor odgovor;
	private OpstiObjekat oo;
	
	@BeforeEach
	public void setUp() {
		vratiCenovnike = new VratiCenovnike();
		odgovor = new Odgovor();
		oo = new StavkaCenovnika();
	}
	
	@AfterEach
	public void tearDown() {
		vratiCenovnike =null;
		odgovor = null;
		oo = null;
	}
	
	@Test
	public void vratiCenovnikeTest() {
		
		odgovor = vratiCenovnike.izvrsiTranziciju(oo);
		
		assertTrue(odgovor.isUspesno());
		assertNotNull(odgovor.getOdgovor());
		assertTrue(odgovor.isUspesno());
		assertNull(odgovor.getPoruka());
		
		
	}
	
	@Test
	public void vratiCenovnikeTestNeuspesno() {
		
		odgovor = vratiCenovnike.izvrsiTranziciju(new Cenovnik());
		
		assertFalse(odgovor.isUspesno());
		assertNull(odgovor.getOdgovor());
		assertNotNull(odgovor.getPoruka());
		
		
	}
	
}
