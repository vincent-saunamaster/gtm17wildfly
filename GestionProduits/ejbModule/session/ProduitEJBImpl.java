package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.Produit;

/**
 * Session Bean implementation class ProduitEJBImpl
 */
@Stateless
public class ProduitEJBImpl implements ProduitRemote, ProduitLocal {

	@PersistenceContext(name="ejb-pu")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ProduitEJBImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int ajouterProduit(Produit p) {
		// TODO Auto-generated method stub
		em.persist(p);
		return p.getId();
	}

	@Override
	public Produit modifierProduit(Produit p) {
		// TODO Auto-generated method stub
		em.merge(p);
		return p;
	}

	@Override
	public void supprimerProduit(Produit p) {
		// TODO Auto-generated method stub
		em.remove(p);
	}

	@Override
	public Produit getProduit(int idProduit) {
		// TODO Auto-generated method stub
		Produit p = em.find(Produit.class, idProduit);
		return p;
	}

	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT p FROM Produit p");
		List<Produit> listP = (List<Produit>)q.getResultList();
		return listP;
	}

}
