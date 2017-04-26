import java.util.Scanner;


public class AffichageAsterisques {

	public static void main(String[] args) {

		int n = 0;
		Scanner sc = new Scanner(System.in);
		
		while(n == 0){ //Pour éviter un affichage vide
			System.out.println("Valeur de n ?");
			n = sc.nextInt();
		}

		int size = 1;
		for(int i = 0; i < n; i++){ //Hauteur
			for(int i2 = 0; i2 < size; i2++){ //Largeur
				System.out.print("*");
			}		
			System.out.println();
			size++;
		}		
		
		for(int j= 1; j<=n; j++){
			for(int i = 1; i<= n-j; i++){
				System.out.print(" ");
			}
			for(int i = 1; i<=j; i++){
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		sc.close();
	}

}
