package car.tp4;

import java.util.Map;
import java.util.Set;

import javax.ejb.Remote;

@Remote
public interface PanierItf {
	public void addItem(int idBook);
	public void removeItem(int idBook);
	public Set<Map.Entry<Book,Integer>> getItems();
	public Commande confirmOrder();
	public int size();

}
