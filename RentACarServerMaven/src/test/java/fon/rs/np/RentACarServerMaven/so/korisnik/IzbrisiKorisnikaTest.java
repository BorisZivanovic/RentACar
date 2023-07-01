package fon.rs.np.RentACarServerMaven.so.korisnik;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fon.rs.np.RentACarZajednickiMaven.domen.Cenovnik;
import fon.rs.np.RentACarZajednickiMaven.domen.Korisnik;
import fon.rs.np.RentACarZajednickiMaven.domen.Mesto;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

class IzbrisiKorisnikaTest {

	private IzbrisiKorisnika izbrisiKorisnika;
	private Odgovor odgovor;
	private OpstiObjekat oo;
	private Mesto mesto;
	
	@BeforeEach
	void setUp() throws Exception {
		izbrisiKorisnika = new IzbrisiKorisnika();
		odgovor = new Odgovor();
		mesto = new Mesto(1L, "Beograd");
		oo = new Korisnik(18L, "Marko", "Markovic",234567899L, new Date(3900,11,10), mesto);
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
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    
        String jsonString = gson.toJson(oo);

        try (FileWriter writer = new FileWriter("src/main/resources/obrisan_korisnik.json")) {
            writer.write(jsonString);
        } catch (IOException e){
            e.printStackTrace();
        }
		
	}
	
	@Test
	public void izbrisiKorisnikaTestNeuspesno() {
		odgovor = izbrisiKorisnika.izvrsiTranziciju(new Cenovnik());
		
		assertFalse(odgovor.isUspesno());
		assertNotNull(odgovor.getPoruka());
		
	}
	
}
