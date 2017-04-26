/**
 * 
 */
package fr.barde.tp2;

/**
 * @author Alexandre
 * 1 mars 2017:10:07:26
 */
public class Monome {

	private float coefficient;
	private int exposant;
	
	/**
	 * @param coefficient
	 * Coefficient du monome
	 * @param exposant
	 * Exposant du monome
	 */
	public Monome(float coefficient, int exposant) throws IllegalArgumentException {	
		if(exposant < 0){
			throw new IllegalArgumentException("Exposant invalide.");
		}
		this.coefficient = coefficient;
		this.exposant = exposant;
	}

	/**
	 * @return the coefficient
	 * Retourne le coefficient
	 */
	public float getCoefficient() {
		return this.coefficient;
	}


	/**
	 * @return the exposant
	 * Retourne l'exposant
	 */
	public int getExposant() {
		return this.exposant;
	}

	
	/**
	 * @return the monome
	 * Retourne la somme de 2 monomes sous la forme d'un autre monome.
	 * @exception IllegalArgumentException
	 * Lève l'exception si les exposants sont différents.
	 */
	public Monome somme(Monome m2) throws IllegalArgumentException{
		if(this.getExposant() != m2.getExposant()){
			throw new IllegalArgumentException("Les exposants sont différents.");
		}
		return (new Monome(this.getCoefficient()+m2.getCoefficient(),this.getExposant()));
	}
	
	/**
	 * @return the monome
	 * Retourne le produit de 2 monomes sous la forme d'un autre monome.
	 */
	public Monome produit(Monome m2) {
		return (new Monome(this.getCoefficient()*m2.getCoefficient(),this.getExposant()+m2.getExposant()));
	}
	
	
	/**
	 * @return the derivee
	 * Retourne la dérivée du monome.
	 */
	public Monome derivee(){
		if(this.getExposant() == 0){
			return (new Monome(0.0F, 0));
		}else{
			return (new Monome(this.getCoefficient()*this.getExposant(), this.getExposant()-1));
		}
	}
	
	/**
	 * 
	 * @return estNul
	 * Retourne vrai si le monome est égal à zéro.
	 */
	public boolean estNul(){
		return(this.getCoefficient() == 0.0F);
	}

	/**
	 * @param coefficient the coefficient to set
	 * Permet de modifier le coefficient du monone.
	 */
	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}

	/**
	 * @param exposant the exposant to set
	 * Permet de modifier l'exposant du monone.
	 */	
	public void setExposant(int exposant) {
		this.exposant = exposant;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getCoefficient()+"xe"+this.getExposant();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(coefficient);
		result = prime * result + exposant;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monome other = (Monome) obj;
		if (Float.floatToIntBits(coefficient) != Float
				.floatToIntBits(other.coefficient))
			return false;
		if (exposant != other.exposant)
			return false;
		return true;
	}
	

	
	
}
