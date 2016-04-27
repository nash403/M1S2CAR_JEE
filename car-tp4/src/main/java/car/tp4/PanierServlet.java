package car.tp4;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PanierSvlt", urlPatterns = { "/car/tp4/addcart", "/car/tp4/rmcart", "/car/tp4/confirm" })
public class PanierServlet extends HttpServlet {
	
	//@EJB(name="Panier")
	private PanierItf panier;
	
	@EJB(name = "Library")
	private LibraryItf bibliotheque;
	
	private static final String ADD = "/car/tp4/addcart";
	private static final String RM = "/car/tp4/rmcart";
	private static final String CONFIRM = "/car/tp4/confirm";
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		panier = (PanierItf) request.getSession().getAttribute("CART");
		if (panier == null) {
			panier = new Panier(bibliotheque);
			request.getSession().setAttribute("CART", panier);
		}
		String path = request.getServletPath();
		System.out.println("\t[CART] params-> id: "+request.getParameter("id")+", author: "+request.getParameter("author")+", title: "+request.getParameter("title")+", year: "+request.getParameter("year"));
		if (path.equals(ADD)) {
			System.out.println("\t[CART] add");
			int idBook = Integer.parseInt(request.getParameter("id"));
			panier.addItem(idBook);
		}
		else if (path.equals(RM)){
			System.out.println("\t[CART] rm");
			int idBook = Integer.parseInt(request.getParameter("id"));
			panier.removeItem(idBook);
		}
		else if (path.equals(CONFIRM)){
			System.out.println("\t[CART] confirm");
			panier.confirmOrder();
		}
		else System.out.println("\t[CART] no URL matching");
		
		System.out.println("\tavant forward "+panier.size());
		this.getServletContext().getRequestDispatcher("/car/tp4/list").forward(request, response);
	}
}
