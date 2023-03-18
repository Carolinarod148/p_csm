/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controlador;

import Entities.TipoDoc;
import Entities.Usuario;
import Facade.TipoDocFacade;
import Facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author mateo
 */
@Named(value = "controladorCrearUsuario")
@SessionScoped
public class ControladorCrearUsuario implements Serializable {

    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private TipoDocFacade tipoDocFacade;
    private String tipoDocSelect;
    private Usuario usuario = new Usuario();

    /**
     * Creates a new instance of ControladorCrearUsuario
     */
    public ControladorCrearUsuario() {
    }

    public void save() {
        usuario.setTipoDocumento(tipoDocFacade.find(tipoDocSelect));
        if (usuario.getNumDoc() != null) {
            usuarioFacade.edit(usuario);
        } else {
            usuarioFacade.create(usuario);
        }
        usuario = new Usuario();

    }

    public List<TipoDoc> getAllTipoDoc() {
        return tipoDocFacade.findAll();
    }

    public List<Usuario> getAllUsuario() {
        return usuarioFacade.findAll();
    }

    public void selectUpdate(Usuario usuario) {
        this.usuario = usuario;
    }

    public void delete(Usuario usuario) {
        usuarioFacade.remove(usuario);
    }

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public TipoDocFacade getTipoDocFacade() {
        return tipoDocFacade;
    }

    public void setTipoDocFacade(TipoDocFacade tipoDocFacade) {
        this.tipoDocFacade = tipoDocFacade;
    }

    public String getTipoDocSelect() {
        return tipoDocSelect;
    }

    public void setTipoDocSelect(String tipoDocSelect) {
        this.tipoDocSelect = tipoDocSelect;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
