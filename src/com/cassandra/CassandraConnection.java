package com.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
public class CassandraConnection {

	public static void main(String[] args) {
		String serverIp = "localhost";
	    String keyspace = "hr";
	    

	    Cluster cluster = Cluster.builder().addContactPoints(serverIp).build();
	    Metadata metadata = cluster.getMetadata();
	    System.out.printf("Connected to cluster: %s\n", metadata.getClusterName());

	    for ( Host host : metadata.getAllHosts() ) {
	        System.out.printf("Datacenter: %s; Host: %s; Rack: %s\n",
	           host.getDatacenter(), host.getAddress(), host.getRack());
	     }
	    
	    Session session = cluster.connect(keyspace);
	    long xLong = Long.MAX_VALUE;
	    long lLimit = 9220000000000000000L;
	    System.out.println("XTRALARGE LONG"+xLong + " min Long " + lLimit + " " + Long.MIN_VALUE + "Sign lLimit " + Long.signum(lLimit) );
	    long startTime = System.currentTimeMillis();
	    System.out.println(" System.currentTimeMillis "+startTime);
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");    
	    Date resultdate = new Date(startTime);
	    System.out.println(sdf.format(resultdate));

	    String cqlStatement = "SELECT * FROM emp";
	    for (Row row : session.execute(cqlStatement)) {
	        System.out.println(row.toString());
	        String cql = "insert into emp (empid, emp_first, emp_last, emp_dept) values ("+7+", '"+ "Satyajit" +"', '"+ "Singh" +"', '"+ "STL" +"');";
	        session.execute(cql);
	    }
	    runmySQL();
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

}
