package gau.java.project5.task2;

public class B extends A{

    public B(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int childMethod1(){
        return this.y - this.x;
    }

    public int childMethod2(){
        return this.x + 2 * this.y;
    }
}


