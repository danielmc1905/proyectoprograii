/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.invenio.proyectoprograii.service;

import org.invenio.proyectoprograii.dao.FacturaDAO;
import org.invenio.proyectoprograii.orm.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author maste
 */
@Service
public class FacturaService {

    @Autowired
    private FacturaDAO facturaDAO;

    public boolean save(Factura factura) {

        return facturaDAO.save(factura);
    }

    public boolean delete(Factura factura) {

        return facturaDAO.delete(factura);
    }

    public boolean update(Factura factura) {

        return facturaDAO.update(factura);
    }

    private String validateFactura(Factura factura) {

        if (factura == null) {
            return "Factura es nulo";
        }

        if (StringUtils.isEmpty(factura.getIdFactura())) {
            return "Debe digitar un id para el factura";
        }

        if (StringUtils.isEmpty(factura.getTipoFactura())) {
            return "Debe digitar el tipo de factura";
        }

        if (StringUtils.isEmpty(factura.getCodigoProducto())) {
            return "Debe digitar el codigo de un producto";
        }

        if (StringUtils.isEmpty(factura.getCantidad())) {
            return "Debe digitar la cantidad a comprar";
        }

        return "";
    }
}
