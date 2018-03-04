/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.invenio.proyectoprograii.controller;

import java.util.List;
import org.invenio.proyectoprograii.orm.Cliente;
import org.invenio.proyectoprograii.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author maste
 */
@RestController
@RequestMapping("clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping
    public List<Cliente> getAll(){
        return clienteService.getClientes();
    }
    
    @PostMapping()
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        
        clienteService.save(cliente);
        
        return cliente;
    }
    
    @PutMapping("{id}")
    public Cliente updateCliente(@RequestBody Cliente updatedClient, @PathVariable("id") String id) {
        
        return null;
    }
    
    @DeleteMapping("{id}")
    public Cliente deleteCliente(@PathVariable("id") String id) {
        
        return null;
    }
    
    @GetMapping("{id}")
    public Cliente getClienteById(@PathVariable("id") String id) {
        
        return null;
    }
}
