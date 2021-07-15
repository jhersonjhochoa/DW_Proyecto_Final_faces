/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.AlumnoSeccionFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.AlumnoSeccion;
import modelo.Seccion;
import modelo.Usuario;
import tools.Mensaje;

/**
 *
 * @author Jhonatan
 */
@ManagedBean
@SessionScoped
public class ManagedAlumnoSeccion {
    @EJB
    private AlumnoSeccionFacadeLocal alumnoSeccionFacade;
    private List<AlumnoSeccion> listaAlumnoSeccion;
    private AlumnoSeccion alumnoSeccion;
    private Usuario alumno;
    private Seccion seccion;
    private List<Mensaje> mensajes;

    public List<AlumnoSeccion> getListaAlumnoSeccion() {
        return listaAlumnoSeccion;
    }

    public void setListaAlumnoSeccion(List<AlumnoSeccion> listaAlumnoSeccion) {
        this.listaAlumnoSeccion = listaAlumnoSeccion;
    }

    public AlumnoSeccion getAlumnoSeccion() {
        return alumnoSeccion;
    }

    public void setAlumnoSeccion(AlumnoSeccion alumnoSeccion) {
        this.alumnoSeccion = alumnoSeccion;
    }

    public Usuario getAlumno() {
        return alumno;
    }

    public void setAlumno(Usuario alumno) {
        this.alumno = alumno;
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
    
    @PostConstruct
    public void init() {
        this.alumnoSeccion = new AlumnoSeccion();
        this.alumno = new Usuario();
        this.seccion = new Seccion();
        this.mensajes = new ArrayList<>();
    }
    
    public void save() {
        alumnoSeccion.setAlumno(alumno);
        alumnoSeccion.setSeccion(seccion);
        if (alumnoSeccion.getId() == null) {
            alumnoSeccionFacade.create(alumnoSeccion);
            mensajes.add(new Mensaje("success", "Alumno agregado a la sección correctamente."));
        } /*else {
            alumnoSeccionFacade.edit(alumnoSeccion);
            mensajes.add(new Mensaje("success", "Actualizado correctamente."));
        }*/
    }
    
    public void delete() {
        alumnoSeccionFacade.remove(alumnoSeccion);
        mensajes.add(new Mensaje("success", "Alumno retirado de la sección correctamente."));
    }
    
    public void loadData(AlumnoSeccion as) {
        this.alumno.setId(as.getAlumno().getId());
        this.seccion.setId(as.getSeccion().getId());
        this.alumnoSeccion = as;
    }
}
