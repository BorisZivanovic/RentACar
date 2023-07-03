package fon.rs.np.RentACarServerMaven.so.korisnik;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.Korisnik;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarServerMaven.so.OpstaSistemskaOperacija;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

/**
 * Sistemska operacija za vraćanje liste korisnika.
 * 
 * @author Boris Zivanovic
 */

public class VratiKorisnike extends OpstaSistemskaOperacija {

	/**
     * Izvršava operaciju vraćanja liste korisnika.
     *
     * @param objekat Objekat koji predstavlja kriterijum pretrage korisnika.
     * @return Odgovor koji sadrži listu pronađenih korisnika ili poruku o neuspešnom izvršavanju operacije.
     */
	
    @Override
    public Odgovor izvrsiOperaciju(OpstiObjekat objekat) {
        Odgovor odgovor = new Odgovor();
        
        try {
            List<OpstiObjekat> korisnici = objekat.dajListu(DbBroker.getInstance().vratiSve(objekat));
            odgovor.setOdgovor(korisnici);
            odgovor.setUspesno(true);
        } catch (SQLException ex) {
            Logger.getLogger(VratiKorisnike.class.getName()).log(Level.SEVERE, null, ex);
            odgovor.setUspesno(false);
            odgovor.setOdgovor(null);
        }
        
        return odgovor;
    }
    
}
