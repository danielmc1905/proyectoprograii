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
import org.invenio.proyectoprograii.orm.Factura;
import org.springframework.stereotype.Repository;

/**
 *
 * @author maste
 */
@Repository
public class FacturaDAO extends BaseDAO{
    
    public boolean save(Factura factura) {
        try {

            Session session = getSession();
            session.save(factura);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
        }

        return false;
    }

    public boolean delete(Factura factura) {
        try {

            Session session = getSession();
            session.delete(factura);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean update(Factura factura) {
        try {

            Session session = getSession();
            session.update(factura);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
        }

        return false;
    }

    public Factura getFacturaById(String id) {

        Session session = getSession();

        Criteria criteria = session.createCriteria(Factura.class, "factura")
                .add(Restrictions.eq("factura.idFactura", id));

        return (Factura) criteria.uniqueResult();
    }

    public List<Factura> getAllUsersWithHQL() {

        Session session = getSession();

        List<Factura> facturas = session.createQuery("FROM Factura").list();

        return facturas;
    }

    public List<Factura> getAllUsersWithCriteria(Boolean withPhone) {

        Session session = getSession();

        Criteria criteria = session.createCriteria(Factura.class, "factura")
                .addOrder(Order.asc("factura.idFactura"));

        return criteria.list();
    }
}
