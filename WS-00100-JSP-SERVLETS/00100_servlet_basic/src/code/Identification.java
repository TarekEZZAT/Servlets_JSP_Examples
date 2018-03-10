package code;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Identification extends HttpServlet {
 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Identification() { super(); }

	public void service(HttpServletRequest requete, 
					 HttpServletResponse reponse)
 					 throws ServletException,  IOException {

		ServletOutputStream sortie= reponse.getOutputStream();

		sortie.println("<html><head>");
		sortie.println("<title>Identification</title>");
		sortie.println("</head><body>");
		sortie.println("<form method=post action=/Controleur>");
		sortie.println("<h1> Qui �tes-vous ? </h1>");
		sortie.println("<p> Votre nom : </p>");
		sortie.println("<input name=nom type=text size=12>");
		sortie.println("<p> Votre pr�nom : </p>");
		sortie.println("<input name=prenom type=text size=12>");
		sortie.println("<input type=submit>");
		sortie.println("</form></body></html>");	

		sortie.close();
	}
}
