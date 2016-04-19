package car.tp4;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BooksManagerItf {
	public List<Book> getAllBooks();
	public List<Author> getAllAuthors();
	public void addBook(Book book);
}
