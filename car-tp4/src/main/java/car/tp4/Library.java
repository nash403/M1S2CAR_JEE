package car.tp4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.Stateful;

@Stateful
public class Library implements LibraryItf {

	// @PersistenceContext
	// // (unitName = "book-pu", type = PersistenceContextType.EXTENDED)
	// private EntityManager em;

	List<Book> books = new ArrayList<Book>();

	public Library() {
		init();
	}

	@Override
	public void init() {
		// Query q = em.createQuery("DELETE from Book");
		// System.out.println("init library " + q);
		// q.executeUpdate();
		System.out.println("init Library");
		addBook(new Book(new Author("Honore de Balzac"), "Le Pere Goriot"));
		addBook(new Book(new Author("Honore de Balzac"), "Les Chouans"));
		addBook(new Book(new Author("Victor Hugo"), "Les Miserables"));
	}

	@Override
	public void addBook(Book book) {
		System.out.println("add " + book);

		// em.getTransaction().begin();
		// em.persist(book);
		// em.getTransaction().commit();
		books.add(book);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBooks() {
		// System.out.println("la");
		// Query q = em.createQuery("SELECT b from Book as b");
		// return q.getResultList();
		return books;
	}

	@Override
	public List<Author> getAllAuthors() {
		// Query q = em.createQuery("SELECT a from Author as a");
		// return q.getResultList();
		HashSet<Author> auteurs = new HashSet<Author>();

		for (Book b : books) {
			auteurs.add(b.getAuthor());
		}

		ArrayList<Author> res = new ArrayList<Author>(auteurs);

		return res;
	}
}
