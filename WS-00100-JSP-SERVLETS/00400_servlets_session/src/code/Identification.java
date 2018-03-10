package code;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Identification")
public class Identification extends HttpServlet {
 	public Identification() { super(); }

	public void service(HttpServletRequest requete, 
					 HttpServletResponse reponse)
 					 throws ServletException,  IOException {

		ServletOutputStream sortie= reponse.getOutputStream();

		sortie.println("<html><head>");
		sortie.println("<title>Identification</title>");
		sortie.println("</head><body>");
		sortie.println("<form method=post action=/00400_servlets_session/Controleur>");
		sortie.println("<h1> Qui êtes-vous ? </h1>");
		sortie.println("<p> Votre nom : </p>");
		sortie.println("<input name=nom type=text size=12>");
		sortie.println("<p> Votre prénom : </p>");
		sortie.println("<input name=prenom type=text size=12>");
		sortie.println("<input type=submit>");
		sortie.println("</form></body></html>");	

		sortie.close();
	}
}
