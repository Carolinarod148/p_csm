/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mateo
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByCodInv", query = "SELECT i FROM Inventario i WHERE i.codInv = :codInv"),
    @NamedQuery(name = "Inventario.findByCantidad", query = "SELECT i FROM Inventario i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "Inventario.findByFecIngreso", query = "SELECT i FROM Inventario i WHERE i.fecIngreso = :fecIngreso"),
    @NamedQuery(name = "Inventario.findByFecSalida", query = "SELECT i FROM Inventario i WHERE i.fecSalida = :fecSalida"),
    @NamedQuery(name = "Inventario.findByEstado", query = "SELECT i FROM Inventario i WHERE i.estado = :estado")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_inv")
    private Integer codInv;
    @Size(max = 45)
    @Column(name = "cantidad")
    private String cantidad;
    @Column(name = "fec_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fecIngreso;
    @Column(name = "fec_salida")
    @Temporal(TemporalType.DATE)
    private Date fecSalida;
    @Column(name = "estado")
    private Short estado;
    @JoinColumn(name = "cod_produc_inv", referencedColumnName = "cod_prod")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto codProducInv;

    public Inventario() {
    }

    public Inventario(Integer codInv) {
        this.codInv = codInv;
    }

    public Integer getCodInv() {
        return codInv;
    }

    public void setCodInv(Integer codInv) {
        this.codInv = codInv;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public Date getFecSalida() {
        return fecSalida;
    }

    public void setFecSalida(Date fecSalida) {
        this.fecSalida = fecSalida;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public Producto getCodProducInv() {
        return codProducInv;
    }

    public void setCodProducInv(Producto codProducInv) {
        this.codProducInv = codProducInv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codInv != null ? codInv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.codInv == null && other.codInv != null) || (this.codInv != null && !this.codInv.equals(other.codInv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Inventario[ codInv=" + codInv + " ]";
    }
    
}
