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
@Table(name = "detalle_entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleEntrada.findAll", query = "SELECT d FROM DetalleEntrada d"),
    @NamedQuery(name = "DetalleEntrada.findByIdDetEnt", query = "SELECT d FROM DetalleEntrada d WHERE d.idDetEnt = :idDetEnt"),
    @NamedQuery(name = "DetalleEntrada.findByCantidad", query = "SELECT d FROM DetalleEntrada d WHERE d.cantidad = :cantidad")})
public class DetalleEntrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_det_ent")
    private Integer idDetEnt;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "num_ordent", referencedColumnName = "num_ord_ent")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrdenEntrada numOrdent;
    @JoinColumn(name = "cod_prod_entrada", referencedColumnName = "cod_prod")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto codProdEntrada;

    public DetalleEntrada() {
    }

    public DetalleEntrada(Integer idDetEnt) {
        this.idDetEnt = idDetEnt;
    }

    public Integer getIdDetEnt() {
        return idDetEnt;
    }

    public void setIdDetEnt(Integer idDetEnt) {
        this.idDetEnt = idDetEnt;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public OrdenEntrada getNumOrdent() {
        return numOrdent;
    }

    public void setNumOrdent(OrdenEntrada numOrdent) {
        this.numOrdent = numOrdent;
    }

    public Producto getCodProdEntrada() {
        return codProdEntrada;
    }

    public void setCodProdEntrada(Producto codProdEntrada) {
        this.codProdEntrada = codProdEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetEnt != null ? idDetEnt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleEntrada)) {
            return false;
        }
        DetalleEntrada other = (DetalleEntrada) object;
        if ((this.idDetEnt == null && other.idDetEnt != null) || (this.idDetEnt != null && !this.idDetEnt.equals(other.idDetEnt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.DetalleEntrada[ idDetEnt=" + idDetEnt + " ]";
    }
    
}
