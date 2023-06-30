package fon.rs.np.RentACarServerMaven.so.iznajmljeno;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fon.rs.np.RentACarZajednickiMaven.domen.Cenovnik;
import fon.rs.np.RentACarZajednickiMaven.domen.Iznajmljivanje;
import fon.rs.np.RentACarZajednickiMaven.domen.KategorijaVozila;
import fon.rs.np.RentACarZajednickiMaven.domen.Korisnik;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.domen.Racun;
import fon.rs.np.RentACarZajednickiMaven.domen.StatusVozila;
import fon.rs.np.RentACarZajednickiMaven.domen.StavkaRacuna;
import fon.rs.np.RentACarZajednickiMaven.domen.Vozilo;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

class IznajmiVoziloTest {

	private IznajmiVozilo iznajmiVozilo;
	private Korisnik korisnik;
	private Vozilo vozilo;
	private KategorijaVozila kategorijaVozila;
	private OpstiObjekat oo;
	private Odgovor odgovor;
	private Iznajmljivanje iznajmljivanje;
	private StavkaRacuna sr;
	private  List<StavkaRacuna> stavkaRacuna;
	private SimpleDateFormat sdf;
	private Date date;
	private Date date2;
	private Date utilDate = new Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	
	@BeforeEach
	void setUp() throws Exception {
		iznajmiVozilo = new IznajmiVozilo();
		odgovor = new Odgovor();
		stavkaRacuna = new ArrayList<>();
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		korisnik = new Korisnik(1L,"Pera","Peric");
		kategorijaVozila = new KategorijaVozila(3L, "Hecbek", 2000);
		vozilo = new Vozilo(2L, "NS67890", "Renault", "Clio", StatusVozila.SLOBODNO, kategorijaVozila);
		date = new Date(2023,7,1);
		date2 = new Date(2023,7,3);
		iznajmljivanje = new Iznajmljivanje(6L, korisnik, vozilo, date, date2);
		sr = new StavkaRacuna(12L, (Racun) oo, 6000, 3402, 9402, korisnik, vozilo, iznajmljivanje);
		stavkaRacuna.add(sr);
		oo = new Racun(6L, sqlDate, 6000, 3402, 9402, korisnik, stavkaRacuna);
		
	}


	
	@AfterEach
	void tearDown() throws Exception {
		iznajmiVozilo = null;
		korisnik = null;
		kategorijaVozila = null;
		vozilo = null;
		oo = null;
		odgovor = null;
	}

	@Test
	public void iznajmiVoziloTest() {
		
		odgovor = iznajmiVozilo.izvrsiTranziciju(oo);
		
		assertTrue(odgovor.isUspesno());
		assertNotNull(odgovor.getOdgovor());
		
	}

	@Test
	public void iznajmiVoziloTestNeuspesno() {
		
		odgovor = iznajmiVozilo.izvrsiTranziciju(new Cenovnik());
		
		assertFalse(odgovor.isUspesno());
		assertNotNull(odgovor.getPoruka());
		
	}
	
}
