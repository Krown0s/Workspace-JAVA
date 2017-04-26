package fr.barde.partiel;

public class Rationnel {

	private long numerateur, denominateur;

	public Rationnel(long n, long d) throws IllegalArgumentException {
		if (d == 0) {
			throw new IllegalArgumentException("Valeur invalide");
		}
		this.numerateur = n;
		this.denominateur = d;
	}

	public long getNumerateur() {
		return this.numerateur;
	}

	public long getDenominateur() {
		return this.denominateur;
	}

	public Rationnel reduction() {
		return (new Rationnel(this.getNumerateur() / pgcd(this.getNumerateur(), this.getDenominateur()),
				this.getDenominateur() / pgcd(this.getNumerateur(), this.getDenominateur())));
	}

	public Rationnel somme(Rationnel r) {
		return (new Rationnel(this.numerateur * r.getDenominateur() + r.getNumerateur() * this.getDenominateur(),
				this.getDenominateur() * r.getDenominateur()));
	}

	public Rationnel produit(Rationnel r) {
		return (new Rationnel(this.getNumerateur() * r.getNumerateur(), this.getDenominateur() * r.getDenominateur()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (denominateur ^ (denominateur >>> 32));
		result = prime * result + (int) (numerateur ^ (numerateur >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rationnel other = (Rationnel) obj;
		if (denominateur != other.denominateur)
			return false;
		if (numerateur != other.numerateur)
			return false;
		Rationnel r = (Rationnel) obj;	
		return(((this.reduction().getNumerateur() == r.reduction().getNumerateur()) && (this.reduction().getDenominateur() == r.reduction().getDenominateur())));
	}

	private static long pgcd(long a, long b) {
		if (a == b) {
			return a;
		}
		if (a < b) {
			return pgcd(a, b - a);
		}
		return pgcd(a - b, b);
	}

	@Override
	public String toString() {
		return this.reduction().getNumerateur() + "/" + this.reduction().getDenominateur();
	}

}
