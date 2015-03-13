package register.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register1
 */
@WebServlet("/Register1")
public class Register1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter(); 
		Connection conn=null;
		response.setContentType("text/html");  
		 final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		 final String DB_URL = "jdbc:mysql://localhost/asha";
         final String USER="root";
         final String PASS="asha";
        
        try {
        	 Class.forName(JDBC_DRIVER);
        	conn = DriverManager.getConnection(DB_URL,USER,PASS);
        	 String sql;
        	 sql="insert into registerutable(Firstname,Middlename,Lastname,Username,Email,Mobile,Address,Password,RePassword)values(?,?,?,?,?,?,?,?,?)";
        	 PreparedStatement  ps = conn.prepareStatement(sql);
        	 String fname=request.getParameter("fname");
        	 String mname=request.getParameter("mname");
        	 String lname=request.getParameter("lname");
        	 String username=request.getParameter("username");
        	 String emailid=request.getParameter("emailid");
        	 String mobno=request.getParameter("mobno");
        	 String address=request.getParameter("address");
        	 String password1=request.getParameter("password1");
        	 String password2=request.getParameter("password2");        	 
			ps.setString(1, fname);
			ps.setString(2, mname);
			ps.setString(3, lname);
			ps.setString(4, username);
			ps.setString(5, emailid);
			ps.setString(6, mobno);
			ps.setString(7, address);
			ps.setString(8, password1);
			ps.setString(9, password2);
		int i=ps.executeUpdate();
			if(i==1){
				System.out.print("user details are inserted through Register1.java class.");
				pw.print("Congratulations!your signup process successful.");
			}
			else{
				System.out.println("user details not inserted in Register1.java class");
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
