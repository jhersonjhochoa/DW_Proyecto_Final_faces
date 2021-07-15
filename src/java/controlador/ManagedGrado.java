/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.GradoFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Grado;
import modelo.NivelEducativo;
import tools.Mensaje;

/**
 *
 * @author Jhonatan
 */
@ManagedBean
@SessionScoped
public class ManagedGrado {
    @EJB
    private GradoFacadeLocal gradoFacade;
    private List<Grado> listaGrado;
    private Grado grado;
    private NivelEducativo nivel;
    private List<Mensaje> mensajes;

    public List<Grado> getListaGrado() {
        return listaGrado;
    }

    public void setListaGrado(List<Grado> listaGrado) {
        this.listaGrado = listaGrado;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public NivelEducativo getNivel() {
        return nivel;
    }

    public void setNivel(NivelEducativo nivel) {
        this.nivel = nivel;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
    
    @PostConstruct
    public void init() {
        this.grado = new Grado();
        this.nivel = new NivelEducativo();
        this.mensajes = new ArrayList<>();
    }
    
    public void save() {
        if (grado.getId() == null) {
            gradoFacade.create(grado);
            mensajes.add(new Mensaje("success", "Grado agregado correctamente."));
        } else {
            gradoFacade.edit(grado);
            mensajes.add(new Mensaje("success", "Grado actualizado correctamente."));
        }
    }
    
    public void delete() {
        gradoFacade.remove(grado);
        mensajes.add(new Mensaje("success", "Grado eliminado correctamente."));
    }
    
    public void loadData(Grado g) {
        this.nivel.setId(g.getNivel().getId());
        this.grado = g;
    }
}
