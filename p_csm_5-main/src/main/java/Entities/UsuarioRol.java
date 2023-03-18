/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mateo
 */
@Entity
@Table(name = "usuario_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRol.findAll", query = "SELECT u FROM UsuarioRol u"),
    @NamedQuery(name = "UsuarioRol.findByCodUtr", query = "SELECT u FROM UsuarioRol u WHERE u.codUtr = :codUtr")})
public class UsuarioRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_utr")
    private Integer codUtr;
    @JoinColumn(name = "cod_rol", referencedColumnName = "cod_rol")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rol codRol;
    @JoinColumn(name = "ndoc_usu", referencedColumnName = "num_doc")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario ndocUsu;

    public UsuarioRol() {
    }

    public UsuarioRol(Integer codUtr) {
        this.codUtr = codUtr;
    }

    public Integer getCodUtr() {
        return codUtr;
    }

    public void setCodUtr(Integer codUtr) {
        this.codUtr = codUtr;
    }

    public Rol getCodRol() {
        return codRol;
    }

    public void setCodRol(Rol codRol) {
        this.codRol = codRol;
    }

    public Usuario getNdocUsu() {
        return ndocUsu;
    }

    public void setNdocUsu(Usuario ndocUsu) {
        this.ndocUsu = ndocUsu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUtr != null ? codUtr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRol)) {
            return false;
        }
        UsuarioRol other = (UsuarioRol) object;
        if ((this.codUtr == null && other.codUtr != null) || (this.codUtr != null && !this.codUtr.equals(other.codUtr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.UsuarioRol[ codUtr=" + codUtr + " ]";
    }
    
}
