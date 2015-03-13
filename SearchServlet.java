package register.edu;
    //package com;
    import java.io.*;
//import java.util.*;
    import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/SearchServlet")   
public class SearchServlet extends HttpServlet
    {
    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	//private ServletConfig config;
    public void init(ServletConfig config)
    throws ServletException{
    //this.config=config;
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
    	response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String connectionURL = "jdbc:mysql://localhost/asha";
    Connection connection=null;
    ResultSet rs;
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    response.setContentType("text/html");
    //HttpSession ses=request.getSession(true);
    try {
    // Load the database driver
    Class.forName("com.mysql.jdbc.Driver");
    // Get a Connection to the database
    connection = DriverManager.getConnection(connectionURL, "root", "asha");
    //Add the data into the database
    String sql = "select username,password from registerutable";
    Statement s = connection.createStatement();
    s.executeQuery (sql);
    rs = s.getResultSet();
    while (rs.next ()){
    username=rs.getString("username");
    password=rs.getString("password");
    }
    rs.close ();
    s.close ();
    }catch(Exception e){
    System.out.println("Exception is ;"+e);
    }
    if(username.equals(request.getParameter("username"))
    && password.equals(request.getParameter("password")))
    {
    // ses.setAttribute("MOBILENO",mobileno);
    // ses.setAttribute("PASSWORD",password);
    // mobileno = (String)ses.getAttribute("MOBILENO");
    out.print("<h1>You are Already Registerd </h1>");
    RequestDispatcher rd = request.getRequestDispatcher("mypage.html");
    rd.forward(request, response);
    }
    else
    {
    out.println("<h1>You are not a Valid User Please Register</h1>");
    out.println("<a href='test.html'><br>Register Here!!</a>");
    }}
    public void destroy()
    {
    }
    }
