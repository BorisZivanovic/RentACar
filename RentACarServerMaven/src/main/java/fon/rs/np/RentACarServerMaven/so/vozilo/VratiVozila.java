package fon.rs.np.RentACarServerMaven.so.vozilo;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarServerMaven.so.OpstaSistemskaOperacija;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

/**
 * Sistemska operacija za vraćanje svih vozila.
 */

public class VratiVozila extends OpstaSistemskaOperacija{

	/**
     * Izvršava operaciju vraćanja svih vozila.
     *
     * @param objekat Objekat koji predstavlja vozilo.
     * @return Odgovor koji sadrži listu svih vozila ili poruku o neuspešnom izvršavanju operacije.
     */
	
    @Override
    public Odgovor izvrsiOperaciju(OpstiObjekat objekat) {
        Odgovor odgovor = new Odgovor();
        
        try {
            List<OpstiObjekat> vozila = objekat.dajListu(DbBroker.getInstance().vratiSve(objekat));
            odgovor.setOdgovor(vozila);
            odgovor.setUspesno(true);
        } catch (SQLException ex) {
            Logger.getLogger(VratiVozila.class.getName()).log(Level.SEVERE, null, ex);
            odgovor.setUspesno(false);
            odgovor.setOdgovor(null);
        }
        
        return odgovor;
    }
    
}
