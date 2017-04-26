/**
 * 
 */
package fr.barde.tp7;

/**
 * @author Alexandre
 * TODO
 * 15 mars 2017:15:53:28
 */
public class Compte {

	private float credit;
	private float debit;
	
	public Compte(){
		this.credit = 0.0F;
		this.debit = 0.0F;
	}
	
	public float getSolde(){
		return this.credit - this.debit;
	}
	
	public void deposer(float montant) throws IllegalArgumentException{
		if(montant < 0.0F){
			throw new IllegalArgumentException("Montant négatif");
		}
		this.credit += montant;
	}
	
	public void retirer(float montant) throws IllegalArgumentException{
		if(montant < 0.0F){
			throw new IllegalArgumentException("Montant négatif");
		}
		this.debit += montant;
	}
	
	@Override
	public String toString(){
		return "Crédit : " + this.credit + ", Débit : " + this.debit;
	}
	
}
