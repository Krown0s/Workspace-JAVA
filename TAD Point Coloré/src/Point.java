/**
 * @author Alexandre
 * TODO
 * 1 mars 2017:10:45:01
 */
public class Point {

	protected double abscisse;
	protected double ordonnee;

	/**
	 * 
	 */
	public Point() {
		super();
	}

	public void translater(double a, double o) {
		this.abscisse += a;
		this.ordonnee += o;
	}

	public void mettreAEchelle(int h) throws IllegalArgumentException {	
		if(h < 0){
			throw new IllegalArgumentException("Valeur trop élevée.");
		}else{
			this.abscisse *= h;
			this.ordonnee *= h;
		}
	}

}