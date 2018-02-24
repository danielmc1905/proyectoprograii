/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.invenio.proyectoprograii.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author maste
 */
@Configuration
@EnableTransactionManagement
public class HibernateConfig {
    
    @Bean(name = "dataSource")
    public ComboPooledDataSource dataSource() throws PropertyVetoException {

        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/proyecto");
        ds.setUser("root");
        ds.setPassword("dmc1905");
        
        return ds;
    }

    @Bean
    public SessionFactory sessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        
        builder.scanPackages("org.invenio.proyectoprograii.orm")
                .addProperties(getHibernateProperties());

        return builder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.format_sql", "true");
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return prop;
    }

    @Bean
    public HibernateTransactionManager txManager() throws PropertyVetoException {
        return new HibernateTransactionManager(sessionFactory());
    }
    
}
