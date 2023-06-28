package fon.rs.np.RentACarKlijentMaven.tabele;

import fon.rs.np.RentACarZajednickiMaven.domen.StavkaRacuna;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleStavkaRacuna extends AbstractTableModel {

    List<StavkaRacuna> iznajmljeno;

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

    public void dodajIznajmljeno(StavkaRacuna novo) {
        iznajmljeno.add(novo);
        fireTableDataChanged();
    }

    public void izbaci(int index) {
        iznajmljeno.remove(index);
        fireTableDataChanged();
    }

    public List<StavkaRacuna> getIznajmljeno() {
        return iznajmljeno;
    }

    public StavkaRacuna vrati(int index) {
        return iznajmljeno.get(index);
    }

}
