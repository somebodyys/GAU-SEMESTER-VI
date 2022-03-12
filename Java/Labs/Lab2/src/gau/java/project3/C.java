package gau.java.project3;

public class C {

    private double a;
    private double b;

    public double method1(){
        return ((4 * this.a * this.a) / this.b) - 1;
    }

    public double method2(){
        return ((3 * Math.pow(this.a, 3)) / 2) - this.b * this.b;
    }
}
