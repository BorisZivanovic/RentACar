package fon.rs.np.RentACarZajednickiMaven.transfer;

import fon.rs.np.RentACarZajednickiMaven.domen.Iznajmljivanje;
import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import java.io.Serializable;
import java.util.List;
import fon.rs.np.RentACarZajednickiMaven.operacija.Operacija;

/**
 * Klasa koja predstavlja zahtev klijenta ka serveru.
 * 
 * <p>Zahtev može sadržati objekat, operaciju i listu iznajmljivanja.
 * Koristi se za komunikaciju između klijenta i servera u sistemu Rent-a-Car.</p>
 * <p>Klasa implementira interfejs Serializable, što omogućava da se objekti klase Request serijalizuju i deserijalizuju.
 * Što je neophodno, jer se koristi prenos podataka između procesa, putem soketa. </p>
 */

public class Zahtev implements Serializable {
    
    private OpstiObjekat objekat;
    private Operacija operacija;
    private List<Iznajmljivanje> lista;
    
    /**
     * Konstruktor koji inicijalizuje objekat Zahtev sa prosleđenim objektom i operacijom.
     * 
     * @param objekat objekat koji se šalje uz zahtev
     * @param operacija operacija koja se šalje uz zahtev
     */
    
    public Zahtev(OpstiObjekat objekat, Operacija operacija) {
        this.objekat = objekat;
        this.operacija = operacija;
    }

    /**
     * Konstruktor koji inicijalizuje objekat Zahtev sa prosleđenom operacijom i listom iznajmljivanja.
     * 
     * @param operacija operacija koja se šalje uz zahtev
     * @param lista lista iznajmljivanja koja se šalje uz zahtev
     */
    
    public Zahtev(Operacija operacija, List<Iznajmljivanje> lista) {
        this.lista = lista;
        this.operacija = operacija;
    }
    
    /**
     * Prazan konstruktor koji inicijalizuje objekat Zahtev.
     */
    
    public Zahtev() {
    }

    /**
     * Vraća objekat koji je sadržan u zahtevu.
     * 
     * @return objekat koji je sadržan u zahtevu
     */
    
    public OpstiObjekat getObjekat() {
        return objekat;
    }

    /**
     * Postavlja objekat koji se šalje uz zahtev.
     * 
     * @param objekat objekat koji treba postaviti
     */
    
    public void setObjekat(OpstiObjekat objekat) {
        this.objekat = objekat;
    }

    /**
     * Vraća operaciju koja je sadržana u zahtevu.
     * 
     * @return operacija koja je sadržana u zahtevu
     */
    
    public Operacija getOperacija() {
        return operacija;
    }

    /**
     * Postavlja operaciju koja se šalje uz zahtev.
     * 
     * @param operacija operacija koju treba postaviti
     */
    
    public void setOperacija(Operacija operacija) {
        this.operacija = operacija;
    }

    /**
     * Vraća listu iznajmljivanja koja je sadržana u zahtevu.
     * 
     * @return lista iznajmljivanja koja je sadržana u zahtevu
     */
    
    public List<Iznajmljivanje> getLista() {
        return lista;
    }
    
}
