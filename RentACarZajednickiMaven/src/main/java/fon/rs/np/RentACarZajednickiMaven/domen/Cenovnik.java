package fon.rs.np.RentACarZajednickiMaven.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Predstavlja objekat cenovnika.
 */

public class Cenovnik extends OpstiObjekat {
	
    private Long id;
    private String naziv;
    private String opis;

    /**
     * Konstruktor koji inicijalizuje objekat cenovnika sa prosleđenim identifikatorom, nazivom i opisom.
     *
     * @param id      identifikator cenovnika
     * @param naziv   naziv cenovnika
     * @param opis    opis cenovnika
     */
    
    public Cenovnik(Long id, String naziv, String opis) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
    }

    @Override
    public String toString() {
        return getNaziv();
    }
    
    /**
     * Prazan konstruktor koji inicijalizuje objekat cenovnika sa podrazumevanim vrednostima.
     */
    
    public Cenovnik() {
    }

    /**
     * Vraća identifikator cenovnika.
     *
     * @return identifikator cenovnika
     */
    
    public Long getId() {
        return id;
    }

    /**
     * Postavlja identifikator cenovnika.
     *
     * @param id identifikator cenovnika
     */
    
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vraća naziv cenovnika.
     *
     * @return naziv cenovnika
     */
    
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja naziv cenovnika.
     *
     * @param naziv naziv cenovnika
     */
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     * Vraća opis cenovnika.
     *
     * @return opis cenovnika
     */
    
    public String getOpis() {
        return opis;
    }

    /**
     * Postavlja opis cenovnika.
     *
     * @param opis opis cenovnika
     */
    
    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String vratiTabelu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String insertKolone() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String dajVrednosti() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OpstiObjekat> dajListu(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String whereUslov() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String whereSelectUslov() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String izmenaObjekta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKolone() {
        return "*";
    }

}
