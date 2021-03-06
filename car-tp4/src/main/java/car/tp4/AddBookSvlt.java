package car.tp4;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddBook", urlPatterns = "/car/tp4/add")
public class AddBookSvlt extends HttpServlet {

	private static final long serialVersionUID = 473375328599205467L;

	@EJB(name = "Library")
	private LibraryItf bibliotheque;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String paramAuteur = request.getParameter("author");
		String paramTitle = request.getParameter("title");
		String year = request.getParameter("year");

		Author auteur = new Author(paramAuteur);
		Book livre = new Book(auteur, paramTitle, year);
		System.out.println("livre ajouté : " + livre);

		bibliotheque.addBook(livre);
		for (Book b : bibliotheque.getAllBooks()) {
			System.out.println("Livre dans bibli " + b);
		}
		request.setAttribute("livre", livre);

		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}
}
