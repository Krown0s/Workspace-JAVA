import java.util.Scanner;
public class Main_UnMonome {
	public static void main(String[] args) {

		Monome m1 = new Monome (0.0f, 0);
		Monome m2 = new Monome (0.0f, 0);
		int choix;
		Scanner sc = new Scanner(System.in);

		do{
			// affichage du menu
			System.out.println("Quel est votre choix :");
			System.out.println("    1- modifier le premier monome");
			System.out.println("    2- modifier le deuxiéme monome");
			System.out.println("    3- afficher le premier monome");
			System.out.println("    4- afficher le deuxiéme monome");
			System.out.println("    5- calculer la somme de 2 monomes");
			System.out.println("    6- calculer le produit de 2 monomes");
			System.out.println("    7- calculer la dérivée du premier monome");
			System.out.println("    8- calculer la dérivée du deuxiéme monome");
			System.out.println("    9- quitter l'application");
			// saisie du choix
			choix = sc.nextInt();
			switch (choix) {
			case 1 : 
				System.out.println("Choisissez le coef");
				float c = sc.nextFloat();
				m1.setCoefficient(c);
				System.out.println("Choisissez l'exposant");
				int e = sc.nextInt();
				m1.setExposant(e);
				break;
			case 2 : 
				System.out.println("Choisissez le coef");
				float c2 = sc.nextFloat();
				m2.setCoefficient(c2);
				System.out.println("Choisissez l'exposant");
				int e2 = sc.nextInt();
				m2.setExposant(e2);
				break;
			case 3 : 
				System.out.println(m1);
				break;
			case 4 : 
				System.out.println(m2);
				break;
			case 5 : 
				System.out.println(m1.somme(m2));
				break;
			case 6 : 
				System.out.println(m1.produit(m2));
				break;
			case 7 : 
				System.out.println(m1.derivee());
				break;
			case 8 : 
				System.out.println(m2.derivee());
				break;
			case 9 : 
				break;
			default:
				System.out.println("Saisie incorrecte");
			}
		}
		while (choix != 9);
		sc.close();
	}
}
