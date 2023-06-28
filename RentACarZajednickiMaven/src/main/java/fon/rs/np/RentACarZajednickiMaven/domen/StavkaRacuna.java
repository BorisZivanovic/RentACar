package fon.rs.np.RentACarZajednickiMaven.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Predstavlja stavku računa.
 */

public class StavkaRacuna extends OpstiObjekat {

    private Long rbStavke;
    private Racun racun;
    private double iznos;
    private double PDV;
    private double iznosSaPDV;
    private Korisnik korisnik;
    private Vozilo vozilo;
    private Iznajmljivanje iznajmljivanje;

    /**
     * Konstruktor sa svim parametrima.
     *
     * @param rbStavke        redni broj stavke
     * @param racun           račun kojem stavka pripada
     * @param iznos           iznos stavke
     * @param PDV             PDV stavke
     * @param iznosSaPDV      iznos sa PDV-om stavke
     * @param korisnik        korisnik koji je iznajmio vozilo
     * @param vozilo          iznajmljeno vozilo
     * @param iznajmljivanje  iznajmljivanje koje je generisalo stavku računa
     */
    
    public StavkaRacuna(Long rbStavke, Racun racun, double iznos, double PDV, double iznosSaPDV, Korisnik korisnik, Vozilo vozilo, Iznajmljivanje iznajmljivanje) {
        this.rbStavke = rbStavke;
        this.racun = racun;
        this.iznos = iznos;
        this.PDV = PDV;
        this.iznosSaPDV = iznosSaPDV;
        this.korisnik = korisnik;
        this.vozilo = vozilo;
        this.iznajmljivanje = iznajmljivanje;
    }

    /**
     * Konstruktor sa iznosom, PDV-om, iznosom sa PDV-om, korisnikom, vozilom i iznajmljivanjem.
     *
     * @param iznos           iznos stavke
     * @param PDV             PDV stavke
     * @param iznosSaPDV      iznos sa PDV-om stavke
     * @param korisnik        korisnik koji je iznajmio vozilo
     * @param vozilo          iznajmljeno vozilo
     * @param iznajmljivanje  iznajmljivanje koje je generisalo stavku računa
     */
    
    public StavkaRacuna(double iznos, double PDV, double iznosSaPDV, Korisnik korisnik, Vozilo vozilo, Iznajmljivanje iznajmljivanje) {
        this.iznos = iznos;
        this.PDV = PDV;
        this.iznosSaPDV = iznosSaPDV;
        this.korisnik = korisnik;
        this.vozilo = vozilo;
        this.iznajmljivanje = iznajmljivanje;
    }

    /**
     * Konstruktor sa iznosom i PDV - om.
     * 
     * @param iznosSaPDV    iznos stavke sa PDV - om
     */
    
    public StavkaRacuna(double iznosSaPDV) {
        this.iznosSaPDV = iznosSaPDV;
    }

    /**
     * Prazan konstruktor.
     */
    
    public StavkaRacuna() {
    }

