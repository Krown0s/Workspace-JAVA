package fr.barde.tp13;

public interface Duree extends Comparable <Duree>{

	abstract int getSecondes();
	abstract int getMinutes();
	abstract int getHeures();
	abstract void ajouterUneSeconde();	
}
