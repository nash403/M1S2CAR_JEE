package car.tp4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4771783296240803993L;
	
	@EJB(name="Library")
	private LibraryItf bibliotheque;
	
	public void init(){
		bibliotheque = new Library();
		bibliotheque.init();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("on passe là");
		request.setAttribute("BIBLI", bibliotheque);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/index.jsp" ).forward( request, response );
	}
}
