package fon.rs.np.RentACarZajednickiMaven.domen;

/**
 * Enumeracija koja predstavlja status vozila.
 * Vozilo moze biti slobodno ili zauzeto u zavisnosti da li je iznajmljeno ili ne.
 * 
 * @author Boris Zivanovic
 */

public enum StatusVozila {
    
	/**
     * Vozilo je slobodno i dostupno za iznajmljivanje.
     */
	
    SLOBODNO,
    
    /**
     * Vozilo je zauzeto i trenutno nije dostupno za iznajmljivanje.
     */
    
    ZAUZETO
    
}
