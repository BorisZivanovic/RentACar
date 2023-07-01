package fon.rs.np.RentACarServerMaven.so.vozilo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fon.rs.np.RentACarZajednickiMaven.domen.Cenovnik;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.domen.StatusVozila;
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
		
		List<Vozilo> slobodnaVozila = new ArrayList<>();
        List<Vozilo> zauzetaVozila = new ArrayList<>();

        // Razdvajanje vozila prema statusu
        List<Vozilo> vozila = (List<Vozilo>) odgovor.getOdgovor();
        for (Vozilo vozilo : vozila) {
            if (vozilo.getStatusVozila() == StatusVozila.SLOBODNO) {
                slobodnaVozila.add(vozilo);
            } else {
                zauzetaVozila.add(vozilo);
            }
        }

        // Smestanje slobodnih vozila u JSON fajl
        smestiVozilaUJson(slobodnaVozila, "src/main/resources/slobodna_vozila.json");

        // Smestanje zauzetih vozila u JSON fajl
        smestiVozilaUJson(zauzetaVozila, "src/main/resources/zauzeta_vozila.json");
			
	}
	
	@Test
	public void vratiVozilaTestNeuspesno() {
		
		odgovor = vratiVozila.izvrsiTranziciju(new Cenovnik());
		
		assertFalse(odgovor.isUspesno());
		assertNull(odgovor.getOdgovor());
		
	}

	private void smestiVozilaUJson(List<Vozilo> vozila, String nazivFajla) {
        try (FileWriter writer = new FileWriter(nazivFajla)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(vozila, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