    @Override
    public String toString() {
        return iznos + " " + PDV + " " + iznosSaPDV + " " + korisnik + " " + vozilo.getStatusVozila() + " "
                + getIznajmljivanje().getDatumIznajmljivanja() + " " + getIznajmljivanje().getDatumVracanja();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof StavkaRacuna)) {
            return false;
        }
        StavkaRacuna sr = (StavkaRacuna) obj;
        if (sr.getVozilo().equals(this.getVozilo())) {
            return true;
        }
        return false;
    }

    /**
     * Vraća redni broj stavke.
     *
     * @return redni broj stavke
     */
    
    public Long getRbStavke() {
        return rbStavke;
    }

    /**
     * Postavlja redni broj stavke.
     *
     * @param rbStavke redni broj stavke
     */
    
    public void setRbStavke(Long rbStavke) {
        this.rbStavke = rbStavke;
    }

    /**
     * Vraća račun kojem stavka pripada.
     *
     * @return račun kojem stavka pripada
     */
    
    public Racun getRacun() {
        return racun;
    }

    /**
     * Postavlja račun kojem stavka pripada.
     *
     * @param racun račun kojem stavka pripada
     */
    
    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    /**
     * Vraća iznos stavke.
     *
     * @return iznos stavke
     */
    
    public double getIznos() {
        return iznos;
    }

    /**
     * Postavlja iznos stavke.
     *
     * @param iznos iznos stavke
     */
    
    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    /**
     * Vraća PDV stavke.
     *
     * @return PDV stavke
     */
    
    public double getPDV() {
        return PDV;
    }

    /**
     * Postavlja PDV stavke.
     *
     * @param PDV PDV stavke
     */
    
    public void setPDV(double PDV) {
        this.PDV = PDV;
    }

    /**
     * Vraća iznos sa PDV-om stavke.
     *
     * @return iznos sa PDV-om stavke
     */
    
    public double getIznosSaPDV() {
        return iznosSaPDV;
    }

    /**
     * Postavlja iznos sa PDV-om stavke.
     *
     * @param iznosSaPDV iznos sa PDV-om stavke
     */
    
    public void setIznosSaPDV(double iznosSaPDV) {
        this.iznosSaPDV = iznosSaPDV;
    }

    /**
     * Vraća korisnika za koga je stavka vezana.
     *
     * @return korisnik za koga je stavka vezana
     */
    
    public Korisnik getKorisnik() {
        return korisnik;
    }
    
    /**
     * Postavlja korisnika za koga je stavka vezana.
     *
     * @param korisnik korisnik za koga je stavka vezana
     */

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    /**
     * Vraća vozilo koje je iznajmljeno u okviru stavke.
     *
     * @return vozilo koje je iznajmljeno u okviru stavke
     */
    
    public Vozilo getVozilo() {
        return vozilo;
    }

    /**
     * Postavlja vozilo koje je iznajmljeno u okviru stavke.
     *
     * @param vozilo vozilo koje je iznajmljeno u okviru stavke
     */
    
    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    /**
     * Vraća iznajmljivanje koje je povezano sa stavkom.
     *
     * @return iznajmljivanje koje je povezano sa stavkom
     */
    
    public Iznajmljivanje getIznajmljivanje() {
        return iznajmljivanje;
    }

    /**
     * Postavlja iznajmljivanje koje je povezano sa stavkom.
     *
     * @param iznajmljivanje iznajmljivanje koje je povezano sa stavkom
     */
    
    public void setIznajmljivanje(Iznajmljivanje iznajmljivanje) {
        this.iznajmljivanje = iznajmljivanje;
    }

    @Override
    public String vratiTabelu() {
        return "stavka_racuna";
    }

    @Override
    public String vratiKolone() {
        return "sr.id_racun, sr.rbStavkeR, sr.iznos, sr.pdv, sr.iznos_sa_pdv, k.id_korisnika, k.ime, k.prezime, v.id_vozila, v.registarski_broj, v.marka, v.model, v.id_kategorije, i.idIznajmljivanja, i.datum_iznajmljivanja as datum_iznajmljivanja, i.datum_vracanja";
    }

    @Override
    public String insertKolone() {
        return "id_racun, iznos, pdv, iznos_sa_pdv, id_korisnika, id_vozila, id_iznajmljivanja";
    }

    @Override
    public String dajVrednosti() {
        return "(" + getRacun().getId() + "," + getIznos() + "," + getPDV() + ","
                + getIznosSaPDV() + "," + getKorisnik().getId() + "," + getVozilo().getId() + ","
                + getIznajmljivanje().getId() + ")";
    }

    @Override
    public List<OpstiObjekat> dajListu(ResultSet rs) {
        List<OpstiObjekat> iznajmljeno = new ArrayList<>();

        try {
            while (rs.next()) {
                if (rs.getString("k.ime") != null) {
                    StavkaRacuna sr = new StavkaRacuna(rs.getLong("sr.rbStavkeR"),
                            new Racun(rs.getLong("sr.id_racun")),
                            rs.getDouble("sr.iznos"), rs.getDouble("sr.pdv"), rs.getDouble("sr.iznos_sa_pdv"),
                            new Korisnik(rs.getLong("k.id_korisnika"),
                                    rs.getString("k.ime"), rs.getString("k.prezime")),
                            new Vozilo(rs.getLong("v.id_vozila"), rs.getString("v.registarski_broj"),
                                    rs.getString("v.marka"), rs.getString("v.model"),
                                    new KategorijaVozila(rs.getLong("v.id_kategorije"))),
                            new Iznajmljivanje(rs.getLong("i.idIznajmljivanja"),
                                    rs.getDate("datum_iznajmljivanja"),
                                    rs.getDate("i.datum_vracanja")));
                    if (!iznajmljeno.contains(sr)) {
                        iznajmljeno.add(sr);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StavkaRacuna.class.getName()).log(Level.SEVERE, null, ex);
        }

        return iznajmljeno;
    }

    @Override
    public String whereUslov() {
        return "";
    }

    @Override
    public String whereSelectUslov() {
        return " sr "
                + "INNER JOIN iznajmljivanje i ON sr.id_iznajmljivanja = i.idIznajmljivanja"
                + " JOIN korisnik k ON sr.id_korisnika = k.id_korisnika "
                + " JOIN vozilo v ON sr.id_vozila = v.id_vozila"
                + " WHERE v.status = 'zauzeto' AND i.datum_iznajmljivanja = ("
                + "	SELECT MAX(ii.datum_iznajmljivanja)"
                + "				FROM iznajmljivanje ii"
                + "				WHERE ii.id_korisnika = i.id_korisnika AND i.id_vozila = ii.id_vozila)"
                + " GROUP BY v.id_vozila";
    }

    @Override
    public String izmenaObjekta() {
        return "";
    }

}
