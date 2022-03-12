package gau.java.project4;

public class C {

    private int a;
    private int b;
    private int x;

    public C() {}

    public C(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public boolean method1(){
        return this.a == this.b;
    }

    public boolean method2(){
        return this.x > Math.min(this.a, this.b) && this.x < Math.max(this.a, this.b);
    }
}
