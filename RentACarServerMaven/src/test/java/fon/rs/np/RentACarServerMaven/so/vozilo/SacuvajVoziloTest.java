package fon.rs.np.RentACarServerMaven.so.vozilo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.Cenovnik;
import fon.rs.np.RentACarZajednickiMaven.domen.KategorijaVozila;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.domen.StatusVozila;
import fon.rs.np.RentACarZajednickiMaven.domen.Vozilo;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

class SacuvajVoziloTest {

	private SacuvajVozilo sacuvajVozilo;
	private Odgovor odgovor;
	private OpstiObjekat oo;
	private KategorijaVozila kategorijaVozila;
	
	@BeforeEach
	public void setUp() {
		sacuvajVozilo = new SacuvajVozilo();
		odgovor = new Odgovor();
		kategorijaVozila = new KategorijaVozila(1L, "Karavan", 3000);
		oo = new Vozilo(5L, "BG12312", "Audi", "A6",StatusVozila.SLOBODNO, kategorijaVozila);
	}
	
	@AfterEach
	public void tearDown() {
		sacuvajVozilo = null;
		odgovor = null;
		oo = null;
	}

	@Test
	public void sacuvajVoziloTest() {
		
		odgovor = sacuvajVozilo.izvrsiTranziciju(oo);
		
		assertTrue(odgovor.isUspesno());
		assertNull(odgovor.getOdgovor());
		assertNotNull(odgovor.getPoruka());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
        String jsonString = gson.toJson(oo);

        try (FileWriter writer = new FileWriter("src/main/resources/novo_vozilo.json")) {
            writer.write(jsonString);
        } catch (IOException e){
            e.printStackTrace();
        }
		
	}
	
	@Test
	public void sacuvajVoziloTestNeuspesno() {
		
		odgovor = sacuvajVozilo.izvrsiTranziciju(new Cenovnik());
		
		assertFalse(odgovor.isUspesno());
		
	}


}
	
