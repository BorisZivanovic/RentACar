package fon.rs.np.RentACarZajednickiMaven.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Predstavlja objekat iznajmljivanja u sistemu Rent-a-Car.
 * 
 * Objekat iznajmljivanja sadrži informacije o korisniku koji je iznajmio vozilo, iznajmljenom vozilu,
 * datumu iznajmljivanja i datumu vraćanja vozila.
 * 
 * @author Boris Zivanovic
 */

public class Iznajmljivanje extends OpstiObjekat {

	/**
	 * Identifikator iznajmljivanja
	 */
    private Long id;
    /**
     * Korisnik koji je iznajmio vozilo
     */
    private Korisnik korisnik;
    /**
     * Iznajmljeno vozilo
     */
    private Vozilo vozilo;
    /**
     * Datum iznajmljivanja vozila
     */
    private Date datumIznajmljivanja;
    /**
     * Datum vracanja vozila
     */
    private Date datumVracanja;

    /**
     * Konstruktor koji inicijalizuje objekat iznajmljivanja sa prosleđenim identifikatorom, korisnikom, vozilom,
     * datumom iznajmljivanja i datumom vraćanja.
     *
     * @param id                  identifikator iznajmljivanja
     * @param korisnik            korisnik koji je iznajmio vozilo
     * @param vozilo              iznajmljeno vozilo
     * @param datumIznajmljivanja datum iznajmljivanja
     * @param datumVracanja       datum vraćanja vozila
     */
    
    public Iznajmljivanje(Long id, Korisnik korisnik, Vozilo vozilo, Date datumIznajmljivanja, Date datumVracanja) {
        setId(id);
        setKorisnik(korisnik);
        setVozilo(vozilo);
        setDatumIznajmljivanja(datumIznajmljivanja);
        setDatumVracanja(datumVracanja);
    }
    
    /**
     * Konstruktor koji inicijalizuje objekat iznajmljivanja sa prosleđenim korisnikom, vozilom,
     * datumom iznajmljivanja i datumom vraćanja.
     *
     * @param korisnik            korisnik koji je iznajmio vozilo
     * @param vozilo              iznajmljeno vozilo
     * @param datumIznajmljivanja datum iznajmljivanja
     * @param datumVracanja       datum vraćanja vozila
     */
    
    public Iznajmljivanje(Korisnik korisnik, Vozilo vozilo, Date datumIznajmljivanja, Date datumVracanja) {
        setKorisnik(korisnik);
        setVozilo(vozilo);
        setDatumIznajmljivanja(datumIznajmljivanja);
        setDatumVracanja(datumVracanja);
    }

    /**
     * Konstruktor koji inicijalizuje objekat iznajmljivanja sa prosleđenim identifikatorom,
     * datumom iznajmljivanja i datumom vraćanja.
     *
     * @param id                  identifikator iznajmljivanja
     * @param datumIznajmljivanja datum iznajmljivanja
     * @param datumVracanja       datum vraćanja vozila
     */
    
    public Iznajmljivanje(Long id, Date datumIznajmljivanja, Date datumVracanja) {
        setId(id);
        setDatumIznajmljivanja(datumIznajmljivanja);
        setDatumVracanja(datumVracanja);
    }

    /**
     * Prazan konstruktor koji inicijalizuje objekat iznajmljivanja sa podrazumevanim vrednostima.
     */
    
    public Iznajmljivanje() {
    }

    /**
     * Vraća identifikator iznajmljivanja.
     *
     * @return identifikator iznajmljivanja
     */
    
    public Long getId() {
        return id;
    }

    /**
     * Postavlja identifikator iznajmljivanja.
     *
     * @param id identifikator iznajmljivanja
     * @throws IllegalArgumentException ako je Id negativan broj
     */
    
    public void setId(Long id) {
    	if(id < 0 )
        	throw new IllegalArgumentException("Id ne sme biti negativan broj");
        this.id = id;
    }

    /**
     * Vraća korisnika koji je iznajmio vozilo.
     *
     * @return korisnik koji je iznajmio vozilo
     */
    
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * Postavlja korisnika koji iznajmljuje vozilo.
     *
     * @param korisnik korisnik koji iznajmljuje vozilo
     * @throws IllegalArgumentException ako korisnik nije u potpunosti inicijalizovan
     */
    
