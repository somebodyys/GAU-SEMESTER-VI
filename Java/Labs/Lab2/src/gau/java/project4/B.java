package gau.java.project4;

public class B {

    private int x;

    // კონსტრუქტორი ცარიელია
    public B() {}

    // ახდენს x ცვლადის ინიციალიზაციას
    public B(int x) {
        this.x = x;
    }

    /*
    ადგენს x-ის მნიშვნელობა მოთავსებულია თუ არა [5; 24] შუალედში
     */
    public boolean method1(){
        return this.x >= 5 && this.x <= 24;
    }
}
