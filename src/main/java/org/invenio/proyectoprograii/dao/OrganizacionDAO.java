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
import org.invenio.proyectoprograii.orm.Organizacion;
import org.springframework.stereotype.Repository;

/**
 *
 * @author maste
 */
@Repository
@Transactional
public class OrganizacionDAO extends BaseDAO{
    
    public boolean save(Organizacion organizacion) {
        try {

            Session session = getSession();
            session.save(organizacion);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
        }

        return false;
    }

    public boolean delete(Organizacion organizacion) {
        try {

            Session session = getSession();
            session.delete(organizacion);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean update(Organizacion organizacion) {
        try {

            Session session = getSession();
            session.update(organizacion);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
        }

        return false;
    }

    public Organizacion getOrganizacionById() {

        Session session = getSession();

        Criteria criteria = session.createCriteria(Organizacion.class, "organizacion");

        return (Organizacion) criteria.uniqueResult();
    }
    

    public List<Organizacion> getAllWithHQL() {

        Session session = getSession();

        List<Organizacion> organizacions = session.createQuery("FROM Organizacion").list();

        return organizacions;
    }

    public List<Organizacion> getAllUsersWithCriteria(Boolean withPhone) {

        Session session = getSession();

        Criteria criteria = session.createCriteria(Organizacion.class, "organizacion")
                .addOrder(Order.asc("organizacion.idOrganizacion"));

        if (withPhone != null) {

            if (withPhone) {
                criteria.add(Restrictions.isNotNull("organizacion.telefono"));
            } else {
                criteria.add(Restrictions.isNull("organizacion.telefono"));
            }

        }

        return criteria.list();
    }
}
