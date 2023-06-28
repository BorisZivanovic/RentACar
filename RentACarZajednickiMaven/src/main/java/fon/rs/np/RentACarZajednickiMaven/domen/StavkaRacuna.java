package fon.rs.np.RentACarZajednickiMaven.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StavkaRacuna extends OpstiObjekat {

    private Long rbStavke;
    private Racun racun;
    private double iznos;
    private double PDV;
    private double iznosSaPDV;
    private Korisnik korisnik;
    private Vozilo vozilo;
    private Iznajmljivanje iznajmljivanje;

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

    public StavkaRacuna(double iznos, double PDV, double iznosSaPDV, Korisnik korisnik, Vozilo vozilo, Iznajmljivanje iznajmljivanje) {
        this.iznos = iznos;
        this.PDV = PDV;
        this.iznosSaPDV = iznosSaPDV;
        this.korisnik = korisnik;
        this.vozilo = vozilo;
        this.iznajmljivanje = iznajmljivanje;
    }

    public StavkaRacuna(double iznosSaPDV) {
        this.iznosSaPDV = iznosSaPDV;
    }

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

    public Long getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(Long rbStavke) {
        this.rbStavke = rbStavke;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public double getPDV() {
        return PDV;
    }

    public void setPDV(double PDV) {
        this.PDV = PDV;
    }

    public double getIznosSaPDV() {
        return iznosSaPDV;
    }

    public void setIznosSaPDV(double iznosSaPDV) {
        this.iznosSaPDV = iznosSaPDV;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    public Iznajmljivanje getIznajmljivanje() {
        return iznajmljivanje;
    }

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
