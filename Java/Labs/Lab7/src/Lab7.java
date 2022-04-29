import java.util.Scanner;

public class Lab7 {

    /**
     * ნატურალურ რიცხვს ეწოდება პოლიდრომი, თუ ამ რიცხვში ციფრების შებრუნებული რიგით ჩაწერის
     * შემდეგ რიცხვის სიდიდე არ შეიცვლება. მაგ 121, 13431 და ა.შ. აჩვენეთ შეტანილი ნატურალური
     * რიცხვი არის თუ არა პოლიდრომი.
     */
    public static boolean method1(){
        int number, storage, checkNumber = 0;
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        storage = number;

        while(number > 0) {
            int lastDigit = number % 10;
            checkNumber = (checkNumber * 10) + lastDigit;
            number /= 10;
        }

        return checkNumber == storage;
    }

    /**
     * შეიტანეთ ხუთი მთელი რიცხვი. თუ რიცხვებიდან რომელიმე სამი არ უდრის ერთმანეთს, დაბეჭდეთ
     * შეტყობინება „NO“, ხოლო თუ რომელიმე სამი ერთმანეთის ტოლია, მაშინ დაბეჭდეთ დანარჩენი ორის
     * შეტანის რიგი. (ანუ მერამდენე რიცხვად მოხდა შეტანა).
     */
    public static void method2(){

    }
}
