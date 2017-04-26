package fr.barde.tp13;

public class DureeEnSecondes implements Duree {
	private int secondes;

	public DureeEnSecondes(int heures, int minutes, int secondes) throws IllegalArgumentException {

		if (heures < 0) {

			throw new IllegalArgumentException("Heures invalides");
		}

		if (minutes < 0 || minutes > 59) {
			throw new IllegalArgumentException("Minutes invalides");

		}

		if (secondes < 0 || secondes > 59) {
			throw new IllegalArgumentException("Secondes invalides");

		}
		this.secondes = this.versSecondes(heures, minutes, secondes);

	}

	private int versSecondes(int h, int m, int s) {
		return h * 3600 + m * 60 + s;

	}

	public int getHeures() {

		return this.secondes / 3600;
	}

	public int getMinutes() {
		return (this.secondes % 3600) / 60;

	}

	public int getSecondes() {
		return this.secondes % 60;

	}

	public void ajouterUneSeconde() {
		this.secondes++;

	}

	@Override

	public boolean equals(Object obj) {
		if (obj == null)

			return false;
		if (this == obj)

			return true;

		if (!(obj instanceof DureeEnSecondes))
			return false;

		DureeEnSecondes d = (DureeEnSecondes) obj;
		return (this.secondes == d.secondes);

	}

	@Override

	public int hashCode() {
		return this.secondes;

	}

	@Override
	public String toString() {

		return this.getHeures() + ":" + this.getMinutes() + ":" + this.getSecondes();

	}

	@Override
	public int compareTo(Duree d) {
		return this.getSecondes() - d.getSecondes();
	}
}
