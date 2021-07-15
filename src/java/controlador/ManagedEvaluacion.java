/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.EvaluacionFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Evaluacion;
import modelo.SeccionCurso;
import tools.Mensaje;

/**
 *
 * @author Jhonatan
 */
@ManagedBean
@SessionScoped
public class ManagedEvaluacion {
    @EJB
    private EvaluacionFacadeLocal evaluacionFacade;
    private List<Evaluacion> listaEvaluacion;
    private Evaluacion evaluacion;
    private SeccionCurso seccionCurso;
    private List<Mensaje> mensajes;

    public List<Evaluacion> getListaEvaluacion() {
        return listaEvaluacion;
    }

    public void setListaEvaluacion(List<Evaluacion> listaEvaluacion) {
        this.listaEvaluacion = listaEvaluacion;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public SeccionCurso getSeccionCurso() {
        return seccionCurso;
    }

    public void setSeccionCurso(SeccionCurso seccionCurso) {
        this.seccionCurso = seccionCurso;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
    
    @PostConstruct
    public void init() {
        this.evaluacion = new Evaluacion();
        this.seccionCurso = new SeccionCurso();
        this.mensajes = new ArrayList<>();
    }
    
    public void save() {
        if (evaluacion.getId() == null) {
            evaluacionFacade.create(evaluacion);
            mensajes.add(new Mensaje("success", "Evaluación agregada correctamente."));
        } else {
            evaluacionFacade.edit(evaluacion);
            mensajes.add(new Mensaje("success", "Evaluación actualizada correctamente."));
        }
    }
    
    public void delete() {
        evaluacionFacade.remove(evaluacion);
        mensajes.add(new Mensaje("success", "Evaluación eliminada correctamente."));
    }
    
    public void loadData(Evaluacion e) {
        this.seccionCurso.setId(e.getSeccionCurso().getId());
        this.evaluacion = e;
    }
}
