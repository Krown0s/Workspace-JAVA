/**
 * 
 */

/**
 * @author Alexandre
 * TODO
 * 22 févr. 2017:09:47:10
 */
public class Couleur {

	
	private int rouge, vert, bleu;
	public static final Couleur ROUGE = new Couleur(255, 0, 0);
	public static final Couleur VERT = new Couleur(0, 255, 0);
	public static final Couleur BLEU = new Couleur(0, 0, 255);
	
	
	/**
	 * @param rouge
	 * @param vert
	 * @param bleu
	 */
	public Couleur(int rouge, int vert, int bleu) {
		super();
		this.setRouge(rouge);
		this.setVert(vert);
		this.setBleu(bleu);		
	}
	
	

	/**
	 * @return the rouge
	 */
	public int getRouge() {
		return this.rouge;
	}



	/**
	 * @param rouge the rouge to set
	 */
	public void setRouge(int rouge) throws IllegalArgumentException {
		if((rouge < 0) || (rouge > 255)){
			throw new IllegalArgumentException("Couleur rouge indélicate.");
		}
		this.rouge = rouge;
	}



	/**
	 * @return the vert
	 */
	public int getVert() {
		return this.vert;
	}



	/**
	 * @param vert the vert to set
	 */
	public void setVert(int vert) throws IllegalArgumentException{
		if((vert < 0) || (vert > 255)){
			throw new IllegalArgumentException("Couleur verte indélicate.");
		}
		this.vert = vert;
	}



	/**
	 * @return the bleu
	 */
	public int getBleu() {
		return this.bleu;
	}



	/**
	 * @param bleu the bleu to set
	 */
	public void setBleu(int bleu) throws IllegalArgumentException{
		if((bleu < 0) || (bleu > 255)){
			throw new IllegalArgumentException("Couleur bleu indélicate.");
		}
		this.bleu = bleu;
	}


	public int valeurRVB(){
		return (256*256*this.getRouge()) + (256*this.getVert()*256) + (this.getBleu()*256*256);
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Couleur [rouge=" + this.rouge + ", vert=" + this.vert + ", bleu=" + this.bleu + "]";
	}
		
}
