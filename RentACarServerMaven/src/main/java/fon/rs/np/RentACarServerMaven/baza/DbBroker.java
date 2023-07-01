package fon.rs.np.RentACarServerMaven.baza;

import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa koja predstavlja broker za pristup bazi podataka.
 */

public class DbBroker {
    
	/**
	 * Instanca DbBrokera
	 */
    private static DbBroker instanca;
    /**
	 * Objekat kalse Connection
	 */
    private Connection konekcija;
    
    /**
     * Prazan konstruktor
     */
    
    private DbBroker() {}
    
    /**
     * Metoda koja vraća instancu klase DbBroker.
     * 
     * @return instanca klase DbBroker
     */
    
    public static DbBroker getInstance() {
        if(instanca == null)
            instanca = new DbBroker();
        return instanca;
    }
    
    /**
     * Metoda za otvaranje konekcije sa bazom podataka.
     * 
     * @return konekcija sa bazom podataka
     * @throws Exception ukoliko se ne uspe uspostaviti konekcija
     */
    
    public Connection otvoriKonekciju() throws Exception {
        if(konekcija == null || konekcija.isClosed()) {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/baza.properties"));
            konekcija = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
                    properties.getProperty("pass"));
            konekcija.setAutoCommit(false);
        }
        return konekcija;
    }
    
    /**
     * Metoda za zatvaranje konekcije sa bazom podataka.
     */
    
    public void zatvoriKonekciju() {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metoda za commit transakcije.
     */
    
    public void commit() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metoda za rollback transakcije.
     */
    
    public void rollback() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metoda za čuvanje objekta u bazi podataka.
     * 
     * @param objekat objekat koji se čuva
     * @return ID novododatog objekta
     * @throws SQLException ukoliko se desi greška pri izvršavanju SQL upita
     */
    
    public Long sacuvaj(OpstiObjekat objekat) throws SQLException {
        String query = "INSERT INTO " + objekat.vratiTabelu() + "(" + objekat.insertKolone() + ")" + 
                " VALUES" + objekat.dajVrednosti();
        System.out.println(query);
        Statement s = konekcija.createStatement();
        s.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = s.getGeneratedKeys();
        Long id = null;
        while(rs.next())
            id = rs.getLong(1);
        s.close();
        return id;
    }
    
    /**
     * Metoda za vraćanje svih objekata iz baze podataka.
     * 
     * @param objekat objekat koji se vraća
     * @return rezultat upita kao ResultSet
     * @throws SQLException ukoliko se desi greška pri izvršavanju SQL upita
     */
    
    public ResultSet vratiSve(OpstiObjekat objekat) throws SQLException {
        String query = "SELECT " + objekat.vratiKolone() + " FROM " + objekat.vratiTabelu() + objekat.whereSelectUslov();
        System.out.println(query);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(query);
        return rs;
    }
    
    /**
     * Metoda za brisanje objekta iz baze podataka.
     * 
     * @param objekat objekat koji se briše
     * @throws SQLException ukoliko se desi greška pri izvršavanju SQL upita
     */
    
    public void izbrisi(OpstiObjekat objekat) throws SQLException {
        String query = "DELETE FROM " + objekat.vratiTabelu() + " WHERE " + objekat.whereUslov();
        Statement s = konekcija.createStatement();
        s.executeUpdate(query);
        s.close();
    }
    
    /**
     * Metoda za izmenu objekta u bazi podataka.
     * 
     * @param objekat objekat koji se menja
     * @throws SQLException ukoliko se desi greška pri izvršavanju SQL upita
     */
    
    public void izmeni(OpstiObjekat objekat) throws SQLException {
        String query = "UPDATE " + objekat.vratiTabelu() + " SET " + objekat.izmenaObjekta() + " WHERE" + objekat.whereUslov();
        System.out.println(query);
        Statement s = konekcija.createStatement();
        s.executeUpdate(query);
        s.close();
    }
    
}
