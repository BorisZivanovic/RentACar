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

public class KlijentskaNit extends Thread {
    
    Socket socket;
    boolean kraj = false;

    public KlijentskaNit(Socket socket) {
        this.socket = socket;
    }

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

    private void send(Odgovor odgovor) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(odgovor);
        } catch (IOException ex) {
            Logger.getLogger(KlijentskaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
