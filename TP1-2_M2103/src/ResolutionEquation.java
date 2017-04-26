import java.util.Scanner;

public class ResolutionEquation {

	public static void main(String[] args) { //Main

		int a = 0, b, c; //D�calaration des coefficients
		double sol1, sol2; //D�clatation des solutions
		
		Scanner sc = new Scanner(System.in); //Cr�ation d'une nouvelle instance Scanner
			
		while(a == 0){ //Pour ne pas avoir une division par z�ro
			System.out.println("Coefficient a :");
			a = sc.nextInt(); //On envoie le message nextInt � l'objet sc
							  //Permet de r�cup�rer le prochain entier qui va �tre rentrer au clavier
		}
		
		System.out.println("Coefficient b :");
		b = sc.nextInt();
		
		System.out.println("Coefficient c :");
		c = sc.nextInt();
		
		double discriminant = ((Math.pow(b, 2))-(4*a*c)); //Calcul du discriminant
														  //Math.pow => Puissance(Chiffre, exposant)
		
		if(discriminant > 0){
			sol1 = (-b+Math.sqrt(discriminant))/(2*a); //Math.sqrt => RacineCarr�e(chiffre)
			sol2 = (-b-Math.sqrt(discriminant))/(2*a);			
			System.out.println("R�solution de l'�quation : " + a + "x^2 + " + b + "x + " + c + " = 0");
			System.out.println("Discriminant : " + discriminant);
			System.out.println("2 solutions : " + sol1 + " et " + sol2);
		}else if(discriminant == 0){
			sol1 = (-b/(2*a));
			System.out.println("R�solution de l'�quation : " + a + "x^2 + " + b + "x + " + c + " = 0");
			System.out.println("Discriminant : " + discriminant);
			System.out.println("1 solution : " + sol1);
		}else if(discriminant < 0){
			System.out.println("R�solution de l'�quation : " + a + "x^2 + " + b + "x + " + c + " = 0");
			System.out.println("Discriminant : " + discriminant);
			System.out.println("Aucune solution r�elle");
		}
		
		sc.close(); //On envoie le message close � l'objet sc
					//Permet de fermer le Scanner

	}

}