    public void setKorisnik(Korisnik korisnik) {
    	if(korisnik == null || korisnik.getId() == 0 || korisnik.getIme().equals("") || korisnik.getPrezime().equals("") || korisnik.getJMBG() == 0 || korisnik.getMesto() == null || korisnik.getDatumRodjenja() == null)
    		throw new IllegalArgumentException("Korisnik mora biti inicijalizovan");
        this.korisnik = korisnik;
    }

    /**
     * Vraća vozilo koje se iznajmljuje.
     *
     * @return vozilo koje se iznajmljuje
     */
    
    public Vozilo getVozilo() {
        return vozilo;
    }

    /**
     * Postavlja vozilo koje se iznajmljuje.
     *
     * @param vozilo vozilo koje se iznajmljuje
     * @throws IllegalArgumentException ako vozilo nije u potpunosti inicijalizovano
     */
    
    public void setVozilo(Vozilo vozilo) {
    	if(vozilo == null || vozilo.getId() == 0 || vozilo.getMarka().equals("") || vozilo.getModel().equals("") || vozilo.getKategorijaVozila() == null || vozilo.getRegistarskiBroj().equals(""))
    		throw new IllegalArgumentException("Vozilo mora biti inicijalizovano");
        this.vozilo = vozilo;
    }

    /**
     * Vraća datum iznajmljivanja.
     *
     * @return datum iznajmljivanja
     */
    
    public Date getDatumIznajmljivanja() {
        return datumIznajmljivanja;
    }

    /**
     * Postavlja datum iznajmljivanja.
     *
     * @param datumIznajmljivanja datum iznajmljivanja
     * @throws IllegalArgumentException ako je datum iznajmljivanja pre sadasnjeg datuma
     */
    
    public void setDatumIznajmljivanja(Date datumIznajmljivanja) {
    	Date currentDate = new Date();
        if (datumIznajmljivanja.before(currentDate)) 
            throw new IllegalArgumentException("Datum iznajmljivanja ne sme biti pre danasnjeg!");
        this.datumIznajmljivanja = datumIznajmljivanja;
    }

    /**
     * Vraća datum vraćanja vozila.
     *
     * @return datum vraćanja vozila
     */
    
    public Date getDatumVracanja() {
        return datumVracanja;
    }

    /**
     * Postavlja datum vraćanja vozila.
     *
     * @param datumVracanja datum vraćanja vozila
     * @throws NullPointerException ako je datum vracanja null
     */
    
    public void setDatumVracanja(Date datumVracanja) {
    	if(datumVracanja == null)
    		throw new NullPointerException("Datum vracanja ne sme biti null");
        this.datumVracanja = datumVracanja;
    }
    
    @Override
    public String vratiTabelu() {
        return "iznajmljivanje";
    }

    @Override
    public String insertKolone() {
        return "id_korisnika, id_vozila, datum_iznajmljivanja, datum_vracanja";
    }

    @Override
    public String dajVrednosti() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "(" + getKorisnik().getId() + "," + getVozilo().getId() + ",'"
                + sdf.format(getDatumIznajmljivanja()) + "','" + 
                sdf.format(getDatumVracanja()) + "')";
    }

    @Override
    public List<OpstiObjekat> dajListu(ResultSet rs) {
        List<OpstiObjekat> iznajmljeno = new ArrayList<>();

        try {
            while (rs.next()) {
                iznajmljeno.add(new Iznajmljivanje(rs.getLong("i.idIznajmljivanja"),
                        new Korisnik(rs.getString("k.ime"), rs.getString("k.prezime")),
                        new Vozilo(rs.getString("v.registarski_broj")),
                        rs.getDate("i.datum_iznajmljivanja"),
                        rs.getDate("i.datum_vracanja")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Iznajmljivanje.class.getName()).log(Level.SEVERE, null, ex);
        }

        return iznajmljeno;
    }

    @Override
    public String whereUslov() {
        return "";
    }

    @Override
    public String whereSelectUslov() {
        return " "
                + " JOIN stavka_racuna sr ON i.idIznajmljivanja = sr.id_iznajmljivanja"
                + " JOIN korisnik k ON i.id_korisnika = k.id_korisnika"
                + " JOIN vozilo v ON v.id_vozila = i.id_vozila";
    }

    @Override
    public String izmenaObjekta() {
        return "";
    }

    @Override
    public String vratiKolone() {
        return "i.idIznajmljivanja, k.ime, k.prezime, v.registarski_broj, i.datum_iznajmljivanja, i.datum_vracanja, sr.iznos_sa_pdv";
    }

}
