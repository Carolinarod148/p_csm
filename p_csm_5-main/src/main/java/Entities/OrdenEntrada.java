/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mateo
 */
@Entity
@Table(name = "orden_entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenEntrada.findAll", query = "SELECT o FROM OrdenEntrada o"),
    @NamedQuery(name = "OrdenEntrada.findByNumOrdEnt", query = "SELECT o FROM OrdenEntrada o WHERE o.numOrdEnt = :numOrdEnt"),
    @NamedQuery(name = "OrdenEntrada.findByNumFactura", query = "SELECT o FROM OrdenEntrada o WHERE o.numFactura = :numFactura"),
    @NamedQuery(name = "OrdenEntrada.findByFecFtura", query = "SELECT o FROM OrdenEntrada o WHERE o.fecFtura = :fecFtura")})
public class OrdenEntrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_ord_ent")
    private Integer numOrdEnt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "num_factura")
    private String numFactura;
    @Column(name = "fec_ftura")
    @Temporal(TemporalType.DATE)
    private Date fecFtura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numOrdent", fetch = FetchType.LAZY)
    private Collection<DetalleEntrada> detalleEntradaCollection;
    @JoinColumn(name = "ndoc_proveedor", referencedColumnName = "num_doc")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario ndocProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numOrdenCartera", fetch = FetchType.LAZY)
    private Collection<Cartera> carteraCollection;

    public OrdenEntrada() {
    }

    public OrdenEntrada(Integer numOrdEnt) {
        this.numOrdEnt = numOrdEnt;
    }

    public OrdenEntrada(Integer numOrdEnt, String numFactura) {
        this.numOrdEnt = numOrdEnt;
        this.numFactura = numFactura;
    }

    public Integer getNumOrdEnt() {
        return numOrdEnt;
    }

    public void setNumOrdEnt(Integer numOrdEnt) {
        this.numOrdEnt = numOrdEnt;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public Date getFecFtura() {
        return fecFtura;
    }

    public void setFecFtura(Date fecFtura) {
        this.fecFtura = fecFtura;
    }

    @XmlTransient
    public Collection<DetalleEntrada> getDetalleEntradaCollection() {
        return detalleEntradaCollection;
    }

    public void setDetalleEntradaCollection(Collection<DetalleEntrada> detalleEntradaCollection) {
        this.detalleEntradaCollection = detalleEntradaCollection;
    }

    public Usuario getNdocProveedor() {
        return ndocProveedor;
    }

    public void setNdocProveedor(Usuario ndocProveedor) {
        this.ndocProveedor = ndocProveedor;
    }

    @XmlTransient
    public Collection<Cartera> getCarteraCollection() {
        return carteraCollection;
    }

    public void setCarteraCollection(Collection<Cartera> carteraCollection) {
        this.carteraCollection = carteraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numOrdEnt != null ? numOrdEnt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenEntrada)) {
            return false;
        }
        OrdenEntrada other = (OrdenEntrada) object;
        if ((this.numOrdEnt == null && other.numOrdEnt != null) || (this.numOrdEnt != null && !this.numOrdEnt.equals(other.numOrdEnt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.OrdenEntrada[ numOrdEnt=" + numOrdEnt + " ]";
    }
    
}
