package fon.rs.np.RentACarServerMaven.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import fon.rs.np.RentACarServerMaven.kontroler.Kontroler;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;
import fon.rs.np.RentACarZajednickiMaven.transfer.Zahtev;

/**
 * Klasa predstavlja serversku nit koja obrađuje zahteve klijenta.
 * 
 * KlijentskaNit je klasa koja nasleđuje Thread i predstavlja serversku nit
 * koja se pokreće za svakog klijenta koji se poveže sa serverom. Svaka instanca
 * ove klase ima svoj socket preko kojeg komunicira sa klijentom.
 * 
 * Nit u petlji čeka na pristizanje zahteva od klijenta, obrađuje ih koristeći
 * odgovarajuće metode iz Kontrolera i šalje odgovor klijentu.
 * 
 * @see Kontroler
 * @see Socket
 * @see Zahtev
 * @see Odgovor
 * @see Thread
 * 
 */

public class KlijentskaNit extends Thread {
    
	/**
     * Socket koji se koristi za komunikaciju sa klijentom.
     */
	
    Socket socket;
    
    /**
     * Promenljiva koja označava da li je nit završena.
     * Ukoliko je vrednost postavljena na true, nit će se zaustaviti.
     */
    
    boolean kraj = false;

    /**
     * Konstruktor klase KlijentskaNit.
     * 
     * @param socket Socket preko kojeg se komunicira sa klijentom
     */
    
    public KlijentskaNit(Socket socket) {
        this.socket = socket;
    }

    /**
     * Metoda koja se izvršava prilikom pokretanja niti.
     * 
     * Metoda čeka na pristizanje zahteva od klijenta, obrađuje ih koristeći
     * odgovarajuće metode iz Kontrolera i šalje odgovor klijentu.
     */
    
    @Override
    public void run() {
        while(!kraj) {
            Zahtev zahtev = receive();
            Odgovor odgovor = new Odgovor();
            switch (zahtev.getOperacija()) {
                case VRATI_MESTA:
                    odgovor = Kontroler.getInstance().vratiMesta(zahtev.getObjekat());
                    break;
                case SACUVAJ_VOZILO:
                    odgovor = Kontroler.getInstance().sacuvajVozilo(zahtev.getObjekat());
                    break;
                case VRATI_KATEGORIJE_VOZILA:
                    odgovor = Kontroler.getInstance().vratiKategorijeVozila(zahtev.getObjekat());
                    break;
                case IZBRISI_VOZILO:
                    odgovor = Kontroler.getInstance().izbrisiVozilo(zahtev.getObjekat());
                    break;
                case VRATI_VOZILA:
                    odgovor = Kontroler.getInstance().vratiVozila(zahtev.getObjekat());
                    break;
                case VRATI_KORISNIKE:
                    odgovor = Kontroler.getInstance().vratiKorisnike(zahtev.getObjekat());
                    break;
                case SACUVAJ_KORISNIKA:
                    odgovor = Kontroler.getInstance().sacuvajKorisnika(zahtev.getObjekat());
                    break;
                case IZBRISI_KORISNIKA:
                    odgovor = Kontroler.getInstance().izbrisiKorisnika(zahtev.getObjekat());
                    break;
                case IZMENI_KORISNIKA:
                    odgovor = Kontroler.getInstance().izmeniKorisnika(zahtev.getObjekat());
                    break;
                case VRATI_CENOVNIKE:
                    odgovor = Kontroler.getInstance().vratiCenovnike(zahtev.getObjekat());
                    break;
                case IZNAJMI:
                    odgovor = Kontroler.getInstance().zapamtiIznajmljivanje(zahtev.getObjekat());
                    break;
                case VRATI_IZNAJMLJENE:
                    odgovor = Kontroler.getInstance().vratiListuIznajmljenihVozila(zahtev.getObjekat());
                    break;
                case IZMENI_VOZILO:
                    odgovor = Kontroler.getInstance().izmeniVozilo(zahtev.getObjekat());
                    break;
                case IZLOGUJ:
                    return;
                default:
                    System.out.println("Pogresna operacija");
            }
            send(odgovor);
        }
    }

    /**
     * Metoda za primanje zahteva od klijenta.
     * 
     * Metoda prima zahtev od klijenta preko ObjectInputStream-a, čita ga i vraća
     * kao objekat klase Zahtev.
     * 
     * @return Zahtev objekat koji predstavlja zahtev klijenta
     */
    
    private Zahtev receive() {
        Zahtev zahtev = new Zahtev();
        
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            zahtev = (Zahtev) in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(KlijentskaNit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KlijentskaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return zahtev;
    }

    /**
     * Metoda za slanje odgovora klijentu.
     * 
     * Metoda šalje odgovor klijentu preko ObjectOutputStream-a.
     * 
     * @param odgovor Odgovor objekat koji se šalje klijentu
     */
    
    private void send(Odgovor odgovor) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(odgovor);
        } catch (IOException ex) {
            Logger.getLogger(KlijentskaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
