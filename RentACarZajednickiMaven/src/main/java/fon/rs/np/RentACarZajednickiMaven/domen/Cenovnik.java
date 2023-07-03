package fon.rs.np.RentACarZajednickiMaven.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Predstavlja objekat cenovnika koji sadrži informacije o cenama i opisima usluga.
 * Cenovnik se koristi za definisanje tarifa i pruža informacije o dostupnim uslugama i njihovim cenama.
 * Svaki cenovnik ima svoj jedinstveni identifikator, naziv i opis.
 * 
 * @author Boris Zivanovic
 */

public class Cenovnik extends OpstiObjekat {
	
	/**
	 * Id cenovnika
	 */
    private Long id;
    /**
     * Naziv cenovnika
     */
    private String naziv;
    /**
     * Opis cenovnika
     */
    private String opis;

    /**
     * Konstruktor koji inicijalizuje objekat cenovnika sa prosleđenim identifikatorom, nazivom i opisom.
     *
     * @param id      identifikator cenovnika
     * @param naziv   naziv cenovnika
     * @param opis    opis cenovnika
     */
    
    public Cenovnik(Long id, String naziv, String opis) {
        setId(id);
        setNaziv(naziv);
        setOpis(opis);
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
     * @throws IllegalArgumentException ako je id negativan broj
     */
    
    public void setId(Long id) {
        if(id < 0 )
        	throw new IllegalArgumentException("Id ne sme biti negativan broj");
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
     * @throws NullPointerException ako je naziv null
     */
    
    public void setNaziv(String naziv) {
    	if(naziv == null )
    		throw new NullPointerException("Naziv cenovnika ne sme biti null");
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
     * @throws NullPointerException ako je opis null
     */
    
    public void setOpis(String opis) {
    	if(opis == null )
    		throw new NullPointerException("Opis cenovnika ne sme biti null");
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
