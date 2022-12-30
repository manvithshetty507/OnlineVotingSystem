

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class RegisterVoter
 */
public class RegisterVoter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterVoter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		DbManager db = new DbManager();
		java.sql.Connection Con = db.getConnector();
		
		String name = request.getParameter("rgname");
		String phoneno = request.getParameter("phno");
		String mail = request.getParameter("mail");
		String voterno = request.getParameter("voterno");
		String address = request.getParameter("add");
		String bday = request.getParameter("bday");
		
		try {
			
			PreparedStatement st = Con.prepareStatement("insert into voters(uname,phno,mail,address,voternumber,dob) values('"+name+"','"+phoneno+"','"+mail+"','"+address+"','"+voterno+"','"+bday+"')");
			st.executeUpdate();
			response.sendRedirect("adminlgg.jsp");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
