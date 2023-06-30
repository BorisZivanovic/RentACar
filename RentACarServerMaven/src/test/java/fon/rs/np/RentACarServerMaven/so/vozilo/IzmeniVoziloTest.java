package fon.rs.np.RentACarServerMaven.so.vozilo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fon.rs.np.RentACarServerMaven.so.korisnik.IzmeniKorisnika;
import fon.rs.np.RentACarZajednickiMaven.domen.Cenovnik;
import fon.rs.np.RentACarZajednickiMaven.domen.KategorijaVozila;
import fon.rs.np.RentACarZajednickiMaven.domen.Korisnik;
import fon.rs.np.RentACarZajednickiMaven.domen.Mesto;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.domen.StatusVozila;
import fon.rs.np.RentACarZajednickiMaven.domen.Vozilo;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

class IzmeniVoziloTest {

	private IzmeniVozilo izmeniVozilo;
	private Odgovor odgovor;
	private OpstiObjekat oo;
	private KategorijaVozila kategorijaVozila;
	
	@BeforeEach
	public void setUp() {
		izmeniVozilo = new IzmeniVozilo();
		odgovor = new Odgovor();
		kategorijaVozila = new KategorijaVozila(3L, "Hecbek", 2000);
		oo = new Vozilo(4L, "BG11111", "Audi", "A7",StatusVozila.SLOBODNO, kategorijaVozila);
	}
	
	@AfterEach
	public void tearDown() {
		izmeniVozilo = null;
		odgovor = null;
		oo = null;
	}

	@Test
	public void izmeniVoziloTest() {
		
		odgovor = izmeniVozilo.izvrsiTranziciju(oo);
		
		assertTrue(odgovor.isUspesno());
		
		System.out.println(odgovor.getOdgovor());
		
	}
	
	@Test
	public void izmeniVoziloTestNeuspesno() {
		
		odgovor = izmeniVozilo.izvrsiTranziciju(new Cenovnik());
		
		assertFalse(odgovor.isUspesno());
		assertNotNull(odgovor.getPoruka());
		
	}

}
