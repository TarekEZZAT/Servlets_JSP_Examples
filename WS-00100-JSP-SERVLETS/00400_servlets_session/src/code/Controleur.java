package code;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejb.Client;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	
	Client leClient;

	public Controleur() {
		super(); 
		}
	public void service(HttpServletRequest requete, 
					   HttpServletResponse reponse)
 					   throws ServletException, IOException {
		// Création ou récupération de l'identifiant de session
		HttpSession laSession = requete.getSession(true);
		System.out.println(laSession.getId());
		ServletContext leContexte =
			 			getServletConfig().getServletContext();
		RequestDispatcher leDispatcher;

		if (( laSession.isNew()) || (leClient == null)) {
			System.out.println(laSession.getId());

			// Création de l'objet client (non renseigné)
			// enregistré comme attribut de la session
			leClient = new Client(" ", " ");
			laSession.setAttribute("qui", leClient);	
			leDispatcher = leContexte.getRequestDispatcher("/Identification");
		} else {
			System.out.println(laSession.getId());

			// Récupération de l'attribut de session
			leClient = (Client) laSession.getAttribute("qui");
			if (requete.getParameter("nom")!= leClient.getNom() ||  
 				requete.getParameter("prenom")!=leClient.getNom()){
				leClient.setNom( requete.getParameter("nom"));
				leClient.setPrenom( requete.getParameter("prenom"));
				laSession.setAttribute("qui", leClient);		
			}	
			leDispatcher = leContexte.getRequestDispatcher("/Access");
		}
		leDispatcher.forward(requete, reponse);
	}
}
