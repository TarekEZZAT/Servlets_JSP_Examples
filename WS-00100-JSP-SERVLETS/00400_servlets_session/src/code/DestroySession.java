package code;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DestroySession
 */
@WebServlet("/DestroySession")
public class DestroySession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DestroySession() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void service(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
		// Création ou récupération de l'identifiant de session
		HttpSession laSession = requete.getSession(true);
		System.out.println(laSession.getId());
		laSession.invalidate();

	}
}
