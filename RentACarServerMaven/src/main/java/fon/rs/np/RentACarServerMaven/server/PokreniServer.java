package fon.rs.np.RentACarServerMaven.server;

import fon.rs.np.RentACarServerMaven.forma.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa koja predstavlja server i omogućava pokretanje servera i prihvatanje klijentskih konekcija.
 */

public class PokreniServer extends Thread {
    
	 /**
     * Referenca na objekat ServerskaForma koji predstavlja glavnu formu servera.
     */
	
    ServerskaForma sf;
    
    /**
     * Promenljiva koja označava da li je server završen.
     * Ukoliko je vrednost postavljena na true, server će se zaustaviti.
     */
    
    boolean kraj = false;
    
    /**
    * ServerSocket koji se koristi za prihvatanje konekcija.
    */
    
    ServerSocket ss;
    
    /**
     * Konstruktor klase PokreniServer.
     *
     * @param sf Objekat ServerskaForma koji predstavlja glavnu formu servera.
     */
    
    public PokreniServer(ServerskaForma sf) {
        this.sf = sf;
    }
    
    /**
     * Metoda run() klase Thread koja se izvršava prilikom pokretanja niti.
     * Vrši pokretanje servera i prihvatanje klijentskih konekcija.
     */
    
    @Override
    public void run() {
        try {
            ss = new ServerSocket(9000);
            System.out.println("Server je pokrenut");
            while(true) {
                Socket socket = ss.accept();
                System.out.println("Klijent je povezan");
                KlijentskaNit kn = new KlijentskaNit(socket);
                kn.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metoda za zaustavljanje servera.
     * Zatvara ServerSocket i prekida prihvatanje klijentskih konekcija.
     */
    
    public void stopServer() {
        try {
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
