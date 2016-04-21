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
	
	@EJB(name="BooksManager")
	private LibraryItf booksManagerBean;
	
//	public Main(){
//		booksManagerBean = new BooksManager();
//		booksManagerBean.addBook(new Book("Honore de Balzac", "Le Pere Goriot"));
//		booksManagerBean.addBook(new Book("Honore de Balzac", "Les Chouans"));
//		booksManagerBean.addBook(new Book("Victor Hugo", "Les Miserables"));
//	}
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("on passe là");
//		response.setContentType("text/html");
//		PrintWriter out =  response.getWriter();
//		out.print("<html><body>");
//		out.print("<h1>LOLILOL</h1>");
//		System.out.println("getting books");
//		List<Book> allBooks = booksManagerBean.getAllBooks();
//		System.out.println("les livres : "+allBooks.size());
//		out.print("<ul>");
//		for (Book book : allBooks) {
//			System.out.println("un livre : "+book);
//			out.print("<li>"+book.toString()+"</li>");
//		}
//		out.print("</ul>");
//		out.print("</body></html>");
		this.getServletContext().getRequestDispatcher( "/WEB-INF/index.jsp" ).forward( request, response );
	}
}
