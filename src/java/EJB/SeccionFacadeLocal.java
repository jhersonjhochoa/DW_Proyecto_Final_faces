/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Seccion;

/**
 *
 * @author Jhonatan
 */
@Local
public interface SeccionFacadeLocal {

    void create(Seccion seccion);

    void edit(Seccion seccion);

    void remove(Seccion seccion);

    Seccion find(Object id);

    List<Seccion> findAll();
    
    List<Seccion> findByYears(int y_start, int y_end);

    List<Seccion> findRange(int[] range);

    int count();
    
}
