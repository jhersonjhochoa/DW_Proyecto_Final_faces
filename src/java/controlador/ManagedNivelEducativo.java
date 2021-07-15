/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.NivelEducativoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ejb.EJB;
import modelo.NivelEducativo;

/**
 *
 * @author Jhonatan
 */
@ManagedBean
@SessionScoped
public class ManagedNivelEducativo {
    @EJB
    private NivelEducativoFacadeLocal nivelEducativoFacade;
    private List<NivelEducativo> listaNivelEducativo;
    private NivelEducativo nivelEducativo;
    
    public List<NivelEducativo> getListaNivelEducativo() {
        this.listaNivelEducativo = nivelEducativoFacade.findAll();
        return listaNivelEducativo;
    }

    public void setListaNivelEducativo(List<NivelEducativo> listaNivelEducativo) {
        this.listaNivelEducativo = listaNivelEducativo;
    }
    
    public NivelEducativo getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(NivelEducativo nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    @PostConstruct
    public void init() {
        this.nivelEducativo = new NivelEducativo();
    }

    public void save() {
        nivelEducativoFacade.create(nivelEducativo);
    }
    
    public void delete() {
        nivelEducativoFacade.remove(nivelEducativo);
    }
    
    public void loadData(NivelEducativo ne) {
        this.nivelEducativo = ne;
    }
    
    public void update() {
        nivelEducativoFacade.edit(nivelEducativo);
    }
}
