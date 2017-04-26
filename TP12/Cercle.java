import java.awt.Graphics;

public class Cercle extends Figure{

	public Cercle(Point p1, Point p2) {
		super(p1, p2);
	}

	public double rayon() {
		return Point.distance(getP1(), getP2());
	}

	public double diametre() {
		return (this.rayon() * 2);
	}

	public double perimetre() {
		return (2 * Math.PI * this.rayon());
	}

	public double surface() {
		return (Math.PI * Math.pow(this.rayon(), 2));
	}

	@Override
	void tracer(Graphics g) {
		g.drawOval(getP1().getX(), getP2().getY(), (int)diametre(), (int)diametre());
	}
	
}
