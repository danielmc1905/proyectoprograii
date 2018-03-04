/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.invenio.proyectoprograii.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.invenio.proyectoprograii.orm.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin01
 */
@Repository
@Transactional
public class ClienteDAO extends BaseDAO {
    
    public boolean save(Cliente cliente) {
        try {

            Session session = getSession();
            session.save(cliente);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
        }

        return false;
    }

    public boolean delete(Cliente cliente) {
        try {

            Session session = getSession();
            session.delete(cliente);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean update(Cliente cliente) {
        try {

            Session session = getSession();
            session.update(cliente);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
        }

        return false;
    }

    public Cliente getClienteById(int id) {

        Session session = getSession();

        Criteria criteria = session.createCriteria(Cliente.class, "cliente")
                .add(Restrictions.eq("cliente.id", id));

        return (Cliente) criteria.uniqueResult();
    }

    public List<Cliente> getAllUsersWithHQL() {

        Session session = getSession();

        List<Cliente> clientes = session.createQuery("FROM Cliente").list();

        return clientes;
    }

    public List<Cliente> getAllUsersWithCriteria(Boolean withPhone) {

        Session session = getSession();

        Criteria criteria = session.createCriteria(Cliente.class, "cliente")
                .createAlias("cliente.facturas", "fact", JoinType.LEFT_OUTER_JOIN)
                .addOrder(Order.asc("cliente.id"));

        if (withPhone != null) {

            if (withPhone) {
                criteria.add(Restrictions.isNotNull("cliente.telefono"));
            } else {
                criteria.add(Restrictions.isNull("cliente.telefono"));
            }

        }

        return criteria.list();
    }

    
}
