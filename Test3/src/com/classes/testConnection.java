package com.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class testConnection {

    // ...
	Context initContext ;
	Context envContext ;
	DataSource ds ;
	Connection con ;
	public void initData()
	{
    try {
    
   
    
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	}

    public void updatePrice()
        throws SQLException{
    	System.out.println("-----------------------------------------------");
        
        PreparedStatement pstmt;
        try {
        int i=0;
        	initContext = new InitialContext();
        	System.out.println("-----------------------------------------------"+i++);
        	envContext = (Context) initContext.lookup("java:comp/env");
        	System.out.println("-----------------------------------------------"+i++);
            ds = (DataSource) envContext.lookup("New Derby");
            System.out.println("-----------------------------------------------"+i++);
            con = ds.getConnection();
            System.out.println("-----------------------------------------------"+i++);
            con.setAutoCommit(false);
            System.out.println("-----------------------------------------------"+i++);
            pstmt = con.prepareStatement("update app.persons set city ='miraroad' where firstname =?");
            System.out.println("-----------------------------------------------"+i++);
            pstmt.setString(1, "raut");
            System.out.println("-----------------------------------------------"+i++);
            
            pstmt.executeUpdate();
            System.out.println("-----------------------------------------------"+i++);

            con.commit();
            System.out.println("-----------------------------------------------"+i++);
            pstmt.close();
            System.out.println("-----------------------------------------------"+i++);
        } catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if (con != null) con.close();
        }
    }

    //private DataSource ds = null;
    //private Context ctx = null;
}