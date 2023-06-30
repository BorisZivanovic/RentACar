package fon.rs.np.RentACarServerMaven.so.mesto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fon.rs.np.RentACarServerMaven.so.cenovnik.VratiCenovnike;
import fon.rs.np.RentACarZajednickiMaven.domen.Cenovnik;
import fon.rs.np.RentACarZajednickiMaven.domen.Mesto;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.domen.StavkaCenovnika;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

class VratiMestaTest {

	private VratiMesta vratiMesta;
	private Odgovor odgovor;
	private OpstiObjekat oo;
	
	@BeforeEach
	public void setUp() {
		vratiMesta = new VratiMesta();
		odgovor = new Odgovor();
		oo = new Mesto();
	}
	
	@AfterEach
	public void tearDown() {
		vratiMesta =null;
		odgovor = null;
		oo = null;
	}
	
	@Test
	public void vratiMestaTest() {
		
		odgovor = vratiMesta.izvrsiTranziciju(oo);
		
		assertTrue(odgovor.isUspesno());
		assertNotNull(odgovor.getOdgovor());
		assertNull(odgovor.getPoruka());
		

		
	}
	
	@Test
	public void vratiMestaTestNeuspesno() {
		
		odgovor = vratiMesta.izvrsiTranziciju(new Cenovnik());
		
		assertFalse(odgovor.isUspesno());
		assertNull(odgovor.getOdgovor());
		assertNotNull(odgovor.getPoruka());
		
		
	}

}
