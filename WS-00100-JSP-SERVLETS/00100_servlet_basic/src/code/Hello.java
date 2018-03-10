package code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet(description = "Premier Servlet", urlPatterns = { "/Hello" })
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prenom = request.getParameter("prenom") ;
		String nom = request.getParameter("nom") ;
		
		PrintWriter out = response.getWriter();
		
		//Création de la page HTML
				out.println("<HTML><BODY>") ;
				out.println("<H1>Bonjour</H1>") ;
				out.println("<P> Bienvenue " + nom + " " + prenom + "<BR>") ;
				out.println("</BODY></HTML>") ;

				

		System.out.println(nom + " " +prenom);

	}

}
