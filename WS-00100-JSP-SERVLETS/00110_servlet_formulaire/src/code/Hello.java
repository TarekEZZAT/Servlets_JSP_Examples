package code;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		@SuppressWarnings("unused")
		Enumeration<String> e = request.getParameterNames();
		ServletOutputStream out = response.getOutputStream();
		out.println("<HTML><BODY>");
		while (e.hasMoreElements()) {
			String nomParam = e.nextElement();
			String valueParam = (String) request.getParameter(nomParam);
			out.println(nomParam + " : " + valueParam + "<BR>");
		}
		out.println("<BODY><HTML>");

	}

}
