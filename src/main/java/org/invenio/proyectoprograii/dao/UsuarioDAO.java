/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.invenio.proyectoprograii.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.invenio.proyectoprograii.orm.Usuario;

/**
 *
 * @author Admin01
 */
@Repository
@Transactional
public class UsuarioDAO extends BaseDAO {

    public boolean save(Usuario usuario) {

        try {

            Session session = getSession();

            session.save(usuario);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
        }
        return false;

    }

    public Usuario getById(String id) {

        Session session = getSession();

        Criteria criteria = session.createCriteria(Usuario.class, "usuario")
                .add(Restrictions.eq("usuario.idUsuario", id));

        return (Usuario) criteria.uniqueResult();
    }

    public List<Usuario> getAllUsuariosWithHQL() {

        Session session = getSession();

        List<Usuario> usuarios = session.createQuery("FROM Usuario").list();

        return usuarios;
    }

    public List<Usuario> getAllWithCriteria(Boolean withPhone) {

        Session session = getSession();

        Criteria criteria = session.createCriteria(Usuario.class, "usuario")
                .addOrder(Order.asc("usuario.createdTime"));

        if (withPhone != null) {

            if (withPhone) {
                criteria.add(Restrictions.isNotNull("usuario.phone"));
            } else {
                criteria.add(Restrictions.isNull("usuario.phone"));
            }

        }

        return criteria.list();
    }

    public boolean delete(Usuario usuario) {

        try {

            Session session = getSession();
            session.delete(usuario);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean update(Usuario usuario) {

        try {
            
            Session session = getSession();
            session.update(usuario);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
        }
        return false;

    }
}
