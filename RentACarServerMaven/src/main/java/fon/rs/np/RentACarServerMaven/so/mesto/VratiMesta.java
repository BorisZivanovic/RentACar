package fon.rs.np.RentACarServerMaven.so.mesto;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarServerMaven.so.OpstaSistemskaOperacija;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

/**
 * Sistemska operacija za vraćanje liste mesta.
 */

public class VratiMesta extends OpstaSistemskaOperacija {

	/**
     * Izvršava operaciju vraćanja liste mesta.
     *
     * @param objekat Objekat koji predstavlja kriterijum pretrage mesta.
     * @return Odgovor koji sadrži listu pronađenih mesta ili poruku o neuspešnom izvršavanju operacije.
     */
	
    @Override
    public Odgovor izvrsiOperaciju(OpstiObjekat objekat) {
        Odgovor odgovor = new Odgovor();
        
        try {
            List<OpstiObjekat> mesta = objekat.dajListu(DbBroker.getInstance().vratiSve(objekat));
            odgovor.setOdgovor(mesta);
            odgovor.setUspesno(true);
        } catch (SQLException ex) {
            Logger.getLogger(VratiMesta.class.getName()).log(Level.SEVERE, null, ex);
            odgovor.setUspesno(false);
            odgovor.setPoruka("Nisu uspesno vracena mesta");
        }
        
        return odgovor;
    }
    
}
