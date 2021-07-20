/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.CursoFacadeLocal;
import EJB.SeccionCursoFacadeLocal;
import EJB.UsuarioFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Curso;
import modelo.Seccion;
import modelo.SeccionCurso;
import modelo.Usuario;
import tools.Mensaje;

/**
 *
 * @author Jhonatan
 */
@ManagedBean
@SessionScoped
public class ManagedSeccionCurso {

    @EJB
    private SeccionCursoFacadeLocal seccionCursoFacade;
    @EJB
    private CursoFacadeLocal cursooFacade;
    private List<SeccionCurso> listaSeccionCurso;
    private SeccionCurso seccionCurso;
    private Curso curso;
    private Seccion seccion;
    private Usuario docente;
    private int f_seccion;
    private List<Mensaje> mensajes;

    public List<SeccionCurso> getListaSeccionCurso() {
        this.listaSeccionCurso = seccionCursoFacade.findBySeccion(f_seccion);
        System.out.println("sec: " + f_seccion);
        return listaSeccionCurso;
    }

    public void setListaSeccionCurso(List<SeccionCurso> listaSeccionCurso) {
        this.listaSeccionCurso = listaSeccionCurso;
    }

    public SeccionCurso getSeccionCurso() {
        return seccionCurso;
    }

    public void setSeccionCurso(SeccionCurso seccionCurso) {
        this.seccionCurso = seccionCurso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Usuario getDocente() {
        return docente;
    }

    public void setDocente(Usuario docente) {
        this.docente = docente;
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
        System.out.println("init called");
        this.seccionCurso = new SeccionCurso();
        this.curso = new Curso();
        this.seccion = new Seccion();
        this.docente = new Usuario();
        this.mensajes = new ArrayList<>();
    }

    public void save() {
        this.mensajes = new ArrayList<>();
        this.seccionCurso.setSeccion(new Seccion(f_seccion));
        this.seccionCurso.setCurso(new Curso(curso.getId()));
        this.seccionCurso.setDocente(new Usuario(docente.getId()));
        if (seccionCurso.getId() == null) {
            seccionCursoFacade.create(seccionCurso);
            mensajes.add(new Mensaje("success", "Curso agregado a la sección correctamente."));
        } else {
            seccionCursoFacade.edit(seccionCurso);
            mensajes.add(new Mensaje("success", "Registro actualizado correctamente."));
        }
    }

    public void delete() {
        seccionCursoFacade.remove(seccionCurso);
        mensajes.add(new Mensaje("success", "Curso retirado de la sección correctamente."));
    }

    public void loadData(SeccionCurso sc) {
        this.mensajes = new ArrayList<>();
        this.curso.setId(sc.getCurso().getId());
        this.seccion.setId(f_seccion);
        this.docente.setId(sc.getDocente().getId());
        this.seccionCurso = sc;
    }

}
