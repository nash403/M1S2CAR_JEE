package car.tp4;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

@Stateful
public class BooksManager implements BooksManagerItf {

	@PersistenceContext(unitName = "book-pu", type = PersistenceContextType.EXTENDED)
	private EntityManager em = Persistence.createEntityManagerFactory( "book-pu" ).createEntityManager();

	@Override
	public void addBook(Book book) {
		System.out.println("add");
		// Book b1 = new Book("Honore de Balzac", "Le Pere Goriot");
		// Book b2 = new Book("Honore de Balzac", "Les Chouans");
		// Book b3 = new Book("Victor Hugo", "Les Miserables");
		//em.getTransaction().begin();
		em.persist(book);
		//em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBooks() {
		System.out.println("la");
		Query q = em.createQuery("SELECT b from Book as b");
		return q.getResultList();
	}

	@Override
	public List<Author> getAllAuthors() {
		Query q = em.createQuery("SELECT a from Author as a");
		return q.getResultList();
	}
}
