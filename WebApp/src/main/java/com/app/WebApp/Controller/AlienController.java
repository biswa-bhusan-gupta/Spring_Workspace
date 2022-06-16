// If it is "/" : Path Variable
// If it is "?" : Request Parameter

//<-------------------------------------------------- Jackson ----------------------------------------------------------->
// RequestBody ---> Converts Raw Data (JSON Format / XML File) from Client Side(Postman) to String Data in Server Side to be stored in Database
// ResponseBody ---> Converts String Data from Server Side to JSON Format / XML File in Client Side(Postman)
package com.app.WebApp.Controller;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.WebApp.Interface.AlienRepo;
import com.app.WebApp.Java.Alien;

//@RestController
@Controller
public class AlienController {
	 
	@Autowired
	AlienRepo crud;
	
	@RequestMapping("/")// RequestMapping("/...")  --> Client sends Request to Server
	public String show() {
		return "home.jsp";
	}

	@RequestMapping("/addAlien") // Should be same as Form Action
	public String getAlien(Alien obj) { // Data coming from Client in WebApp will be assigned to Object
		crud.save(obj); // Datas will be saved to Database
		return "home.jsp";
	}
	
	
	// <-------------------------------------------- POST ----------------------------------------------------->
	// In Postman : Client sends Data to Server through '/Alien'
	@PostMapping("/AlienPOST") // GetMapping("/....")--> Client Sends POST Request to Server
	@ResponseBody
//	@RequestMapping(path="/Alien",consumes= {"application/xml"})
	public Alien get(@RequestBody Alien alien) { // Data coming from Client in WebApp will be assigned to Object //RequestBody ---> Converts Raw Data (JSON Format) from Postman to String Data i.e Stored in Database  
		
		Alien obj1 = crud.save(alien); // Datas will be saved to Database
		System.out.println(alien);
		System.out.println("From Client : ID -> " + obj1.getAid() + " Name -> " + obj1.getAname());
		
		return alien;
	}
	
	
//	@RequestMapping("/getAlien") // Should be same as Form Action
//	public ModelAndView showAlien(@RequestParam int aid) { // Data coming from Client in WebApp will be assigned to Object
//		
//		ModelAndView mv = new ModelAndView("showAlien.jsp");
//		
//		Alien obj = crud.findById(aid).orElse(new Alien());
//		System.out.println("From Client : ID -> " + obj.getAid() + " Name -> " + obj.getAname());
//		mv.addObject("Object",obj);
//		
//		System.out.println(crud.findByAname("Yash"));
//	//	System.out.println(crud.findByAnameSorted("Yash"));
//
//		System.out.println(crud.findByAid(101));
//		System.out.println(crud.findByAidGreaterThan(102));
//		System.out.println(crud.findByAidLessThan(104));
//
//		System.out.println("Hello World");
//		
//		return mv;
//	}
	
	//<----------------------------------------------- PUT ---------------------------------------------------------------->
	@PutMapping("/AlienPUT")
	@ResponseBody
	public Alien getUpdate(@RequestBody Alien alien) { 
		
		Alien obj2 = crud.save(alien); 
		System.out.println(alien);
	    System.out.println("From Client : ID -> " + obj2.getAid() + " Name -> " + obj2.getAname());

		return alien;
	}
	
	//<------------------------------------------------ DELETE ------------------------------------------------------------->
	@DeleteMapping("/AlienDEL/{aid}")
	public String del(@PathVariable("aid") int aid) {
		
		crud.deleteById(aid);
		return "Deleted";
		
	}
	
	// <----------------------------------------------- GET ALL ------------------------------------------------------------>
//	@RequestMapping("/Aliens")
//	@RequestMapping(path="/Aliens",produces= {"application/xml"})
	
	@GetMapping("/Aliens") // GetMapping("/....")--> Client Sends GET Request to Server
	@ResponseBody
	public Iterable<Alien> showAliens() { // Return Type will be in JSON Format due to Jackson
//		public String showAliens() {

		System.out.println("Without Conversion to String Type : " + crud.findAll());
		System.out.println("After Conversion to String Type :  " + crud.findAll().toString());
		

		return crud.findAll(); // In String Format
	}
	
	//<------------------------------------------------- GET ID ----------------------------------------------------------->
	
	@RequestMapping("/Aliens/{ash}")
	@ResponseBody
	public Optional<Alien> showAlien(@PathVariable("ash") int aid) {
//		public String showAlien(@PathVariable("aid") int aid) {

//		return crud.findById(aid).toString();
	    
		return crud.findById(aid); // In JSON Format
	}	
	
}
