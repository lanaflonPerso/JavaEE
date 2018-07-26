package GestionNbMystere.Identification;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IdentLoginServlet
 */
@WebServlet("/Identification")
public class IdentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdentLoginServlet() {
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
		if(request.getParameter("slogin") != null 
				&& request.getParameter("smdp") !=null){
			String slogin = request.getParameter("slogin");
			String smdp = request.getParameter("smdp");
			if (slogin.equals(IdentLogin.getLogin()) 
					&& smdp.equals(IdentLogin.getMdp())) {
				HttpSession session = request.getSession();
				session.setAttribute("login", true);
				session.setAttribute("user", "admin");
				RequestDispatcher rd = request.getRequestDispatcher("./nouveauNombre");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);;
			}
		}
	}

}
