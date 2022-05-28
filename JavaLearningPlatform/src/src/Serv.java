/*
package pack;

import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*/
/**
 * Servlet implementation class Serv
 *//*

@WebServlet("/Serv")
public class Serv extends HttpServlet {
	
	@EJB
	Facade f;
	private static final long serialVersionUID = 1L;
       
    */
/**
     * @see HttpServlet#HttpServlet()
     *//*

    public Serv() {
        super();
        // TODO Auto-generated constructor stub
    }

	*/
/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		System.out.println("op = " + op);
		switch(op) {
			case "ajoutp":
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				f.ajoutPersonne(nom, prenom);
				request.getRequestDispatcher("index.html").forward(request, response);
				break;
			case "ajouta":
				String rue = request.getParameter("Rue");
				String ville = request.getParameter("Ville");
				f.ajoutAdresse(rue, ville);
				request.getRequestDispatcher("index.html").forward(request, response);
				break;
			case "lister":
				Collection<Person> lp = f.listePersonnes();
				request.setAttribute("lp", lp);
				request.getRequestDispatcher("liste.jsp").forward(request, response);
				break;
			case "associer":
				Collection<Person> lpe = f.listePersonnes();
				Collection<Adresse> la = f.listeAdresses();
				request.setAttribute("lp", lpe);
				request.setAttribute("la", la);
				request.getRequestDispatcher("choix.jsp").forward(request, response);
				break;
			case "valider":
				int idp = Integer.parseInt(request.getParameter("idp"));
				int ida = Integer.parseInt(request.getParameter("ida"));
				f.associer(idp, ida);
				request.getRequestDispatcher("index.html").forward(request, response);
		}
	}

	*/
/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
*/
