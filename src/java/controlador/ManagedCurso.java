/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.CursoFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Curso;
import tools.Mensaje;

/**
 *
 * @author Jhonatan
 */
@ManagedBean
@SessionScoped
public class ManagedCurso {
    @EJB
    private CursoFacadeLocal cursoFacade;
    private List<Curso> listaCurso;
    private Curso curso;
    private List<Mensaje> mensajes;

    public List<Curso> getListaCurso() {
        this.listaCurso = cursoFacade.findAll();
        return listaCurso;
    }

    public void setListaCurso(List<Curso> listaCurso) {
        this.listaCurso = listaCurso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
    
    @PostConstruct
    public void init() {
        this.curso = new Curso();
        this.mensajes = new ArrayList<>();
    }
    
    public void save() {
        this.mensajes = new ArrayList<>();
        if (curso.getId() == null) {
            cursoFacade.create(curso);
            mensajes.add(new Mensaje("success", "Curso agregado correctamente."));
        } else {
            cursoFacade.edit(curso);
            mensajes.add(new Mensaje("success", "Curso actualizado correctamente."));
        }
    }
    
    public void delete() {
        cursoFacade.remove(curso);
        mensajes.add(new Mensaje("success", "Curso eliminado correctamente."));
    }
    
    public void loadData(Curso c) {
        this.mensajes = new ArrayList<>();
        this.curso = c;
    }
}
