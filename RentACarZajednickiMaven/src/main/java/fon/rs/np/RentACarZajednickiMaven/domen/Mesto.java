package fon.rs.np.RentACarZajednickiMaven.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa koja predstavlja entitet Mesto.
 */

public class Mesto extends OpstiObjekat {
    
    private Long id;
    private String naziv;

    /**
     * Konstruktor koji inicijalizuje objekat klase Mesto sa zadatim id-om i nazivom.
     *
     * @param id    identifikacioni broj mesta
     * @param naziv naziv mesta
     */
    
    public Mesto(Long id, String naziv) {
        setId(id);
        setNaziv(naziv);
    }

    /**
     * Prazan konstruktor koji inicijalizuje objekat klase Mesto.
     */
    
    public Mesto() {
    }

    /**
     * Vraća naziv mesta.
     *
     * @return naziv mesta
     */
    
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
    
    /**
     * Vraća identifikacioni broj mesta.
     *
     * @return identifikacioni broj mesta
     */
    
    public Long getId() {
        return id;
    }

    /**
     * Postavlja identifikacioni broj mesta.
     *
     * @param id identifikacioni broj mesta
     */

    
    public void setId(Long id) {
    	if(id < 0)
    		throw new IllegalArgumentException("Id ne sme biti negativan broj");
        this.id = id;
    }

    /**
     * Vraća naziv mesta.
     *
     * @return naziv mesta
     */
    
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja naziv mesta.
     *
     * @param naziv naziv mesta
     */
    
    public void setNaziv(String naziv) {
    	if(naziv == null )
    		throw new NullPointerException("Naziv mesta ne sme biti null");
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
