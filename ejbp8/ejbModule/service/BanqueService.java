package service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.IBanqueLocal;
import metier.Compte;
@Stateless
@WebService
public class BanqueService 
{
	@EJB
	private IBanqueLocal metier;
	@WebMethod
	public List<Compte>	 consulterComptes(){
		return metier.getAllComptes();
	}
	
	@WebMethod(operationName="ajouterCompte")
	public void addCompte(@WebParam(name="solde") double s) 
	{  Compte c=new Compte(s,new Date());
	
		metier.addCompte(c);
		
	}
}









