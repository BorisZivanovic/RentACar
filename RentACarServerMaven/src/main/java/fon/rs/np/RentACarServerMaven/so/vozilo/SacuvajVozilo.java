package fon.rs.np.RentACarServerMaven.so.vozilo;

import fon.rs.np.RentACarServerMaven.baza.DbBroker;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarServerMaven.so.OpstaSistemskaOperacija;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

public class SacuvajVozilo extends OpstaSistemskaOperacija {

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
