package fon.rs.np.RentACarServerMaven.so;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

/**
 * Apstraktna sistemska operacija koju sve konkretne sistemske operacije nasleđuju.
 */

public abstract class OpstaSistemskaOperacija {
    
	/**
     * Izvršava tranziciju koja se sastoji od otvaranja konekcije,
     * izvršavanja konkretne operacije, potvrde (commit) ili poništenja (rollback) transakcije i zatvaranja konekcije.
     *
     * @param objekat Objekat nad kojim se izvršava operacija.
     * @return Odgovor koji predstavlja rezultat izvršavanja operacije.
     */
	
    public Odgovor izvrsiTranziciju(OpstiObjekat objekat) {
        Odgovor odgovor = new Odgovor();
        
        try {
            DbBroker.getInstance().otvoriKonekciju();
            odgovor = izvrsiOperaciju(objekat);
            DbBroker.getInstance().commit();
            
        } catch (Exception ex) {
            Logger.getLogger(OpstaSistemskaOperacija.class.getName()).log(Level.SEVERE, null, ex);
            DbBroker.getInstance().rollback();
            odgovor.setUspesno(false);
            odgovor.setPoruka(ex.getMessage());
        } finally {
            DbBroker.getInstance().zatvoriKonekciju();
        }
        
        return odgovor;
    }
    
    /**
     * Izvršava konkretnu operaciju nad objektom.
     *
     * @param objekat Objekat nad kojim se izvršava operacija.
     * @return Odgovor koji predstavlja rezultat izvršavanja operacije.
     */
    
    public abstract Odgovor izvrsiOperaciju(OpstiObjekat objekat);
    
}
