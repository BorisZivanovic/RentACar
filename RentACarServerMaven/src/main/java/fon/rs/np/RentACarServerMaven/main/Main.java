/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fon.rs.np.RentACarServerMaven.main;

import fon.rs.np.RentACarServerMaven.forma.ServerskaForma;

/**
 * Glavna klasa za pokretanje servera.
 * 
 * Klasa Main sadrži statičku metodu main() koja se koristi za pokretanje
 * serverske forme. Instancira se objekat ServerskaForma i postavlja na vidljiv,
 * čime se prikazuje prozor serverske forme na ekranu.
 * 
 * Ova klasa se koristi za pokretanje servera i prikazivanje korisničkog interfejsa
 * za upravljanje serverom.
 * 
 * @author Boris
 */

public class Main {

	/**
     * Glavna metoda za pokretanje servera.
     * 
     * @param args argumenti komandne linije (ne koriste se)
     */
	
    public static void main(String[] args) {
        (new ServerskaForma()).setVisible(true);
    }
    
}