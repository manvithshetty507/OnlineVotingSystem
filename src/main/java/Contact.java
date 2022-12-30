

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Contact
 */
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
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
		
		String u_name = request.getParameter("name");
		String phone_number = request.getParameter("phone");
		String email = request.getParameter("mail");
		String u_comment = request.getParameter("comment");
		
		try {
			
			PreparedStatement st = Con.prepareStatement("INSERT INTO contacts(u_name,phone_number,email,u_comment) VALUES('"+u_name+"','"+phone_number+"','"+email+"','"+u_comment+"')");
			st.executeUpdate();
			response.sendRedirect("index.jsp");
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("index.jsp");
	}

}
