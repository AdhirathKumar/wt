<html>
	<body>
		<%@ page import = "java.sql.*" %>
		<%
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/javalab","root","Password@123");
				Statement stmt = con.createStatement();
				String query = "Select * from details where name = '"+ name+"' and
password = '"+ password +"'";
				ResultSet rs = stmt.executeQuery(query);
				if(rs.next()) {
					out.print("Login Successful !!! Welcome to you - "+name);
				} else {
					out.print("!!!Enter Valid User Details!!!");
				}
			} catch (Exception e) {
				out.write("Error in JDBC connectivity"+e);
			}
		%>
	</body>
</html>
