package gau.java.project4;

public class A {
    private int x;

    // კონსტრუქტორი ბეჭდავს „hello My Class“
    public A() {
        System.out.println("Hello My Class");
    }

    // ადგენს x ლუწია თუ კენტი;
    public String method1(){
        return this.x % 2 == 1 ? "Odd" : "Even";
    }
}
