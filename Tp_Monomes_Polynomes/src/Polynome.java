public class Polynome {
	/**
	 * Degrés maximum du polynôme
	 */
	public static final int DEGRE_MAX = 99;
	/**
	 * Tableau contenant les monômes
	 */
	private Float[] coefficient;

	/**
	 * crée 1 poynôme nul
	 */
	public Polynome() {
		this.coefficient = new Float[Polynome.DEGRE_MAX + 1];
		/**
		 * Crée le tableau de coefficients
		 */
		for (int i = 0; i < coefficient.length; i++) {
			this.coefficient[i] = 0.0f;

		}
	}

	/**
	 * Positionne un nouveau monôme dans un polynôme
	 * 
	 * @param m
	 *            monôme à positionner dans le polynôme
	 * @throws IllegalArgumentException
	 *             Si exposant du monome m est supérieur à DEGRE_MAX
	 */
	public void setMonome(Monome m) throws IllegalArgumentException {
		if (m.getExposant() > coefficient.length) {
			throw new IllegalArgumentException("exposant torp grand");
		}
		this.coefficient[m.getExposant()] = m.getCoefficient();
	}

	/**
	 * Positionne un nouveau monôme dans un polynôme
	 * 
	 * @param m
	 *            monôme à positionner dans le polynôme
	 * @throws IllegalArgumentException
	 *             Si exposant du monome m est inférieur à 0
	 */
	public Monome getMonome(int e) throws IllegalArgumentException {
		if (e < 0) {
			throw new IllegalArgumentException("exposant torp grand");
		}
		return new Monome(this.coefficient[e], e);
	}

	/**
	 * 
	 * @return
	 */
	public Polynome derivee() {
		Polynome resultat = new Polynome();
		for (int i = 0; i < coefficient.length; i++) {
			if (this.coefficient[i] == 0) {
				resultat.coefficient[i] = 0.0F;
			} else {
				resultat.setMonome(getMonome(i).derivee());
			}
		}
		return (resultat);
	}

	/**
	 * Calcul la somme de deux polynomes
	 * 
	 * @param p1
	 *            polynome à aditionner
	 */
	public Polynome somme(Polynome p1) {
		Polynome resultat2 = new Polynome();
		for (int i = 0; i < coefficient.length; i++) {
			resultat2.setMonome(this.getMonome(i).somme(p1.getMonome(i)));
		}
		return resultat2;
	}
	
	public Polynome produit(Monome m){
		Polynome poly = new Polynome();
		for(int i = 0; i < coefficient.length; i++){
			if(!this.getMonome(i).estNul()){
				poly.setMonome(this.getMonome(i).produit(m));
			}
		}
		return poly;
	}

	public String toString() {
		String résultat = "";
		for (int i = this.coefficient.length - 2; i >= 0; i--) {
			if (!this.getMonome(i).estNul()) {
				résultat += this.getMonome(i);
			}
		}
		if (résultat.equals("")) {
			return "0";
		}
		if (résultat.charAt(1) == '-') {
			return "-" + résultat.substring(3, résultat.length());
		}
		return résultat.substring(3, résultat.length());
	}

}
