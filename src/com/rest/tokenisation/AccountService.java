package com.rest.tokenisation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Path("/acct")
public class AccountService {
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public String save(Account acct) {
		System.out.println("acct/save" + acct);
/*		Gson gson = new Gson(); 
		final Employee user = gson.fromJson(acct, Employee.class);
		System.out.println(user);
*/		return "AccountService Done";
	}
}
