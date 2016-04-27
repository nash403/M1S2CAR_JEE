package car.tp4;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class Library implements LibraryItf {

	 @PersistenceContext//(unitName = "book-pu", type = PersistenceContextType.EXTENDED)
	 private EntityManager em;


	@Override
	public void init() {
		System.out.println("init Library");
		Query q1 = em.createQuery("DELETE from Author");
		Query q2 = em.createQuery("DELETE from Book");
		q1.executeUpdate();
		q2.executeUpdate();
		System.out.println("Empty Library");
		System.out.println("adding items to Library");
		Author a1 = new Author("Honore de Balzac");
		Author a2 = new Author("Victor Hugo");
		addBook(new Book(a1, "Le Pere Goriot","2000"));
		addBook(new Book(a1, "Les Chouans","2001"));
		addBook(new Book(a2, "Les Miserables","1920"));
	}

	@Override
	public void addBook(Book book) {
		System.out.println("add " + book);

		Author author = em.find(Author.class, book.getAuthor().getName());
		if (author == null){			
			em.persist(book.getAuthor());
			em.persist(book);
		}
		else {			
			em.persist(book);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBooks() {
		 System.out.println("Requested Book list");
		 Query q = em.createQuery("SELECT b from Book as b");
		 return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> getAllAuthors() {
		System.out.println("Requested Author list");
		Query q = em.createQuery("SELECT a from Author as a");
		 return q.getResultList();
	}

	@Override
	public Book getBook(long id) {
		return em.find(Book.class, id);
	}
}
