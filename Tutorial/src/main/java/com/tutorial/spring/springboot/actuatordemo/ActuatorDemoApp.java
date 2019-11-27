package com.tutorial.spring.springboot.actuatordemo;

/**
 * 
        <!-- Spring boot actuator - exposing metrics of spring boot -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>

        used for checking appication health

        url : localhost:8080/actuator/health 

        possible endpoints 
        {
            /health
            /info
            {
                update application info by updating the application.property file 
                
                info.app.name=MySuperCoolApp
                info.app.description=Acrazyandfunapp,yoohoo!
                info.app.version=1.0.0
            }
            /auditevents
            {
                Audit events for your application


            }
            /beansList of all beans registered in the Spring application contex
            {

            }
            /mappingsList of all @RequestMapping paths

            full list at - www.luv2code.com/actuator-endpoints
        }

        by-Default only health and info is exposed. 
        for exposing all endpoints 
        update application.property file 
        # Use wildcard "*" to expose all endpoints
        # Can also expose individual endpoints with a comma-delimited list 
        management.endpoints.web.exposure.include=*
 * @author Ankit.Dixit
 *
 */

public class ActuatorDemoApp {
	
}


