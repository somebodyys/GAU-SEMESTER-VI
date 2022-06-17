package com.example.task2;

public class Player {

    private int balance;

    public Player(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void win(int amount){
        this.balance += amount;
    }

    public void lose(int amount){
        this.balance -= amount;
    }
}
