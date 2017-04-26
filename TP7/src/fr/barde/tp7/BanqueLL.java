package fr.barde.tp7;

import java.util.LinkedList;
import java.util.List;

public class BanqueLL {
    /**
     * libellé de la banque
     */
    private String libelle;

    /**
     * ensemble des comptes de la banque
     */
    LinkedList<CompteBancaire> comptes;

    /**
     * construit une banque vide
     * 
     * @param libellé
     *            de la banque
     */
    public BanqueLL(String libelle) {
        this.libelle = libelle;
        this.comptes = new LinkedList<CompteBancaire>();
    }

    /**
     * renvoie le libellé d'une banque
     * 
     * @return libellé
     */
    public String getLibellé() {
        return this.libelle;
    }

    /**
     * renvoie le compte d'une banque de numéro donné
     * 
     * @param numéro
     *            numéro du compte recherché
     * @return compte bancaire ou null s'il n'existe pas
     */
    private CompteBancaire getCompte(String numéro) {
    	for(CompteBancaire cb : this.comptes){
    		if(cb.getNumero().equals(numéro)) return cb;
    	}
    	return null;
    }

    /**
     * ouvre un compte dans une banque
     * 
     * @param numéro
     *            numéro du compte bancaire à ouvrir
     * @param valeur
     *            d'initialisation du compte
     * @throws IllegalArgumentException
     *             s'il n'y a déjà un compte associé à ce numéro
     */
    public void ouvrir(String numéro, float valeur) throws IllegalArgumentException{
        if(this.estCompteExistant(numéro)){
        	throw new IllegalArgumentException("Ce compte existe déjà.");
        }
        CompteBancaire cb = new CompteBancaire(numéro);
        cb.deposer(valeur);
        this.comptes.add(cb);
    }

    /**
     * dépose une valeur sur un compte de la banque
     * 
     * @param numéro
     *            du compte à créditer
     * @param valeur
     *            valeur à créditer
     * @throws IllegalArgumentException
     *             s'il n'y a pas de compte associé à ce numéro
     */
    public void déposer(String numéro, float valeur) throws IllegalArgumentException {
        if(!estCompteExistant(numéro)){
        	throw new IllegalArgumentException("Compte inexistant.");
        }
        this.getCompte(numéro).deposer(valeur);
    }

    /**
     * retire une valeur sur un compte de la banque
     * 
     * @param numéro
     *            du compte à débiter
     * @param valeur
     *            valeur à créditer
     * @throws IllegalArgumentException
     *             s'il n'y a pas de compte associé à ce numéro
     */
    public void retirer(String numéro, float valeur) throws IllegalArgumentException{
        if(!estCompteExistant(numéro)){
        	throw new IllegalArgumentException("Compte inexistant.");
        }
        this.getCompte(numéro).retirer(valeur);
    }

    /**
     * renvoie le solde d'une banque
     * 
     * @return solde
     */
    public float solde() {
        float solde = 0.0F;
        for(CompteBancaire cb : this.comptes){
        	solde += cb.getSolde();
        }
        return solde;
    }

    /**
     * ferme un compte de la banque
     * 
     * @param numéro
     *            du compte à fermer
     * @throws IllegalArgumentException
     *             s'il n'y a pas de compte associé à ce numéro
     * @throws IllegalArgumentException
     *             si le compte à fermer n'est pas vide
     */
    public void fermer(String numéro) {
        if(!estCompteExistant(numéro)){
        	throw new IllegalArgumentException("Compte inexistant.");
        }
        if(this.getCompte(numéro).getSolde() != 0){
        	throw new IllegalArgumentException("Compte non vide.");
        }
        this.comptes.remove(this.getCompte(numéro));
    }

    /**
     * affiche la liste de comptes dont le solde est négatif
     */
    public void afficherComptesDébiteurs() {
        System.out.println("Liste des comptes débiteurs");
        for(CompteBancaire cb : this.comptes){
        	if(cb.getSolde() < 0.0F){
        		System.out.println(cb);
        	}
        }
    }

    /**
     * vérifie si un compte appartient à la banque
     * 
     * @param numéro
     *            numéro du compte bancaire
     * @return true si le compte existe et false sinon
     */
    boolean estCompteExistant(String numéro) {
    	return this.getCompte(numéro) != null;
    }

    @Override
    public String toString() {
        String ch = "Banque :" + this.libelle;
        for(CompteBancaire cb : this.comptes){
        	ch += "\n" + cb;
        }
        return ch;
    }

}
