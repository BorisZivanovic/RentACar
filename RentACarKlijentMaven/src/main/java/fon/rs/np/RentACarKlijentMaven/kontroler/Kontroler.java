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

public class Kontroler {

    private static Kontroler instance;
    
    GlavnaForma gf;
    
    private Kontroler() {
    }
    
    public static Kontroler getInstance() {
        if(instance == null)
            instance = new Kontroler();
        return instance;
    }

    public GlavnaForma getGf() {
        return gf;
    }
    
    public void setGf(GlavnaForma gf) {
        this.gf = gf;
    }
    
    public List<Mesto> vratiMesta() {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(new Mesto(), Operacija.VRATI_MESTA));
        Odgovor odgovor = Komunikacija.getInstance().primiOdgovor();
        if(!odgovor.isUspesno()) {
            JOptionPane.showMessageDialog(null, odgovor.getPoruka(), "Greska", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return (List<Mesto>) odgovor.getOdgovor();
    }

    public Odgovor sacuvajVozilo(Vozilo vozilo) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(vozilo, Operacija.SACUVAJ_VOZILO));
        Odgovor odgovor = Komunikacija.getInstance().primiOdgovor();
        if(!odgovor.isUspesno()) 
            JOptionPane.showMessageDialog(null, "Nije se uspesno sacuvalo vozilo");
        else
            JOptionPane.showMessageDialog(null, "Uspesno je sacuvano vozilo");
        return odgovor;
    }

    public List<KategorijaVozila> vratiKategorijeVozila() {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(new KategorijaVozila(), Operacija.VRATI_KATEGORIJE_VOZILA));
        Odgovor odgovor = Komunikacija.getInstance().primiOdgovor();
        return (List<KategorijaVozila>) odgovor.getOdgovor();
    }

    public Odgovor izbrisiVozilo(Vozilo r) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(r, Operacija.IZBRISI_VOZILO));
        return Komunikacija.getInstance().primiOdgovor();
    }

    public List<Vozilo> vratiVozila(Vozilo vozilo) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(vozilo, Operacija.VRATI_VOZILA));
        return (List<Vozilo>) Komunikacija.getInstance().primiOdgovor().getOdgovor();
    }
    
    public List<Vozilo> vratiSlobodnaVozila(Vozilo vozilo) {
        vozilo.setId(Long.MIN_VALUE);
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(vozilo, Operacija.VRATI_VOZILA));
        return (List<Vozilo>) Komunikacija.getInstance().primiOdgovor().getOdgovor();
    }

    public List<Korisnik> vratiKorisnike() {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(new Korisnik(), Operacija.VRATI_KORISNIKE));
        return (List<Korisnik>) Komunikacija.getInstance().primiOdgovor().getOdgovor();
    }

    public Odgovor sacuvajKorisnika(Korisnik noviKorisnik) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(noviKorisnik, Operacija.SACUVAJ_KORISNIKA));
        return Komunikacija.getInstance().primiOdgovor();
    }

    public Odgovor izbrisiKorisnika(Korisnik vratiKorisnika) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(vratiKorisnika, Operacija.IZBRISI_KORISNIKA));
        return Komunikacija.getInstance().primiOdgovor();
    }

    public Odgovor izmeniKorisnika(Korisnik noviKorisnik) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(noviKorisnik, Operacija.IZMENI_KORISNIKA));
        return Komunikacija.getInstance().primiOdgovor();
    }

    public List<StavkaCenovnika> ucitajListuCenovnika(StavkaCenovnika cenovnik) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(cenovnik, Operacija.VRATI_CENOVNIKE));
        return (List<StavkaCenovnika>) Komunikacija.getInstance().primiOdgovor().getOdgovor();
    }

    public Odgovor iznajmiVozilo(Racun r) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(r,Operacija.IZNAJMI));
        return Komunikacija.getInstance().primiOdgovor();
    }

    public List<StavkaRacuna> vratiIznajmljeno(StavkaRacuna stavkaRacuna) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(stavkaRacuna, Operacija.VRATI_IZNAJMLJENE));
        return (List<StavkaRacuna>) Komunikacija.getInstance().primiOdgovor().getOdgovor();
    }

    public Odgovor izmeniVozilo(Vozilo vozilo) {
        Komunikacija.getInstance().posaljiZahtev(new Zahtev(vozilo, Operacija.IZMENI_VOZILO));
        return Komunikacija.getInstance().primiOdgovor();
    }
    
}
