/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.invenio.proyectoprograii.service;

import java.util.List;
import org.invenio.proyectoprograii.dao.OrganizacionDAO;
import org.invenio.proyectoprograii.orm.Organizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author maste
 */
@Service
public class OrganizacionService {

    @Autowired
    private OrganizacionDAO organizacionDAO;

    public boolean save(Organizacion organizacion) {

        return organizacionDAO.save(organizacion);
    }

    public boolean delete(Organizacion organizacion) {

        return organizacionDAO.delete(organizacion);
    }

    public boolean update(Organizacion organizacion) {

        return organizacionDAO.update(organizacion);
    }
    
    public Organizacion getOrganizacion(String id){
        
        return organizacionDAO.getOrganizacionById(id);
    }
    
    public List<Organizacion> getOrganizaciones(){
        
        return organizacionDAO.getAllWithHQL();
    }

    private String validateOrganizacion(Organizacion organizacion) {

        if (organizacion == null) {
            return "La organizacion no puede ser nula";
        }

        if (StringUtils.isEmpty(organizacion.getIdCliente())) {
            return "Debe digitar un id para la organizacion";
        }

        if (StringUtils.isEmpty(organizacion.getNombre())) {
            return "Debe digitar un nombre para la organizacion";
        }

        if (StringUtils.isEmpty(organizacion.getDireccion())) {
            return "Debe digitar la direccion de la organizacion";
        }

        if (StringUtils.isEmpty(organizacion.getCorreo())) {
            return "Debe digitar el correo de la organizacion";
        }
        
        if (StringUtils.isEmpty(organizacion.getTelefono())) {
            return "Debe digitar el telefono de la organizacion";
        }

        return "";
    }
}
