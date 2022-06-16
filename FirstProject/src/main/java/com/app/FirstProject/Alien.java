package com.app.FirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // Adding as Component makes it as Spring Bean 
//@Scope(value = "prototype") // It creates a Object/Instance for Class whenever getBean() is called
public class Alien {
     private int aide;
     private String aname;
     private String tech;
     @Autowired // i. By calling Autowired it will search for Objects in the Spring Container ii. It searches by type
     @Qualifier("lap") // It searches by name
     private Laptop laptop; // We are creating Object of Laptop as "laptop"
     
	public Alien() {
		super();
		System.out.println("Object is Created"); 
	}
	
	public int getAide() {
		return aide;
	}
	public void setAide(int aide) {
		this.aide = aide;
	}
	
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	
	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	
	public void show() {
		System.out.println("In Alien Class");
		laptop.get();
	}


	
	
	
     
}
