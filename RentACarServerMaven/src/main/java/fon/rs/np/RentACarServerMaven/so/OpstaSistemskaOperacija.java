package fon.rs.np.RentACarServerMaven.so;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

public abstract class OpstaSistemskaOperacija {
    
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
    
    public abstract Odgovor izvrsiOperaciju(OpstiObjekat objekat);
    
}
