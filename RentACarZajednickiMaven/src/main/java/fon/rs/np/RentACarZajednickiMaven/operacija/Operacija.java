package fon.rs.np.RentACarZajednickiMaven.operacija;

/**
 * Enumeracija koja predstavlja operacije u sistemu Rent-a-Car.
 * 
 * @author Boris Zivanovic
 */

public enum Operacija {
    
	/**
     * Operacija za vraćanje svih mesta u sistemu.
     */
	
    VRATI_MESTA,
    
    /**
     * Operacija za čuvanje novog mesta u sistemu.
     */
    
    SAČUVAJ_MESTO,
    
    /**
     * Operacija za izmenu postojećeg mesta u sistemu.
     */
    
    IZMENI_MESTO,
    
    /**
     * Operacija za brisanje postojećeg mesta iz sistema.
     */
    
    IZBRISI_MESTO,
    
    /**
     * Operacija za čuvanje novog korisnika u sistemu.
     */
    
    SACUVAJ_KORISNIKA,
    
    /**
     * Operacija za vraćanje svih korisnika u sistemu.
     */
    
    VRATI_KORISNIKE,
    
    /**
     * Operacija za izmenu postojećeg korisnika u sistemu.
     */
    
    IZMENI_KORISNIKA,
    
    /**
     * Operacija za brisanje postojećeg korisnika iz sistema.
     */
    
    IZBRISI_KORISNIKA,
    
    /**
     * Operacija za čuvanje novog vozila u sistemu.
     */
    
    SACUVAJ_VOZILO,
    
    /**
     * Operacija za vraćanje svih vozila u sistemu.
     */
    
    VRATI_VOZILA,
    
    /**
     * Operacija za brisanje postojećeg vozila iz sistema.
     */
    
    IZBRISI_VOZILO,
    
    /**
     * Operacija za izmenu postojećeg vozila u sistemu.
     */
    
    IZMENI_VOZILO,
    
    /**
     * Operacija za vraćanje svih kategorija vozila u sistemu.
     */
    
    VRATI_KATEGORIJE_VOZILA,
    
    /**
     * Operacija za vraćanje svih cenovnika u sistemu.
     */
    
    VRATI_CENOVNIKE,
    
    /**
     * Operacija za iznajmljivanje vozila.
     */
    
    IZNAJMI,
    
    /**
     * Operacija za vraćanje iznajmljenih vozila.
     */
    
    VRATI_IZNAJMLJENE,
    
    /**
     * Operacija za izlogovanje korisnika iz sistema.
     */
    
    IZLOGUJ
    
}
