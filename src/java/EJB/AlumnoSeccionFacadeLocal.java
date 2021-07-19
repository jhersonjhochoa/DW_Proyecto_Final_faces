/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.AlumnoSeccion;
import modelo.Seccion;

/**
 *
 * @author Jhonatan
 */
@Local
public interface AlumnoSeccionFacadeLocal {

    void create(AlumnoSeccion alumnoSeccion);

    void edit(AlumnoSeccion alumnoSeccion);

    void remove(AlumnoSeccion alumnoSeccion);

    AlumnoSeccion find(Object id);

    List<AlumnoSeccion> findAll();

    List<AlumnoSeccion> findRange(int[] range);
    
    List<AlumnoSeccion> findBySeccion(int s);

    int count();
    
}
