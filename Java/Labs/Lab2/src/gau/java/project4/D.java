package gau.java.project4;

public class D {

    private int x;
    private int y;

    public D() {
        System.out.println("Hello My Class");
    }

    public int method1(){
        if(this.x > 0)
            return 4 * this.x - this.y;

        return 2 * this.x + this.y;
    }
}
