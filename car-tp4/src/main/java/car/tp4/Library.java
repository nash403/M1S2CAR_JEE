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

//	List<Book> books = new ArrayList<Book>();

//	public Library() {
//		init();
//	}

	@Override
	public void init() {
		// Query q = em.createQuery("DELETE from Book");
		// System.out.println("init library " + q);
		// q.executeUpdate();
		System.out.println("init Library");
		Query q1 = em.createQuery("DELETE from Author");
		Query q2 = em.createQuery("DELETE from Book");
		q1.executeUpdate();
		q2.executeUpdate();
		System.out.println("Empty Library");
		System.out.println("adding items to Library");
		Author a1 = new Author("Honore de Balzac");
		Author a2 = new Author("Victor Hugo");
//		em.persist(a1);
//		em.persist(a2);
		addBook(new Book(a1, "Le Pere Goriot","2000"));
		addBook(new Book(a1, "Les Chouans","2001"));
		addBook(new Book(a2, "Les Miserables","1920"));
	}

	@Override
	public void addBook(Book book) {
		System.out.println("add " + book);

//		 em.getTransaction().begin();
		Author author = em.find(Author.class, book.getAuthor().getName());
		if (author == null){			
			em.persist(book.getAuthor());
			em.persist(book);
		}
		else {			
			em.persist(book);
		}
//		 em.getTransaction().commit();
//		books.add(book);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBooks() {
		 System.out.println("Requested Book list");
		 Query q = em.createQuery("SELECT b from Book as b");
		 return q.getResultList();
//		return books;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> getAllAuthors() {
		System.out.println("Requested Author list");
		Query q = em.createQuery("SELECT a from Author as a");
		 return q.getResultList();
//		 List<Book> livres = getAllBooks();
//		 List<Author> authors = new ArrayList<Author>();
//		 for( Book b : livres){
//			 authors.add(b.getAuthor());
//		 }
//		 return authors;
//		HashSet<Author> auteurs = new HashSet<Author>();
//
//		for (Book b : books) {
//			auteurs.add(b.getAuthor());
//		}
//
//		ArrayList<Author> res = new ArrayList<Author>(auteurs);
//
//		return res;
	}

	@Override
	public Book getBook(long id) {
		return em.find(Book.class, id);
	}
}
