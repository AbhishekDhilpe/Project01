package com.revature.project01;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project01.tools.HibernateUtil;



@Path("controller")
public class Controller {
	
	@GET
	@Path("/hello")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHello() {
		Session session= null;
		session = HibernateUtil.getSessionFactory().openSession();
		ObjectMapper objMapper = new ObjectMapper();
		Employee e1 = new Employee("Abhi","dhilpe","pwd","eml");
		
		try {
			return objMapper.writeValueAsString(e1);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return  e.getMessage();
		}
		
	}
	
	@POST
	@Path("/show")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String PostForm(@FormParam("fname") String fname,@FormParam("lname") String lname, @FormParam("designation") String designation) {
        return "Accept was " + fname + " " + lname+" "+designation ;
    }
}
