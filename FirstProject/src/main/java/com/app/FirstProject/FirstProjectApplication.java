// There can be Different Spring Beans in a Spring Container

package com.app.FirstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context =  SpringApplication.run(FirstProjectApplication.class, args);
		
		System.out.println("In Spring Boot");
		
		Alien a1 = context.getBean(Alien.class); // In Spring Alien.Class Creates an Object of Alien Class which is available in Spring Container as Spring Bean
	    a1.show();
	    
//	    Alien a2 = context.getBean(Alien.class);
//	    a2.show();
	}

}
