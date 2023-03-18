/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mateo
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByNumDoc", query = "SELECT u FROM Usuario u WHERE u.numDoc = :numDoc"),
    @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave"),
    @NamedQuery(name = "Usuario.findByPnom", query = "SELECT u FROM Usuario u WHERE u.pnom = :pnom"),
    @NamedQuery(name = "Usuario.findBySnom", query = "SELECT u FROM Usuario u WHERE u.snom = :snom"),
    @NamedQuery(name = "Usuario.findByPape", query = "SELECT u FROM Usuario u WHERE u.pape = :pape"),
    @NamedQuery(name = "Usuario.findBySape", query = "SELECT u FROM Usuario u WHERE u.sape = :sape"),
    @NamedQuery(name = "Usuario.findByRs", query = "SELECT u FROM Usuario u WHERE u.rs = :rs"),
    @NamedQuery(name = "Usuario.findByTel", query = "SELECT u FROM Usuario u WHERE u.tel = :tel"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "num_doc")
    private String numDoc;
   
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clave")
    private String clave;
    @Size(max = 20)
    @Column(name = "pnom")
    private String pnom;
    @Size(max = 20)
    @Column(name = "snom")
    private String snom;
    @Size(max = 20)
    @Column(name = "pape")
    private String pape;
    @Size(max = 20)
    @Column(name = "sape")
    private String sape;
    @Size(max = 45)
    @Column(name = "rs")
    private String rs;
    @Size(max = 30)
    @Column(name = "tel")
    private String tel;
    @Size(max = 15)
    @Column(name = "correo")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ndocUsu", fetch = FetchType.LAZY)
    private Collection<UsuarioRol> usuarioRolCollection;
    @OneToMany(mappedBy = "ndocProveedor", fetch = FetchType.LAZY)
    private Collection<OrdenEntrada> ordenEntradaCollection;
    @OneToMany(mappedBy = "ndocClient", fetch = FetchType.LAZY)
    private Collection<Pedido> pedidoCollection;
    @JoinColumn(name = "tipo_documento", referencedColumnName = "cod_tdoc")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoDoc tipoDocumento;

    public Usuario() {
    }

    public Usuario(String numDoc) {
        this.numDoc = numDoc;
    }

    public Usuario(String numDoc, String clave) {
        this.numDoc = numDoc;
        this.clave = clave;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPnom() {
        return pnom;
    }

    public void setPnom(String pnom) {
        this.pnom = pnom;
    }

    public String getSnom() {
        return snom;
    }

    public void setSnom(String snom) {
        this.snom = snom;
    }

    public String getPape() {
        return pape;
    }

    public void setPape(String pape) {
        this.pape = pape;
    }

    public String getSape() {
        return sape;
    }

    public void setSape(String sape) {
        this.sape = sape;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public Collection<UsuarioRol> getUsuarioRolCollection() {
        return usuarioRolCollection;
    }

    public void setUsuarioRolCollection(Collection<UsuarioRol> usuarioRolCollection) {
        this.usuarioRolCollection = usuarioRolCollection;
    }

    @XmlTransient
    public Collection<OrdenEntrada> getOrdenEntradaCollection() {
        return ordenEntradaCollection;
    }

    public void setOrdenEntradaCollection(Collection<OrdenEntrada> ordenEntradaCollection) {
        this.ordenEntradaCollection = ordenEntradaCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    public TipoDoc getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDoc tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numDoc != null ? numDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.numDoc == null && other.numDoc != null) || (this.numDoc != null && !this.numDoc.equals(other.numDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Usuario[ numDoc=" + numDoc + " ]";
    }
    
}
