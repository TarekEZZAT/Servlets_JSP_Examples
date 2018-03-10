package fr.uitt.biblio.controleur;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.uitt.biblio.modele.Adherent;

public class CtrlLogin extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse rep)
		throws ServletException, IOException {
			String nomAdherent=  req.getParameter("nomAdh");
			String motDePasse = req.getParameter("motPasse");
			
			HttpSession laSession = req.getSession();

			System.out.println("Ctrlident = " + laSession.getId());

			ServletContext leContexte = getServletConfig().getServletContext();
			if (nomAdherent != null && nomAdherent.equals("Alain")){
				Adherent unAdherent = new Adherent (nomAdherent, motDePasse );
				laSession.setAttribute("adherent", unAdherent);
				//ajoute de paramètre à la requête pour le retour dans le servlet contrôleur
				req.setAttribute("identification", new Boolean (true));
			}
			else {
				req.setAttribute("identification", new Boolean (false));
				
			}
			
	}

}
