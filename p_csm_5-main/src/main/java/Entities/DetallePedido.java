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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mateo
 */
@Entity
@Table(name = "detalle_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePedido.findAll", query = "SELECT d FROM DetallePedido d"),
    @NamedQuery(name = "DetallePedido.findByCodDetPed", query = "SELECT d FROM DetallePedido d WHERE d.codDetPed = :codDetPed"),
    @NamedQuery(name = "DetallePedido.findByCantidad", query = "SELECT d FROM DetallePedido d WHERE d.cantidad = :cantidad")})
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_det_ped")
    private Integer codDetPed;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "num_pedido", referencedColumnName = "num_pedido")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido numPedido;
    @JoinColumn(name = "cod_prod", referencedColumnName = "cod_prod")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto codProd;

    public DetallePedido() {
    }

    public DetallePedido(Integer codDetPed) {
        this.codDetPed = codDetPed;
    }

    public Integer getCodDetPed() {
        return codDetPed;
    }

    public void setCodDetPed(Integer codDetPed) {
        this.codDetPed = codDetPed;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Pedido numPedido) {
        this.numPedido = numPedido;
    }

    public Producto getCodProd() {
        return codProd;
    }

    public void setCodProd(Producto codProd) {
        this.codProd = codProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDetPed != null ? codDetPed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedido)) {
            return false;
        }
        DetallePedido other = (DetallePedido) object;
        if ((this.codDetPed == null && other.codDetPed != null) || (this.codDetPed != null && !this.codDetPed.equals(other.codDetPed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.DetallePedido[ codDetPed=" + codDetPed + " ]";
    }
    
}
