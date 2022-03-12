package gau.java.project4;

public class F {

    private float x;
    private float y;

    public F() {}

    public F(float x) {
        this.x = x;
    }

    public F(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float method1(){
        return gcd(this.x, this.y);
    }

    private float gcd(float x, float y){
        if(x < y)
            return gcd(y, x);

        if(Math.abs(y) < 0.001)
            return x;

        return (gcd(y, (float)(x - Math.floor( x / y) * y)));
    }

    public float method2(){
        return this.x * this.y / gcd(this.x, this.y);
    }
}

