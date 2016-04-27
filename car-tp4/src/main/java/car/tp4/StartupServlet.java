package car.tp4;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Startup",urlPatterns = "/car/tp4", loadOnStartup = 1, asyncSupported = true)
public class StartupServlet extends HttpServlet {

	private static final long serialVersionUID = -4771783296240803993L;

	@EJB(name = "Library")
	private LibraryItf bibliotheque;

	@Override
	public void init(ServletConfig config) {
		bibliotheque.init();
		System.out.println("[Application Startup] Ok");
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}
}
