import java.awt.Graphics;

public class Rectangle extends Figure {

	public Rectangle(Point p1, Point p2) {
		super(p1, p2);
	}

	public int largeur() {
		return Math.abs(getP2().getX() - getP1().getX());
	}

	public int hauteur() {
		return Math.abs(getP2().getY() - getP1().getY());
	}

	public double perimetre() {
		return (2 * (this.largeur() + this.hauteur()));
	}

	public double surface() {
		return (this.largeur() * this.hauteur());
	}
	
	public void tracer(Graphics g){
		g.drawRect(getP1().getX(), getP2().getY(), largeur(), hauteur());
	}
}
