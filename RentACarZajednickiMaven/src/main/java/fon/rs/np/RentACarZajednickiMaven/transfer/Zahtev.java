package fon.rs.np.RentACarZajednickiMaven.transfer;

import fon.rs.np.RentACarZajednickiMaven.domen.Iznajmljivanje;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.io.Serializable;
import java.util.List;
import fon.rs.np.RentACarZajednickiMaven.operacija.Operacija;

public class Zahtev implements Serializable {
    
    private OpstiObjekat objekat;
    private Operacija operacija;
    private List<Iznajmljivanje> lista;
    
    public Zahtev(OpstiObjekat objekat, Operacija operacija) {
        this.objekat = objekat;
        this.operacija = operacija;
    }

    public Zahtev(Operacija operacija, List<Iznajmljivanje> lista) {
        this.lista = lista;
        this.operacija = operacija;
    }
    
    public Zahtev() {
    }

    public OpstiObjekat getObjekat() {
        return objekat;
    }

    public void setObjekat(OpstiObjekat objekat) {
        this.objekat = objekat;
    }

    public Operacija getOperacija() {
        return operacija;
    }

    public void setOperacija(Operacija operacija) {
        this.operacija = operacija;
    }

    public List<Iznajmljivanje> getLista() {
        return lista;
    }
    
}
