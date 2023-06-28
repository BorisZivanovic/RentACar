package fon.rs.np.RentACarServerMaven.so.vozilo;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarServerMaven.so.OpstaSistemskaOperacija;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

/**
 * Sistemska operacija za izmenu podataka o vozilu.
 */

public class IzmeniVozilo extends OpstaSistemskaOperacija {

	/**
     * Izvršava operaciju izmene podataka o vozilu.
     *
     * @param objekat Objekat koji predstavlja vozilo sa izmenjenim podacima.
     * @return Odgovor koji sadrži informaciju o uspešnosti izmene podataka o vozilu ili poruku o neuspešnom izvršavanju operacije.
     */
	
    @Override
    public Odgovor izvrsiOperaciju(OpstiObjekat objekat) {
        Odgovor odgovor = new Odgovor();
        
        try {
            DbBroker.getInstance().izmeni(objekat);
            odgovor.setOdgovor(null);
            odgovor.setPoruka("Uspesno izmenjeni podaci o vozilu");
            odgovor.setUspesno(true);
        } catch (SQLException ex) {
            Logger.getLogger(IzmeniVozilo.class.getName()).log(Level.SEVERE, null, ex);
            odgovor.setUspesno(false);
            odgovor.setPoruka("Greska prilikom promene podataka o vozilu");
        }
        
        return odgovor;
    }
    
}
