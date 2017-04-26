
public class Monome {
	private float coefficient;
	private int exposant;
	
	public Monome(float c, int e) throws IllegalArgumentException{
		if (e<0){
			throw new IllegalArgumentException("Exposant invalide");
		}
		this.coefficient=c;
		this.exposant=e;
	}
//----------------GETTER---------------------
	public float getCoefficient() {
		return this.coefficient;
	}

	public int getExposant() {
		return this.exposant;
	}
//---------------SETTERs----------------------
	public void setCoefficient(float c) {
		this.coefficient = c;
	}

	public void setExposant(int e) {
		this.exposant = e;
	}
//------------------SOMME---------------------
	public Monome somme(Monome m2) throws IllegalArgumentException{
		if (this.getExposant() != m2.getExposant()){
			throw new IllegalArgumentException("Exposants invalides");
		}
		return(new Monome(this.getCoefficient()+m2.getCoefficient(),this.exposant));
	}
//--------------------PRODUIT---------------------------
	public Monome produit(Monome m2){
		return(new Monome(this.getCoefficient()*m2.getCoefficient(),this.getExposant()+m2.getExposant()));
	}
//---------------------DERIVEE-----------------------------
	public Monome derivee(){
		if(this.getExposant()==0){
			Monome resultat = new Monome(0.0F,0);
			return(resultat);
		}
		else{
			return(new Monome(this.getCoefficient()*this.getExposant(),this.getExposant()-1));
		}
	}
//--------------------estNul------------------------
	public boolean estNul(){
		return(this.getCoefficient()==0.0F);
	}
	
	@Override
	public String toString() {
		if (this.estNul()) {
			return "0";
		}
		String resultat = "";
		if (this.getCoefficient() < 0.0F) {
			resultat += " - ";
			if ((this.getCoefficient() != -1.0F)
					|| (this.getCoefficient() == -1.0F
					&& this.getExposant() == 0)) {
				resultat += (-this.getCoefficient());
			}
		} else {
			resultat += " + ";
			if ((this.getCoefficient() != 1.0F)
					|| (this.getCoefficient() == 1.0F
					&& this.getExposant() == 0)) {
				resultat += this.getCoefficient();
			}
		}
		if (this.getExposant() == 0) {
			return resultat;
		}
		resultat += "x";
		if (this.getExposant() != 1) {
			resultat += "e" + this.getExposant();
		}
		return resultat;
	}
	
}