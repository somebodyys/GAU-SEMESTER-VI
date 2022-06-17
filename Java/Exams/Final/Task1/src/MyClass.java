import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

interface myInterface {
    void method1();
    void method2();
    void method3();
    void method4();
}


public class MyClass implements myInterface {

    private final ArrayList<String> collection = new ArrayList<>();

    private final char[] symbols = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' , 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    /**
     * კოლექციაში ჩაწერს 20 შემთხვევით 7 სიმბოლოან სტრიქონს, თითოული
     * სტრიქონი შედგება განსხვავებული სიმბოლოებისგან;
     */
    public void method1(){
        for (int i = 0; i < 20; i++) {
            String myString = this.generateString(7);
            this.collection.add(myString);
        }
    }

    /**
     * აგენერირებს სტრიქონს
     */
    private String generateString(int symbolCount){
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < symbolCount; i++) {
            while (true){
                char randomChar = this.symbols[random.nextInt(0, this.symbols.length - 1)];
                if(!result.toString().contains(String.valueOf(randomChar))){
                    result.append(randomChar);
                    break;
                }
            }
        }

        return result.toString();
    }

    /**
     * შეცვლის კოლექციაში იმ სტრიქონებს, რომელიც შეიცავს სიმბოლო a-ს,
     * შემთხვევითი 5 სიმბოლოიანი სტრიქონით, რომელიც არ შეიცავს სიმბოლო a-ს;
     */
    public void method2(){
        for (int i = 0; i < this.collection.size(); i++) {
            if (this.collection.get(i).contains("a")){
                String replaceString;

                do {
                    replaceString = generateString(5);
                } while (replaceString.contains("a"));

                this.collection.set(i, replaceString);
            }
        }
    }

    /**
     * ჩაამატებს კოლექციაში შემთხვევითად აღებული ინდექსის შემდეგ 5
     * შემთხვევით მხოლოდ ციფრებისგან შემდგარ 4 სიმბოლოიან სტრიქონს;
     */
    public void method3(){
        Random random = new Random();
        int randomIndex = random.nextInt(0, this.collection.size() - 1);

        for (int i = randomIndex; i < randomIndex + 5; i++) {
            StringBuilder numberString = new StringBuilder();

            for (int j = 0; j < 4; j++) {
                numberString.append(random.nextInt(0, 9));
            }

            this.collection.add(i, numberString.toString());
        }
    }

    /**
     * ბეჭდავს კოლექციას.
     */
    public void method4(){
        System.out.println(
                Arrays.toString(this.collection.toArray())
        );
    }

}
