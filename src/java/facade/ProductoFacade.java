/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Model.Productos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author Chris
 */
@Stateless
public class ProductoFacade implements ProductoLocal{
    @PersistenceContext(unitName = "mingesoPU")
    private EntityManager em;

    @Override
    public void addProducto(Productos producto) {
        em.persist(producto);
    }

    @Override
    public void editProducto(Productos producto) {
        em.merge(producto);
    }

    @Override
    public void deleteProducto(int productoId) {
        em.remove(getProducto(productoId));
    }

    @Override
    public Productos getProducto(int productoId) {
        return em.find(Productos.class, productoId);
    }

    @Override
    public List<Productos> getAllProductos() {
        return em.createNamedQuery("Productos.findAll").getResultList();
    }

    
}
