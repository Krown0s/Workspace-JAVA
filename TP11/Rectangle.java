public class Rectangle {

	private Point p1;
	private Point p2;

	public Rectangle(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Point getP1() {
		return p1;
	}

	public Point getP2() {
		return p2;
	}

	public int largeur() {
		return Math.abs(this.p2.getX() - this.p1.getX());
	}

	public int hauteur() {
		return Math.abs(this.p2.getY() - this.p1.getY());
	}

	public double perimetre() {
		return (2 * (this.largeur() + this.hauteur()));
	}

	public double surface() {
		return (this.largeur() * this.hauteur());
	}
}
