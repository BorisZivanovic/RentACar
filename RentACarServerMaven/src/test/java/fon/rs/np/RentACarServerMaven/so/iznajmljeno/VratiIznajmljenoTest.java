package fon.rs.np.RentACarServerMaven.so.iznajmljeno;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fon.rs.np.RentACarZajednickiMaven.domen.Iznajmljivanje;
import fon.rs.np.RentACarZajednickiMaven.domen.KategorijaVozila;
import fon.rs.np.RentACarZajednickiMaven.domen.Korisnik;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.domen.Racun;
import fon.rs.np.RentACarZajednickiMaven.domen.StatusVozila;
import fon.rs.np.RentACarZajednickiMaven.domen.StavkaRacuna;
import fon.rs.np.RentACarZajednickiMaven.domen.Vozilo;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

class VratiIznajmljenoTest {

	private VratiIznajmljeno vratiIznajmljeno;
	private Odgovor odgovor;
	private OpstiObjekat oo;
	
	@BeforeEach
	void setUp() throws Exception {
		vratiIznajmljeno = new VratiIznajmljeno();
		odgovor = new Odgovor();
		
		oo = new StavkaRacuna();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		oo = null;
	}

	@Test
	public void vratiVoziloTest() {
		
		odgovor = vratiIznajmljeno.izvrsiTranziciju(oo);
		
		assertTrue(odgovor.isUspesno());
		assertNotNull(odgovor.getOdgovor());
		
		System.out.println(odgovor.getOdgovor());
		
	}
	
	@Test
	public void vratiVoziloTestNeuspesno() {
		
		odgovor = vratiIznajmljeno.izvrsiTranziciju(new Racun(15L));
		
		assertFalse(odgovor.isUspesno());
		assertNull(odgovor.getOdgovor());
		assertNotNull(odgovor.getPoruka());
		
		System.out.println(odgovor.getOdgovor());
		
	}
	

}
