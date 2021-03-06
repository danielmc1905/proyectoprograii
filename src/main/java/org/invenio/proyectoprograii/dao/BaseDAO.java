/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.invenio.proyectoprograii.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin01
 */
@Repository
public abstract class BaseDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession() {
        
        if(sessionFactory.getCurrentSession() == null){
            
            return sessionFactory.openSession();
        }
        
        return sessionFactory.getCurrentSession();
    }
}
