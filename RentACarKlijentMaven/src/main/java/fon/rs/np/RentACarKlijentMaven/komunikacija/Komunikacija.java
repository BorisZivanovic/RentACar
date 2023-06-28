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

public class Komunikacija {
    
    private static Komunikacija instance;
    Socket socket;
    
    private Komunikacija() {
        try {
            socket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Server nije pokrenut");
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Komunikacija getInstance() {
        if(instance == null)
            instance = new Komunikacija();
        return instance;
    }
    
    public void posaljiZahtev(Zahtev zahtev) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(zahtev);
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
