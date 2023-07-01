package fon.rs.np.RentACarServerMaven.so.cenovnik;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fon.rs.np.RentACarZajednickiMaven.domen.Cenovnik;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.domen.StavkaCenovnika;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class VratiCenovnikeTest {

	private VratiCenovnike vratiCenovnike;
	private Odgovor odgovor;
	private OpstiObjekat oo;
	
	@BeforeEach
	public void setUp() {
		vratiCenovnike = new VratiCenovnike();
		odgovor = new Odgovor();
		oo = new StavkaCenovnika();
	}
	
	@AfterEach
	public void tearDown() {
		vratiCenovnike =null;
		odgovor = null;
		oo = null;
	}
	
	@Test
	public void vratiCenovnikeTest() {
		
		try {
            odgovor = vratiCenovnike.izvrsiTranziciju(oo);
            
            if (odgovor.isUspesno()) {
                List<OpstiObjekat> stavkeCenovnika = (List<OpstiObjekat>) odgovor.getOdgovor();

                
                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                
                String jsonString = gson.toJson(stavkeCenovnika);

                
                try (FileWriter writer = new FileWriter("src/main/resources/stavke_cenovnika.json")) {
                    writer.write(jsonString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(VratiCenovnike.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		assertTrue(odgovor.isUspesno());
		assertNotNull(odgovor.getOdgovor());
		assertTrue(odgovor.isUspesno());
		assertNull(odgovor.getPoruka());
		
		 
	}
	
	@Test
	public void vratiCenovnikeTestNeuspesno() {
		
		odgovor = vratiCenovnike.izvrsiTranziciju(new Cenovnik());
		
		assertFalse(odgovor.isUspesno());
		assertNull(odgovor.getOdgovor());
		assertNotNull(odgovor.getPoruka());
		
		
	}
	
}
