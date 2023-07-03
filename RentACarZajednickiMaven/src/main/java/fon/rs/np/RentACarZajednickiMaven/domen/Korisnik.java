package fon.rs.np.RentACarZajednickiMaven.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Predstavlja entitet "Korisnik" koji ima informacije o korisniku sistema za iznajmljivanje automobila.
 * Nasleđuje apstraktnu klasu OpstiObjekat.
 * 
 * @author Boris Zivanovic
 */

public class Korisnik extends OpstiObjekat {

	/**
	 * Id korisnika
	 */
    private Long id;
    /**
     * Ime korisnika
     */
    private String ime;
    /**
     * Prezime korisnika
     */
    private String prezime;
    /**
     * Jedinstveni maticni broj korisnika
     */
    private Long JMBG;
    /**
     * Datum rodjenja korisnika
     */
    private Date datumRodjenja;
    /**
     * Mesto odakle je korisnik
     */
    private Mesto mesto;

    /**
     * Konstruktor koji inicijalizuje objekat klase Korisnik sa svim atributima.
     *
     * @param id             identifikacioni broj korisnika
     * @param ime            ime korisnika
     * @param prezime        prezime korisnika
     * @param JMBG           JMBG (Jedinstveni matični broj građana) korisnika
     * @param datumRodjenja  datum rođenja korisnika
     * @param mesto          mesto prebivališta korisnika
     */
    
    public Korisnik(Long id, String ime, String prezime, Long JMBG, Date datumRodjenja, Mesto mesto) {
        setId(id);
        setIme(ime);
        setPrezime(prezime);
        setJMBG(JMBG);
        setDatumRodjenja(datumRodjenja);
        setMesto(mesto);
    }

    /**
     * Konstruktor koji inicijalizuje objekat klase Korisnik sa svim atributima,
     * osim identifikacionog broja.
     *
     * @param ime            ime korisnika
     * @param prezime        prezime korisnika
     * @param JMBG           JMBG (Jedinstveni matični broj građana) korisnika
     * @param datumRodjenja  datum rođenja korisnika
     * @param mesto          mesto prebivališta korisnika
     */
    
    public Korisnik(String ime, String prezime, Long JMBG, Date datumRodjenja, Mesto mesto) {
    	setIme(ime);
        setPrezime(prezime);
        setJMBG(JMBG);
        setDatumRodjenja(datumRodjenja);
        setMesto(mesto);
    }
    
    /**
     * Konstruktor koji inicijalizuje objekat klase Korisnik samo sa identifikacionim
     * brojem, imenom i prezimenom korisnika.
     *
     * @param id      identifikacioni broj korisnika
     * @param ime     ime korisnika
     * @param prezime prezime korisnika
     */
    
    public Korisnik(Long id ,String ime, String prezime) {
    	setId(id);
        setIme(ime);
        setPrezime(prezime);
    }
    
    /**
     * Konstruktor koji inicijalizuje objekat klase Korisnik samo sa imenom i prezimenom korisnika.
     *
     * @param ime     ime korisnika
     * @param prezime prezime korisnika
     */
    
    public Korisnik(String ime, String prezime) {
    	setIme(ime);
        setPrezime(prezime);
    }
    
    /**
     * Prazan konstruktor koji inicijalizuje objekat klase Korisnik.
     */
    
    public Korisnik() {
    }

