package fon.rs.np.RentACarServerMaven.so.korisnik;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fon.rs.np.RentACarServerMaven.so.cenovnik.VratiCenovnike;
import fon.rs.np.RentACarZajednickiMaven.domen.Cenovnik;
import fon.rs.np.RentACarZajednickiMaven.domen.Korisnik;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.domen.StavkaCenovnika;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

class VratiKorisnikeTest {

	private VratiKorisnike vratiKorisnike;
	private Odgovor odgovor;
	private OpstiObjekat oo;
	
	@BeforeEach
	public void setUp() {
		vratiKorisnike = new VratiKorisnike();
		odgovor = new Odgovor();
		oo = new Korisnik();
	}
	
	@AfterEach
	public void tearDown() {
		vratiKorisnike =null;
		odgovor = null;
		oo = null;
	}
	
	@Test
	public void vratiKorisnikeTest() {
		
		try {
            odgovor = vratiKorisnike.izvrsiTranziciju(oo);
            
            if (odgovor.isUspesno()) {
                List<OpstiObjekat> korisnici = (List<OpstiObjekat>) odgovor.getOdgovor();

                
                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                
                String jsonString = gson.toJson(korisnici);

                
                try (FileWriter writer = new FileWriter("src/main/resources/korisnici.json")) {
                    writer.write(jsonString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(VratiKorisnike.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		assertTrue(odgovor.isUspesno());
		assertNotNull(odgovor.getOdgovor());
		assertNull(odgovor.getPoruka());
		
		
	}
	
	@Test
	public void vratiKorisnikeTestNeuspesno() {
		
		odgovor = vratiKorisnike.izvrsiTranziciju(new Cenovnik());
		
		assertFalse(odgovor.isUspesno());
		assertNull(odgovor.getOdgovor());
		assertNotNull(odgovor.getPoruka());
		
		
	}

}
