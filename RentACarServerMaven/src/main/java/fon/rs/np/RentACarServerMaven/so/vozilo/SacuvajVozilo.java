package fon.rs.np.RentACarServerMaven.so.vozilo;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarServerMaven.so.OpstaSistemskaOperacija;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

/**
 * Sistemska operacija za čuvanje podataka o vozilu.
 * 
 * @author Boris Zivanovic
 */

public class SacuvajVozilo extends OpstaSistemskaOperacija {

	/**
     * Izvršava operaciju čuvanja podataka o vozilu.
     *
     * @param objekat Objekat koji predstavlja vozilo koje treba sačuvati.
     * @return Odgovor koji sadrži informaciju o uspešnosti čuvanja vozila ili poruku o neuspešnom izvršavanju operacije.
     */
	
    @Override
    public Odgovor izvrsiOperaciju(OpstiObjekat objekat) {
        Odgovor odgovor = new Odgovor();
        try {
            DbBroker.getInstance().sacuvaj(objekat);
            odgovor.setOdgovor(null);
            odgovor.setPoruka("Uspesno sacuvano vozilo");
            odgovor.setUspesno(true);
        } catch (SQLException ex) {
            Logger.getLogger(SacuvajVozilo.class.getName()).log(Level.SEVERE, null, ex);
            odgovor.setUspesno(false);
            try {
                throw new Exception("Neuspesno sacuvano vozilo");
            } catch (Exception ex1) {
                Logger.getLogger(SacuvajVozilo.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return odgovor;
    }

}
