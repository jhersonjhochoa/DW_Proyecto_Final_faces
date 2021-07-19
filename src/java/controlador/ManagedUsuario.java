/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.UsuarioFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.RolUsuario;
import modelo.Usuario;
import tools.Mensaje;

/**
 *
 * @author Jhonatan
 */
@ManagedBean
@SessionScoped
public class ManagedUsuario {
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    private List<Usuario> listaUsuario;
    private Usuario usuario;
    private RolUsuario rolUsuario;
    private List<Mensaje> mensajes;

    public List<Usuario> getListaUsuario() {
        listaUsuario = usuarioFacade.findAll();
        return listaUsuario;
    }
    
    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public RolUsuario getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
    
    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
    
    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        this.rolUsuario = new RolUsuario();
        this.mensajes = new ArrayList<>();
    }

    public void save() {
        this.mensajes = new ArrayList<>();
        RolUsuario rol_anterior = usuario.getRol();
        usuario.setRol(rolUsuario);
        if (usuario.getId() == null) {
            usuario.setPassword(usuario.getDocumento());
            usuarioFacade.create(usuario);
            mensajes.add(new Mensaje("success", "Usuario agregado correctamente."));
        } else {
            if (!Objects.equals(rolUsuario.getId(), rol_anterior.getId())) {
                if (!usuario.getAlumnoSeccionCollection().isEmpty()) {
                    mensajes.add(new Mensaje("warning", "Se omitió la actualización del Rol. El alumno está matriculado en una o más secciones."));
                    usuario.setRol(rol_anterior);
                } else if (!usuario.getSeccionCursoCollection().isEmpty()) {
                    mensajes.add(new Mensaje("warning", "Se omitió la actualización del Rol. El docente está asignado en una o más secciones."));
                    usuario.setRol(rol_anterior);
                }
            }
            usuarioFacade.edit(usuario);
            mensajes.add(new Mensaje("success", "Usuario actualizado correctamente."));
        }
    }
    
    public void delete() {
        if (!usuario.getAlumnoSeccionCollection().isEmpty()) {
            mensajes.add(new Mensaje("danger", "No se puede eliminar el alumno por que está matriculado en una o más secciones."));
        } else if (!usuario.getSeccionCursoCollection().isEmpty()) {
            mensajes.add(new Mensaje("danger", "No se puede eliminar el docente por que está asignado en una o más secciones."));
        } else {
            usuarioFacade.remove(usuario);
            mensajes.add(new Mensaje("success", "Usuario eliminado correctamente."));
        }  
    }
    
    public void loadData(Usuario u) {
        this.mensajes = new ArrayList<>();
        this.rolUsuario.setId(u.getRol().getId());
        this.usuario = u;
    }
    
}
