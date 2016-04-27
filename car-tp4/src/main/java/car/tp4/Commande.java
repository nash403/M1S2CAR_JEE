package car.tp4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToMany
	private Collection<Book> orderedBooks;
	private Collection<Integer> orderedQties;
	
	public Commande(){
		this.orderedBooks = new ArrayList<Book>();
		this.orderedQties = new ArrayList<Integer>();
	}
	
	public Commande(Collection<Book> livres,Collection<Integer> qtes){
		this.orderedBooks = livres;
		this.orderedQties = qtes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Book> getOrderedBooks() {
		return orderedBooks;
	}

	public void setOrderedBooks(List<Book> orderedBooks) {
		this.orderedBooks = orderedBooks;
	}

	public Collection<Integer> getOrderedQties() {
		return orderedQties;
	}

	public void setOrderedQties(List<Integer> orderedQties) {
		this.orderedQties = orderedQties;
	}
	
	public String toString() {
		return "Commande "+id;
	}
	
}
