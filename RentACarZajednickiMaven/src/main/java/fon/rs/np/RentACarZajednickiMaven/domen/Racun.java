package fon.rs.np.RentACarZajednickiMaven.domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public class Racun extends OpstiObjekat {
    
    private Long id;
    private Date datumIzdavanja;
    private double cenaBezPDV;
    private double PDV;
    private double cenaSaPDV;
    private Korisnik korisnik;
    private List<StavkaRacuna> stavkaRacuna;

    public Racun(Long id, Date datumIzdavanja, double cenaBezPDV, double PDV, double cenaSaPDV, Korisnik korisnik, List<StavkaRacuna> stavkaRacuna) {
        this.id = id;
        this.datumIzdavanja = datumIzdavanja;
        this.cenaBezPDV = cenaBezPDV;
        this.PDV = PDV;
        this.cenaSaPDV = cenaSaPDV;
        this.korisnik = korisnik;
        this.stavkaRacuna = stavkaRacuna;
    }
    
    public Racun(Date datumIzdavanja, double cenaBezPDV, double PDV, double cenaSaPDV, Korisnik korisnik, List<StavkaRacuna> stavkaRacuna) {
        this.datumIzdavanja = datumIzdavanja;
        this.cenaBezPDV = cenaBezPDV;
        this.PDV = PDV;
        this.cenaSaPDV = cenaSaPDV;
        this.korisnik = korisnik;
        this.stavkaRacuna = stavkaRacuna;
    }
    
    public Racun(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public double getCenaBezPDV() {
        return cenaBezPDV;
    }

    public void setCenaBezPDV(double cenaBezPDV) {
        this.cenaBezPDV = cenaBezPDV;
    }

    public double getPDV() {
        return PDV;
    }

    public void setPDV(double PDV) {
        this.PDV = PDV;
    }

    public double getCenaSaPDV() {
        return cenaSaPDV;
    }

    public void setCenaSaPDV(double cenaSaPDV) {
        this.cenaSaPDV = cenaSaPDV;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public List<StavkaRacuna> getStavkaRacuna() {
        return stavkaRacuna;
    }

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
