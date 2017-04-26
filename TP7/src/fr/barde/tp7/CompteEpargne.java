/**
 * 
 */
package fr.barde.tp7;

/**
 * @author Alexandre
 * TODO
 * 15 mars 2017:16:07:58
 */
public class CompteEpargne extends CompteBancaire{

	private float taux;
	
	public CompteEpargne(String numero, float taux) throws IllegalArgumentException{
		super(numero);
		if(taux < 0){
			throw new IllegalArgumentException("Taux négatif");
		}
		this.taux = taux;
		
	}
	
	public float getTaux(){
		return this.taux;
	}
	
	public float getInteret(){
		if(this.getSolde() > 0){
			return this.getSolde() * this.getTaux();
		}else{
			return 0.0F;
		}
	}
	
	public void ajouterInteret(){
		this.deposer(this.getInteret());
	}
	
}
