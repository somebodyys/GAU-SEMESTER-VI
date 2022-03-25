package gau.java.task2;

public class A {
    protected int x;

    // ანიჭებს და ბეჭდავს x ცვლადის მნიშვნელობას
    public A(int x) {
        this.x = x;
        System.out.println(this.x);
    }

    // ადგენს x ცვლადი ლუწია თუ კენტი
    public byte method1(){
        return (byte) (this.x % 2);
    }
}
