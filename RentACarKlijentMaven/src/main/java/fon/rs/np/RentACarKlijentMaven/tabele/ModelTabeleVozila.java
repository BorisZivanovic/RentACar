package fon.rs.np.RentACarKlijentMaven.tabele;

import fon.rs.np.RentACarZajednickiMaven.domen.StatusVozila;
import fon.rs.np.RentACarZajednickiMaven.domen.Vozilo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabeleVozila extends AbstractTableModel {

    List<Vozilo> vozila;
    
    public ModelTabeleVozila(List<Vozilo> vozila) {
        this.vozila = vozila;
    }
    
    @Override
    public int getRowCount() {
        return vozila.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vozilo vozilo = vozila.get(rowIndex);
        
        if(columnIndex == 0)
            return vozilo.getRegistarskiBroj();
        if(columnIndex == 1)
            return vozilo.getMarka();
        if(columnIndex == 2)
            return vozilo.getModel();
        if(columnIndex == 3)
            return vozilo.getStatusVozila();
        if(columnIndex == 4)
            return vozilo.getKategorijaVozila();
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0)
            return "registarski broj";
        if(column == 1)
            return "marka";
        if(column == 2)
            return "model";
        if(column == 3)
            return "status";
        if(column == 4)
            return "kategorija";
        
        return null;
    }
    
    public void dodajVozilo(Vozilo vozilo) {
        vozila.add(vozilo);
        fireTableDataChanged();
    }
    
    public Vozilo vratiVozilo(int broj) {
        return vozila.get(broj);
    }

    public void izbrisiVozilo(int row) {
        vozila.remove(row);
        fireTableDataChanged();
    }
    
    public void iznajmi(Vozilo v) {
        for(Vozilo vozilo : vozila) {
            if(vozilo.getId().equals(v.getId())) {
                vozilo.setStatusVozila(StatusVozila.ZAUZETO);
                fireTableDataChanged();
                return;
            }
        }
    }
    
    public void vratiIznajmljeno(Vozilo v) {
        for(Vozilo vozilo : vozila) {
            if(vozilo.getId().equals(v.getId())) {
                vozilo.setStatusVozila(StatusVozila.SLOBODNO);
                fireTableDataChanged();
                return;
            }
        }
    }
    
    public void izmeniVozilo(Vozilo v) {
        for(Vozilo vozilo : vozila) {
            if(vozilo.getId().equals(v.getId())) {
                vozilo.setMarka(v.getMarka());
                vozilo.setModel(v.getModel());
                vozilo.setKategorijaVozila(v.getKategorijaVozila());
                fireTableDataChanged();
                return;
            }
        }
    }
    
}
