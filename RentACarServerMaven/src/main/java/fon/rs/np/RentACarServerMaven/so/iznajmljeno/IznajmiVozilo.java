package fon.rs.np.RentACarServerMaven.so.iznajmljeno;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarZajednickiMaven.domen.Racun;
import fon.rs.np.RentACarZajednickiMaven.domen.StavkaRacuna;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarServerMaven.so.OpstaSistemskaOperacija;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

/**
 * Sistemska operacija za iznajmljivanje vozila.
 * 
 * @author Boris Zivanovic
 */

public class IznajmiVozilo extends OpstaSistemskaOperacija {

	 /**
     * Izvršava operaciju iznajmljivanja vozila.
     *
     * @param objekat Objekat koji sadrži podatke o računu i stavkama računa.
     * @return Odgovor koji sadrži iznajmljeni račun ili poruku o neuspešnom izvršavanju operacije.
     */
	
    @Override
    public Odgovor izvrsiOperaciju(OpstiObjekat objekat) {
        Odgovor odgovor = new Odgovor();
        
        try {
            Long id = DbBroker.getInstance().sacuvaj(objekat);
            Racun r = (Racun) objekat;
            r.setId(id);
            
            for(StavkaRacuna sr : r.getStavkaRacuna()) {
                sr.setRacun(r);
                sr.getIznajmljivanje().setId(DbBroker.getInstance().sacuvaj(sr.getIznajmljivanje()));
                DbBroker.getInstance().izmeni(sr.getVozilo());
                sr.setRbStavke(DbBroker.getInstance().sacuvaj(sr));
            }
            
            odgovor.setOdgovor(r);
            odgovor.setUspesno(true);
        } catch (SQLException ex) {
            Logger.getLogger(IznajmiVozilo.class.getName()).log(Level.SEVERE, null, ex);
            odgovor.setUspesno(false);
            odgovor.setPoruka("Neuspesno iznajmljivanje vozila");
        }
        
        return odgovor;
    }
    
}
