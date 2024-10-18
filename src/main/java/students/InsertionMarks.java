package students;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertdata")
public class InsertionMarks extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int rollno = Integer.parseInt(req.getParameter("rollno"));
		String name = req.getParameter("name");
		int tel = Integer.parseInt(req.getParameter("tel"));
		int hin = Integer.parseInt(req.getParameter("hin"));
		int eng = Integer.parseInt(req.getParameter("eng"));
		int math = Integer.parseInt(req.getParameter("math"));
		int sci = Integer.parseInt(req.getParameter("sci"));
		int soc = Integer.parseInt(req.getParameter("soci"));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmarks", "root", "root");
			String sql = "insert into marks values(" + rollno + ",'" + name + "'," + tel + "," + hin + "," + eng + ","
					+ math + "," + sci + "," + soc + ")";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();

			PrintWriter pw = resp.getWriter();
			pw.write(
					"<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; display: flex; justify-content: center; align-items: center; height: 100vh;\">\r\n"
							+ "\r\n" + "<form id=\"form-1\" action=\"inserted\">\r\n"
							+ "<div class=\"message-container\">\r\n"
							+ "   <h1 style=\"color: #009879; font-size: 24px; margin-bottom: 20px;\">\r\n"
							+ "    Success!\r\n" + "</h1>\r\n" + "\r\n"
							+ "    <p style=\"font-size: 16px; color: #333; margin-bottom: 20px;\">Record Has Been Inserted</p>\r\n"
							+ "   <a href=\"index.jsp\" \r\n"
							+ "   style=\"display: inline-block; padding: 10px 20px; background-color: #009879; color: white; text-decoration: none; border-radius: 5px; transition: background-color 0.3s ease;\">\r\n"
							+ "   Go Back to Home\r\n" + "</a>\r\n" + "\r\n" + "</div>\r\n" + "\r\n" + "</form>\r\n"
							+ "</body>");
			con.close();
			ps.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
