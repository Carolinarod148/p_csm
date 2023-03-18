/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mateo
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByNumPedido", query = "SELECT p FROM Pedido p WHERE p.numPedido = :numPedido"),
    @NamedQuery(name = "Pedido.findByFecha", query = "SELECT p FROM Pedido p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Pedido.findByDirEnvio", query = "SELECT p FROM Pedido p WHERE p.dirEnvio = :dirEnvio")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_pedido")
    private Integer numPedido;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "dir_envio")
    private String dirEnvio;
    @OneToMany(mappedBy = "numPedido", fetch = FetchType.LAZY)
    private Collection<DetallePedido> detallePedidoCollection;
    @JoinColumn(name = "cod_est_pedido", referencedColumnName = "cod_estado")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoPedido codEstPedido;
    @JoinColumn(name = "ndoc_client", referencedColumnName = "num_doc")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario ndocClient;

    public Pedido() {
    }

    public Pedido(Integer numPedido) {
        this.numPedido = numPedido;
    }

    public Integer getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Integer numPedido) {
        this.numPedido = numPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDirEnvio() {
        return dirEnvio;
    }

    public void setDirEnvio(String dirEnvio) {
        this.dirEnvio = dirEnvio;
    }

    @XmlTransient
    public Collection<DetallePedido> getDetallePedidoCollection() {
        return detallePedidoCollection;
    }

    public void setDetallePedidoCollection(Collection<DetallePedido> detallePedidoCollection) {
        this.detallePedidoCollection = detallePedidoCollection;
    }

    public EstadoPedido getCodEstPedido() {
        return codEstPedido;
    }

    public void setCodEstPedido(EstadoPedido codEstPedido) {
        this.codEstPedido = codEstPedido;
    }

    public Usuario getNdocClient() {
        return ndocClient;
    }

    public void setNdocClient(Usuario ndocClient) {
        this.ndocClient = ndocClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numPedido != null ? numPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.numPedido == null && other.numPedido != null) || (this.numPedido != null && !this.numPedido.equals(other.numPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Pedido[ numPedido=" + numPedido + " ]";
    }
    
}
