/**
 * 
 */

/**
 * @author Alexandre
 * TODO
 * 22 févr. 2017:10:10:40
 */
public class TestCouleur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Couleur c1 = new Couleur(255, 0 ,0);
		Couleur c2 = new Couleur(0, 0, 255);
		System.out.println(c1);
		System.out.println("La valeur RVB de c1 est " + c1.valeurRVB());
		System.out.println(c2);
		System.out.println("La valeur RVB de c2 est " + c2.valeurRVB());
		

	}

}
