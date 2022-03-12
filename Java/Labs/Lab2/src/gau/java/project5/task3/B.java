package gau.java.project5.task3;

public class B extends A{

    public int childMethod1(){
        return (this.y - this.x) / 3;
    }

    public int childMethod2(){
        return (this.x * this.x + 2 * this.y) / 5;
    }

    public void childMethod3(){
        System.out.println(this.x);
    }
}
