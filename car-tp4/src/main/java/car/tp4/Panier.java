package car.tp4;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class Panier implements PanierItf {

	@EJB(name = "Library")
	private LibraryItf bibliotheque;

	private HashMap<Book, Integer> order = new HashMap<Book, Integer>();

	@Override
	public void addItem(int id, int qty) {
		Book book = bibliotheque.getBook(id);
		if (book != null) {
			if (order.containsKey(book))
				order.put(book, order.get(book) + 1);
			else
				order.put(book, 1);
		}
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
	public void confirmOrder() {
		System.out.println("Order confirmed for "+getItems().size()+" items.");

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
