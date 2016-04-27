package car.tp4;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {

	private String name;
	private Collection<Book> books;

	public Author() {
		books = new ArrayList<Book>();
	}

	public Author(String name) {
		this.name = name;
	}

	@OneToMany
	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return name;
	}
}
