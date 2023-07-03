package fon.rs.np.RentACarKlijentMaven.tabele;

import fon.rs.np.RentACarZajednickiMaven.domen.StatusVozila;
import fon.rs.np.RentACarZajednickiMaven.domen.Vozilo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Model tabele za prikaz vozila.
 * Klasa nasleđuje apstraktnu klasu AbstractTableModel i implementira njene apstraktne metode.
 * 
 * @author Boris Zivanovic
 */

public class ModelTabeleVozila extends AbstractTableModel {

	/**
	 * lista vozila
	 */
    List<Vozilo> vozila;
    
    /**
     * Konstruktor koji inicijalizuje model tabele vozila.
     * @param vozila Lista vozila.
     */
    
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
    
    /**
     * Dodaje novo vozilo u tabelu.
     * @param vozilo Vozilo koje se dodaje.
     */
    
    public void dodajVozilo(Vozilo vozilo) {
        vozila.add(vozilo);
        fireTableDataChanged();
    }
    
    /**
     * Vraća vozilo sa datim indeksom.
     * @param broj Indeks vozila.
     * @return Vozilo sa datog indeksa.
     */
    
    public Vozilo vratiVozilo(int broj) {
        return vozila.get(broj);
    }

    /**
     * Izbacuje vozilo iz tabele na datom indeksu.
     * @param row Indeks vozila koje se izbacuje.
     */
    
    public void izbrisiVozilo(int row) {
        vozila.remove(row);
        fireTableDataChanged();
    }
    
    /**
     * Postavlja status vozila na ZAUZETO za dato vozilo.
     * @param v Vozilo koje se iznajmljuje.
     */
    
    public void iznajmi(Vozilo v) {
        for(Vozilo vozilo : vozila) {
            if(vozilo.getId().equals(v.getId())) {
                vozilo.setStatusVozila(StatusVozila.ZAUZETO);
                fireTableDataChanged();
                return;
            }
        }
    }
    
    /**
     * Postavlja status vozila na SLOBODNO za dato vozilo.
     * @param v Vozilo koje se vraća, a prethodno je bilo iznajmljeno.
     */
    
    public void vratiIznajmljeno(Vozilo v) {
        for(Vozilo vozilo : vozila) {
            if(vozilo.getId().equals(v.getId())) {
                vozilo.setStatusVozila(StatusVozila.SLOBODNO);
                fireTableDataChanged();
                return;
            }
        }
    }
    
    /**
     * Izmenjuje podatke o vozilu.
     * @param v Vozilo sa izmenjenim podacima.
     */
    
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
