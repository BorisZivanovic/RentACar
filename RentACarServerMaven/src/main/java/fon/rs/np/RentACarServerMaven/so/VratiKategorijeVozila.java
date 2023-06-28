package fon.rs.np.RentACarServerMaven.so;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

/**
 * Sistemska operacija koja vraća sve kategorije vozila iz baze podataka.
 */

public class VratiKategorijeVozila extends OpstaSistemskaOperacija {

	/**
     * Izvršava operaciju vraćanja kategorija vozila.
     *
     * @param objekat Objekat koji predstavlja kategoriju vozila.
     * @return Odgovor koji sadrži listu pronađenih kategorija vozila.
     */
	
    @Override
    public Odgovor izvrsiOperaciju(OpstiObjekat objekat) {
        Odgovor odgovor = new Odgovor();

        try {
            List<OpstiObjekat> kategorije = objekat.dajListu(DbBroker.getInstance().vratiSve(objekat));

            odgovor.setOdgovor(kategorije);
            odgovor.setUspesno(true);
            odgovor.setPoruka("Sistem je uspesno pronasao kategorije vozila");

        } catch (SQLException ex) {
            Logger.getLogger(VratiKategorijeVozila.class.getName()).log(Level.SEVERE, null, ex);
            odgovor.setUspesno(false);
            try {
                throw new Exception("Nisu pronadjene kategorije vozila");
            } catch (Exception ex1) {
                Logger.getLogger(VratiKategorijeVozila.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return odgovor;
    }

}
