/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.invenio.proyectoprograii.ui;

import org.invenio.proyectoprograii.service.OrganizacionService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author maste
 */
@SpringBootApplication
@ComponentScan("org.invenio.proyectoprograii")
public class Init {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        final ConfigurableApplicationContext context = new SpringApplicationBuilder(Init.class).headless(false).run(args);
        
        OrganizacionService organizacionService = context.getBean(OrganizacionService.class);
        
        if(organizacionService.getOrganizaciones().isEmpty()){
            FrmPrueba frmPrueba = new FrmPrueba();
            frmPrueba.setVisible(true);
        } else {
            FrmEscritorio frmEscritorio = new FrmEscritorio(context);
            frmEscritorio.setVisible(true);
        }
    }
    
}
