package students;

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

@WebServlet("/updatedata")
public class Update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int roll=Integer.parseInt(req.getParameter("rollno"));
		String name = req.getParameter("name");
		int tel = Integer.parseInt(req.getParameter("tel"));
		int hin = Integer.parseInt(req.getParameter("hin"));
		int eng = Integer.parseInt(req.getParameter("eng"));
		int math = Integer.parseInt(req.getParameter("math"));
		int sci = Integer.parseInt(req.getParameter("sci"));
		int soc = Integer.parseInt(req.getParameter("soci"));

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmarks","root","root");
			String sql="update  marks set name=?,telugu=?,hindi=?,english=?,math=?,science=?,social=? where rollno="+roll;
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, tel);
			ps.setInt(3, hin);
			ps.setInt(4, eng);
			ps.setInt(5, math);
			ps.setInt(6, sci);
			ps.setInt(7, soc);
		
			int rs = ps.executeUpdate();
			
			PrintWriter pw=resp.getWriter();
			
			
			 pw.write(
			            "<head><body><div style='display: flex; flex-direction: column; justify-content: center; align-items: center; height: 100vh; gap: 20px;'>" +
			                "<span style='color: #4a90e2; font-weight: bold; font-size: 24px; padding: 10px 20px; " +
			                "background-color: #ffffff; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); " +
			                "text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);'>" +
			                rs + " Row Updated</span>" +
			                "<a href='index.jsp' style='display: inline-block; padding: 10px 20px; background-color: #009879; color: white; " +
			                "text-decoration: none; border-radius: 5px; transition: background-color 0.3s ease;'>Go Back to Home</a>" +
			            "</head></body></div>"
			        );	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
