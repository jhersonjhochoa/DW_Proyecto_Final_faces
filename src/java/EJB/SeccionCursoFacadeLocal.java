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
import modelo.SeccionCurso;

/**
 *
 * @author Jhonatan
 */
@Local
public interface SeccionCursoFacadeLocal {

    void create(SeccionCurso seccionCurso);

    void edit(SeccionCurso seccionCurso);

    void remove(SeccionCurso seccionCurso);

    SeccionCurso find(Object id);

    List<SeccionCurso> findAll();

    List<SeccionCurso> findRange(int[] range);

    List<SeccionCurso> findBySeccion(int s);

    int count();
    
}
