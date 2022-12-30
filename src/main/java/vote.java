

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class vote
 */
public class vote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DbManager db = new DbManager();
		java.sql.Connection Con = db.getConnector();
		
		String vnumber = request.getParameter("voterno");
		String party = request.getParameter("party");
		
		try {
			PreparedStatement st = Con.prepareStatement("select * from voters where voternumber='"+vnumber+"'");
			ResultSet rs = ((java.sql.Statement) st).executeQuery("select * from voters where voternumber='"+vnumber+"'");
			
			if(rs.next())
			{
				PreparedStatement st1 = Con.prepareStatement("insert into temp_vid(vnumber) values('"+vnumber+"')");
				PreparedStatement st2 = Con.prepareStatement("insert into vote(vnumber,party) values('"+vnumber+"','"+party+"')");
				
				st1.executeUpdate();
				st2.executeUpdate();
				
				response.sendRedirect("index.jsp");
			}
			else
			{
				response.sendRedirect("invalid.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
