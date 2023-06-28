package fon.rs.np.RentACarServerMaven.so.cenovnik;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarServerMaven.so.OpstaSistemskaOperacija;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

/**
 * Sistemska operacija koja vraća sve cenovnike iz baze podataka.
 */

public class VratiCenovnike extends OpstaSistemskaOperacija{

	/**
     * Izvršava operaciju vraćanja cenovnika.
     *
     * @param objekat Objekat koji sadrži podatke potrebne za izvršavanje operacije.
     * @return Odgovor koji sadrži listu cenovnika ili poruku o neuspešnom izvršavanju operacije.
     */
	
    @Override
    public Odgovor izvrsiOperaciju(OpstiObjekat objekat) {
        Odgovor odgovor = new Odgovor();
        
        try {
            List<OpstiObjekat> cenovnici = objekat.dajListu(DbBroker.getInstance().vratiSve(objekat));
            odgovor.setOdgovor(cenovnici);
            odgovor.setUspesno(true);
        } catch (SQLException ex) {
            Logger.getLogger(VratiCenovnike.class.getName()).log(Level.SEVERE, null, ex);
            odgovor.setUspesno(false);
            odgovor.setPoruka("Neuspesno preuzimanje cenovnika");
        }
        
        return odgovor;
    }
    
}
