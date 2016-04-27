package car.tp4;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class Panier implements PanierItf {

	@EJB(name = "Library")
	private LibraryItf bibliotheque;

	private HashMap<Book, Integer> order = new HashMap<Book, Integer>();
	
	public Panier(){
		bibliotheque = new Library();
	}
	
	public Panier(LibraryItf bibli){
		bibliotheque = bibli;
	}

	@Override
	public void addItem(int id) {
		Book book = bibliotheque.getBook(id);
		System.out.println("adding to cart " + book + ", id: " + id);
		if (book != null) {
			System.out.println("\tBook non nul");
			if (order.containsKey(book)) {
				System.out.println("\tincrément panier");
				order.put(book, order.get(book) + 1);
			} else {
				System.out.println("\tajout panier");
				order.put(book, 1);
			}
		}
		System.out.println("\ttaille panier maintenant " + size());
	}

	@Override
	public void removeItem(int id) {
		Book book = bibliotheque.getBook(id);
		if (book != null) {
			Integer v = order.get(book);
			if (v != null && v > 1)
				order.put(book, order.get(book) - 1);
			else if (v != null && v == 1)
				order.remove(book);
		}

	}

	@Override
	@Remove
	public Commande confirmOrder() {
		System.out.println("Order confirmed for " + getItems().size() + " items.");
		Commande commande = new Commande(order.keySet(), order.values());
		return commande;
//		em.persist(commande);
	}

	@Override
	public Set<Entry<Book, Integer>> getItems() {
		return order.entrySet();
	}

	@Override
	public int size() {
		return order.size();

	}

}
