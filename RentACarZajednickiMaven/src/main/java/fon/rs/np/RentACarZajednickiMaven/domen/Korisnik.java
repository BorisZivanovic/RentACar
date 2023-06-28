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
 * Predstavlja entitet "Korisnik" koji ima informacije o korisniku sistema.
 * Nasleđuje apstraktnu klasu OpstiObjekat.
 */

public class Korisnik extends OpstiObjekat {

    private Long id;
    private String ime;
    private String prezime;
    private Long JMBG;
    private Date datumRodjenja;
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
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.datumRodjenja = datumRodjenja;
        this.mesto = mesto;
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
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.datumRodjenja = datumRodjenja;
        this.mesto = mesto;
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
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
    }
    
    /**
     * Konstruktor koji inicijalizuje objekat klase Korisnik samo sa imenom i prezimenom korisnika.
     *
     * @param ime     ime korisnika
     * @param prezime prezime korisnika
     */
    
    public Korisnik(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }
    
    /**
     * Prazan konstruktor koji inicijalizuje objekat klase Korisnik.
     */
    
    public Korisnik() {
    }

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
     */
    
    public void setId(Long id) {
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
     */
    
    public void setIme(String ime) {
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
     */
    
    public void setPrezime(String prezime) {
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
     */
    
    public void setJMBG(Long JMBG) {
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
     */
    
    public void setDatumRodjenja(Date datumRodjenja) {
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
     */
    
    public void setMesto(Mesto mesto) {
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
