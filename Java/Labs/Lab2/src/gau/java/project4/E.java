package gau.java.project4;

public class E {

    private float x;
    private float y;

    public E() {}

    public E(float x) {
        this.x = x;
    }

    public float method1(){
        if(this.y != 0)
            return this.x / this.y + this.x * this.y;

        if(this.x >= 0)
            return (float)Math.pow(this.x, 4) + y;

        return -1;
    }

    public float method2(){
        return Math.min(this.x, this.y);
    }
}
