package com.rest.tokenisation;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Query;
import org.hibernate.Session;

import com.persistance.api.EmployeeObject;
import com.persistance.api.HibernateUtil;


@Path("/empservice")
public class EmployeeService {
	
	  @GET
	  @Path("/get")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainTextHello() {
	    return "Hello Satyajit. This is your first RESTful GET request. Have fun!";
	  }	

	@GET
	@Path("/emp/{employeeid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("employeeid") int employeeId) {
		String emp = null;
		Employee employee = null;
		EmployeeObject eo = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createQuery("from EmployeeObject eo where eo.employeeId =:EMPLOYEEID").setString("EMPLOYEEID",
				new Integer(employeeId).toString());

		List result = query.list();
		Iterator it = result.iterator();
		while (it.hasNext()) {
			eo = (EmployeeObject) it.next();

			if(null != eo){
				employee = new Employee();
				employee.setEmployeeId(eo.getEmployeeId());
				employee.setEmailId(eo.getEmailId());
				employee.setEmployeeName(eo.getEmployeeName());
				employee.setManagerId(eo.getManagerId());
			}
			emp = "EMPLOYEE EMPLOYEEID :" + employee.getEmployeeId() + " , EMPLOYEE EMPLOYEENAME  :" + employee.getEmployeeName() + ", EMPLOYEE EMAILID : "
					+ employee.getEmailId() + " , EMPLOYEE MANAGERID  :" + employee.getManagerId();
			System.out.println("Employee - " + emp);
		}
		session.close();
		
		return employee;
	}

	@POST
	@Path("/employee")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createEmployee(Employee eo) {
		EmployeeObject employee = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		employee = new EmployeeObject();
		employee.setEmployeeId(eo.getEmployeeId());
		employee.setEmailId(eo.getEmailId());
		employee.setEmployeeName(eo.getEmployeeName());
		employee.setManagerId(eo.getManagerId());
		session.save(employee);
		session.getTransaction().commit();
		return Response.status(201).entity(employee).build();

	}
	
	@GET
	@Path("/getEmployeeXML/{employeeid}")
	@Produces(MediaType.APPLICATION_XML)
	public Employee getEmployeeXML(@PathParam("employeeid") int employeeId) {
		String emp = null;
		Employee employee = new Employee();
		EmployeeObject eo = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createQuery("from EmployeeObject eo where eo.employeeId =:EMPLOYEEID").setString("EMPLOYEEID",
				new Integer(employeeId).toString());

		List result = query.list();
		Iterator it = result.iterator();
		while (it.hasNext()) {
			eo = (EmployeeObject) it.next();

			if(null != eo){
				employee.setEmployeeId(eo.getEmployeeId());
				employee.setEmailId(eo.getEmailId());
				employee.setEmployeeName(eo.getEmployeeName());
				employee.setManagerId(eo.getManagerId());
				emp = "EMPLOYEE EMPLOYEEID :" + eo.getEmployeeId() + " , EMPLOYEE EMPLOYEENAME  :" + eo.getEmployeeName() + ", EMPLOYEE EMAILID : "
						+ eo.getEmailId() + " , EMPLOYEE MANAGERID  :" + eo.getManagerId();
				System.out.println("Employee - " + emp);
				
			} else {
				System.out.println("Query returned NULL");
			}
		}
		session.close();
		return employee;
	}

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Employee createUser(Employee emp) {
		//TODO: Create Logic goes here
		return emp;
		
	}	
	
	@GET
	@Path("/hello")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createEmployee() {

		String result = "Hi ";
		return Response.status(201).entity(result).build();

	}
}
