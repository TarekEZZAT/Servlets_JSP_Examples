package fr.uitt.biblio.controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// import biblio.modele.Adherent;

/**
 * @version 	1.0
 * @author
 */
public class CtrlPrincipal extends HttpServlet {

	// pas dire static car une seule instance du contrôleur et pas de propagation entre 2 serveurs
	private final int PAGE_INDEX = 0;
	private final int PAGE_LOGIN = 1;
	private final int PAGE_RESERVATION = 2;

	protected void service(HttpServletRequest req, HttpServletResponse rep)
		throws ServletException, IOException {
		//		ServletContext leContexte = getServletConfig().getServletContext();
		ServletContext leContexte = getServletContext();
			RequestDispatcher leDispatcher = null;
		HttpSession laSession = req.getSession(true);
		try {

			if (laSession.isNew()) {
				leDispatcher = leContexte.getRequestDispatcher("/login.jsp");
			} else {
				String page = req.getParameter("page");
				int onVientDe;
				// pour se protéger des URL modifiées par l'utilisateur
				if (page == null)
					page = "0";
					
				onVientDe = Integer.parseInt(page);

				switch (onVientDe) {

					case PAGE_INDEX :

						if ((req.getAttribute("identification") != null)
							&& ((Boolean) req.getAttribute("identification"))
								.booleanValue()) {
							// Appel de la JSP de réservation de livre
							leDispatcher =
								leContexte.getRequestDispatcher(
									"/reservationTagLibIterate.jsp");
						} else {
							// Appel de la JSP d'identification
							leDispatcher =
								leContexte.getRequestDispatcher("/login.jsp");
							//rep.sendRedirect("login.jsp");
						}
						break;

					case PAGE_LOGIN :

						// on vient du formulaire d'habilitation
						leDispatcher =
							leContexte.getRequestDispatcher("/CtrlLogin");
						leDispatcher.include(req, rep);
						if (((Boolean) req.getAttribute("identification"))
							.booleanValue()) {
							// Appel de la JSP de réservation de livre
							leDispatcher =
								leContexte.getRequestDispatcher(
								"/reservationTagLibIterate.jsp");
						} else {
							// Appel de la JSP d'identification
							leDispatcher =
								leContexte.getRequestDispatcher("/login.jsp");
						}
						break;

					case PAGE_RESERVATION :
						// on vient du formulaire de réservation
						leDispatcher =
							leContexte.getRequestDispatcher("/CtrlReservation");
						leDispatcher.include(req, rep);
						if ((req
							.getAttribute("reservation")
							.equals("reserver"))) {
							// Appel de la JSP de réservation de livre
							leDispatcher =
								leContexte.getRequestDispatcher(
								"/reservationTagLibIterate.jsp");
						} else if (
							(req
								.getAttribute("reservation")
								.equals("cloturer"))) {
							// Appel de la	JSP de cloture
							leDispatcher =
								leContexte.getRequestDispatcher(
									"/deconnexion.jsp");
							if (laSession != null){
								laSession.setAttribute("adherent",null);
								laSession.invalidate();						
								laSession = null;

							}
						} else {
							//Pb d'URL directe alors que session clôturée
							leDispatcher =
								leContexte.getRequestDispatcher("login.jsp");

						}

						break;

					default :
						//Pb d'URL directe alors que session clôturée
						leDispatcher =
							leContexte.getRequestDispatcher("/login.jsp");

						break;
				}
			}
			leDispatcher.forward(req, rep);
		} catch (Throwable t) {
			leDispatcher = leContexte.getRequestDispatcher("/erreur.html");
			leDispatcher.forward(req, rep);
			laSession.setAttribute("adherent",null);
			laSession.invalidate();
			laSession = null;
			
		}
	}
}
