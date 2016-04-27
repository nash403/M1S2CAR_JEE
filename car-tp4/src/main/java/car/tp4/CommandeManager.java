package car.tp4;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CommandeManager implements CommandeManagerItf {
	
	@PersistenceContext
	private EntityManager cm;

	@Override
	public void register(Commande c) {
		cm.persist(c);

	}

	@Override
	public List<Commande> getCommandes() {
		System.out.println("Requested Commande list");
		Query q = cm.createQuery("SELECT a from Author as a");
		 return q.getResultList();
	}

}
