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

public class Kontroler {
    
    private static Kontroler instance;
    
    private Kontroler() {}
    
    public static Kontroler getInstance() {
        if(instance == null)
            instance = new Kontroler();
        return instance;
    }
    
    public Odgovor vratiMesta(OpstiObjekat oo) {
        return new VratiMesta().izvrsiTranziciju(oo);
    }

    public Odgovor sacuvajVozilo(OpstiObjekat objekat) {
        return new SacuvajVozilo().izvrsiTranziciju(objekat);
    }

    public Odgovor vratiKategorijeVozila(OpstiObjekat objekat) {
        return new VratiKategorijeVozila().izvrsiTranziciju(objekat);
    }

    public Odgovor izbrisiVozilo(OpstiObjekat objekat) {
        return new IzbrisiVozilo().izvrsiTranziciju(objekat);
    }

    public Odgovor vratiVozila(OpstiObjekat objekat) {
        return new VratiVozila().izvrsiTranziciju(objekat);
    }

    public Odgovor vratiKorisnike(OpstiObjekat objekat) {
        return new VratiKorisnike().izvrsiTranziciju(objekat);
    }

    public Odgovor sacuvajKorisnika(OpstiObjekat objekat) {
        return new SacuvajKorisnika().izvrsiTranziciju(objekat);
    }

    public Odgovor izbrisiKorisnika(OpstiObjekat objekat) {
        return new IzbrisiKorisnika().izvrsiTranziciju(objekat);
    }

    public Odgovor izmeniKorisnika(OpstiObjekat objekat) {
        return new IzmeniKorisnika().izvrsiTranziciju(objekat);
    }

    public Odgovor vratiCenovnike(OpstiObjekat objekat) {
        return new VratiCenovnike().izvrsiTranziciju(objekat);
    }

    public Odgovor zapamtiIznajmljivanje(OpstiObjekat objekat) {
        return new IznajmiVozilo().izvrsiTranziciju(objekat);
    }

    public Odgovor vratiListuIznajmljenihVozila(OpstiObjekat objekat) {
        return new VratiIznajmljeno().izvrsiTranziciju(objekat);
    }

    public Odgovor izmeniVozilo(OpstiObjekat objekat) {
        return new IzmeniVozilo().izvrsiTranziciju(objekat);
    }
    
}
