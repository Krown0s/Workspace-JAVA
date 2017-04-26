package fr.barde.partiel;

public class Main {

	public static void main(String[] args) {	

		long a = 2L;
		Rationnel u = new Rationnel(1, 2);
		Rationnel unDemi = new Rationnel(1, 2);
		for(int i = 1; i < 5; i++){
			long n = a * u.getDenominateur();
			long d = u.getNumerateur();
			Rationnel v = new Rationnel(n, d);
			u = unDemi.produit(u.somme(v));
		}
		System.out.println("Valeur approch�e de racine carr� de " + a + " = " + u);
		double racine = (double) (u.getNumerateur()) / (double) (u.getDenominateur());
		System.out.println("Valeur approche� de racine carr� de " + a + " = " + racine);
		
	}

}
