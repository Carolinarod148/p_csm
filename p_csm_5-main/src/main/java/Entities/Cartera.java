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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mateo
 */
@Entity
@Table(name = "cartera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartera.findAll", query = "SELECT c FROM Cartera c"),
    @NamedQuery(name = "Cartera.findByCodCartera", query = "SELECT c FROM Cartera c WHERE c.codCartera = :codCartera"),
    @NamedQuery(name = "Cartera.findByFecIni", query = "SELECT c FROM Cartera c WHERE c.fecIni = :fecIni"),
    @NamedQuery(name = "Cartera.findByFecFin", query = "SELECT c FROM Cartera c WHERE c.fecFin = :fecFin"),
    @NamedQuery(name = "Cartera.findByEstadoPago", query = "SELECT c FROM Cartera c WHERE c.estadoPago = :estadoPago")})
public class Cartera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cartera")
    private Integer codCartera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ini")
    @Temporal(TemporalType.DATE)
    private Date fecIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_fin")
    @Temporal(TemporalType.DATE)
    private Date fecFin;
    @Column(name = "estado_pago")
    private Short estadoPago;
    @JoinColumn(name = "num_orden_cartera", referencedColumnName = "num_ord_ent")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrdenEntrada numOrdenCartera;

    public Cartera() {
    }

    public Cartera(Integer codCartera) {
        this.codCartera = codCartera;
    }

    public Cartera(Integer codCartera, Date fecIni, Date fecFin) {
        this.codCartera = codCartera;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
    }

    public Integer getCodCartera() {
        return codCartera;
    }

    public void setCodCartera(Integer codCartera) {
        this.codCartera = codCartera;
    }

    public Date getFecIni() {
        return fecIni;
    }

    public void setFecIni(Date fecIni) {
        this.fecIni = fecIni;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public Short getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(Short estadoPago) {
        this.estadoPago = estadoPago;
    }

    public OrdenEntrada getNumOrdenCartera() {
        return numOrdenCartera;
    }

    public void setNumOrdenCartera(OrdenEntrada numOrdenCartera) {
        this.numOrdenCartera = numOrdenCartera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCartera != null ? codCartera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartera)) {
            return false;
        }
        Cartera other = (Cartera) object;
        if ((this.codCartera == null && other.codCartera != null) || (this.codCartera != null && !this.codCartera.equals(other.codCartera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Cartera[ codCartera=" + codCartera + " ]";
    }
    
}
