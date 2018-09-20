package nine_exer;

public class Main {

    public static void main(String[] args) {
        I i = new A();
        C c = new A();
        B b = new A();
        A a = new A();
        System.out.println(a.ab+" " +a.b + " " +  a.bc + " " + a.c + a.i  );
        //System.out.println(b.ab+" " +b.b + " " +  b.bc + " " + b.c + b.i  );
        a.doSomething();
        b.doSomething();
        c.doSomething();

        int you =0;
        System.out.println(you);
        int fag = 78;
        System.out.println(fag);
        int cin = fag = you;
        System.out.println(you + " " + fag + " " + cin);
	// write your code here
    }
}
