/**
 * 
 */

/**
 * @author Alexandre
 * 24 févr. 2017:09:56:29
 */
public class PointColore extends Point {

	private PointColoreData data = new PointColoreData();
	public static final PointColore POINT_ORIGINE = new PointColore(0.0, 0.0, 0, 0, 0);
	
	/**
	 * @param abscisse
	 * @param ordonnee
	 * @param data.rouge
	 * @param data.vert
	 * @param data.bleu
	 */
	public PointColore(double a, double o, int r, int v, int b) throws IllegalArgumentException{
		super();
		if(((r < 0) || (r > 255)) || ((v < 0) || (v > 255)) || ((b < 0) || (b > 255))){
			throw new IllegalArgumentException("Valeur incorrecte.");
		}else{
			this.abscisse = a;
			this.ordonnee = o;
			this.data.rouge = r;
			this.data.vert = v;
			this.data.bleu = b;
		}
	}

	/**
	 * @return the abscisse
	 */
	public double getAbscisse() {
		return this.abscisse;
	}

	/**
	 * @return the ordonnee
	 */
	public double getOrdonnee() {
		return this.ordonnee;
	}

	/**
	 * @return the rouge
	 */
	public int getRouge() {
		return this.data.rouge;
	}

	/**
	 * @param rouge the rouge to set
	 */
	public void setRouge(int rouge) throws IllegalArgumentException{
		if((rouge >= 0) || (rouge <= 255)){
			this.data.rouge = rouge;
		}else{
			throw new IllegalArgumentException("Erreur valeur.");
		}
	}

	/**
	 * @return the vert
	 */
	public int getVert() {
		return this.data.vert;
	}

	/**
	 * @param vert the vert to set
	 */
	public void setVert(int vert) throws IllegalArgumentException{
		if((data.bleu >= 0) || (data.bleu <= 255)){
			this.data.vert = vert;
		}else{
			throw new IllegalArgumentException("Erreur valeur.");
		}		
	}

	/**
	 * @return the bleu
	 */
	public int getBleu() {
		return this.data.bleu;
	}

	/**
	 * @param bleu the bleu to set
	 */
	public void setBleu(int bleu) throws IllegalArgumentException{
		if((bleu >= 0) || (bleu <= 255)){
			this.data.bleu = bleu;
		}else{
			throw new IllegalArgumentException("Erreur valeur.");
		}
		
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + this.abscisse + "; " + this.ordonnee
				+ ") [" + this.data.rouge + ", " + this.data.vert + ", " + this.data.bleu
				+ "]";
	}
	
	
	
}
