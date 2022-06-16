
// Prefix : Path of a Page
// Suffix : Extension of a Page
package com.app.MyWebApp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	 @RequestMapping("home")  // Should have same name as of JSP File i.e "home"
//	 @ResponseBody // If it is Response Body then it outputs return statement in WebApp

//	 public String show(@RequestParam("name") String myName,HttpSession session) { // If in WebPage its name then take that from client side name value and save it as myName
		 
//		 public String show(HttpServletRequest req) {  // Request Object "req" is used to Fetch Data
//		 HttpSession session =  req.getSession(); // Session sends Data recieved from Client in WebPage to JSP File
		 
//		 String myName = req.getParameter("name"); // Fetches from Client in WebPage
		 
//    	 System.out.println("Hello World " + myName); // Will show output in Console or Server
    	 
//    	 session.setAttribute("Name", myName); // Sending Name fetched from Client in WebApp to JSP File
    	 
//    	 return "home"; // If Prefix and Suffix
//    	 return "home.jsp" // If it is Request Mapping then it redirects to JSP File  // If no Prefix and Suffix
	 
	 
//	 public ModelAndView show(@RequestParam("name") String myName) {
	 public ModelAndView show(Alien al) { // Creation of Object for Alien Class
		 
		 ModelAndView mv = new ModelAndView();
		 
		 mv.addObject("obj",al);
		 mv.setViewName("home");
		 
		 return mv;
     }
}
