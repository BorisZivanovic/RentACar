package fon.rs.np.RentACarServerMaven.so.korisnik;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fon.rs.np.RentACarServerMaven.so.cenovnik.VratiCenovnike;
import fon.rs.np.RentACarZajednickiMaven.domen.Cenovnik;
import fon.rs.np.RentACarZajednickiMaven.domen.Korisnik;
import fon.rs.np.RentACarZajednickiMaven.domen.Mesto;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.domen.StavkaCenovnika;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

class SacuvajKorisnikaTest {

	private SacuvajKorisnika sacuvajKorisnika;
	private Odgovor odgovor;
	private OpstiObjekat oo;
	private Mesto mesto;
	
	
	@BeforeEach
	public void setUp() {
		sacuvajKorisnika = new SacuvajKorisnika();
		mesto = new Mesto();
		odgovor = new Odgovor();
		mesto.setId(1L);
		mesto.setNaziv("Beograd");
		oo = new Korisnik(60L,"Marko", "Markovic", 234567899L, new Date(2000, 10, 10), mesto);
	}
	
	@AfterEach
	public void tearDown() {
		sacuvajKorisnika =null;
		odgovor = null;
		oo = null;
	}
	
	@Test
	public void sacuvajKorisnikaTest() {
		
		odgovor = sacuvajKorisnika.izvrsiTranziciju(oo);
		
		System.out.println(odgovor.getOdgovor());
		
		assertTrue(odgovor.isUspesno());
		assertNotNull(odgovor.getOdgovor());
		assertNotNull(odgovor.getPoruka());
		
		
	}
	
	@Test
	public void sacuvajKorisnikaTestNeuspesno() {
		
		odgovor = sacuvajKorisnika.izvrsiTranziciju(new Cenovnik());
		
		assertFalse(odgovor.isUspesno());
		assertNull(odgovor.getOdgovor());
		assertNotNull(odgovor.getPoruka());
		
		
	}

}
