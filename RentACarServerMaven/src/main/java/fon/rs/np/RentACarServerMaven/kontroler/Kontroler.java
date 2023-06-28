package fon.rs.np.RentACarServerMaven.kontroler;

import fon.rs.np.RentACarZajednickiMaven.domen.OpstiObjekat;
import fon.rs.np.RentACarServerMaven.so.VratiKategorijeVozila;
import fon.rs.np.RentACarServerMaven.so.cenovnik.VratiCenovnike;
import fon.rs.np.RentACarServerMaven.so.iznajmljeno.IznajmiVozilo;
import fon.rs.np.RentACarServerMaven.so.iznajmljeno.VratiIznajmljeno;
import fon.rs.np.RentACarServerMaven.so.korisnik.IzbrisiKorisnika;
import fon.rs.np.RentACarServerMaven.so.korisnik.IzmeniKorisnika;
import fon.rs.np.RentACarServerMaven.so.korisnik.SacuvajKorisnika;
import fon.rs.np.RentACarServerMaven.so.korisnik.VratiKorisnike;
import fon.rs.np.RentACarServerMaven.so.mesto.VratiMesta;
import fon.rs.np.RentACarServerMaven.so.vozilo.IzbrisiVozilo;
import fon.rs.np.RentACarServerMaven.so.vozilo.IzmeniVozilo;
import fon.rs.np.RentACarServerMaven.so.vozilo.SacuvajVozilo;
import fon.rs.np.RentACarServerMaven.so.vozilo.VratiVozila;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;

/**
 * Kontroler klasa koja upravlja poslovnim logikama servera.
 */

public class Kontroler {
    
	/**
	 * Instanca kontrolera
	 */
    private static Kontroler instance;
    
    /**
     * Prazan konstruktor
     */
    
    private Kontroler() {}
    
    /**
     * Metoda koja vraća instancu kontrolera.
     * Implementirana je kao Singleton kako bi se osiguralo da postoji samo jedna instanca kontrolera.
     * 
     * @return instanca kontrolera
     */
    
    public static Kontroler getInstance() {
        if(instance == null)
            instance = new Kontroler();
        return instance;
    }
    
    /**
     * Metoda koja izvršava poslovnu logiku za vraćanje svih mesta.
     * 
     * @param oo objekat koji se koristi za prenos podataka
     * @return odgovor na zahtev sa podacima o mestima
     */
    
    public Odgovor vratiMesta(OpstiObjekat oo) {
        return new VratiMesta().izvrsiTranziciju(oo);
    }

    /**
     * Metoda koja izvršava poslovnu logiku za čuvanje vozila.
     * 
     * @param objekat objekat koji sadrži podatke o vozilu koje treba sačuvati
     * @return odgovor na zahtev o uspešnosti čuvanja vozila
     */
    
    public Odgovor sacuvajVozilo(OpstiObjekat objekat) {
        return new SacuvajVozilo().izvrsiTranziciju(objekat);
    }

    /**
     * Metoda koja izvršava poslovnu logiku za vraćanje kategorija vozila.
     * 
     * @param objekat objekat koji se koristi za prenos podataka
     * @return odgovor na zahtev sa podacima o kategorijama vozila
     */
    
    public Odgovor vratiKategorijeVozila(OpstiObjekat objekat) {
        return new VratiKategorijeVozila().izvrsiTranziciju(objekat);
    }

    /**
     * Metoda koja izvršava poslovnu logiku za brisanje vozila.
     * 
     * @param objekat objekat koji sadrži podatke o vozilu koje treba obrisati
     * @return odgovor na zahtev o uspešnosti brisanja vozila
     */
    
    public Odgovor izbrisiVozilo(OpstiObjekat objekat) {
        return new IzbrisiVozilo().izvrsiTranziciju(objekat);
    }

    /**
     * Metoda koja izvršava poslovnu logiku za vraćanje svih vozila.
     * 
     * @param objekat objekat koji se koristi za prenos podataka
     * @return odgovor na zahtev sa podacima o vozilima
     */
    
    public Odgovor vratiVozila(OpstiObjekat objekat) {
        return new VratiVozila().izvrsiTranziciju(objekat);
    }

    /**
     * Metoda koja izvršava poslovnu logiku za vraćanje svih korisnika.
     * 
     * @param objekat objekat koji se koristi za prenos podataka
     * @return odgovor na zahtev sa podacima o korisnicima
     */
    
    public Odgovor vratiKorisnike(OpstiObjekat objekat) {
        return new VratiKorisnike().izvrsiTranziciju(objekat);
    }

    /**
     * Metoda koja izvršava poslovnu logiku za čuvanje korisnika.
     * 
     * @param objekat objekat koji sadrži podatke o korisniku koje treba sačuvati
     * @return odgovor na zahtev o uspešnosti čuvanja korisnika
     */
    
    public Odgovor sacuvajKorisnika(OpstiObjekat objekat) {
        return new SacuvajKorisnika().izvrsiTranziciju(objekat);
    }

    /**
     * Metoda koja izvršava poslovnu logiku za brisanje korisnika.
     * 
     * @param objekat objekat koji sadrži podatke o korisniku koji treba obrisati
     * @return odgovor na zahtev o uspešnosti brisanja korisnika
     */
    
    public Odgovor izbrisiKorisnika(OpstiObjekat objekat) {
        return new IzbrisiKorisnika().izvrsiTranziciju(objekat);
    }

    /**
     * Metoda koja izvršava poslovnu logiku za izmenu podataka o korisniku.
     * 
     * @param objekat objekat koji sadrži podatke o korisniku koje treba izmeniti
     * @return odgovor na zahtev o uspešnosti izmene korisnika
     */
    
    public Odgovor izmeniKorisnika(OpstiObjekat objekat) {
        return new IzmeniKorisnika().izvrsiTranziciju(objekat);
    }

    /**
     * Metoda koja izvršava poslovnu logiku za vraćanje cenovnika.
     * 
     * @param objekat objekat koji se koristi za prenos podataka
     * @return odgovor na zahtev sa podacima o cenovnicima
     */
    
    public Odgovor vratiCenovnike(OpstiObjekat objekat) {
        return new VratiCenovnike().izvrsiTranziciju(objekat);
    }

    /**
     * Metoda koja izvršava poslovnu logiku za čuvanje podataka o iznajmljivanju vozila.
     * 
     * @param objekat objekat koji sadrži podatke o iznajmljivanju koje treba sačuvati
     * @return odgovor na zahtev o uspešnosti čuvanja iznajmljivanja
     */
    
    public Odgovor zapamtiIznajmljivanje(OpstiObjekat objekat) {
        return new IznajmiVozilo().izvrsiTranziciju(objekat);
    }

    /**
     * Metoda koja izvršava poslovnu logiku za vraćanje liste iznajmljenih vozila.
     * 
     * @param objekat objekat koji se koristi za prenos podataka
     * @return odgovor na zahtev sa podacima o iznajmljenim vozilima
     */
    
    public Odgovor vratiListuIznajmljenihVozila(OpstiObjekat objekat) {
        return new VratiIznajmljeno().izvrsiTranziciju(objekat);
    }

    /**
     * Metoda koja izvršava poslovnu logiku za izmenu podataka o vozilu.
     * 
     * @param objekat objekat koji sadrži podatke o vozilu koje treba izmeniti
     * @return odgovor na zahtev o uspešnosti izmene vozila
     */
    
    public Odgovor izmeniVozilo(OpstiObjekat objekat) {
        return new IzmeniVozilo().izvrsiTranziciju(objekat);
    }
    
}
