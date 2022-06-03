import java.util.*;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    /**
     * ჩაწერეთ კოლექციაშიში ხუთი შემთხვევითი მთელი რიცხვი და დაბეჭდეთ.
     */
    public static void task1(){
        Integer[] myArray = new Integer[5];
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            myArray[i] = random.nextInt();
        }
        System.out.println(Arrays.toString(myArray));
    }

    /**
     * ჩაწერეთ კოლექციაში ხუთი შემთხვევითი მთელი რიცხვი. დაბეჭდეთ
     * პირდაპირი და შებრუნებული რიგით.
     */
    public static void task2(){
        Integer[] myArray = new Integer[5];
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            myArray[i] = random.nextInt();
            System.out.print(myArray[i] + "\t");
        }

        System.out.println();

        for (int i = 4; i >= 0 ; i--) {
            System.out.print(myArray[i] + "\t");
        }
    }

    /**
     * ჩაწერეთ კოლექციაში ხუთი შემთხვევითი მთელი რიცხვი. დაალაგეთ
     * ზრდადობით და დაბეჭდეთ.
     */
    public static void task3(){
        Queue<Integer> myNumbers = new PriorityQueue<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            myNumbers.add(random.nextInt(0, 100));
        }

        while (myNumbers.size() != 0){
            System.out.print(myNumbers.poll() + "\t");
        }
    }

    /**
     * ჩაწერეთ კოლექციაში ხუთი შემთხვევითი მთელი რიცხვი. დაალაგეთ
     * კლებადობით და დაბეჭდეთ.
     */
    public static void task4(){
        Random random = new Random();
        Queue<Integer> myNumbers = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < 5; i++) {
            myNumbers.add(random.nextInt(0, 100));
        }

        while (myNumbers.size() != 0){
            System.out.print(myNumbers.poll() + "\t");
        }
    }

    /**
     * ჩაწერეთ კოლექციაში ხუთი შემთხვევითი მთელი რიცხვი. ჩაამატეთ ბოლოში
     * სამი შემთხვევითი რიცხვი. დაბეჭდეთ თავდაპირველი და მიღებული
     * კოლექცია.
     */
    public static void task5(){
        List<Integer> myList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            myList.add(random.nextInt());
        }
        System.out.println(myList);

        for (int i = 0; i < 3; i++) {
            myList.add(random.nextInt());
        }
        System.out.println(myList);
    }
}

