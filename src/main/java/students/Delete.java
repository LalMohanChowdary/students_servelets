package students;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletedata")
public class Delete extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int rollno = Integer.parseInt(req.getParameter("rollno"));

		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmarks", "root", "root");

		    String checkSql = "SELECT COUNT(*) FROM marks WHERE rollno = ?";
		    PreparedStatement checkPs = con.prepareStatement(checkSql);
		    checkPs.setInt(1, rollno);
		    ResultSet rs = checkPs.executeQuery();

		    if (rs.next() && rs.getInt(1) > 0) {
		        String sql = "DELETE FROM marks WHERE rollno = ?";
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setInt(1, rollno);
		        ps.execute();
		        
		        PrintWriter pw = resp.getWriter();
		        pw.write(
		            "<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; display: flex; flex-direction: column; justify-content: center; align-items: center; height: 100vh; margin: 0; text-align: center;\">\r\n"
		            + "    <h1 style=\"color: #e74c3c; font-size: 36px; padding: 20px; background-color: #fff; border: 2px solid #e74c3c; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\">\r\n"
		            + "        Record Deleted\r\n"
		            + "    </h1>\r\n"
		            + "    <a href=\"index.jsp\" \r\n"
		            + "       style=\"display: inline-block; padding: 10px 20px; background-color: #009879; color: white; text-decoration: none; border-radius: 5px; transition: background-color 0.3s ease; margin-top: 20px;\">\r\n"
		            + "       Go Back to Home\r\n"
		            + "    </a>\r\n"
		            + "</body>");
		        ps.close();
		    } else {
		        PrintWriter pw = resp.getWriter();
		        pw.write(
		            "<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; display: flex; flex-direction: column; justify-content: center; align-items: center; height: 100vh; margin: 0; text-align: center;\">\r\n"
		            + "    <h1 style=\"color: #e74c3c; font-size: 36px; padding: 20px; background-color: #fff; border: 2px solid #e74c3c; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\">\r\n"
		            + "        Record Not Found\r\n"
		            + "    </h1>\r\n"
		            + "    <a href=\"students.jsp\" \r\n"
		            + "       style=\"display: inline-block; padding: 10px 20px; background-color: #009879; color: white; text-decoration: none; border-radius: 5px; transition: background-color 0.3s ease; margin-top: 20px;\">\r\n"
		            + "       Go Back to Home\r\n"
		            + "    </a>\r\n"
		            + "</body>");
		    }

		    rs.close();
		    checkPs.close();
		    con.close();

		} catch (ClassNotFoundException | SQLException e) {
		    e.printStackTrace();
		}


	}
}
