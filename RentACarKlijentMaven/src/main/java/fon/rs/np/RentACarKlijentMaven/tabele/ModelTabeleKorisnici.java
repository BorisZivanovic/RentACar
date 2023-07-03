package fon.rs.np.RentACarKlijentMaven.tabele;

import fon.rs.np.RentACarZajednickiMaven.domen.Korisnik;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Model tabele za prikaz korisnika.
 * Klasa nasleđuje apstraktnu klasu AbstractTableModel i implementira njene apstraktne metode.
 * 
 * @author Boris Zivanovic
 */

public class ModelTabeleKorisnici extends AbstractTableModel {

	/**
	 * lista korisnika
	 */
    List<Korisnik> korisnici;

    /**
     * Konstruktor koji inicijalizuje model tabele korisnika.
     * @param korisnici Lista korisnika.
     */
    
    public ModelTabeleKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    @Override
    public int getRowCount() {
        return korisnici.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik korisnik = korisnici.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return korisnik.getId();
            case 1:
                return korisnik.getIme();
            case 2:
                return korisnik.getPrezime();
            case 3:
                return korisnik.getJMBG();
            case 4:
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                return df.format(korisnik.getDatumRodjenja());
                //return korisnik.getDatumRodjenja();
            case 5:
                return korisnik.getMesto();
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Ime";
            case 2:
                return "Prezime";
            case 3:
                return "JMBG";
            case 4:
                return "Datum rodjenja";
            case 5:
                return "Mesto";
            default:
                throw new AssertionError();
        }
    }

    /**
     * Dodaje korisnika u tabelu.
     * @param korisnik Korisnik koji se dodaje.
     */
    
    public void dodajKorisnika(Korisnik korisnik) {
        korisnici.add(korisnik);
        fireTableDataChanged();
    }

    /**
     * Briše korisnika iz tabele na datom indeksu.
     * @param index Indeks korisnika koji se briše.
     */
    
    public void izbrsiKorisnika(int index) {
        korisnici.remove(index);
        fireTableDataChanged();
    }

    /**
     * Vraća korisnika sa datog indeksa.
     * @param index Indeks korisnika.
     * @return Korisnik sa datog indeksa.
     */
    
    public Korisnik vratiKorisnika(int index) {
        return korisnici.get(index);
    }

    /**
     * Proverava da li korisnik već postoji u tabeli.
     * @param korisnik Korisnik koji se proverava.
     * @return True ako korisnik postoji, false ako ne postoji.
     */
    
    public boolean daLiPostoji(Korisnik korisnik) {
        for (Korisnik k : korisnici) {
            if (korisnik.equals(k)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    /**
     * Izmenjuje podatke o korisniku u tabeli.
     * @param noviKorisnik Korisnik sa izmenjenim podacima.
     */
    
    public void izmeniPodatke(Korisnik noviKorisnik) {
        for(Korisnik korisnik : korisnici) {
            if(korisnik.equals(noviKorisnik)) {
                korisnik.setIme(noviKorisnik.getIme());
                korisnik.setPrezime(noviKorisnik.getPrezime());
                korisnik.setJMBG(noviKorisnik.getJMBG());
                korisnik.setDatumRodjenja(noviKorisnik.getDatumRodjenja());
                korisnik.setMesto(noviKorisnik.getMesto());
            }
        }
        fireTableDataChanged();
    }

}
