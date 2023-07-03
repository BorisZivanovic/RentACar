package fon.rs.np.RentACarZajednickiMaven.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Predstavlja vozilo.
 */

public class Vozilo extends OpstiObjekat {

    private Long id;
    private String registarskiBroj;
    private String marka;
    private String model;
    private StatusVozila statusVozila;
    private KategorijaVozila kategorijaVozila;

    /**
     * Konstruiše novi objekat klase Vozilo sa datim parametrima.
     *
     * @param id               identifikator vozila
     * @param registarskiBroj  registarski broj vozila
     * @param marka            marka vozila
     * @param model            model vozila
     * @param statusVozila     status vozila
     * @param kategorijaVozila kategorija vozila
     */
    
    public Vozilo(Long id, String registarskiBroj, String marka, String model, StatusVozila statusVozila, KategorijaVozila kategorijaVozila) {
        setId(id);
        setRegistarskiBroj(registarskiBroj);
        setMarka(marka);
        setModel(model);
        setStatusVozila(statusVozila);
        setKategorijaVozila(kategorijaVozila);
    }

    /**
     * Konstruiše novo vozilo sa datim parametrima.
     *
     * @param registarskiBroj  registarski broj vozila
     * @param marka            marka vozila
     * @param model            model vozila
     * @param statusVozila     status vozila
     * @param kategorijaVozila kategorija vozila
     */
    
    public Vozilo(String registarskiBroj, String marka, String model, StatusVozila statusVozila, KategorijaVozila kategorijaVozila) {
    	setRegistarskiBroj(registarskiBroj);
        setMarka(marka);
        setModel(model);
        setStatusVozila(statusVozila);
        setKategorijaVozila(kategorijaVozila);
    }
    
    /**
     * Konstruiše novo vozilo sa datim parametrima.
     *
     * @param id               identifikator vozila
     * @param registarskiBroj  registarski broj vozila
     * @param marka            marka vozila
     * @param model            model vozila
     * @param kategorijaVozila kategorija vozila
     */
    
    public Vozilo(Long id, String registarskiBroj, String marka, String model, KategorijaVozila kategorijaVozila) {
        setId(id);
        setRegistarskiBroj(registarskiBroj);
        setMarka(marka);
        setModel(model);
        setKategorijaVozila(kategorijaVozila);
    }
    
    /**
     * Konstruiše novo vozilo sa zadatim registarskim brojem.
     *
     * @param registarskiBroj registarski broj vozila
     */
    
    public Vozilo(String registarskiBroj) {
        setRegistarskiBroj(registarskiBroj);
    }

    @Override
    public String toString() {
        return registarskiBroj;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.registarskiBroj);
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
        final Vozilo other = (Vozilo) obj;
        return Objects.equals(this.registarskiBroj, other.registarskiBroj);
    }
    
    /**
     * Prazan konstruktor
     */
    
    public Vozilo() {
    }

    /**
     * Vraća ID vozila.
     *
     * @return ID vozila
     */
    
    public Long getId() {
        return id;
    }

    /**
     * Postavlja ID vozila.
     *
     * @param id ID vozila
     */
    
    public void setId(Long id) {
    	if(id < 0)
            throw new IllegalArgumentException("Id ne sme biti negativan broj");
        this.id = id;
    }

    /**
     * Vraća marku vozila.
     *
     * @return marka vozila
     */
    
    public String getMarka() {
        return marka;
    }

    /**
     * Postavlja marku vozila.
     *
     * @param marka marka vozila
     */
    
    public void setMarka(String marka) {
    	if(marka == null )
    		throw new NullPointerException("Marka ne sme biti null");
        this.marka = marka;
    }

    /**
     * Vraća model vozila.
     *
     * @return model vozila
     */
    
    public String getModel() {
        return model;
    }

    /**
     * Postavlja model vozila.
     *
     * @param model model vozila
     */
    
    public void setModel(String model) {
    	if(model == null )
    		throw new NullPointerException("Model ne sme biti null");
        this.model = model;
    }

    /**
     * Vraća status vozila.
     *
     * @return status vozila
     */
    
    public StatusVozila getStatusVozila() {
        return statusVozila;
    }

    /**
     * Postavlja status vozila.
     *
     * @param statusVozila status vozila
     */
    
    public void setStatusVozila(StatusVozila statusVozila) {
        this.statusVozila = statusVozila;
    }

    /**
     * Vraća kategoriju vozila.
     *
     * @return kategorija vozila
     */
    
    public KategorijaVozila getKategorijaVozila() {
        return kategorijaVozila;
    }

    /**
     * Postavlja kategoriju vozila.
     *
     * @param kategorijaVozila kategorija vozila
     */
    
    public void setKategorijaVozila(KategorijaVozila kategorijaVozila) {
    	if(kategorijaVozila == null || kategorijaVozila.getId() == 0 || kategorijaVozila.getNaziv().equals("") || kategorijaVozila.getCena() <= 0)
    		throw new IllegalArgumentException("Kategorija vozila mora biti inicijalizovana");
        this.kategorijaVozila = kategorijaVozila;
    }

    /**
     * Vraća registarski broj vozila.
     *
     * @return registarski broj vozila
     */
    
    public String getRegistarskiBroj() {
        return registarskiBroj;
    }

    /**
     * Postavlja registarski broj vozila.
     *
     * @param registarskiBroj registarski broj vozila
     */
    
    public void setRegistarskiBroj(String registarskiBroj) {
    	if(registarskiBroj == null )
    		throw new NullPointerException("Registarski broj ne sme biti null");
        this.registarskiBroj = registarskiBroj;
    }

    @Override
    public String vratiTabelu() {
        return "vozilo";
    }

    @Override
    public String insertKolone() {
        return "registarski_broj, marka, model, status , id_kategorije";
    }

    @Override
    public String dajVrednosti() {
        return "('" + getRegistarskiBroj() + "','" + getMarka() + "','" + getModel()
                + "','" + getStatusVozila().toString()
                + "'," + getKategorijaVozila().getId() + ")";
    }

    @Override
    public List<OpstiObjekat> dajListu(ResultSet rs) {
        List<OpstiObjekat> vozila = new ArrayList<>();

        try {
            while (rs.next()) {
                vozila.add(new Vozilo(rs.getLong("id_vozila"),
                        rs.getString("registarski_broj"),
                        rs.getString("marka"),
                        rs.getString("model"),
                        StatusVozila.valueOf(rs.getString("status").toUpperCase()),
                        new KategorijaVozila(rs.getLong("id_kategorije"), rs.getString("naziv"),
                                rs.getDouble("cena"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vozilo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Neuspesno ucitana vozila iz baze");
        }

        return vozila;
    }

    public String whereSelectUslov() {
        String query = " v JOIN kategorija_vozila kv ON v.id_kategorije = kv.id_kategorije";
        if(getId() != null && getId() == Long.MIN_VALUE)
            query += " where v.status = 'slobodno'";
        return query;
    }

    @Override
    public String whereUslov() {
        return " id_vozila = " + getId();
    }

    @Override
    public String izmenaObjekta() {
        return "registarski_broj = '" + getRegistarskiBroj()+ "', marka = '" + getMarka() + "',model = '" + getModel() +
                "', status = '" + getStatusVozila() + "', id_kategorije = " + getKategorijaVozila().getId();
    }

    @Override
    public String vratiKolone() {
        return "*";
    }

}
