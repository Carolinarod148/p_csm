/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controlador;

import Entities.Categoria;
import Entities.Producto;
import Entities.UnidadMedida;
import Facade.CategoriaFacade;
import Facade.ProductoFacade;
import Facade.UnidadMedidaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author mateo
 */
@Named(value = "controlador_inventario")
@SessionScoped
public class controlador_inventario implements Serializable {

    @EJB
    private ProductoFacade productoFacade;
    @EJB
    private UnidadMedidaFacade unidadMedidaFacade;
    @EJB
    private CategoriaFacade categoriaFacade;
    private Producto producto = new Producto();
    private Integer categoriaSelect;
    private Integer unidadMedidaSelect;

    /**
     * Creates a new instance of controlador_inventario
     */
    public controlador_inventario() {
    }

    public List<Categoria> getAllCategoria() {
        return categoriaFacade.findAll();
    }

    public List<UnidadMedida> getAllUnidadMedida() {
        return unidadMedidaFacade.findAll();
    }

    public void save() {
        producto.setCodCategoria(categoriaFacade.find(categoriaSelect));
        producto.setCodUnimed(unidadMedidaFacade.find(unidadMedidaSelect));
        if (producto.getCodProd() != null) {
            productoFacade.edit(producto);
        } else {
            productoFacade.create(producto);
        }
        producto = new Producto();

    }
    public void selectUpdate (Producto producto){
        this.producto = producto;
    }

    public Integer getCategoriaSelect() {
        return categoriaSelect;
    }

    public void setCategoriaSelect(Integer categoriaSelect) {
        this.categoriaSelect = categoriaSelect;
    }

    public Integer getUnidadMedidaSelect() {
        return unidadMedidaSelect;
    }

    public void setUnidadMedidaSelect(Integer unidadMedidaSelect) {
        this.unidadMedidaSelect = unidadMedidaSelect;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public UnidadMedidaFacade getUnidadMedidaFacade() {
        return unidadMedidaFacade;
    }

    public void setUnidadMedidaFacade(UnidadMedidaFacade unidadMedidaFacade) {
        this.unidadMedidaFacade = unidadMedidaFacade;
    }

    public CategoriaFacade getCategoriaFacade() {
        return categoriaFacade;
    }

    public void setCategoriaFacade(CategoriaFacade categoriaFacade) {
        this.categoriaFacade = categoriaFacade;
    }

    public ProductoFacade getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
    }

    public List<Producto> getAll() {
        return productoFacade.findAll();
    }

    public void delete(Producto producto) {
        productoFacade.remove(producto);
    }
}
