package tp10;

public class PileBornee_Solution {
    private final int MAX_SIZE;
    private int size;
    private Cellule top;

    public PileBornee_Solution(int n) {
        this.MAX_SIZE = n;
        this.size = 0;
        this.top = null;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(int valeur) {
        if (this.size < this.MAX_SIZE) {
            Cellule top = new Cellule(valeur, this.top);
            this.top = top;
            this.size += 1;
        }
    }

    public int getMaxSize() {
        return this.MAX_SIZE;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isFull() {
        return this.size == this.MAX_SIZE;
    }

    public int top() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException("La pile est vide, top impossible");
        }
        return top.valeur;
    }

    public void pop() throws EmptyStackException {
        if (!this.isEmpty()) {
            this.top = top.suivant;
            this.size -= 1;
        }else{
        	throw new EmptyStackException("Nope");
        }
    }

    private class Cellule {
        public int valeur;
        public Cellule suivant;

        public Cellule(int valeur, Cellule suivant) {
            this.valeur = valeur;
            this.suivant = suivant;
        }
    }

    @Override
    public String toString() {
        String result = "PileBornee [maxSize = " + this.MAX_SIZE + ", size = "
                + this.size + ", elements = ";
        Cellule enCours = top;
        while (enCours != null) {
            result += enCours.valeur + " ";
            enCours = enCours.suivant;
        }
        result += ']';
        return result;
    }

}
