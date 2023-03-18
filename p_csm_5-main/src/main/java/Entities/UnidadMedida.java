/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "unidad_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadMedida.findAll", query = "SELECT u FROM UnidadMedida u"),
    @NamedQuery(name = "UnidadMedida.findByCodUnimed", query = "SELECT u FROM UnidadMedida u WHERE u.codUnimed = :codUnimed"),
    @NamedQuery(name = "UnidadMedida.findByNombreUnidadMedida", query = "SELECT u FROM UnidadMedida u WHERE u.nombreUnidadMedida = :nombreUnidadMedida"),
    @NamedQuery(name = "UnidadMedida.findByDescripcion", query = "SELECT u FROM UnidadMedida u WHERE u.descripcion = :descripcion")})
public class UnidadMedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_unimed")
    private Integer codUnimed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_unidad_medida")
    private String nombreUnidadMedida;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "codUnimed", fetch = FetchType.LAZY)
    private Collection<Producto> productoCollection;

    public UnidadMedida() {
    }

    public UnidadMedida(Integer codUnimed) {
        this.codUnimed = codUnimed;
    }

    public UnidadMedida(Integer codUnimed, String nombreUnidadMedida) {
        this.codUnimed = codUnimed;
        this.nombreUnidadMedida = nombreUnidadMedida;
    }

    public Integer getCodUnimed() {
        return codUnimed;
    }

    public void setCodUnimed(Integer codUnimed) {
        this.codUnimed = codUnimed;
    }

    public String getNombreUnidadMedida() {
        return nombreUnidadMedida;
    }

    public void setNombreUnidadMedida(String nombreUnidadMedida) {
        this.nombreUnidadMedida = nombreUnidadMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUnimed != null ? codUnimed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadMedida)) {
            return false;
        }
        UnidadMedida other = (UnidadMedida) object;
        if ((this.codUnimed == null && other.codUnimed != null) || (this.codUnimed != null && !this.codUnimed.equals(other.codUnimed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.UnidadMedida[ codUnimed=" + codUnimed + " ]";
    }
    
}
