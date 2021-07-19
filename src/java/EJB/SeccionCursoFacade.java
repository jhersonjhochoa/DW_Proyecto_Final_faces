/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.AlumnoSeccion;
import modelo.Seccion;
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
    
    private CriteriaBuilder getCb() {
        return getEntityManager().getCriteriaBuilder();
    }

    @Override
    public List<AlumnoSeccion> findBySeccion(int s) {
        CriteriaQuery cq = getCb().createQuery();
        Root<SeccionCurso> from = cq.from(SeccionCurso.class);
        cq.select(from);
        cq.where(getCb().equal(from.<Integer>get("seccion"), s));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
}
