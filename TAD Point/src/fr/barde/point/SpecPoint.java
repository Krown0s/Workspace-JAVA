/**
 * 
 */
package fr.barde.point;

/**
 * @author Alexandre
 * TODO
 * 10 févr. 2017:16:49:23
 */
public interface SpecPoint {

	public void PointOrigine();
	
	public Point Point(float a, float o); //pas de constructeur dans l'interface.
	
	public float abscisse (Point p);
	
	public float ordonnée (Point p);
	
	public Point translater (Point p, float a, float o);
	
	public Point mettreAEchelle (Point o, float x) throws IllegalArgumentException;
	
	
	
}
