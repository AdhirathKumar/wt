import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class Login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/javalab","root","Password@123");
				Statement stmt = con.createStatement();
				String query = "Select * from details where name = '"+ name+"' and password =
'"+ password +"'";
				ResultSet rs = stmt.executeQuery(query);
				if(rs.next()){
					out.print("Welcome to you "+name);
				}else{
					out.print("Sorry Incorrect Entry");
				}} catch (Exception e) {
				out.write("Error in JDBC connectivity : "+e);
				}}
			public static void main(String[] args) {
				System.out.println("Continue to Browser");
			}}
