/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.SeccionFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Grado;
import modelo.Seccion;
import tools.Mensaje;

/**
 *
 * @author Jhonatan
 */
@ManagedBean
@SessionScoped
public class ManagedSeccion {
    @EJB
    private SeccionFacadeLocal seccionFacade;
    private List<Seccion> listaSeccion;
    private Seccion seccion;
    private Grado grado;
    private List<Mensaje> mensajes;

    public List<Seccion> getListaSeccion() {
        return listaSeccion;
    }

    public void setListaSeccion(List<Seccion> listaSeccion) {
        this.listaSeccion = listaSeccion;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }
    
    @PostConstruct
    public void init() {
        this.seccion = new Seccion();
        this.mensajes = new ArrayList<>();
    }
    
    public void save() {
        seccion.setGrado(grado);
        if (seccion.getId() == null) {
            seccionFacade.create(seccion);
            mensajes.add(new Mensaje("success", "Seccion agregada correctamente."));
        } else {
            seccionFacade.edit(seccion);
            mensajes.add(new Mensaje("success", "Seccion actualizada correctamente."));
        }
    }
    
    public void delete() {
        seccionFacade.remove(seccion);
        mensajes.add(new Mensaje("success", "Seccion eliminada correctamente."));
    }
    
    public void loadData(Seccion s) {
        this.grado.setId(s.getGrado().getId());
        this.seccion = s;        
    }
}
