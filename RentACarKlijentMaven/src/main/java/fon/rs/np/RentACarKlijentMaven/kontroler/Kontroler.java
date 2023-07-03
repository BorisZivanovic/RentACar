package fon.rs.np.RentACarKlijentMaven.kontroler;

import fon.rs.np.RentACarZajednickiMaven.domen.KategorijaVozila;
import fon.rs.np.RentACarZajednickiMaven.domen.Korisnik;
import fon.rs.np.RentACarZajednickiMaven.domen.Mesto;
import fon.rs.np.RentACarZajednickiMaven.domen.Racun;
import fon.rs.np.RentACarZajednickiMaven.domen.StavkaCenovnika;
import fon.rs.np.RentACarZajednickiMaven.domen.StavkaRacuna;
import fon.rs.np.RentACarZajednickiMaven.domen.Vozilo;
import fon.rs.np.RentACarKlijentMaven.form.GlavnaForma;
import java.util.List;
import javax.swing.JOptionPane;
import fon.rs.np.RentACarKlijentMaven.komunikacija.Komunikacija;
import fon.rs.np.RentACarZajednickiMaven.operacija.Operacija;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;
import fon.rs.np.RentACarZajednickiMaven.transfer.Zahtev;

/**
 * Klasa Kontroler predstavlja glavni kontroler aplikacije.
 * Sadrži metode koje komuniciraju sa serverom putem objekta Komunikacija,
 * kao i metode za manipulaciju podacima i prikaz korisničkog interfejsa.
 * 
 * @author Boris Zivanovic
 */

public class Kontroler {

	/**
	 * instanca klase Kontroler
	 */
    private static Kontroler instance;
    /**
     * glavna JFrame forma
     */
    GlavnaForma gf;
    
    /**
     * prazan konstruktor
     */
    
    private Kontroler() {
    }
    
    /**
     * Metoda za dobijanje instance klase Kontroler.
     * Kreira novu instancu ukoliko već nije kreirana.
     * @return Instanca klase Kontroler.
     */
    
    public static Kontroler getInstance() {
        if(instance == null)
            instance = new Kontroler();
        return instance;
    }

    /**
     * Metoda za dobijanje glavne forme aplikacije.
     * @return GlavnaForma objekat.
     */
    
    public GlavnaForma getGf() {
        return gf;
    }
    
    /**
     * Metoda za postavljanje glavne forme aplikacije.
     * @param gf GlavnaForma objekat.
     */
    
    public void setGf(GlavnaForma gf) {
        this.gf = gf;
    }
    
    /**
     * Metoda za slanje zahteva za dobijanje liste mesta.
     * @return Lista objekata klase Mesto.
     */
    
