package fon.rs.np.RentACarZajednickiMaven.domen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MestoTest {

	private Mesto mesto;
	
	@BeforeEach
	void setUp() throws Exception {
		mesto = new Mesto(1L, "Beograd");
	}

	@AfterEach
	void tearDown() throws Exception {
		mesto = null;
	}
	
	 @Test
	    public void testSetId() {
	        mesto.setId(2L);
	        assertEquals(2L, mesto.getId());
	    }
	 
	 @Test
	    public void testSetNaziv() {
	        mesto.setNaziv("Novi Sad");
	        assertEquals("Novi Sad", mesto.getNaziv());
	    }
	 
	 @Test
	    public void testEquals() {
	        Mesto mesto2 = new Mesto(1L, "Beograd");
	        assertTrue(mesto.equals(mesto2));
	    }

	    @Test
	    public void testEqualsSameObject() {
	        assertTrue(mesto.equals(mesto));
	    }

	    @Test
	    public void testEqualsNull() {
	        assertFalse(mesto.equals(null));
	    }

	    @Test
	    public void testEqualsDifferentClass() {
	    	Mesto mesto2 = new Mesto(2L, "Jagodina");
	        assertFalse(mesto.equals(mesto2));
	    }

	    @Test
	    public void testToString() {
	        assertEquals("Beograd", mesto.toString());
	    }

}
