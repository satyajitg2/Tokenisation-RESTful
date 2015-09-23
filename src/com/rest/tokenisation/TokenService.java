package com.rest.tokenisation;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

	  
}


/*RANDOM NUMBER GENERATOR by VIJAY
 * public class RandomGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Generate Token
		long startTime = System.currentTimeMillis();
		SecureRandom random = new SecureRandom();
		long endTime = System.currentTimeMillis();
		System.out.println("Time to create SecureRandom ="+(endTime-startTime));
		  startTime = System.currentTimeMillis();
		for(int i=0;i<1000000;i++){ 
			System.out.println("secureRandomStr="+new BigInteger(130, random).toString(32));
		}
		  endTime = System.currentTimeMillis();
		System.out.println("Time="+(endTime-startTime));
	}
}

public final class RandomInteger {
  
  public static final void main(String... aArgs){
    log("Generating 10 random integers in range 0..xxxxx.");
    
    //note a single Random object is reused here
    Random randomGenerator = new Random();
    for (int idx = 1; idx <= 10; ++idx){
      int randomInt = randomGenerator.nextInt(100000000);
      log("Generated : " + randomInt);
    }
    
    log("Done.");
  }
  
  private static void log(String aMessage){
    System.out.println(aMessage);
  }
}


public class RandomAlphabets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		long startTime = System.currentTimeMillis();
		Random random = new Random();
		for(int i=0;i<1000;i++){
			sb = new StringBuilder();
			for (int x = 0; x<20; x++) {
				char c = chars[random.nextInt(chars.length)];
				sb.append(c);
			}
			String output = sb.toString();
			System.out.println(output);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time="+(endTime-startTime));
		
	}

}
*
*
*
*/
