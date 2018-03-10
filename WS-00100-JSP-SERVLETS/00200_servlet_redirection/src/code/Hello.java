package code;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet(
		description = "Accueil des stagiaires", 
		urlPatterns = { "/Hello" }, 
		initParams = { 
				@WebInitParam(name = "company", value = "ESIC", description = "nom de la société"), 
				@WebInitParam(name = "stage", value = "servlets+ JSP", description = "thème de la formation")
		})
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
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String nom, valeur;

		Enumeration<String> e =  config.getInitParameterNames();
		while (e.hasMoreElements()) {
			nom = (String)e.nextElement();
			valeur = config.getInitParameter(nom);
			System.out.println ("Nom : " + nom + " valeur : " + valeur);
		}
		
		System.out.println(config.getServletName());
		System.out.println(config.getServletContext().getServerInfo());

	}
    
    
    
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream out =response.getOutputStream ();
		String nouvelleURL = "http://www.google.com";
		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader("Location", nouvelleURL);
		out.println("<html><head><title>301 Moved Permanently</title></head>");
		out.println("<body>Document moved to <a href=" + nouvelleURL );
		out.println("here</a>.<p></body></html>");
		out.close();
	}

}
