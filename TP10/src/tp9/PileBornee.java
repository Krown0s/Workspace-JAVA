package tp9;

import java.util.Arrays;

public class PileBornee {
    private final int MAX_SIZE;
    private int size;
    private int [] top;

    public PileBornee(int n) {
        this.MAX_SIZE = n;
        this.size = 0;
        this.top = new int [n];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(int valeur) {
        this.top[this.size] = valeur;
        this.size += 1;
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
        return this.top[size-1];
    }

    public void pop() {
        this.size -= 1;
     }

    @Override
	public String toString() {
		return "PileBornee [MAX_SIZE=" + MAX_SIZE + ", size=" + size + ", top="
				+ Arrays.toString(top) + "]";
	}
}
