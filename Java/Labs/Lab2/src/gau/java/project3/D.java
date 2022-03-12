package gau.java.project3;

public class D {

    private double a;
    private double b;
    private double z;

    public double method1(){
        return (this.a + Math.pow(this.b, 3) - 7)/(this.z + 8);
    }

    public double method2(){
        return (this.a + this.z - Math.pow(this.b, 3))/(this.a * this.b * this.z);
    }

    public double method3(){
        return (this.a * this.z - this.b)/(this.b * this.z);
    }
}
