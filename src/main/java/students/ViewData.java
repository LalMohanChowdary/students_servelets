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

@WebServlet("/viewdata")
public class ViewData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int roll = Integer.parseInt(req.getParameter("roll"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmarks", "root", "root");
			String sql = "select * from marks where rollno=" + roll;
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
		

			PrintWriter pw = resp.getWriter();

//			pw.write(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + ","
//					+ rs.getString(5) + "," + rs.getString(6) + "," + rs.getString(7) + "," + rs.getString(8));
			pw.write("<html><head><title>Record Details</title></head>");
			pw.write("<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px; display: flex; justify-content: center; align-items: center; height: 100vh;\">");
			pw.write("<div style=\"width: 100%; max-width: 900px; background-color: #fff; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); padding: 20px; border-radius: 8px;\">");
			pw.write("<h1 style=\"color: #333; text-align: center;\">Record Details</h1>");
			pw.write("<table style=\"width: 100%; border-collapse: collapse;\">");
			pw.write("<thead>");
			pw.write("<tr>");
			pw.write("<th style=\"padding: 12px; text-align: left; border-bottom: 2px solid #ddd; background-color: #009879; color: white;\">ID</th>");
			pw.write("<th style=\"padding: 12px; text-align: left; border-bottom: 2px solid #ddd; background-color: #009879; color: white;\">Name</th>");
			pw.write("<th style=\"padding: 12px; text-align: left; border-bottom: 2px solid #ddd; background-color: #009879; color: white;\">Tel</th>");
			pw.write("<th style=\"padding: 12px; text-align: left; border-bottom: 2px solid #ddd; background-color: #009879; color: white;\">Hin</th>");
			pw.write("<th style=\"padding: 12px; text-align: left; border-bottom: 2px solid #ddd; background-color: #009879; color: white;\">Eng</th>");
			pw.write("<th style=\"padding: 12px; text-align: left; border-bottom: 2px solid #ddd; background-color: #009879; color: white;\">Math</th>");
			pw.write("<th style=\"padding: 12px; text-align: left; border-bottom: 2px solid #ddd; background-color: #009879; color: white;\">Sci</th>");
			pw.write("<th style=\"padding: 12px; text-align: left; border-bottom: 2px solid #ddd; background-color: #009879; color: white;\">Soc</th>");
			pw.write("</tr>");
			pw.write("</thead>");
			pw.write("<tbody>");

			while (rs.next()) {
			    pw.write("<tr>");
			    for (int i = 1; i <= 8; i++) {
			        pw.write("<td style=\"padding: 12px; text-align: left; border-bottom: 1px solid #ddd;\">" + rs.getString(i) + "</td>");
			    }
			    pw.write("</tr>");
			}

			pw.write("</tbody>");
			pw.write("</table>");
			pw.write("<a href=\"index.jsp\" style=\"display: inline-block; padding: 10px 20px; background-color: #009879; color: white; text-decoration: none; border-radius: 5px; transition: background-color 0.3s ease; margin-top: 20px;\">Go Back to Home</a>");
			pw.write("</div>");
			pw.write("</body></html>");

			
			con.close();
			ps.close();
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
