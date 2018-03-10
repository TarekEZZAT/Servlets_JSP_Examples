package fr.uitt.biblio.controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.uitt.biblio.modele.Adherent;
import fr.uitt.biblio.modele.Livre;

public class CtrlReservation extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse rep)
		throws ServletException, IOException {

		HttpSession laSession = req.getSession();

		ServletContext leContexte = getServletConfig().getServletContext();

		if (req.getParameter("reserver") != null) {
			if (laSession == null) {
				System.err.println("plus de session ");
				req.setAttribute("reservation", "sessionInactive");
			} else {
				// Je réserve un livre
				String titreLivre = req.getParameter("titreLivre");
				String categorieLivre = req.getParameter("categorieLivre");

				Adherent adherent =
					(Adherent) laSession.getAttribute("adherent");
				Livre unLivre = new Livre(titreLivre, categorieLivre);
				adherent.ajoutLivre(unLivre);
				req.setAttribute("reservation", "reserver");
			}
		} else {
			// Je cloture la session
			req.setAttribute("reservation", "cloturer");
		}
	}

}
