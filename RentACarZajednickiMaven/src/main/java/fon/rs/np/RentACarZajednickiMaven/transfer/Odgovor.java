package fon.rs.np.RentACarZajednickiMaven.transfer;

import java.io.Serializable;

/**
 * Klasa koja predstavlja odgovor servera na zahtev klijenta.
 * 
 * <p>Odgovor sadrži podatke o rezultatu zahteva, poruku i informaciju o uspešnosti zahteva.
 * Može se koristiti za prenos objekata sa servera na klijenta i obrnuto.</p>
 * <p> Klasa implementira interfejs Serializable, sto omogucava da se objekti klase Response serijalizuju i deserijlizuju.
 * Sto je neophodno, ukoliko koristimo prenos podataka izmedju procesa, putem soketa.</p>
 * 
 * @author Boris Zivanovic
 */

public class Odgovor implements Serializable {
    
    private Object odgovor;
    private String poruka;
    private boolean uspesno;

    /**
     * Konstruktor koji inicijalizuje objekat Odgovor sa prosleđenim parametrima.
     * 
     * @param odgovor rezultat zahteva
     * @param poruka poruka koja opisuje odgovor
     * @param uspesno informacija da li je zahtev uspešno izvršen
     */
    
    public Odgovor(Object odgovor, String poruka, boolean uspesno) {
        this.odgovor = odgovor;
        this.poruka = poruka;
        this.uspesno = uspesno;
    }

    /**
     * Prazan konstruktor koji inicijalizuje objekat Odgovor.
     */
    
    public Odgovor() {
    }

    /**
     * Vraća rezultat zahteva.
     * 
     * @return rezultat zahteva
     */
    
    public Object getOdgovor() {
        return odgovor;
    }

    /**
     * Postavlja rezultat zahteva.
     * 
     * @param odgovor rezultat zahteva koji treba postaviti
     */
    
    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    /**
     * Vraća poruku koja opisuje odgovor.
     * 
     * @return poruka koja opisuje odgovor
     */
    
    public String getPoruka() {
        return poruka;
    }

    /**
     * Postavlja poruku koja opisuje odgovor.
     * 
     * @param poruka poruka koja treba postaviti
     */
    
    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    /**
     * Proverava da li je zahtev uspešno izvršen.
     * 
     * @return true ako je zahtev uspešno izvršen, false inače
     */
    
    public boolean isUspesno() {
        return uspesno;
    }

    /**
     * Postavlja informaciju da li je zahtev uspešno izvršen.
     * 
     * @param uspesno true ako je zahtev uspešno izvršen, false inače
     */
    
    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }
    
}
