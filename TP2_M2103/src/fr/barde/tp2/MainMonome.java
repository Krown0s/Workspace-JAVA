package fr.barde.tp2;
import java.util.Scanner;

public class MainMonome {
	
		public static void main(String[] args) {

			Monome m1 = new Monome (0.0f, 0);
			Monome m2 = new Monome (0.0f, 0);
			int choix;
			Scanner entree = new Scanner(System.in);

			do{
				// affichage du menu
				System.out.println("Quel est votre choix :");
				System.out.println("    1- modifier le premier monôme"); //done
				System.out.println("    2- modifier le deuxième monôme"); //done
				System.out.println("    3- afficher le premier monôme"); //done
				System.out.println("    4- afficher le deuxième monôme"); //done
				System.out.println("    5- calculer la somme de 2 monômes"); //done
				System.out.println("    6- calculer le produit de 2 monômes"); //done
				System.out.println("    7- calculer la dérivée du premier monôme"); //done
				System.out.println("    8- calculer la dérivée du deuxième monôme"); //done
				System.out.println("    9- quitter l'application"); //done
				// saisie du choix
				choix = entree.nextInt();
				switch (choix) {
				case 1 : 
					System.out.println("Exposant ?");
					m1.setExposant(entree.nextInt());
					System.out.println("Coefficient ?");
					m1.setCoefficient(entree.nextFloat());
					break;
				case 2 : 
					System.out.println("Exposant ?");
					m2.setExposant(entree.nextInt());
					System.out.println("Coefficient ?");
					m2.setCoefficient(entree.nextFloat());
					break;
				case 3 : 
					System.out.println(m1);
					break;
				case 4 : 
					System.out.println(m2);
					break;
				case 5 : 
					m1.somme(m2);
					System.out.println(m1);
					break;
				case 6 : 
					m1.produit(m2);
					System.out.println(m1);
					break;
				case 7 : 
					m1.derivee();
					System.out.println(m1);
					break;
				case 8 : 
					m2.derivee();
					System.out.println(m2);
					break;
				case 9 : 
					break;
				default:
					System.out.println("Valeur invalide.");
				}
			}
			while (choix != 9);
			entree.close();
		}
}



