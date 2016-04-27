package car.tp4;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListBook", urlPatterns = "/car/tp4/list")
public class ListBookSvlt extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2341882186706224107L;

	@EJB(name = "Library")
	private LibraryItf bibliotheque;
	private PanierItf panier;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		List<Book> books = bibliotheque.getAllBooks();
		List<Author> authors = bibliotheque.getAllAuthors();
		
		System.out.printf("Bibliothèque de %d livres\n", books.size());
		for (Book b : books) {
			System.out.println("\t" + b);
		}
		
		System.out.printf("%d auteurs sont connus.\n", authors.size());
		for (Author a : authors) {
			System.out.println("\t" + a);
		}

		panier = (PanierItf) request.getSession().getAttribute("CART");
		if (panier == null) {
			panier = new Panier(bibliotheque);
			request.getSession().setAttribute("CART", panier);
		}
		request.setAttribute("p-size", panier.size());
		request.setAttribute("p-list", panier.getItems());


		request.setAttribute("list", books);
		request.setAttribute("authors", authors);
		this.getServletContext().getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
	}
}
