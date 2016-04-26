package car.tp4;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/car/tp4", loadOnStartup = 1, asyncSupported = true)
public class Main extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4771783296240803993L;

	@EJB(name = "Library")
	private LibraryItf bibliotheque;

	@Override
	public void init(ServletConfig config) {
		bibliotheque.init();// = new Library();
		config.getServletContext().setAttribute("BIBLI", bibliotheque);
		System.out.println("[Application Startup] Ok");
	}

	// @Override
	// public void service(HttpServletRequest request, HttpServletResponse
	// response)
	// throws IOException, ServletException {
	// request.setAttribute("BIBLI", bibliotheque);
	// this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp")
	// .forward(request, response);
	// }
}
