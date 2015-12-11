package com.rest.tokenisation;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Row;
import com.google.gson.Gson;
import com.persistance.api.EmployeeObject;
import com.persistance.api.HibernateUtil;
import com.persistance.api.RandomObject;

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
		long startTime = System.currentTimeMillis();
		for(int i=0;i<100000;i++){ 
			data = new BigInteger(130, rand) + "\r\n";
			System.out.println("Token " + i + " ---> " + data);
		}
			    
	    long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);

		System.out.println("Duration for  " + "Tokens" + " => " + duration + " in milliseconds");
		return data;
	}
	
	public static void runmySQL() {
	    try
	    {
	      // create a mysql database connection
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection conn = null;
	    	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott","root", "mysql");
	        Statement stmt = conn.createStatement();

	        String sql;
	        //sql = "SELECT id, first, last, age FROM Employees";
	        sql = " insert into randomtable (randomNumber, frequency) values ("+6751276+", 1)";
	        stmt.executeUpdate(sql);

	 
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	  }	
	
	@GET
	@Path("/tokenisePOCJDBC/{tokeniseStringData}")
	@Produces(MediaType.TEXT_PLAIN)
	public long tokenisePOCJDBC(@PathParam("tokeniseStringData") String tokeniseStringData) {
		SecureRandom rand = new SecureRandom();
		RandomObject eo = null;
		long i, data = 0;
		long d;
		byte bytes[] = new byte[20];
		rand.nextBytes(bytes);
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	Connection conn = null;
		try {
	    	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott","root", "mysql");
		} catch (Exception e) {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		}
        String sql;
        
		for (int j = 0; j < 1000; j++) { 
			for(i=0;i<1000000;i++){ 
				data = rand.nextLong();
				sql = " insert into randomtable (randomNumber, frequency) values ("+data+", 1)";
		        Statement stmt;
				try {
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQ jdbc Inserted jth * ith " + j + " * " + i + " -> " + data );
			}	
		}
		return data;
	}


	@GET
	@Path("/tokenisePOCCassandra/{tokeniseStringData}")
	@Produces(MediaType.TEXT_PLAIN)
	public long tokenisePOCCassandra(@PathParam("tokeniseStringData") String tokeniseStringData) {
		SecureRandom rand = new SecureRandom();
		RandomObject eo = null;
		String errorMessages = null;
		com.datastax.driver.core.Session session = setupCassandraSession();
		long i, data = 0;
		long d;
		byte bytes[] = new byte[20];
		rand.nextBytes(bytes);
		for (int j = 0; j < 1000; j++) { //10,000,000 10 million
			//session.beginTransaction();
			for(i=0;i<1000000;i++){ //86576576
				data = rand.nextLong();
				String cqlStatement = "insert into tokentab(randomnumber, frequency) values( " + data + "," + 1+ ")";
				try {
					session.execute(cqlStatement);
					System.out.println("-----------------------Inserted jth * ith " + j + " * " + i + " -> " + data );
				} catch (Exception e) {
				    errorMessages += e.getMessage(); 
				}
			}	
		}
		return data;		
	}
	
	//create table tokentable_integer (randomNumber bigint primary key, isUsed boolean, dateCreated timestamp, tokenId uuid);
	@GET
	@Path("/tokeniseCassandraInt/{tokeniseStringData}")
	@Produces(MediaType.TEXT_PLAIN)
	public long tokeniseCassandraInt(@PathParam("tokeniseStringData") String tokeniseStringData) {
		SecureRandom rand = new SecureRandom();
		RandomObject eo = null;
		String errorMessages = null;
		long lLimit = 9220000000000000000L;
		long uLimit = Long.MAX_VALUE;
		
		com.datastax.driver.core.Session session = setupCassandraSession();
		long i, data = 0;
		long d;
		byte bytes[] = new byte[20];
		rand.nextBytes(bytes);
		long num = 0;
		boolean bool = false;
		for (int j = 0; j < 10000000; j++) { //10,000,000 10 million
			for(i=0;i<10000000;i++){ //86576576
				data = rand.nextLong();
				if ( lLimit < data && (data < uLimit)) {
					String cqlStatement = "insert into tokenbank(randomnumber, frequency) values( " + data + "," + 1+ ")";
					try {
						session.execute(cqlStatement);
						num++;
						System.out.println("-----------------------Inserted jth * ith " + j + " * " + i + " -> " + " index " + num + data );
					} catch (Exception e) {
					    errorMessages += e.getMessage(); 
					}
					
				}
			}	
		}
		return data;		
	}

	private com.datastax.driver.core.Session setupCassandraSession() {
		String serverIp = "localhost";
	    String keyspace = "hr";
	    

	    Cluster cluster = Cluster.builder().addContactPoints(serverIp).build();
	    Metadata metadata = cluster.getMetadata();
	    System.out.printf("Connected to cluster: %s\n", metadata.getClusterName());

	    for ( Host host : metadata.getAllHosts() ) {
	        System.out.printf("Datacenter: %s; Host: %s; Rack: %s\n",
	           host.getDatacenter(), host.getAddress(), host.getRack());
	     }
	    
	    com.datastax.driver.core.Session session = cluster.connect(keyspace);		
	    return session;
	}

	@GET
	@Path("/tokenisePOC/{tokeniseStringData}")
	@Produces(MediaType.TEXT_PLAIN)
	public long tokenisePOC(@PathParam("tokeniseStringData") String tokeniseStringData) {
		SecureRandom rand = new SecureRandom();
		RandomObject eo = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		long i, data = 0;
		long d;
		byte bytes[] = new byte[20];
		rand.nextBytes(bytes);
		for (int j = 0; j < 100; j++) { //10,000,000 10 million
			session.beginTransaction();
			for(i=0;i<100000;i++){ //86576576
				data = rand.nextLong();
				RandomObject e = new RandomObject();
				e.setRandomNumber(data);
				e.setFrequency(1);
				session.save(e);
				System.out.println("Inserted jth * ith " + j + " * " + i + " -> " + data );
				
				/*Query query = session.createQuery("from randomtable eo where eo.randomNumber =:rand").setString("rand",
						new Long(data).toString());
				List result = query.list();
				Iterator it = result.iterator();
				if (it.hasNext()) {
					//There is an existing record, retrieve it and increment the frequency.
					eo = (RandomObject) it.next();
					if(null != eo){
						int freq = eo.getFrequency();
						freq++;
						RandomObject e = new RandomObject();
						e.setRandomNumber(data);
						e.setFrequency(freq);
						session.save(e);
					} else {
						System.out.println("Query returned NULL");
					}
				} else {
					RandomObject e = new RandomObject();
					e.setRandomNumber(data);
					e.setFrequency(1);
					session.save(e);
				}
				
				*/
			}	
			session.getTransaction().commit();
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
		long startTime = System.currentTimeMillis();
		String data = new String();
		
		for(int i=0;i<100000;i++){
			sb = new StringBuilder();
			for (int x = 0; x<20; x++) {
				char c = chars[rand.nextInt(chars.length)];
				sb.append(c);
			}
			output = sb.toString();
			System.out.println("String token " + i + " ---> " + output);
		}
		
	    long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println("Time elapsed for String Buld Tokenise: " + duration);
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

