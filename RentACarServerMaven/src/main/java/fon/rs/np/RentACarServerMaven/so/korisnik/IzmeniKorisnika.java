package fon.rs.np.RentACarServerMaven.so.korisnik;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarServerMaven.so.OpstaSistemskaOperacija;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

public class IzmeniKorisnika extends OpstaSistemskaOperacija {

    @Override
    public Odgovor izvrsiOperaciju(OpstiObjekat objekat) {
        Odgovor odgovor = new Odgovor();
        
        try {
            DbBroker.getInstance().izmeni(objekat);
            odgovor.setOdgovor(null);
            odgovor.setPoruka("Uspesno su izmenjeni podaci o korisniku");
            odgovor.setUspesno(true);
        } catch (SQLException ex) {
            Logger.getLogger(IzmeniKorisnika.class.getName()).log(Level.SEVERE, null, ex);
            odgovor.setPoruka("Neuspesno izmenjeni podaci o korisniku");
            odgovor.setUspesno(false);
        }
        
        return odgovor;
    }
    
}
