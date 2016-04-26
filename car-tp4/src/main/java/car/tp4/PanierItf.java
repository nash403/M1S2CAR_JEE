package car.tp4;

import java.util.Map;
import java.util.Set;

import javax.ejb.Local;

@Local
public interface PanierItf {
	public void addItem(int idBook, int qty);
	public void removeItem(int idBook);
	public Set<Map.Entry<Book,Integer>> getItems();
	public void confirmOrder();
	public int size();

}
