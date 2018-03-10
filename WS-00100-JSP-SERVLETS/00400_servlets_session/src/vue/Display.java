package vue;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejb.Client;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Client leClient;
	public Display() {
		super();
	}

	public void service(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {

		HttpSession laSession = requete.getSession(false);
		if ((laSession == null) 
				|| (leClient == null)
				|| (leClient.getNom()==null)
				||(leClient.getPrenom()==null)
				){
			ServletContext leContexte = getServletConfig().getServletContext();
			RequestDispatcher leDispatcher;
			leDispatcher = leContexte.getRequestDispatcher("/Controleur");
			leDispatcher.forward(requete, reponse);
		}

		ServletOutputStream sortie = reponse.getOutputStream();

		// Récupération de l'identifiant de session
		leClient = (Client) laSession.getAttribute("qui");
		String nomParam, valeurParam;
		Enumeration<String> listeParam = requete.getParameterNames();

		sortie.println("<html>");
		sortie.println("<head>");
		sortie.println("<title>Ouvrage demandé</title>");
		sortie.println("</head>");
		sortie.println("<body>");
		sortie.println("<h1>Bonjour " + leClient.getPrenom() + " " + leClient.getNom() + "</h1>");
		while (listeParam.hasMoreElements()) {
			nomParam = (String) listeParam.nextElement();
			valeurParam = requete.getParameter(nomParam);
			sortie.println("<p>nom du paramètre : " + nomParam + "</p>");
			sortie.println("<p>valeur: " + valeurParam + "</p>");
		}
		sortie.println("</body>");
		sortie.println("</html>");

		sortie.close();
	}
}
