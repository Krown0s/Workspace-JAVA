
public class MainPoly {

	public static void main(String[] args) {

		Polynome poly = new Polynome();
		Monome mon1 = new Monome(0.0F, 1);
		Monome mon2 = new Monome(1.0F, 1);
		Monome mon3 = new Monome(2.0F, 2);
		
		Polynome poly2 = new Polynome();
		Monome mon_1 = new Monome(0.0F, 1);
		Monome mon_2 = new Monome(1.0F, 1);
		Monome mon_3 = new Monome(2.0F, 2);
		
		poly.setMonome(mon1);
		poly.setMonome(mon2);
		poly.setMonome(mon3);
		
		poly2.setMonome(mon_1);
		poly2.setMonome(mon_2);
		poly2.setMonome(mon_3);
		
		System.out.print("Poly 1: ");
		System.out.println(poly);
		
		System.out.print("Poly 2: ");
		System.out.println(poly2);
		

		System.out.print("Somme: ");
		System.out.println(poly.somme(poly2));
		
		System.out.print("Dérivée: ");
		System.out.println(poly.derivee());
		
		

	}

}
