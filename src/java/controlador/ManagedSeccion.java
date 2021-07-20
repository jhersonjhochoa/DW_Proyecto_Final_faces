/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.SeccionFacadeLocal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.Facelet;
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
    private int y_start;
    private int y_end;

    public ManagedSeccion() {
        y_start = Calendar.getInstance().get(Calendar.YEAR);
        y_end = y_start + 1;
    }
    
    public List<Seccion> getListaTotal() {
        return seccionFacade.findAll();
    }

    public List<Seccion> getListaSeccion() {
        this.listaSeccion = seccionFacade.findByYears(y_start, y_end);
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
    
    public int getY_start() {
        return y_start;
    }

    public void setY_start(int y_start) {
        this.y_start = y_start;
    }

    public int getY_end() {
        return y_end;
    }

    public void setY_end(int y_end) {
        this.y_end = y_end;
    }
    
    @PostConstruct
    public void init() {
        this.seccion = new Seccion();
        this.grado = new Grado();
        this.mensajes = new ArrayList<>();
    }
    
    public void save() {
        this.mensajes = new ArrayList<>();
        seccion.setGrado(new Grado(grado.getId()));
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
        String version = FacesContext.class.getPackage().getImplementationVersion();
        System.out.println("version: " + version);
        System.out.println("JSF API Location: " + FacesContext.class.getProtectionDomain().getCodeSource());
        System.out.println("JSF Impl Location: " + Facelet.class.getProtectionDomain().getCodeSource());
        this.mensajes = new ArrayList<>();
        this.grado.setId(s.getGrado().getId());
        this.seccion = s;        
    }   
    
}
