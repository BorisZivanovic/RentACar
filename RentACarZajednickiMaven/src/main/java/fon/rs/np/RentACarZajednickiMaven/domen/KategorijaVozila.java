package fon.rs.np.RentACarZajednickiMaven.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa predstavlja kategoriju vozila.
 * Kategorija vozila se koristi za klasifikaciju vozila prema određenim karakteristikama.
 * Svaka kategorija ima jedinstveni identifikator, naziv i cenu.
 * 
 * @author Boris Zivanovic
 */

public class KategorijaVozila extends OpstiObjekat {

	/**
	 * Id kategorije vozila
	 */
    private Long id;
    /**
     * Naziv kategorije vozila
     */
    private String naziv;
    /**
     * cena kategorije vozila
     */
    private double cena;

    /**
     * Konstruktor koji inicijalizuje objekat sa prosleđenim identifikatorom, nazivom i cenom.
     * 
     * @param id identifikator kategorije vozila
     * @param naziv naziv kategorije vozila
     * @param cena cena kategorije vozila
     */
    
    public KategorijaVozila(Long id, String naziv, double cena) {
        setId(id);
        setNaziv(naziv);
        setCena(cena);
    }

    /**
     * Konstruktor koji inicijalizuje objekat sa prosleđenim nazivom.
     * 
     * @param naziv naziv kategorije vozila
     */
    
    public KategorijaVozila(String naziv) {
        setNaziv(naziv);
    }
    
    /**
     * Konstruktor koji inicijalizuje objekat sa prosleđenim identifikatorom.
     * 
     * @param id identifikator kategorije vozila
     */
    
    public KategorijaVozila(Long id) {
       setId(id);
    }
    
    /**
     * Podrazumevani konstruktor.
     */
    
    public KategorijaVozila() {
    }

    /**
     * Vraća string reprezentaciju objekta klase KategorijaVozila.
     * String se sastoji od naziva kategorije vozila.
     *
     * @return string reprezentacija objekta
     */
    @Override
    public String toString() {
        return getNaziv();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.naziv);
        return hash;
    }

    /**
     * Poređenje objekata klase KategorijaVozila.
     * Dva objekta se smatraju jednakim ako imaju isti naziv.
     *
     * @param obj objekat koji se poredi
     * @return true ako su objekti jednaki, false inače
     */
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
        final KategorijaVozila other = (KategorijaVozila) obj;
        return Objects.equals(this.naziv, other.naziv);
    }
    
    /**
     * Getter metoda za identifikator kategorije vozila.
     * 
     * @return identifikator kategorije vozila
     */
    
    public Long getId() {
        return id;
    }

    /**
     * Setter metoda za identifikator kategorije vozila.
     * 
     * @param id identifikator kategorije vozila
     * @throws IllegalArgumentException ako je id negativan broj
     */
    
    public void setId(Long id) {
    	if(id < 0 )
        	throw new IllegalArgumentException("Id ne sme biti negativan broj");
        this.id = id;
    }

    /**
     * Getter metoda za naziv kategorije vozila.
     * 
     * @return naziv kategorije vozila
     */
    
    public String getNaziv() {
        return naziv;
    }

    /**
     * Setter metoda za naziv kategorije vozila.
     * 
     * @param naziv naziv kategorije vozila
     * @throws NullPointerException ako je naziv null
     */
    
    public void setNaziv(String naziv) {
    	if(naziv == null )
    		throw new NullPointerException("Kategorija vozila ne sme biti null");
        this.naziv = naziv;
    }

    /**
     * Getter metoda za cenu kategorije vozila.
     * 
     * @return cena kategorije vozila
     */
    
    public double getCena() {
        return cena;
    }

    /**
     * Setter metoda za cenu kategorije vozila.
     * 
     * @param cena cena kategorije vozila
     * @throws IllegalArgumentException ako je cena negativan broj
     */
    
    public void setCena(double cena) {
    	if(cena < 0 )
        	throw new IllegalArgumentException("Cena ne sme biti negativan broj");
        this.cena = cena;
    }

    @Override
    public String vratiTabelu() {
        return "kategorija_vozila";
    }

    @Override
    public String insertKolone() {
        return "";
    }

    @Override
    public String dajVrednosti() {
        return "";
    }

    @Override
    public List<OpstiObjekat> dajListu(ResultSet rs) {
        List<OpstiObjekat> kategorije = new ArrayList<>();

        try {
            while (rs.next()) {
                KategorijaVozila kv = new KategorijaVozila(rs.getLong("id_kategorije"),
                        rs.getString("naziv"), rs.getDouble("cena"));
                kategorije.add(kv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KategorijaVozila.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kategorije;
    }

    @Override
    public String whereUslov() {
        return "";
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
