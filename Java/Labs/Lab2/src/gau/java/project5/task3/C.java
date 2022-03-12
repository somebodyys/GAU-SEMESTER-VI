package gau.java.project5.task3;

public class C extends B {

    private double z;
    private double r;

    // გვიბრუნებს ყველა ცვლადს შორის მაქსიმალურს
    public double thirdChildMethod1(){
        double max = this.x;
        if(this.y > max) max = this.y;
        if(this.z > max) max = this.z;
        if(this.r > max) max = this.r;

        return max;
    }

    public double thirdChildMethod2(){
        return (this.x * this.x + 2 * this.y)/(this.z - this.r);
    }

    public double thirdChildMethod3(){
        return ((double)(this.y - this.x) / 3) + (this.r / (this.z + 4));
    }
}
