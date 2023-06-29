package fon.rs.np.RentACarZajednickiMaven.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CenovnikTest {

	Cenovnik cenovnik;
	
	@BeforeEach
	void setUp() throws Exception {
		cenovnik = new Cenovnik();
	}

	@AfterEach
	void tearDown() throws Exception {
		cenovnik = null;
	}

	@Test
    public void testKonstruktorSaParametrima() {
        Long id = 1L;
        String naziv = "Cenovnik 1";
        String opis = "Opis cenovnika 1";

        Cenovnik cenovnik = new Cenovnik(id, naziv, opis);

        Assertions.assertEquals(id, cenovnik.getId());
        Assertions.assertEquals(naziv, cenovnik.getNaziv());
        Assertions.assertEquals(opis, cenovnik.getOpis());
    }

	@Test
    public void testPodrazumevaniKonstruktor() {

        Assertions.assertNull(cenovnik.getId());
        Assertions.assertNull(cenovnik.getNaziv());
        Assertions.assertNull(cenovnik.getOpis());
    }
	
	@Test
    public void testPostaviId() {
		
        Long id = 1L;

        cenovnik.setId(id);

        Assertions.assertEquals(id, cenovnik.getId());
    }
	
	@Test
    public void testPostaviNaziv() {

        String naziv = "Cenovnik 1";

        cenovnik.setNaziv(naziv);

        Assertions.assertEquals(naziv, cenovnik.getNaziv());
    }
	
	@Test
    public void testPostaviOpis() {

        String opis = "Opis cenovnika 1";

        cenovnik.setOpis(opis);

        Assertions.assertEquals(opis, cenovnik.getOpis());
    }
	
	@Test
    public void testToString() {
        String naziv = "Cenovnik 1";


        cenovnik.setNaziv(naziv);

        String ocekivaniString = naziv;
        String dobijeniString = cenovnik.toString();

        Assertions.assertEquals(ocekivaniString, dobijeniString);
    }
	
}
