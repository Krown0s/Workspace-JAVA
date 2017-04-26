import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Figure> listeFigure = new ArrayList<Figure>();

		
		Point p1 = new Point(60, 20);
		Point p2 = new Point(150, 200);
		Point p3 = new Point(90, 21);
		Point p4 = new Point(12, 110);
		Rectangle r = new Rectangle(p1, p2);
		Cercle c = new Cercle(p3, p4);
		
		listeFigure.add(r);
		listeFigure.add(c);

		FenetreFigures f = new FenetreFigures(listeFigure);
		
	}

}
