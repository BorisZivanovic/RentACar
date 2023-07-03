package fon.rs.np.RentACarZajednickiMaven.domen;

import java.io.Serializable;
import java.util.List;
import java.sql.ResultSet;

/**
 * Apstraktna klasa koja predstavlja opšti objekat.
 * Definiše apstraktne metode koje treba implementirati u podklasama.
 * 
 * @author Boris Zivanovic
 */

public abstract class OpstiObjekat implements Serializable {

	/**
     * Vraća naziv tabele u bazi podataka za trenutni objekat.
     *
     * @return naziv tabele
     */
	
    public abstract String vratiTabelu();
    
    /**
     * Vraća kolone koje treba selektovati iz tabele za trenutni objekat.
     *
     * @return lista kolona
     */
    
    public abstract String vratiKolone();

    /**
     * Vraća kolone koje treba ubaciti prilikom inserta novog objekta u tabelu.
     *
     * @return lista kolona
     */
    
    public abstract String insertKolone();

    /**
     * Vraća vrednosti koje treba ubaciti prilikom inserta novog objekta u tabelu.
     *
     * @return lista vrednosti
     */
    
    public abstract String dajVrednosti();
    
    /**
     * Vraća listu objekata dobijenu iz ResultSet objekta.
     *
     * @param rs ResultSet objekat
     * @return lista objekata
     */
    
    public abstract List<OpstiObjekat> dajListu(ResultSet rs);

    /**
     * Vraća WHERE uslov za selektovanje objekta iz tabele.
     *
     * @return WHERE uslov
     */
    
    public abstract String whereUslov();
    
    /**
     * Vraća WHERE uslov za spajanje tabela prilikom selektovanja objekta.
     *
     * @return WHERE uslov
     */
    
    public abstract String whereSelectUslov();

    /**
     * Vraća izmenu objekta u formatu kolona=vrednost.
     *
     * @return izmena objekta
     */
    
    public abstract String izmenaObjekta();
    
}
