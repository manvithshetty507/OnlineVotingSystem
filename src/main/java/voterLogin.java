

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class voterLogin
 */
public class voterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		DbManager db = new DbManager();
		java.sql.Connection Con = db.getConnector();
		
		String vnumber = request.getParameter("ID");
		
		try {
			
			PreparedStatement st1 = Con.prepareStatement("select vnumber from temp_vid where vnumber = '"+vnumber+"'");
			ResultSet rs1 = st1.executeQuery("select vnumber from temp_vid where vnumber = '"+vnumber+"'");
			
			if(rs1.next())
			{
				response.sendRedirect("voted.jsp");
			}
			else 
			{
				PreparedStatement st = Con.prepareStatement("select * from voters where voternumber='"+vnumber+"'");
				ResultSet rs = ((java.sql.Statement) st).executeQuery("select * from voters where voternumber='"+vnumber+"'");
				
				if(rs.next())
				{
					response.sendRedirect("userenter.jsp");
				}
				else
				{
					response.sendRedirect("invalid.jsp");
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
