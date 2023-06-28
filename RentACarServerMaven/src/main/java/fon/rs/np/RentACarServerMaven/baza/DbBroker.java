package fon.rs.np.RentACarServerMaven.baza;

import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbBroker {
    
    private static DbBroker instanca;
    private Connection konekcija;
    
    private DbBroker() {}
    
    public static DbBroker getInstance() {
        if(instanca == null)
            instanca = new DbBroker();
        return instanca;
    }
    
    public Connection otvoriKonekciju() throws Exception {
        if(konekcija == null || konekcija.isClosed()) {
            Properties properties = new Properties();
            properties.load(new FileInputStream("baza.properties"));
            konekcija = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
                    properties.getProperty("pass"));
            konekcija.setAutoCommit(false);
        }
        return konekcija;
    }
    
    public void zatvoriKonekciju() {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void commit() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollback() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DbBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
    
    public ResultSet vratiSve(OpstiObjekat objekat) throws SQLException {
        String query = "SELECT " + objekat.vratiKolone() + " FROM " + objekat.vratiTabelu() + objekat.whereSelectUslov();
        System.out.println(query);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(query);
        return rs;
    }
    
    public void izbrisi(OpstiObjekat objekat) throws SQLException {
        String query = "DELETE FROM " + objekat.vratiTabelu() + " WHERE " + objekat.whereUslov();
        Statement s = konekcija.createStatement();
        s.executeUpdate(query);
        s.close();
    }
    
    public void izmeni(OpstiObjekat objekat) throws SQLException {
        String query = "UPDATE " + objekat.vratiTabelu() + " SET " + objekat.izmenaObjekta() + " WHERE" + objekat.whereUslov();
        System.out.println(query);
        Statement s = konekcija.createStatement();
        s.executeUpdate(query);
        s.close();
    }
    
}
