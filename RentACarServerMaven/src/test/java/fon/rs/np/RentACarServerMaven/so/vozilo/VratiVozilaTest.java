package fon.rs.np.RentACarServerMaven.so.vozilo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fon.rs.np.RentACarServerMaven.so.korisnik.VratiKorisnike;
import fon.rs.np.RentACarZajednickiMaven.domen.Cenovnik;
import fon.rs.np.RentACarZajednickiMaven.domen.Korisnik;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.domen.Vozilo;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

class VratiVozilaTest {

	private VratiVozila vratiVozila;
	private Odgovor odgovor;
	private OpstiObjekat oo;
	
	@BeforeEach
	public void setUp() {
		vratiVozila = new VratiVozila();
		odgovor = new Odgovor();
		oo = new Vozilo();
	}
	
	@AfterEach
	public void tearDown() {
		vratiVozila =null;
		odgovor = null;
		oo = null;
	}
	
	@Test
	public void vratiVozilaTest() {
		
		odgovor = vratiVozila.izvrsiTranziciju(oo);
		
		assertTrue(odgovor.isUspesno());
		assertNotNull(odgovor.getOdgovor());
			
	}
	
	@Test
	public void vratiVozilaTestNeuspesno() {
		
		odgovor = vratiVozila.izvrsiTranziciju(new Cenovnik());
		
		assertFalse(odgovor.isUspesno());
		assertNull(odgovor.getOdgovor());
		
	}

}
