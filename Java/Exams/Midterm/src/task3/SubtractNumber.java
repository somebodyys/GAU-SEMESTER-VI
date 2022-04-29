package task3;

import java.io.IOException;
import java.util.Random;


public class SubtractNumber implements Runnable{

    /**
     * განსაზღვრეთ კლასი SubtractNumber, PrimaryNumber ცვლადით.
     */
    private final PrimaryNumber primaryNumber;

    /**
     * დაწერეთ
     * SubtractNumber კონსტრუქტორი, რომელიც უზრუნველყოფს PrimeryNumber
     * ცვლადის ინიციალიზაციას.
     */
    public SubtractNumber(PrimaryNumber primaryNumber) {
        this.primaryNumber = primaryNumber;
    }

    /**
     * დაწერეთ მეთოდი, რომელიც PrimeryNumber ობიექტის number ცვლადს
     * ამცირებს შემთხვევითი რიცხვით [50; 60] შუალედიდან, იმ შემთხვევაში თუ
     * number ცვლადის მნიშვნელობა მეტია ან ტოლი 60-ის.
     */
    public void method2() throws IOException {
        Random random = new Random();
        int currentNumber = this.primaryNumber.getNumber();
        if( currentNumber >= 60){
            this.primaryNumber.setNumber(
                    currentNumber - random.nextInt(50, 60)
            );
        }
    }

    /**
     * გამოიძახეთ მისი მეთოდი 5-ჯერ
     */
    @Override
    public void run(){
        try {
            for (int i = 0; i < 5; i++)
                method2();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