    public List<Mesto> vratiMesta() {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(new Mesto(), Operacija.VRATI_MESTA));
        Odgovor odgovor = Komunikacija.getInstance().primiOdgovor();
        if(!odgovor.isUspesno()) {
            JOptionPane.showMessageDialog(null, odgovor.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return (List<Mesto>) odgovor.getOdgovor();
    }

    /**
     * Metoda za slanje zahteva za čuvanje vozila.
     * @param vozilo Vozilo koje treba sačuvati.
     * @return Odgovor sa servera.
     */
    
    public Odgovor sacuvajVozilo(Vozilo vozilo) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(vozilo, Operacija.SACUVAJ_VOZILO));
        Odgovor odgovor = Komunikacija.getInstance().primiOdgovor();
        if(!odgovor.isUspesno()) 
            JOptionPane.showMessageDialog(null, "Nije se uspesno sacuvalo vozilo");
        else
            JOptionPane.showMessageDialog(null, "Uspesno je sacuvano vozilo");
        return odgovor;
    }

    /**
     * Metoda za slanje zahteva za dobijanje liste kategorija vozila.
     * @return Lista objekata klase KategorijaVozila.
     */
    
    public List<KategorijaVozila> vratiKategorijeVozila() {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(new KategorijaVozila(), Operacija.VRATI_KATEGORIJE_VOZILA));
        Odgovor odgovor = Komunikacija.getInstance().primiOdgovor();
        return (List<KategorijaVozila>) odgovor.getOdgovor();
    }

    /**
     * Metoda za slanje zahteva za brisanje vozila.
     * @param r Vozilo koje treba izbrisati.
     * @return Odgovor sa servera.
     */
    
    public Odgovor izbrisiVozilo(Vozilo r) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(r, Operacija.IZBRISI_VOZILO));
        return Komunikacija.getInstance().primiOdgovor();
    }

    /**
     * Metoda za slanje zahteva za dobijanje liste vozila.
     * @param vozilo Vozilo koje treba filtrirati (opciono).
     * @return Lista objekata klase Vozilo.
     */
    
    public List<Vozilo> vratiVozila(Vozilo vozilo) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(vozilo, Operacija.VRATI_VOZILA));
        return (List<Vozilo>) Komunikacija.getInstance().primiOdgovor().getOdgovor();
    }
    
    /**
     * Metoda za slanje zahteva za dobijanje liste slobodnih vozila.
     * @param vozilo Vozilo koje treba filtrirati (opciono).
     * @return Lista objekata klase Vozilo.
     */
    
    public List<Vozilo> vratiSlobodnaVozila(Vozilo vozilo) {
        vozilo.setId(Long.MIN_VALUE);
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(vozilo, Operacija.VRATI_VOZILA));
        return (List<Vozilo>) Komunikacija.getInstance().primiOdgovor().getOdgovor();
    }

    /**
     * Metoda za slanje zahteva za dobijanje liste korisnika.
     * @return Lista objekata klase Korisnik.
     */
    
    public List<Korisnik> vratiKorisnike() {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(new Korisnik(), Operacija.VRATI_KORISNIKE));
        return (List<Korisnik>) Komunikacija.getInstance().primiOdgovor().getOdgovor();
    }

    /**
     * Metoda za slanje zahteva za čuvanje korisnika.
     * @param noviKorisnik Korisnik koji treba sačuvati.
     * @return Odgovor sa servera.
     */
    
    public Odgovor sacuvajKorisnika(Korisnik noviKorisnik) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(noviKorisnik, Operacija.SACUVAJ_KORISNIKA));
        return Komunikacija.getInstance().primiOdgovor();
    }

    /**
     * Metoda za slanje zahteva za brisanje korisnika.
     * @param vratiKorisnika Korisnik koji treba izbrisati.
     * @return Odgovor sa servera.
     */
    
    public Odgovor izbrisiKorisnika(Korisnik vratiKorisnika) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(vratiKorisnika, Operacija.IZBRISI_KORISNIKA));
        return Komunikacija.getInstance().primiOdgovor();
    }

    /**
     * Metoda za slanje zahteva za izmenu korisnika.
     * @param noviKorisnik Korisnik koji treba izmeniti.
     * @return Odgovor sa servera.
     */
    
    public Odgovor izmeniKorisnika(Korisnik noviKorisnik) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(noviKorisnik, Operacija.IZMENI_KORISNIKA));
        return Komunikacija.getInstance().primiOdgovor();
    }

    /**
     * Metoda za slanje zahteva za dobijanje liste stavki cenovnika.
     * @param cenovnik StavkaCenovnika objekat (opciono).
     * @return Lista objekata klase StavkaCenovnika.
     */
    
    public List<StavkaCenovnika> ucitajListuCenovnika(StavkaCenovnika cenovnik) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(cenovnik, Operacija.VRATI_CENOVNIKE));
        return (List<StavkaCenovnika>) Komunikacija.getInstance().primiOdgovor().getOdgovor();
    }

    /**
     * Metoda za slanje zahteva za iznajmljivanje vozila.
     * @param r Racun objekat koji predstavlja iznajmljivanje vozila.
     * @return Odgovor sa servera.
     */
    
    public Odgovor iznajmiVozilo(Racun r) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(r,Operacija.IZNAJMI));
        return Komunikacija.getInstance().primiOdgovor();
    }

    /**
     * Metoda za slanje zahteva za dobijanje liste iznajmljenih vozila.
     * @param stavkaRacuna StavkaRacuna objekat (opciono).
     * @return Lista objekata klase StavkaRacuna.
     */
    
    public List<StavkaRacuna> vratiIznajmljeno(StavkaRacuna stavkaRacuna) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(stavkaRacuna, Operacija.VRATI_IZNAJMLJENE));
        return (List<StavkaRacuna>) Komunikacija.getInstance().primiOdgovor().getOdgovor();
    }

    /**
     * Metoda za slanje zahteva za izmenu podataka o vozilu.
     * @param vozilo Vozilo koje treba izmeniti.
     * @return Odgovor sa servera.
     */
    
    public Odgovor izmeniVozilo(Vozilo vozilo) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(vozilo, Operacija.IZMENI_VOZILO));
        return Komunikacija.getInstance().primiOdgovor();
    }
    
}
