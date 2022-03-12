package gau.java.project3;

public class B {

    private int n;
    private int y;

    public long method1(){
        return 2L * this.n * this.n + 1;
    }

    public long method2(){
        return 3L * (long)Math.pow(this.y, 3) - (long)this.n * this.n;
    }
}