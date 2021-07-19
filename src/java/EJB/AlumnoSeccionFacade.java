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

/**
 *
 * @author Jhonatan
 */
@Stateless
public class AlumnoSeccionFacade extends AbstractFacade<AlumnoSeccion> implements AlumnoSeccionFacadeLocal {

    @PersistenceContext(unitName = "SW_Proyecto_Final_facesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnoSeccionFacade() {
        super(AlumnoSeccion.class);
    }
    
    private CriteriaBuilder getCb() {
        return getEntityManager().getCriteriaBuilder();
    }

    @Override
    public List<AlumnoSeccion> findBySeccion(int s) {
        CriteriaQuery cq = getCb().createQuery();
        Root<AlumnoSeccion> from = cq.from(AlumnoSeccion.class);
        cq.select(from);
        cq.where(getCb().equal(from.<Seccion>get("seccion"), new Seccion(s)));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
}
