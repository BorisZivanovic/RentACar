package fon.rs.np.RentACarServerMaven.so.korisnik;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarServerMaven.so.OpstaSistemskaOperacija;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

public class SacuvajKorisnika extends OpstaSistemskaOperacija {

    @Override
    public Odgovor izvrsiOperaciju(OpstiObjekat objekat) {
        Odgovor odgovor = new Odgovor();
        
        try {
            Long id = DbBroker.getInstance().sacuvaj(objekat);
            odgovor.setUspesno(true);
            odgovor.setOdgovor(id);
            odgovor.setPoruka("Uspesno sacuvan korisnik");
        } catch (SQLException ex) {
            Logger.getLogger(SacuvajKorisnika.class.getName()).log(Level.SEVERE, null, ex);
            odgovor.setUspesno(false);
            odgovor.setPoruka("Nije uspesno sacuvan korisnik");
        }
        
        return odgovor;
    }
    
}
