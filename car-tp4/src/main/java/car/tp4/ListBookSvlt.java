package car.tp4;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListBookSvlt extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2341882186706224107L;
	
	@EJB(name="BooksManager")
	private BooksManagerItf booksManagerBean = new BooksManager();

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("liste livres");

	    
	    //booksManagerBean.addBook(livre);


	    this.getServletContext().getRequestDispatcher( "/WEB-INF/index.jsp" ).forward( request, response );
	}
}
