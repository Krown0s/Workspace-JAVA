package tp10;

public class ClientPileBornee {

    public static void main(String[] args) throws EmptyStackException {
        PileBornee_Solution p = new PileBornee_Solution(3);
        System.out.println(p);
        p.push(11);
        System.out.println(p);
        p.push(22);
        System.out.println(p);
        p.push(33);
        System.out.println(p);
        p.push(44);
        System.out.println(p);
        p.pop();
        System.out.println(p);
    }

}
