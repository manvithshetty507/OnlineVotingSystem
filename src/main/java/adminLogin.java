

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class adminLogin
 */
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		DbManager db = new DbManager();
		java.sql.Connection Con = db.getConnector();
		
		String name = request.getParameter("adname");
		String pass = request.getParameter("adpassword");
		
		try {
			
			PreparedStatement st = Con.prepareStatement("select * from adminn where admin_name='"+name+"' and admin_password='"+pass+"'");
			ResultSet rs = ((java.sql.Statement) st).executeQuery("select * from adminn where admin_name='"+name+"' and admin_Password='"+pass+"'");
			
			if(rs.next())
			{
				HttpSession session = request.getSession();
				session.setAttribute("adname", name);
				response.sendRedirect("adminlgg.jsp");
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