    /**
     * Vraća string reprezentaciju trenutnog objekta.
     * String se sastoji od imena i prezimena korisnika.
     *
     * @return String reprezentacija trenutnog objekta
     */
    @Override
    public String toString() {
        return getIme() + " " + getPrezime();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.JMBG);
        return hash;
    }

    /**
     * Poređuje trenutni objekat sa drugim objektom, tacnije JMBG oba korisnika kako bi se utvrdilo da li su jednaki.
     *
     * @param o Objekat koji treba uporediti sa trenutnim objektom
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
        final Korisnik other = (Korisnik) obj;
        return Objects.equals(this.JMBG, other.JMBG);
    }
    
    /**
     * Vraća identifikacioni broj korisnika.
     *
     * @return identifikacioni broj korisnika
     */
    
    public Long getId() {
        return id;
    }

    /**
     * Postavlja identifikacioni broj korisnika.
     *
     * @param id identifikacioni broj korisnika
     * @throws IllegalArgumentException ako je id negativan broj
     */
    
    public void setId(Long id) {
    	 if(id < 0 )
         	throw new IllegalArgumentException("Id ne sme biti negativan broj");
        this.id = id;
    }

    /**
     * Vraća ime korisnika.
     *
     * @return ime korisnika
     */
    
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja ime korisnika.
     *
     * @param ime ime korisnika
     * @throws NullPointerException ako je ime null
     */
    
    public void setIme(String ime) {
    	if(ime == null )
    		throw new NullPointerException("Ime korisnika ne sme biti null");
        this.ime = ime;
    }

    
    /**
     * Vraća prezime korisnika.
     *
     * @return prezime korisnika
     */
    
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja prezime korisnika.
     *
     * @param prezime prezime korisnika
     * @throws NullPointerException ako je prezime null
     */
    
    public void setPrezime(String prezime) {
    	if(prezime == null )
    		throw new NullPointerException("Prezime korisnika ne sme biti null");
        this.prezime = prezime;
    }

    /**
     * Vraća JMBG (Jedinstveni matični broj građana) korisnika.
     *
     * @return JMBG korisnika
     */
    
    public Long getJMBG() {
        return JMBG;
    }

    /**
     * Postavlja JMBG (Jedinstveni matični broj građana) korisnika.
     *
     * @param JMBG JMBG korisnika
     * @throws IllegalArgumentException ako je JMBG negativan broj ili 0
     */
    
    public void setJMBG(Long JMBG) {
    	 if(JMBG < 0)
          	throw new IllegalArgumentException("JMBG ne sme biti negativan broj ili 0");
        this.JMBG = JMBG;
    }

    /**
     * Vraća datum rođenja korisnika.
     *
     * @return datum rođenja korisnika
     */
    
    public Date getDatumRodjenja() { //yyyy-MM-dd"
        return datumRodjenja;
    }

    /**
     * Postavlja datum rođenja korisnika.
     *
     * @param datumRodjenja datum rođenja korisnika
     * @throws NullPointerException ako je datum rodjenja null
     * @throws IllegalArgumentException ako je datum rodjenja nakon sadasnjeg
     */
    
    public void setDatumRodjenja(Date datumRodjenja) {
    	Date currentDate = new Date();
    	if(datumRodjenja ==null)
    		throw new NullPointerException("Datum rodjenja ne sme biti null");
        if (datumRodjenja.after(currentDate)) 
            throw new IllegalArgumentException("Datum ne sme biti u buducnosti");
        this.datumRodjenja = datumRodjenja;
    }

    /**
     * Vraća mesto prebivališta korisnika.
     *
     * @return mesto prebivališta korisnika
     */
    
    public Mesto getMesto() {
        return mesto;
    }

    /**
     * Postavlja mesto prebivališta korisnika.
     *
     * @param mesto mesto prebivališta korisnika
     * @throws IllegalArgumentException ako mesto nije u potpunosti inicijalizovano
     */
    
    public void setMesto(Mesto mesto) {
    	if(mesto == null || mesto.getId() == 0 || mesto.getNaziv().equals(""))
    		throw new IllegalArgumentException("Mesto ne sme biti null");
        this.mesto = mesto;
    }

    @Override
    public String vratiTabelu() {
        return "korisnik";
    }

    @Override
    public String insertKolone() {
        return "ime, prezime, jmbg, datum_rodjenja, id_mesta";
    }

    @Override
    public String dajVrednosti() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "('" + getIme() + "','" + getPrezime() + "'," + getJMBG() + ",'" + sdf.format(getDatumRodjenja()) + "'," + getMesto().getId() + ")";
    }

    @Override
    public List<OpstiObjekat> dajListu(ResultSet rs) {
        List<OpstiObjekat> korisnici = new ArrayList<>();

        try {
            while (rs.next()) {
                korisnici.add(new Korisnik(rs.getLong("id_korisnika"),
                        rs.getString("ime"), rs.getString("prezime"),
                        rs.getLong("jmbg"), rs.getDate("datum_rodjenja"),
                        new Mesto(rs.getLong("id_mesta"), rs.getString("naziv"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
        }

        return korisnici;
    }

    @Override
    public String whereUslov() {
        return " id_korisnika = " + getId();
    }

    @Override
    public String whereSelectUslov() {
        return " k JOIN mesto m ON k.id_mesta = m.idMesta";
    }

    @Override
    public String izmenaObjekta() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "ime = '" + getIme() + "', prezime = '" + getPrezime() + "', "
                + "jmbg = " + getJMBG() + ", datum_rodjenja = '" + sdf.format(getDatumRodjenja())
                + "', id_mesta = " + getMesto().getId();
    }

    @Override
    public String vratiKolone() {
        return "*";
    }

}
