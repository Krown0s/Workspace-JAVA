package fr.barde.tp2;

import java.util.Arrays;

public class Polynome {

	/**
	 * Degr� maximum de Polyn�me.
	 */
	public static final int DEGRE_MAX = 99;
	
	/**
	 * Tableau contenant les coefficients des mon�mes.
	 */
	private float[] coefficients;
	
	/**
	 * Cr�er un polyn�me nul.
	 */
	public Polynome(){
		//Cr�er le tableau de coefficients
		this.coefficients = new float[DEGRE_MAX+1];
		for(int i = 0; i < coefficients.length; i++){
			this.coefficients[i] = 0.0F;
		}
	}
	
	/**
	 * Positionne un nouveau mon�ne dans un polyn�me.
	 * @param m
	 * Monome � positionner dans le polyn�me.
	 * @throws IllegalArgumentException
	 * Si exposant du monome m est sup�rieur � DEGRE_MAX.
	 */
	public void setMonome(Monome m) throws IllegalArgumentException{
		if(m.getExposant() > coefficients.length){
			throw new IllegalArgumentException("Trop grand");
		}
		this.coefficients[m.getExposant()] = m.getCoefficient();
	}
	
	/**
	 * R�cup�re un nouveau mon�ne dans un polyn�me.
	 * @param e
	 * Position de l'exposant.
	 * @throws IllegalArgumentException
	 * Si exposant e est sup�rieur � DEGRE_MAX.
	 */
	public Monome getMonome(int e) throws IllegalArgumentException{
		if((e > coefficients.length) ||(e < 0)){
			throw new IllegalArgumentException("Invalide");
		}
		return new Monome(this.coefficients[e], e);
	}
	
	/**
	 * R�cup�re un nouveau mon�me qui est la d�riv�e.
	 * @return poly
	 * Retourne un mon�me qui correspond � la d�riv�e du mon�me.
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
	 * R�cup�re un nouveau mon�me qui est le produit.
	 * @param m
	 * Mon�me qui va �tre additionn� � notre mon�me actuel.
	 * @return poly
	 * Retourne un mon�me qui correspond au produit de m et du mon�me actuel.
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
