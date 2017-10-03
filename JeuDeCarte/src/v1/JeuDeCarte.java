package v1;

public class JeuDeCarte
{

    public static final int NB_CARTES = Couleur.values().length * Valeur.values().length;
    private Carte[] jeu;
    private int nbCartes; //Nombre de cartes dans le paquet

    /**
     * Construit 1 paquet de cartes
     */
    public JeuDeCarte()
    {
        this.nbCartes = 0;
        this.jeu = new Carte[JeuDeCarte.NB_CARTES];
        for(Couleur c : Couleur.values())
        {
            for(Valeur v : Valeur.values())
            {
                this.jeu[this.nbCartes] = new Carte(v, c);
                this.nbCartes ++;
            }
        }
    }

    public Carte getPremiereCarte() throws PaquetVideException
    {
        if(this.nbCartes <= 0)
        {
            throw new PaquetVideException();
        }
    }

}
