/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.SeccionCurso;

/**
 *
 * @author Jhonatan
 */
@Stateless
public class SeccionCursoFacade extends AbstractFacade<SeccionCurso> implements SeccionCursoFacadeLocal {

    @PersistenceContext(unitName = "SW_Proyecto_Final_facesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeccionCursoFacade() {
        super(SeccionCurso.class);
    }
    
}
