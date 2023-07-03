package fon.rs.np.RentACarKlijentMaven.komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import fon.rs.np.RentACarZajednickiMaven.transfer.Odgovor;
import fon.rs.np.RentACarZajednickiMaven.transfer.Zahtev;

/**
 * Klasa Komunikacija omogućava komunikaciju sa serverom putem soketa.
 * Implementira Singleton obrazac dizajna kako bi se obezbedila samo jedna instanca klase za celu aplikaciju.
 * 
 * @author Boris Zivanovic
 */

public class Komunikacija {
    
	/**
	 * instanca klase Komunikacija
	 */
    private static Komunikacija instance;
    /**
     * socket za komunikaciju
     */
    Socket socket;
    
    /**
     * Konstruktor klase Komunikacija.
     * Inicijalizuje socket i povezuje se sa serverom na zadatoj adresi i portu.
     * U slučaju da server nije pokrenut, prikazuje se odgovarajuća poruka korisniku.
     */
    
    private Komunikacija() {
        try {
            socket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Server nije pokrenut");
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Vraća instancu klase Komunikacija.
     *
     * @return instanca klase Komunikacija
     */
    
    public static Komunikacija getInstance() {
        if(instance == null)
            instance = new Komunikacija();
        return instance;
    }
    
    /**
     * Šalje zahtev serveru.
     *
     * @param zahtev zahtev koji se šalje serveru
     */
    
    public void posaljiZahtev(Zahtev zahtev) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(zahtev);
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Čeka i prima odgovor od servera.
     *
     * @return odgovor od servera
     */
    
    public Odgovor primiOdgovor() {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            return (Odgovor) in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
