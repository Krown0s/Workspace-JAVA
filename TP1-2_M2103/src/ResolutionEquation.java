import java.util.Scanner;

public class ResolutionEquation {

	public static void main(String[] args) { //Main

		int a = 0, b, c; //Décalaration des coefficients
		double sol1, sol2; //Déclatation des solutions
		
		Scanner sc = new Scanner(System.in); //Création d'une nouvelle instance Scanner
			
		while(a == 0){ //Pour ne pas avoir une division par zéro
			System.out.println("Coefficient a :");
			a = sc.nextInt(); //On envoie le message nextInt à l'objet sc
							  //Permet de récupérer le prochain entier qui va être rentrer au clavier
		}
		
		System.out.println("Coefficient b :");
		b = sc.nextInt();
		
		System.out.println("Coefficient c :");
		c = sc.nextInt();
		
		double discriminant = ((Math.pow(b, 2))-(4*a*c)); //Calcul du discriminant
														  //Math.pow => Puissance(Chiffre, exposant)
		
		if(discriminant > 0){
			sol1 = (-b+Math.sqrt(discriminant))/(2*a); //Math.sqrt => RacineCarrée(chiffre)
			sol2 = (-b-Math.sqrt(discriminant))/(2*a);			
			System.out.println("Résolution de l'équation : " + a + "x^2 + " + b + "x + " + c + " = 0");
			System.out.println("Discriminant : " + discriminant);
			System.out.println("2 solutions : " + sol1 + " et " + sol2);
		}else if(discriminant == 0){
			sol1 = (-b/(2*a));
			System.out.println("Résolution de l'équation : " + a + "x^2 + " + b + "x + " + c + " = 0");
			System.out.println("Discriminant : " + discriminant);
			System.out.println("1 solution : " + sol1);
		}else if(discriminant < 0){
			System.out.println("Résolution de l'équation : " + a + "x^2 + " + b + "x + " + c + " = 0");
			System.out.println("Discriminant : " + discriminant);
			System.out.println("Aucune solution réelle");
		}
		
		sc.close(); //On envoie le message close à l'objet sc
					//Permet de fermer le Scanner

	}

}
