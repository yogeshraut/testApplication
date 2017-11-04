package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.testConnection;

/**
 * Servlet implementation class GetData
 */
@WebServlet("/GetData")
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("Hi there....");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		out.println("password...."+password);
		out.println("name...."+name);
		
		Cookie cookie=new Cookie("Test","hirhere");
		response.addCookie(cookie);
		
		Cookie cookie2=null;
		Cookie cookies[]=null;
		cookies=request.getCookies();
		
		for (int i = 0; i < cookies.length; i++) {
			cookie2=cookies[i];
			out.println("cookie2.getName()="+cookie2.getName() +"cookie2.getValue()="+cookie2.getValue());
			
			
		}
		testConnection obj=new  testConnection();
		try {
			
			obj.initData();
			obj.updatePrice();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
