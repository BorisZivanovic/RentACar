package fon.rs.np.RentACarServerMaven.server;

import fon.rs.np.RentACarServerMaven.forma.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PokreniServer extends Thread {
    
    ServerskaForma sf;
    boolean kraj = false;
    ServerSocket ss;
    
    public PokreniServer(ServerskaForma sf) {
        this.sf = sf;
    }
    
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

    public void stopServer() {
        try {
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
