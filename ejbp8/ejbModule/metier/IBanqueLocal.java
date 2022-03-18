package metier;

import java.util.List;

import javax.ejb.Local;
@Local

public interface IBanqueLocal {
	public Long addCompte(Compte c);
	public List<Compte> getAllComptes();
	public void verser (Long code,double mt);
	public void retirer(Long code,double mt);
	public Compte consulterCompte(Long code);
	public void supprimerCompte(Long Code);
}
