/**
 * 
 */
package fr.barde.tp2;

/**
 * @author Alexandre
 * 8 mars 2017:09:55:23
 */
public class MainPolynome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Polynome un = new Polynome();
		Polynome deux = new Polynome();
		
		Monome premier = new Monome(1.0F, 1);
		Monome deuxieme = new Monome(3.0F, 2);
		
		un.setMonome(premier);
		un.setMonome(deuxieme);
		
		deux.setMonome(premier);
		deux.setMonome(deuxieme);
		
		System.out.print("Un : ");
		System.out.println(un);
		System.out.print("Deux : ");
		System.out.println(deux);
		
		System.out.print("Dérivée : ");
		Polynome derivee = un.derivee();
		System.out.println(derivee);
	
		Polynome somme = deux.somme(un);
		System.out.print("Somme : ");
		System.out.println(somme);
	

	}

}
