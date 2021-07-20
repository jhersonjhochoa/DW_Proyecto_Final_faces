/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.AlumnoSeccionFacadeLocal;
import EJB.UsuarioFacade;
import EJB.UsuarioFacadeLocal;
import java.math.BigDecimal;
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
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    private List<AlumnoSeccion> listaAlumnoSeccion;
    private AlumnoSeccion alumnoSeccion;
    private Usuario alumno;
    private Seccion seccion;
    private int f_seccion;
    private List<Mensaje> mensajes;

    public ManagedAlumnoSeccion() {
        f_seccion = 0;
    }
    
    public List<AlumnoSeccion> getListaAlumnoSeccion() {
        if (f_seccion == 0) {
            this.listaAlumnoSeccion =  new ArrayList<>();
            if (listaAlumnoSeccion.isEmpty()) {
                mensajes.add(new Mensaje("secondary", "Seleccione una sección para ver los alumnos"));
            }
        } else {
            this.listaAlumnoSeccion = alumnoSeccionFacade.findBySeccion(f_seccion);
            if (listaAlumnoSeccion.isEmpty()) {
                mensajes.add(new Mensaje("warning", "Esta sección aún no tiene alumnos"));
            }
        }
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

    public int getF_seccion() {
        return f_seccion;
    }

    public void setF_seccion(int f_seccion) {
        this.f_seccion = f_seccion;
    }
    
    @PostConstruct
    public void init() {
        this.alumnoSeccion = new AlumnoSeccion();
        this.alumno = new Usuario();
        this.seccion = new Seccion();
        this.mensajes = new ArrayList<>();
    }
    
    public void save() {
        this.mensajes = new ArrayList<>();
        alumno = usuarioFacade.findByDocumento(alumno.getDocumento());
        alumnoSeccion.setAlumno(new Usuario(alumno.getId()));
        alumnoSeccion.setSeccion(new Seccion(f_seccion));
        alumnoSeccion.setOrdenMertio(0);
        alumnoSeccion.setPromedio(BigDecimal.ZERO);
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
        this.mensajes = new ArrayList<>();
        this.alumno.setId(as.getAlumno().getId());
        this.seccion.setId(f_seccion);
        this.alumnoSeccion = as;
    }

}
