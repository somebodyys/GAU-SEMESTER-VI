package gau.java.project5.task2;

public class C extends B {

    private double z;

    public C(int x, int y) {
        super(x, y);
    }

    // გვიბრუნებს x, y, z ცვლადების საშუალო არითმეტიკულს
    public double thirdChildMethod1() {
        return (this.x + this.y + this.z) / 3;
    }

    //გვიბრუნებს x, y, z ცვლადების საშუალო გეომეტრიულს
    public double thirdChildMethod2() {
        return Math.pow(this.x * this.y * this.z, 1 / 3F);
    }

    // გვიბრუნებს x, y, z ცვლადებს შორის მაქსიმალურს
    public double thirdChildMethod3() {
        double max = this.x;
        if (this.y > max) max = this.y;
        if (this.z > max) max = this.z;

        return max;
    }

}
