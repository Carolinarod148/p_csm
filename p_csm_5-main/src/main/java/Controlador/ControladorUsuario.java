/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controlador;

import Entities.Usuario;
import Facade.UsuarioFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author mateo
 */
@Named(value = "controladorUsuario")
@RequestScoped
public class ControladorUsuario {
    
        @EJB
        private UsuarioFacade usuariofacade;
        Usuario usuario = new Usuario();
    /**
     * Creates a new instance of ControladorUsuario
     */
    public ControladorUsuario() {
    }
    
    public String loginU(){
        String ruta = "index";
        FacesContext context = FacesContext.getCurrentInstance();
          try{
            this.usuariofacade.loginUser(usuario.getCorreo(), usuario.getClave());
            if (usuario == null) {
                FacesMessage fm = new FacesMessage("Usuario y/o contraseña incorrectos", "ERROR MSG");
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, fm);
                
               
            } else {
                context.getExternalContext().getSessionMap().put("usuario", usuario.getClave());
                ruta = "index";
          }
          }catch (Exception e){
              
          }
          return ruta; 
}

    public UsuarioFacade getUsuariofacade() {
        return usuariofacade;
    }

    public void setUsuariofacade(UsuarioFacade usuariofacade) {
        this.usuariofacade = usuariofacade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
