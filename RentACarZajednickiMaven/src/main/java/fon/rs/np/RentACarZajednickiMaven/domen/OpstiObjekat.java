package fon.rs.np.RentACarZajednickiMaven.domen;

import java.io.Serializable;
import java.util.List;
import java.sql.ResultSet;

public abstract class OpstiObjekat implements Serializable {

    public abstract String vratiTabelu();
    
    public abstract String vratiKolone();

    public abstract String insertKolone();

    public abstract String dajVrednosti();
    
    public abstract List<OpstiObjekat> dajListu(ResultSet rs);

    public abstract String whereUslov();
    
    public abstract String whereSelectUslov();

    public abstract String izmenaObjekta();
    
}
