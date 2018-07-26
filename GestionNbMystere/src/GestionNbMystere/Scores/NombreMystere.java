package GestionNbMystere.Scores;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class NombreMystère
 */
@WebServlet("/Nombre")
public class NombreMystere extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NombreMystere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session  = request.getSession();
		String log = session.getAttribute("log").toString();
		int score = Integer.parseInt(session.getAttribute("count").toString());
		if(request.getParameter("proposition") != null) {
			int nombre = Integer.parseInt(session.getAttribute("nombre").toString());
			int essai = Integer.parseInt(request.getParameter("proposition"));
			if((boolean) session.getAttribute("win") == true ){
			}
			else {
				try {
					score++;
					session.setAttribute("count",score);
					if(nombre == essai){
						session.setAttribute("win", true);
						session.setAttribute("status", "win");
						log = GenerationNombreMystere.bonNombre();
						session.setAttribute("log", log);
						if (session.getAttribute("highscore") != null ) {
							if((boolean) session.getAttribute("win")) {
									if(Integer.parseInt(session.getAttribute("highscore").toString()) > Integer.parseInt(session.getAttribute("count").toString())) {
										session.setAttribute("highscore", session.getAttribute("count"));
									}
								}
							}
							else {
								session.setAttribute("highscore", score);
							}
					}
					else if (nombre > essai) {
						session.setAttribute("win", false);
						session.setAttribute("status", "grand");
						log += "  " + GenerationNombreMystere.tropGrand();
						session.setAttribute("log", log);
					}
					else if (nombre < essai) {
						session.setAttribute("win", false);
						session.setAttribute("status", "petit");
						log += "  " + GenerationNombreMystere.tropPetit();
						session.setAttribute("log", log);
						
					}
				}
				catch(NumberFormatException e) {
					System.out.println(e);
				}
				
			}
			RequestDispatcher rd = request.getRequestDispatcher("jeu.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("jeu.jsp");
			rd.forward(request, response);
		}
		
	}

}
