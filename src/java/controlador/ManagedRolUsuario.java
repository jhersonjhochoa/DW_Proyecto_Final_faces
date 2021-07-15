/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.RolUsuarioFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.RolUsuario;

/**
 *
 * @author Jhonatan
 */
@ManagedBean
@SessionScoped
public class ManagedRolUsuario {
    @EJB
    private RolUsuarioFacadeLocal rolUsuarioFacade;
    private List<RolUsuario> listaRolUsuario;
    private RolUsuario rolUsuario;

    public List<RolUsuario> getListaRolUsuario() {
        listaRolUsuario = rolUsuarioFacade.findAll();
        return listaRolUsuario;
    }

    public void setListaRolUsuario(List<RolUsuario> listaRolUsuario) {
        this.listaRolUsuario = listaRolUsuario;
    }

    public RolUsuario getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
    
    @PostConstruct
    public void init() {
        this.rolUsuario = new RolUsuario();
    }

    public void save() {
        rolUsuarioFacade.create(rolUsuario);
    }
    
    public void delete() {
        rolUsuarioFacade.remove(rolUsuario);
    }
    
    public void loadData(RolUsuario ru) {
        this.rolUsuario = ru;
    }
    
    public void update() {
        rolUsuarioFacade.edit(rolUsuario);
    }
}
