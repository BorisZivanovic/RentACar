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

class IzmeniKorisnikaTest {

	private IzmeniKorisnika izmeniKorisnika;
	private Odgovor odgovor;
	private OpstiObjekat oo;
	
	@BeforeEach
	public void setUp() {
		izmeniKorisnika = new IzmeniKorisnika();
		odgovor = new Odgovor();
		oo = new Korisnik(10L, "Marko", "Markovic", 123456789L, new Date(), new Mesto(20L, "Jagodina"));
	}
	
	@AfterEach
	public void tearDown() {
		izmeniKorisnika = null;
		odgovor = null;
		oo = null;
	}

	@Test
	public void izmeniKorisnikaTest() {
		
		odgovor = izmeniKorisnika.izvrsiTranziciju(oo);
		
		assertTrue(odgovor.isUspesno());
		
		System.out.println(odgovor.getOdgovor());
		
	}
	
	@Test
	public void izmeniKorisnikaTestNeuspesno() {
		
		odgovor = izmeniKorisnika.izvrsiTranziciju(new Cenovnik());
		
		assertFalse(odgovor.isUspesno());
		assertNotNull(odgovor.getPoruka());
		
	}

}
