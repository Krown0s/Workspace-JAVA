package tp10;

public class Palindrome {

	private String palindrome;
	
	public Palindrome(String palindrome){
		this.palindrome = palindrome;
	}
	
	public boolean estPalindrome(){
		PileBorneeT<Character> inverseur = new PileBorneeT<Character>(this.palindrome.length());
		for(int i = 0; i < this.palindrome.length(); i++){
			try {
				inverseur.push(this.palindrome.charAt(i));
			} catch (FullStackException e) {
				e.printStackTrace();
			}
		}
		String inversee = "";
		while(!inverseur.isEmpty()){
			try {
				inversee += inverseur.top();
				inverseur.pop();
			} catch (EmptyStackException e) {
				e.printStackTrace();
			}
		}
		return this.palindrome.equals(inversee);	
	}
	
	public static void main (String[] args){
		Palindrome radar = new Palindrome("radar");
		Palindrome raddar = new Palindrome("raddar");
		Palindrome nonRadar = new Palindrome("nonraddar");
		System.out.println("radar " + radar.estPalindrome());
		System.out.println("raddar " + raddar.estPalindrome());
		System.out.println("nonraddar " + nonRadar.estPalindrome());
	}
	
}
