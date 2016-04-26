package car.tp4;

import java.io.IOException;
import java.util.List;

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

	@EJB(name = "Library")
	private LibraryItf bibliotheque;
	@EJB(name = "Panier")
	private PanierItf panier;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		List<Book> books = bibliotheque.getAllBooks();
		
		System.out.printf("Bibliothèque de %d livres\n",books.size());
		for(Book b: books){
			System.out.println("\t"+b);
		}

		// booksManagerBean.addBook(livre);
		request.setAttribute("LIST", books);
		request.setAttribute("p-size", panier.size());
		this.getServletContext().getRequestDispatcher("/list.jsp")
				.forward(request, response);
	}
}
