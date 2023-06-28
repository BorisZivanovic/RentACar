package fon.rs.np.RentACarKlijentMaven.tabele;

import fon.rs.np.RentACarZajednickiMaven.domen.StavkaRacuna;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Model tabele za prikaz stavki računa.
 * Klasa nasleđuje apstraktnu klasu AbstractTableModel i implementira njene apstraktne metode.
 */

public class ModelTabeleStavkaRacuna extends AbstractTableModel {

	/**
	 * lista stavki racuna
	 */
    List<StavkaRacuna> iznajmljeno;

    /**
     * Konstruktor koji inicijalizuje model tabele stavki računa.
     * @param iznajmljeno Lista stavki računa.
     */
    
    public ModelTabeleStavkaRacuna(List<StavkaRacuna> iznajmljeno) {
        if (iznajmljeno == null) {
            this.iznajmljeno = new ArrayList<>();
        } else {
            this.iznajmljeno = iznajmljeno;
        }
    }

    @Override
    public int getRowCount() {
        return iznajmljeno.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna i = iznajmljeno.get(rowIndex);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        switch (columnIndex) {
            case 0:
                return i.getRbStavke();
            case 1:
                return i.getVozilo();
            case 2:
                return i.getKorisnik();
            case 3:
                return df.format(i.getIznajmljivanje().getDatumIznajmljivanja());
            case 4:
                return df.format(i.getIznajmljivanje().getDatumVracanja());
            case 5:
                return i.getIznosSaPDV();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Registarski broj";
            case 2:
                return "Korisnik";
            case 3:
                return "Datum iznajmljivanja";
            case 4:
                return "Datum vracanja";
            case 5:
                return "Ukupan iznos";
            default:
                return "";
        }
    }

    /**
     * Dodaje novu stavku računa u tabelu.
     * @param novo Stavka računa koja se dodaje.
     */
    
    public void dodajIznajmljeno(StavkaRacuna novo) {
        iznajmljeno.add(novo);
        fireTableDataChanged();
    }

    /**
     * Izbacuje stavku računa iz tabele na datom indeksu.
     * @param index Indeks stavke računa koja se izbacuje.
     */
    
    public void izbaci(int index) {
        iznajmljeno.remove(index);
        fireTableDataChanged();
    }

    /**
     * Vraća listu stavki računa.
     * @return Lista stavki računa.
     */
    
    public List<StavkaRacuna> getIznajmljeno() {
        return iznajmljeno;
    }

    /**
     * Vraća stavku računa sa datog indeksa.
     * @param index Indeks stavke računa.
     * @return Stavka računa sa datog indeksa.
     */
    
    public StavkaRacuna vrati(int index) {
        return iznajmljeno.get(index);
    }

}
