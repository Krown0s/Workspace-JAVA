package v1;

public class Carte
{

    private Couleur c;
    private Valeur v;

    public Carte(Valeur v, Couleur c)
    {
        this.v = v;
        this.c = c;
    }

    public Couleur getCouleur()
    {
        return this.c;
    }

    public Valeur getValeur()
    {
        return this.v;
    }

    public String toString()
    {
        return this.getValeur() + " DE " + this.getCouleur();
    }

}
