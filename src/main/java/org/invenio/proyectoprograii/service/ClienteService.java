/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.invenio.proyectoprograii.service;

import java.util.List;
import org.invenio.proyectoprograii.dao.ClienteDAO;
import org.invenio.proyectoprograii.orm.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author Admin01
 */
@Service
public class ClienteService {
    
    @Autowired
    private ClienteDAO clienteDAO;
    
    public boolean save(Cliente cliente) {

        return clienteDAO.save(cliente);
    }
    
    public boolean delete(Cliente cliente){
        
        return clienteDAO.delete(cliente);
    }
    
    public boolean update(Cliente cliente){
        
        return clienteDAO.update(cliente);
    }
    
    public List<Cliente> getClientes(){
        
        return clienteDAO.getAllUsersWithCriteria(Boolean.TRUE);
    }
    
    public Cliente getCliente(int id){
        
        return clienteDAO.getClienteById(id);
    }

    private String validateCliente(Cliente cliente) {

        if (cliente == null) {
            return "Cliente es nulo";
        }

        if (StringUtils.isEmpty(cliente.getId())) {
            return "Debe digitar un id para el cliente";
        }

        if (StringUtils.isEmpty(cliente.getNombre())) {
            return "Debe digitar un nombre para el cliente";
        }

        if (StringUtils.isEmpty(cliente.getApellido1())) {
            return "Debe digitar el primer apellido del cliente";
        }
        
        if (StringUtils.isEmpty(cliente.getApellido2())) {
            return "Debe digitar el segundo apellido del cliente";
        }
        if(StringUtils.isEmpty(cliente.getCorreo())){
            return "Debe digitar un correo para el cliente";            
        }
        if(StringUtils.isEmpty(cliente.getTelefono())){
            return "Debe digitar el telefono del cliente";
        }
        if (StringUtils.isEmpty(cliente.getDireccion())) {
            return "Debe digitar la direccion del cliente";
        }
        
        return "";
    }
}
