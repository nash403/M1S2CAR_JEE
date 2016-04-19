package car.tp4;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBookSvlt extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 473375328599205467L;
	
	@EJB(name="BooksManager")
	private BooksManagerItf booksManagerBean = new BooksManager();

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Ajout livre");
		String paramAuteur = request.getParameter( "author" );
		String paramTitle = request.getParameter( "title" );
		
		Author auteur = new Author(paramAuteur);
		Book livre = new Book(auteur, paramTitle);
		System.out.println("livre ajouté : "+livre);

	    request.setAttribute( "livre", livre );
	    
	    booksManagerBean.addBook(livre);


	    this.getServletContext().getRequestDispatcher( "/WEB-INF/index.jsp" ).forward( request, response );
	}

}
