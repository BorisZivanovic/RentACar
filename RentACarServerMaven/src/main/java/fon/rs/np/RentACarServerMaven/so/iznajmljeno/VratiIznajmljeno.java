package fon.rs.np.RentACarServerMaven.so.iznajmljeno;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarServerMaven.so.OpstaSistemskaOperacija;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

/**
 * Sistemska operacija za vraćanje liste iznajmljenih vozila.
 */

public class VratiIznajmljeno extends OpstaSistemskaOperacija {

	/**
     * Izvršava operaciju vraćanja liste iznajmljenih vozila.
     *
     * @param objekat Objekat koji predstavlja iznajmljeno vozilo.
     * @return Odgovor koji sadrži listu iznajmljenih vozila ili poruku o neuspešnom izvršavanju operacije.
     */
	
    @Override
    public Odgovor izvrsiOperaciju(OpstiObjekat objekat) {
        Odgovor odgovor = new Odgovor();
        
        try {
            List<OpstiObjekat> iznajmljeno = objekat.dajListu(DbBroker.getInstance().vratiSve(objekat));
            odgovor.setOdgovor(iznajmljeno);
            odgovor.setUspesno(true);
        } catch (SQLException ex) {
            Logger.getLogger(VratiIznajmljeno.class.getName()).log(Level.SEVERE, null, ex);
            odgovor.setUspesno(false);
            odgovor.setPoruka("Neuspesno uzimanje iznajmljenih vozila");
        }
        
        return odgovor;
    }
    
}
