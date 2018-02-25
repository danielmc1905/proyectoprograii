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
import org.invenio.proyectoprograii.orm.Inventario;
import org.springframework.stereotype.Repository;

/**
 *
 * @author maste
 */
@Repository
@Transactional
public class InventarioDAO extends BaseDAO{
    
    public boolean save(Inventario inventario) {
        try {

            Session session = getSession();
            session.save(inventario);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
        }

        return false;
    }

    public boolean delete(Inventario inventario) {
        try {

            Session session = getSession();
            session.delete(inventario);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean update(Inventario inventario) {
        try {

            Session session = getSession();
            session.update(inventario);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
        }

        return false;
    }

    public Inventario getInventarioById(String codigo) {

        Session session = getSession();

        Criteria criteria = session.createCriteria(Inventario.class, "inventario")
                .add(Restrictions.eq("inventario.codigo", codigo));

        return (Inventario) criteria.uniqueResult();
    }

    public List<Inventario> getAllInventoryWithHQL() {

        Session session = getSession();

        List<Inventario> inventarios = session.createQuery("FROM Inventario").list();

        return inventarios;
    }

    public List<Inventario> getAllUsersWithCriteria(Boolean withPhone) {

        Session session = getSession();

        Criteria criteria = session.createCriteria(Inventario.class, "inventario")
                .addOrder(Order.asc("inventario.codigo"));

        return criteria.list();
    }
}
