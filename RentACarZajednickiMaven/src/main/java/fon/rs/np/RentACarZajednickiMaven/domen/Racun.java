package fon.rs.np.RentACarZajednickiMaven.domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 * Klasa koja predstavlja račun u sistemu Rent-a-Car.
 * Nasleđuje apstraktnu klasu OpstiObjekat.
 */

public class Racun extends OpstiObjekat {
	
    private Long id;
    private Date datumIzdavanja;
    private double cenaBezPDV;
    private double PDV;
    private double cenaSaPDV;
    private Korisnik korisnik;
    private List<StavkaRacuna> stavkaRacuna;

    /**
     * Konstruktor koji inicijalizuje objekat Račun sa svim atributima.
     *
     * @param id                identifikator računa
     * @param datumIzdavanja    datum izdavanja računa
     * @param cenaBezPDV        cena bez PDV-a
     * @param PDV               iznos PDV-a
     * @param cenaSaPDV         cena sa PDV-om
     * @param korisnik          korisnik koji je izdao račun
     * @param stavkaRacuna      lista stavki računa
     */
    
    public Racun(Long id, Date datumIzdavanja, double cenaBezPDV, double PDV, double cenaSaPDV, Korisnik korisnik, List<StavkaRacuna> stavkaRacuna) {
        this.id = id;
        this.datumIzdavanja = datumIzdavanja;
        this.cenaBezPDV = cenaBezPDV;
        this.PDV = PDV;
        this.cenaSaPDV = cenaSaPDV;
        this.korisnik = korisnik;
        this.stavkaRacuna = stavkaRacuna;
    }
    
    /**
     * Konstruktor koji inicijalizuje objekat Račun bez identifikatora.
     *
     * @param datumIzdavanja    datum izdavanja računa
     * @param cenaBezPDV        cena bez PDV-a
     * @param PDV               iznos PDV-a
     * @param cenaSaPDV         cena sa PDV-om
     * @param korisnik          korisnik koji je izdao račun
     * @param stavkaRacuna      lista stavki računa
     */
    
    public Racun(Date datumIzdavanja, double cenaBezPDV, double PDV, double cenaSaPDV, Korisnik korisnik, List<StavkaRacuna> stavkaRacuna) {
        this.datumIzdavanja = datumIzdavanja;
        this.cenaBezPDV = cenaBezPDV;
        this.PDV = PDV;
        this.cenaSaPDV = cenaSaPDV;
        this.korisnik = korisnik;
        this.stavkaRacuna = stavkaRacuna;
    }
    
    /**
     * Konstruktor koji inicijalizuje objekat Račun sa datim identifikatorom.
     *
     * @param id identifikator računa
     */
    
    public Racun(Long id) {
        this.id = id;
    }

    /**
     * Getter za ID racuna.
     * 
     * @return ID racuna
     */
    
    public Long getId() {
        return id;
    }

    /**
     * Setter za ID racuna.
     * 
     * @param id ID racuna
     */
    
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter za datum izdavanja racuna.
     * 
     * @return datum izdavanja racuna
     */
    
    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    /**
     * Setter za datum izdavanja racuna.
     * 
     * @param datumIzdavanja datum izdavanja racuna
     */
    
    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    /**
     * Getter za cenu bez PDV-a.
     * 
     * @return cena bez PDV-a
     */
    
    public double getCenaBezPDV() {
        return cenaBezPDV;
    }

    /**
     * Setter za cenu bez PDV-a.
     * 
     * @param cenaBezPDV cena bez PDV-a
     */
    
    public void setCenaBezPDV(double cenaBezPDV) {
        this.cenaBezPDV = cenaBezPDV;
    }

    /**
     * Getter za PDV.
     * 
     * @return PDV
     */
    
    public double getPDV() {
        return PDV;
    }

    /**
     * Setter za PDV.
     * 
     * @param PDV PDV
     */
    
    public void setPDV(double PDV) {
        this.PDV = PDV;
    }

    /**
     * Getter za cenu sa PDV-om.
     * 
     * @return cena sa PDV-om
     */
    
    public double getCenaSaPDV() {
        return cenaSaPDV;
    }

    /**
     * Setter za cenu sa PDV-om.
     * 
     * @param cenaSaPDV cena sa PDV-om
     */
    
    public void setCenaSaPDV(double cenaSaPDV) {
        this.cenaSaPDV = cenaSaPDV;
    }

    /**
     * Getter za korisnika racuna.
     * 
     * @return korisnik racuna
     */
    
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * Setter za korisnika racuna.
     * 
     * @param korisnik korisnik racuna
     */
    
    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    /**
     * Getter za listu stavki racuna.
     * 
     * @return lista stavki racuna
     */
    
    public List<StavkaRacuna> getStavkaRacuna() {
        return stavkaRacuna;
    }

    /**
     * Setter za listu stavki racuna.
     * 
     * @param stavkaRacuna lista stavki racuna
     */
    
    public void setStavkaRacuna(List<StavkaRacuna> stavkaRacuna) {
        this.stavkaRacuna = stavkaRacuna;
    }
    
    @Override
    public String vratiTabelu() {
        return "racun";
    }

    @Override
    public String vratiKolone() {
        return "";
    }

    @Override
    public String insertKolone() {
        return "datum_izdavanja,cena_bez_pdv, pdv, cena_sa_pdv, id_korisnika";
    }

    @Override
    public String dajVrednosti() {
        return "('" + getDatumIzdavanja() + "'," + getCenaBezPDV() + "," + getPDV() + "," + getCenaSaPDV() + "," + 
                getKorisnik().getId() + ")";
    }

    @Override
    public List<OpstiObjekat> dajListu(ResultSet rs) {
        return null;
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
    
}
