package fon.rs.np.RentACarKlijentMaven.tabele;

import fon.rs.np.RentACarZajednickiMaven.domen.Korisnik;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleKorisnici extends AbstractTableModel {

    List<Korisnik> korisnici;

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

    public void dodajKorisnika(Korisnik korisnik) {
        korisnici.add(korisnik);
        fireTableDataChanged();
    }

    public void izbrsiKorisnika(int index) {
        korisnici.remove(index);
        fireTableDataChanged();
    }

    public Korisnik vratiKorisnika(int index) {
        return korisnici.get(index);
    }

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
