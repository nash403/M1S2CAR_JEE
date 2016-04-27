package car.tp4;

import java.util.List;

import javax.ejb.Local;

@Local
public interface CommandeManagerItf {
	public void register(Commande c);
	public List<Commande> getCommandes();
}
