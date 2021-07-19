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
import modelo.Usuario;

/**
 *
 * @author Jhonatan
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "SW_Proyecto_Final_facesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    private CriteriaBuilder getCb() {
        return getEntityManager().getCriteriaBuilder();
    }

    @Override
    public Usuario findByDocumento(String doc) {
        CriteriaQuery cq = getCb().createQuery();
        Root<Usuario> from = cq.from(Usuario.class);
        cq.select(from);
        cq.where(getCb().equal(from.<String>get("documento"), doc));
        return (Usuario) getEntityManager().createQuery(cq).getSingleResult();
    }
}
