/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.invenio.proyectoprograii.service;


import org.invenio.proyectoprograii.dao.InventarioDAO;
import org.invenio.proyectoprograii.orm.Inventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author maste
 */
@Service
public class InventarioService {
    
    @Autowired
    private InventarioDAO inventarioDAO;

    public boolean save(Inventario inventario) {

        return inventarioDAO.save(inventario);
    }

    public boolean delete(Inventario inventario) {

        return inventarioDAO.delete(inventario);
    }

    public boolean update(Inventario inventario) {

        return inventarioDAO.update(inventario);
    }

    private String validateInventario(Inventario inventario) {

        if (inventario == null) {
            return "El producto no puede ser nulo";
        }

        if (StringUtils.isEmpty(inventario.getCodigo())) {
            return "Debe digitar un codigo para el producto";
        }

        if (StringUtils.isEmpty(inventario.getDescripcion())) {
            return "Debe digitar una descripcion para el producto";
        }

        if (StringUtils.isEmpty(inventario.getCantidad())) {
            return "Debe digitar la cantidad del producto";
        }

        if (StringUtils.isEmpty(inventario.getPrecioUnitario())) {
            return "Debe digitar el precio unitario";
        }

        return "";
    }
}
