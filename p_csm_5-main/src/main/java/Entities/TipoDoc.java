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
@Table(name = "tipo_doc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDoc.findAll", query = "SELECT t FROM TipoDoc t"),
    @NamedQuery(name = "TipoDoc.findByCodTdoc", query = "SELECT t FROM TipoDoc t WHERE t.codTdoc = :codTdoc"),
    @NamedQuery(name = "TipoDoc.findByTipoDoc", query = "SELECT t FROM TipoDoc t WHERE t.tipoDoc = :tipoDoc")})
public class TipoDoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_tdoc")
    private String codTdoc;
    @Size(max = 20)
    @Column(name = "tipo_doc")
    private String tipoDoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento", fetch = FetchType.LAZY)
    private Collection<Usuario> usuarioCollection;

    public TipoDoc() {
    }

    public TipoDoc(String codTdoc) {
        this.codTdoc = codTdoc;
    }

    public String getCodTdoc() {
        return codTdoc;
    }

    public void setCodTdoc(String codTdoc) {
        this.codTdoc = codTdoc;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTdoc != null ? codTdoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDoc)) {
            return false;
        }
        TipoDoc other = (TipoDoc) object;
        if ((this.codTdoc == null && other.codTdoc != null) || (this.codTdoc != null && !this.codTdoc.equals(other.codTdoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TipoDoc[ codTdoc=" + codTdoc + " ]";
    }
    
}
