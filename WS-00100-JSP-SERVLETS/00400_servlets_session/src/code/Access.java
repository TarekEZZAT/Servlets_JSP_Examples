package code;

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

import java.io.IOException;

@WebServlet("/Access")
public class Access extends HttpServlet {
	
	Client leClient;
	
	public Access(){ 
		super(); 
	}

	public void service(HttpServletRequest requete, 
					   HttpServletResponse reponse)
 					   throws ServletException,  IOException {

		ServletOutputStream sortie= reponse.getOutputStream();

		// Récupération de l'identifiant de session	
		
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
		
		
		System.out.println(laSession.getId());

		leClient = (Client) laSession.getAttribute("qui");	

		sortie.println("<html><head>");
		sortie.println("<title>Ouvrage demandé</title>");
		sortie.println("</head><body>");
		sortie.println("<form method=post , action=/00400_servlets_session/Display>");
		sortie.println("<p> Bonjour </p>");
		sortie.println("<h1>Bonjour " + leClient.getPrenom() + " " + leClient.getNom() +"</h1>");
		sortie.println("<p> Quel est son titre ? </p>");
		sortie.println("<input name=titre type=text size=12>");
		sortie.println("<p>Sa catégorie ? </p>");
		sortie.println("<input name=categorie type=text size=12>");
		sortie.println("<input type=submit>");	
		sortie.println("</form></body></html>");	
		sortie.close();	
	}
}
