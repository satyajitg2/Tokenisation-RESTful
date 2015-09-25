package com.rest.tokenisation;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Path("/tokenservice")
public class TokenService {

	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_PLAIN)
	public String initialise() {
		return "Token Service Initialising!";
	}

	@GET
	@Path("/tokeniseString/{tokeniseStringData}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getEmployee(@PathParam("tokeniseStringData") String tokeniseStringData) {
		
		String data = new String();
		SecureRandom rand = new SecureRandom();
		byte bytes[] = new byte[20];
		rand.nextBytes(bytes);
		data = new BigInteger(130, rand).toString();
		return data;
	}

	@GET
	@Path("/tokeniseBulk/{tokeniseStringData}")
	@Produces(MediaType.TEXT_PLAIN)
	public String tokeniseBulk(@PathParam("tokeniseStringData") String tokeniseStringData) {
		String data = new String();
		SecureRandom rand = new SecureRandom();
		byte bytes[] = new byte[20];
		rand.nextBytes(bytes);
	    for(int i=0;i<100;i++){ 
			data += new BigInteger(130, rand) + "\r\n";
		}
		return data;
	}
	
	@GET
	@Path("/tokeniseAlpha")
	@Produces(MediaType.TEXT_PLAIN)	
	public String tokeniseAlpha() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		String output = new String();
		SecureRandom rand = new SecureRandom();
		for(int i=0;i<1000;i++){
			sb = new StringBuilder();
			for (int x = 0; x<20; x++) {
				char c = chars[rand.nextInt(chars.length)];
				sb.append(c);
			}
			output = sb.toString();
		}
		return output;
	}
	
	@POST
	@Path("/employee")
	@Consumes(MediaType.TEXT_PLAIN)
	public String createEmployee(String str) {
		//Set POST request, no Content Type, Set Body as String
		System.out.println("createEmployee : " + str);
		return "Done";

	}
	
	@POST
	@Path("/jsonSend")
	@Consumes(MediaType.APPLICATION_JSON)
	public String jsonSend(String str) {
		//POST http://localhost:8080/Tokenisation/webapi/tokenservice/jsonSend
		//Content JSON
		//Body JSON
		System.out.println("jsonSend : " + str);
		return "Done";

	}
	
	@POST
	@Path("/jsonSendObjectReceiver")
	@Consumes(MediaType.APPLICATION_JSON)
	public String jsonSendObjectReceiver(Token str) {
		//POST http://localhost:8080/Tokenisation/webapi/tokenservice/jsonSendObjectReceiver
		//Content JSON
		//Body JSON
		System.out.println("jsonSendObjectReceiver : " + str);
		return "Done";

	}

}

