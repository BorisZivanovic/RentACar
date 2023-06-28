package fon.rs.np.RentACarZajednickiMaven.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mesto extends OpstiObjekat {
    
    private Long id;
    private String naziv;

    public Mesto(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public Mesto() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.naziv);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mesto other = (Mesto) obj;
        return Objects.equals(this.naziv, other.naziv);
    }
    
    @Override
    public String toString() {
        return getNaziv();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String vratiTabelu() {
        return "mesto";
    }

    @Override
    public String insertKolone() {
        return null;
    }

    @Override
    public String dajVrednosti() {
        return null;
    }

    @Override
    public List<OpstiObjekat> dajListu(ResultSet rs) {
        List<OpstiObjekat> mesta = new ArrayList<>();
        
        try {
            while(rs.next()) {
                mesta.add(new Mesto(rs.getLong("idMesta"), rs.getString("naziv")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mesta;
    }

    @Override
    public String whereUslov() {
        return " id = " + getId();
    }

    @Override
    public String whereSelectUslov() {
        return "";
    }

    @Override
    public String izmenaObjekta() {
        return "";
    }

    @Override
    public String vratiKolone() {
        return "*";
    }
    
}
