/**
 * 
 */
package fr.barde.tp7;

/**
 * @author Alexandre
 * TODO
 * 15 mars 2017:15:58:21
 */
public class CompteBancaire extends Compte{

	private String numero;
	
	public CompteBancaire(String numero){
		super();
		this.numero = numero;
	}

	public String getNumero(){
		return this.numero;
	}
	
	@Override
	public String toString(){
		return "Numéro : " + this.getNumero() 
				+ ", Crédit : " + super.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Integer.parseInt(this.getNumero());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == this){
			return true;
		}
		if(obj instanceof CompteBancaire){
			return this.getNumero() == ((CompteBancaire) obj).getNumero();
		}
		return false;
	}
	
	
	
}
