package fon.rs.np.RentACarZajednickiMaven.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StavkaCenovnika extends OpstiObjekat {
    
    private Long id;
    private String naziv;
    private String opis;
    private double cena;
    private Cenovnik cenovnik;

    public StavkaCenovnika(Long id, String naziv, String opis, double cena, Cenovnik cenovnik) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        this.cenovnik = cenovnik;
    }
    
    public StavkaCenovnika(String naziv, double cena, Cenovnik cenovnik) {
        this.naziv = naziv;
        this.cena = cena;
        this.cenovnik = cenovnik;
    }
    
    public StavkaCenovnika() {
    }

    @Override
    public String toString() {
        return getCenovnik().getNaziv() + " - " + getNaziv();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Cenovnik getCenovnik() {
        return cenovnik;
    }

    public void setCenovnik(Cenovnik cenovnik) {
        this.cenovnik = cenovnik;
    }

    @Override
    public String vratiTabelu() {
        return "stavka_cenovnika";
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
        List<OpstiObjekat> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                lista.add(new StavkaCenovnika(rs.getString("sc.naziv"),
                        rs.getDouble("cena"),
                        new Cenovnik(rs.getLong("c.id_cenovnika"), 
                                rs.getString("c.naziv"), rs.getString("c.opis"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cenovnik.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public String whereUslov() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String whereSelectUslov() {
        return " sc JOIN cenovnik c ON c.id_cenovnika = sc.id_cenovnika";
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
