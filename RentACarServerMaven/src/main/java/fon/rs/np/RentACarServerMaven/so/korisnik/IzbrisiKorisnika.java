package fon.rs.np.RentACarServerMaven.so.korisnik;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarServerMaven.so.OpstaSistemskaOperacija;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

/**
 * Sistemska operacija za brisanje korisnika iz sistema.
 */

public class IzbrisiKorisnika extends OpstaSistemskaOperacija {

	/**
     * Izvršava operaciju brisanja korisnika iz sistema.
     *
     * @param objekat Objekat koji predstavlja korisnika koji se briše.
     * @return Odgovor koji sadrži poruku o uspešnom brisanju ili poruku o neuspešnom izvršavanju operacije.
     */
	
    @Override
    public Odgovor izvrsiOperaciju(OpstiObjekat objekat) {
        Odgovor odgovor = new Odgovor();
        
        try {
            DbBroker.getInstance().izbrisi(objekat);
            odgovor.setOdgovor(null);
            odgovor.setUspesno(true);
            odgovor.setPoruka("Uspesno je izbrisan korisnik");
        } catch (SQLException ex) {
            Logger.getLogger(IzbrisiKorisnika.class.getName()).log(Level.SEVERE, null, ex);
            odgovor.setUspesno(false);
            odgovor.setPoruka("Nije uspeo da se izbrise korisnik");
        }
        
        return odgovor;
    }

}
