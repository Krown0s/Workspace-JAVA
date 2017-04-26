package fr.barde.tp2;

import java.util.Arrays;

public class Polynome {

	/**
	 * Degré maximum de Polynôme.
	 */
	public static final int DEGRE_MAX = 99;
	
	/**
	 * Tableau contenant les coefficients des monômes.
	 */
	private float[] coefficients;
	
	/**
	 * Créer un polynôme nul.
	 */
	public Polynome(){
		//Créer le tableau de coefficients
		this.coefficients = new float[DEGRE_MAX+1];
		for(int i = 0; i < coefficients.length; i++){
			this.coefficients[i] = 0.0F;
		}
	}
	
	/**
	 * Positionne un nouveau monône dans un polynôme.
	 * @param m
	 * Monome à positionner dans le polynôme.
	 * @throws IllegalArgumentException
	 * Si exposant du monome m est supérieur à DEGRE_MAX.
	 */
	public void setMonome(Monome m) throws IllegalArgumentException{
		if(m.getExposant() > coefficients.length){
			throw new IllegalArgumentException("Trop grand");
		}
		this.coefficients[m.getExposant()] = m.getCoefficient();
	}
	
	/**
	 * Récupère un nouveau monône dans un polynôme.
	 * @param e
	 * Position de l'exposant.
	 * @throws IllegalArgumentException
	 * Si exposant e est supérieur à DEGRE_MAX.
	 */
	public Monome getMonome(int e) throws IllegalArgumentException{
		if((e > coefficients.length) ||(e < 0)){
			throw new IllegalArgumentException("Invalide");
		}
		return new Monome(this.coefficients[e], e);
	}
	
	/**
	 * Récupère un nouveau monôme qui est la dérivée.
	 * @return poly
	 * Retourne un monôme qui correspond à la dérivée du monôme.
	 */
	public Polynome derivee(){
		Polynome poly = new Polynome();
		for(int i = 0; i < this.coefficients.length; i++){
			if(this.coefficients[i] == 0.0F){
				poly.coefficients[i] = 0.0F;
				System.out.print("x");
			}else{
				//poly.coefficients[i] = (this.getMonome(i).getCoefficient()*this.getMonome(i).getExposant());
				poly.getMonome(i).derivee();
			}
		}
		return poly;
	}

	/**
	 * Récupère un nouveau monôme qui est le produit.
	 * @param m
	 * Monôme qui va être additionné à notre monôme actuel.
	 * @return poly
	 * Retourne un monôme qui correspond au produit de m et du monôme actuel.
	 */
	public Polynome somme(Polynome p2){
		Polynome poly = new Polynome();
		for(int i = 0; i < this.coefficients.length; i++){
			//poly.coefficients[i] = (this.getMonome(i).getCoefficient()+m.getCoefficient());
			poly.setMonome(this.getMonome(i).somme(p2.getMonome(i)));
		}
		return poly;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Polynome [coefficients=" + Arrays.toString(coefficients) + "]";
	}	
	
	
}
