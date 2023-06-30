package fon.rs.np.RentACarServerMaven.so.korisnik;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fon.rs.np.RentACarZajednickiMaven.domen.Cenovnik;
import fon.rs.np.RentACarZajednickiMaven.domen.Korisnik;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

class IzbrisiKorisnikaTest {

	private IzbrisiKorisnika izbrisiKorisnika;
	private Odgovor odgovor;
	private OpstiObjekat oo;
	
	@BeforeEach
	void setUp() throws Exception {
		izbrisiKorisnika = new IzbrisiKorisnika();
		odgovor = new Odgovor();
		oo = new Korisnik();
	}

	@AfterEach
	void tearDown() throws Exception {
		izbrisiKorisnika = null;
		odgovor = null;
		oo = null;
	}

	@Test
	public void izbrisiKorisnikaTest() {
		odgovor = izbrisiKorisnika.izvrsiTranziciju(oo);
		
		assertTrue(odgovor.isUspesno());
		assertNull(odgovor.getOdgovor());
		assertNotNull(odgovor.getPoruka());
		
	}
	
	@Test
	public void izbrisiKorisnikaTestNeuspesno() {
		odgovor = izbrisiKorisnika.izvrsiTranziciju(new Cenovnik());
		
		assertFalse(odgovor.isUspesno());
		assertNotNull(odgovor.getPoruka());
		
	}
	
}
