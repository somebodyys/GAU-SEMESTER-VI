import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
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
        int[] numbers = new int[5];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            hashMap.put(numbers[i], occurence(numbers, numbers[i]));
        }

        if(!hashMap.containsValue(3))
            System.out.println("NO");
        if(hashMap.containsValue(3))
            System.out.println("YES");
        
    }
    
    private static int occurence(int[] array, int number){
        int counter = 0;
        for (int j : array) {
            if (number == j)
                counter++;
        }
        
        return counter;
    }
    
    /**
     * შეიტანეთ მთელი დადებითი რიცხვი, დაბეჭდეთ რიცხვის შებრუნებული რიგის გაორკეცებული
     * ნამრავლი. გაითვალისწინეთ ბოლოში ნულების არსებობა.
     */
    public static void method3(){
        int number, newNumber = 0, index = 0;
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();

        while(number > 0){
            int lastDigit = number % 10;
            if(lastDigit != 0){
                newNumber = newNumber * 10 + lastDigit;
                index++;
            }
            number /= 10;

        }

        System.out.println(newNumber * 2);
    }

    /**
     * განსაზღვრეთ 6x5 ნამდვილი ტიპის მატრიცა. ელემენტებს მიანიჭეთ შემთხვევითი მნიშვნელობები [a;
     * b](a და b მთელი რიცხვებია). დაალაგეთ კლებადობით მატრიცის პირველი სვეტი, მიღებული პირველი
     * სვეტის შესაბამისად გადაანაცვლეთ სტრიქონები, დაბეჭდეთ თავდაპირველი და მიღებული
     * მატრიცები.
     */
    public static void method4(){
        int [][] matrix = new int[6][5];
        int a, b;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = random.nextInt(a, b);
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n*******\n");
        Arrays.sort(matrix, (x, y) -> Integer.compare(x[0], y[0]));
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * განსაზღვრეთ 100 ელემენტიანი მთელი ტიპის მასივი. ელემენტებს მიანიჭეთ შემთხვევითი
     * მნიშვნელობები [0; 99]-შუალედიდან. დათვალეთ რამდენი ელემენტია მის ინდექსზე მეტი.
     */
    public static void method5(){
        int counter = 0;
        int[] numbers = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            numbers[i] = random.nextInt(0, 99);
            if (numbers[i] > i)
                counter++;
        }

        System.out.println(counter);
    }
}
