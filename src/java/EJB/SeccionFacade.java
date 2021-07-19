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
import modelo.Seccion;

/**
 *
 * @author Jhonatan
 */
@Stateless
public class SeccionFacade extends AbstractFacade<Seccion> implements SeccionFacadeLocal {

    @PersistenceContext(unitName = "SW_Proyecto_Final_facesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeccionFacade() {
        super(Seccion.class);
    }
    
    private CriteriaBuilder getCb() {
        return getEntityManager().getCriteriaBuilder();
    }
    
    @Override
    public List<Seccion> findByYears(int y_start, int y_end) {
        CriteriaQuery cq = getCb().createQuery();
        Root<Seccion> from = cq.from(Seccion.class);
        cq.select(from);
        cq.where(getCb().between(from.<Integer>get("anio"), y_start, y_end));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
