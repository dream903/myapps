package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ejb.MessageDriven;
@Stateless(name="BK")
public class BanqueEJBImpl implements IBanqueRemote,IBanqueLocal {

	@PersistenceContext(unitName="UP_BANQUE")
	private EntityManager em;
	@Override
	public Long addCompte(Compte c) {
	em.persist(c); return c.getCode();
	}

	@Override
	public List<Compte> getAllComptes() {
		Query req=em.createQuery("select c from Compte c");
		return req.getResultList();
	}

	@Override
	public void verser(Long code, double mt) {
		Compte cp=em.find(Compte.class, code);
		cp.setSolde(cp.getSolde()+mt);
	}

	@Override
	public void retirer(Long code, double mt) {
		Compte cp=em.find(Compte.class, code);
		cp.setSolde(cp.getSolde()-mt);		
	}

	@Override
	public Compte consulterCompte(Long code) {
		Compte cp=em.find(Compte.class, code);
		if (cp==null) throw new RuntimeException("cpte intouvable");
		return cp;
	}

	@Override
	public void supprimerCompte(Long Code) {
		em.remove(Code);		
	}

}
