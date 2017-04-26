package fr.barde.point;

/**
 * @author Alexandre 
 * TODO 
 * 10 f�vr. 2017:16:50:11
 */
public abstract class Point implements SpecPoint{

	private float abscisse, ordonn�e;

	public Point(float a, float b) {
		this.abscisse = a;
		this.ordonn�e = b;
	}	
	
	
	public void PointOrigine(){}

	public float abscisse (Point p){
		return p.abscisse;
	}
	
	public float ordonn�e (Point p){
		return p.ordonn�e;
	}
	
	public Point translater (Point p, float a, float o){
		p = Point(a, o);
		return p;
	}
	
	public Point mettreAEchelle (Point o, float x) throws IllegalArgumentException{
		if (x <= 0){
			throw new IllegalArgumentException("Valeur incorrecte");
		}
		return o;
	}
	
	public String toString(){
		return ("(" + this.abscisse + "; " + this.ordonn�e + ")");
	}

}
