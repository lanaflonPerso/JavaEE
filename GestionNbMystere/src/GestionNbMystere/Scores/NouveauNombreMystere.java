package GestionNbMystere.Scores;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NouveauNombreMystere
 */
@WebServlet("/nouveauNombre")
public class NouveauNombreMystere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NouveauNombreMystere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		GestionScores gs = new GestionScores();
		Random rnd = new Random();
		int val = rnd.nextInt(100)+1;
		if(session.getAttribute("nombre") == null) {
			session.setAttribute("nombre", gs);
		}
		else {
			gs = (GestionScores) session.getAttribute("nombre");
		}
		session.setAttribute("win", false);
		session.setAttribute("log", "");
		gs.addMystere(val);
		gs.getCoups().clear();
		session.setAttribute("nombre", gs);
		RequestDispatcher rd = request.getRequestDispatcher("jeu.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
