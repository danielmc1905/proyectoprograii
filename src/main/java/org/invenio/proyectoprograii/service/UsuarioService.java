/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.invenio.proyectoprograii.service;

import java.util.List;
import org.invenio.proyectoprograii.dao.UsuarioDAO;
import org.invenio.proyectoprograii.orm.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author Admin01
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    public boolean save(Usuario usuario) {

        return usuarioDAO.save(usuario);
    }

    public boolean delete(Usuario usuario){
        
        return usuarioDAO.delete(usuario);
    }

    public boolean update(Usuario usuario){
        
        return usuarioDAO.update(usuario);
    }
    
    public List<Usuario> getUsuarios(){
        
        return usuarioDAO.getAllUsuariosWithHQL();
    }

    private String validateUsuario(Usuario usuario) {

        if (usuario == null) {
            return "Usuario es nulo";
        }

        if (StringUtils.isEmpty(usuario.getIdUsuario())) {
            return "Debe digitar un id para el usuario";
        }

        if (StringUtils.isEmpty(usuario.getTipo())) {
            return "Debe digitar un tipo de usuario";
        }

        if (StringUtils.isEmpty(usuario.getDescripcion())) {
            return "Debe digitar una descripcion para el usuario";
        }
        if(StringUtils.isEmpty(usuario.getContrasena())){
            return "Debe digitar una contrasena para el usuario";
        }
        return "";
    }
}
