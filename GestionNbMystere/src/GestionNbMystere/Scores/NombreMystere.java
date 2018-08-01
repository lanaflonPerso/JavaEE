package GestionNbMystere.Scores;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
		//on récupère la session active
		HttpSession session  = request.getSession();
		GestionScores gs = new GestionScores();
		String log = new String();
		
		if(session.getAttribute("log") != null) {
			log = session.getAttribute("log").toString();			
		}
		else {
			session.setAttribute("log", log);
		}
		
		if(session.getAttribute("nombre") == null) {
			session.setAttribute("nombre",gs);
		}
		else {
			gs = (GestionScores) session.getAttribute("nombre");
		}
		
		//On teste la proposition non nulle
		if(request.getParameter("proposition") != null) {
			int nombre = gs.getMystere().get(gs.getMystere().size()-1);							
			int essai = -1;
			try {
			 essai = Integer.parseInt(request.getParameter("proposition"));
			}
			catch(NumberFormatException e) {
				RequestDispatcher rd = request.getRequestDispatcher("jeu.jsp");
				rd.forward(request, response);
			}
			// si le booleen jeuTermine est vrai, on a gagné ou trop nul et on ne fait plus rien.
			if((Boolean) session.getAttribute("jeuTermine")){}
			else if(gs.getCoups().size() > 26) {
				log = "<li class='alert alert-danger'> Vous êtes trop nul vous ne meritez pas de continuer à jouer</li>";
				session.setAttribute("log", log);
				session.setAttribute("jeuTermine", true);
			}
			// sinon on déroule l'algo;
			else {
				try {
					gs.addCoup(essai);
					session.setAttribute("nombre", gs);
					//si on a le bon nombre
					if(essai < 0 || essai > 100) {
						session.setAttribute("jeuTermine", false);
						log += "  <li class='alert alert-danger'> Mauvais nombre rentré</li>";
						session.setAttribute("log", log);
					}
					else {
						if(nombre == essai){							
							session.setAttribute("jeuTermine", true);			
							log = "<li class='alert alert-success'>Bravo, vous avez trouvé le nombre mystère<li>";
							session.setAttribute("log", log);
							int coups = gs.getCoups().size();
							gs.addSolve(coups);
						}
						//si on a un essai plus petit que le nombre mystère
						else if (nombre > essai) {
							session.setAttribute("jeuTermine", false);
							log += "  <li class='alert alert-warning'>Le nombre mystère est plus grand que " + essai +"</li>";
							session.setAttribute("log", log);
						}
						//si on a un essai plus grand que le nombre mystère
						else if (nombre < essai) {
							session.setAttribute("jeuTermine", false);
							log += "  <li class='alert alert-warning'>Le nombre mystère est plus petit que " + essai +"</li>";
							session.setAttribute("log", log);
						}						
					}
				}
				catch(Exception e) {
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
