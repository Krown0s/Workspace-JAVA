package tp10;

public class PileBorneeT <T>{
    private final int MAX_SIZE;
    private int size;
    private Cellule top;

    public PileBorneeT(int n) {
        this.MAX_SIZE = n;
        this.size = 0;
        this.top = null;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(T valeur) throws FullStackException {
       if(this.size >= this.MAX_SIZE){
    	   throw new FullStackException("La pile est pleine, push impossible");
       }
	   Cellule top = new Cellule(valeur, this.top);
       this.top = top;
       this.size ++;
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

    public T top() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException("La pile est vide, top impossible");
        }
        return this.top.valeur;
    }

    public void pop() throws EmptyStackException {
        if(!this.isEmpty()){
        	this.top = top.suivant;
        	this.size --;
        }else{
        	throw new EmptyStackException("Nope");
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
    
    private class Cellule{
    	public T valeur;
    	public Cellule suivant;
    	
    	public Cellule(T valeur, Cellule suivant){
    		this.valeur = valeur;
    		this.suivant = suivant;
    	}
    }
}
