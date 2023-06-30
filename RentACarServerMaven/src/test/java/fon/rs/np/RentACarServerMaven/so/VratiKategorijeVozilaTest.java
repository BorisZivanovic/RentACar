package fon.rs.np.RentACarServerMaven.so;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fon.rs.np.RentACarServerMaven.so.vozilo.VratiVozila;
import fon.rs.np.RentACarZajednickiMaven.domen.Cenovnik;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.domen.Vozilo;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

class VratiKategorijeVozilaTest {

	private VratiKategorijeVozila vratiKategorijeVozila;
	private Odgovor odgovor;
	private OpstiObjekat oo;
	
	@BeforeEach
	public void setUp() {
		vratiKategorijeVozila = new VratiKategorijeVozila();
		odgovor = new Odgovor();
		oo = new Vozilo();
	}
	
	@AfterEach
	public void tearDown() {
		vratiKategorijeVozila =null;
		odgovor = null;
		oo = null;
	}
	
	@Test
	public void vratiKategorijeVozilaTest() {
		
		odgovor = vratiKategorijeVozila.izvrsiTranziciju(oo);
		
		assertTrue(odgovor.isUspesno());
		assertNotNull(odgovor.getOdgovor());
		assertNotNull(odgovor.getPoruka());
			
	}
	
	@Test
	public void vratiVozilakategorijeTestNeuspesno() {
		
		odgovor = vratiKategorijeVozila.izvrsiTranziciju(new Cenovnik());
		
		assertFalse(odgovor.isUspesno());
		assertNull(odgovor.getOdgovor());
		assertNotNull(odgovor.getPoruka());
		
	}

}
