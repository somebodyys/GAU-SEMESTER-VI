package gau.java.workingWithFiles;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Files {

    private BufferedWriter writer;

    /**
     * Handle Folder creating if it does not exist
     */
    private void handleFolder(String folderName){
        File file = new File(folderName);
        if(!file.exists())
            if(file.mkdir()) System.out.printf("%s folder was successfully created!%n", folderName);
    }

    /**
     * მთელი 24, 39, -90 რიცხვები ჩაწერეთ data.txt ფაილში, ფაილი შექმენით myFiles
     * საქაღალდეში.
     */
    public void task1() throws IOException {
        this.handleFolder("myFiles");

        this.writer = new BufferedWriter(
                new FileWriter("myFiles/data.txt")
        );
        int[] numbers = { 24, 39, -90};

        for(int number : numbers)
            this.writer.write(number + "\n");

        this.writer.close();
    }

    /**
     * 0-დან 100-მდე მთელი რიცხვები ჩაწერეთ data1.txt ფაილში. myFiles საქაღალდეში.
     */
    public void task2() throws IOException {
        this.handleFolder("myFiles");
        this.writer = new BufferedWriter(
                new FileWriter("myFiles/data1.txt")
        );

        for (int i = 0; i < 100; i++)
            this.writer.write(i + "\n");

        this.writer.close();
    }

    /**
     * myFiles1 საქაღალდეში საქაღალდეში შექმენით 30 ფაილი, ფაილებში ჩაწერეთ სიტყვა
     * „Programmer“.
     */
    public void task3() throws IOException{
        this.handleFolder("myFiles1");

        for (int i = 0; i < 30; i++) {
            this.writer = new BufferedWriter(
                    new FileWriter(String.format("myFiles1/%d.txt", i))
            );
            this.writer.write("Programmer");
            this.writer.close();
        }
    }

    /**
     * myFiles2 საქაღალდეში საქაღალდეში შექმენით 30 ფაილი, ფაილებში ჩაწერეთ
     * სიტყვები „Programmer1“, „Programmer2“ .... „Programmer30“.
     */
    public void task4() throws IOException{
        this.handleFolder("myFiles2");

        for (int i = 0; i < 30; i++) {
            this.writer = new BufferedWriter(
                    new FileWriter(String.format("myFiles2/%d.txt", i))
            );
            this.writer.write(String.format("Programmer%d", i));
            this.writer.close();
        }
    }

    /**
     * კლავიატურიდან გადაცემული [a, b] შუალედიდან ჩაწერეთ data2.txt ფაილში 100
     * შემთხვევითი მთელი რიცხვი. ფაილი შექმენით myFiles საქაღალდეში.
     */
    public void task5() throws IOException{
        this.handleFolder("myFiles");
        int a, b;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        this.writer = new BufferedWriter(
                new FileWriter("myFiles/data2.txt")
        );
        a = scanner.nextInt();
        b = scanner.nextInt();

        for (int i = 0; i < 100; i++) {
            this.writer.write(
                    random.nextInt(a, b) + "\n"
            );
        }

        this.writer.close();
    }

    /**
     * კლავიატურიდან გადაცემული [a, b] შუალედიდან დაამატეთ data3.txt ფაილში 50
     * შემთხვევითი ნამდვილი რიცხვი. დამატებული რიცხვები გამოყავით მასში არსებული
     * რიცხვებიდან. myFiles საქაღალდეში.
     */
    public void task6() throws IOException{
        this.handleFolder("myFiles");
        double a, b;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        this.writer = new BufferedWriter(
                new FileWriter("myFiles/data3.txt")
        );
        a = scanner.nextInt();
        b = scanner.nextInt();

        for (int i = 0; i < 50; i++) {
            this.writer.write(
                    random.nextDouble(a, b) + "\n"
            );
        }

        this.writer.close();
    }

    /**
     * დაწერეთ პროგრამა, რომელიც y=x^3+e^x ფუნქციის მნიშვნელობებს დაითვლის
     * [0; 2 ] შუალედში მეასედების სიზუსტით და შესაბამის მნიშვნელობებს
     * ჩაწერს function.txt ფაილში myFiles საქაღალდეში.
     */
    public void task7() throws IOException {
        this.handleFolder("myFiles");
        this.writer = new BufferedWriter(
                new FileWriter("myFiles/function.txt")
        );

        for (float x = 0; x < 2F; x += 0.01) {
            this.writer.write(
                    Math.pow(x, 3) + Math.exp(x) + "\n"
            );
        }
        this.writer.close();
    }

    /**
     * დაწერეთ პროგრამა, რომელიც y=sin(sin(x))+e^x+1 ფუნქციის მნიშვნელობებს დაითვლის
     * [0; 2 ] შუალედში მეასედების სიზუსტით და შესაბამის მნიშვნელობებს ჩაწერს function.txt ფაილში.
     */
    public void task8() throws IOException{
        this.handleFolder("myFiles");
        this.writer = new BufferedWriter(
                new FileWriter("myFiles/function1.txt")
        );

        for (float x = 0; x < 2F; x += 0.01) {
            this.writer.write(
                    Math.sin(Math.sin(x)) + Math.exp(x) + 1 + "\n"
            );
        }
        this.writer.close();
    }

    /**
     * დაწერეთ ფუნქცია, რომელიც ჩაწერს 10 000-ს ‘.txt’ გაფართოების ფაილს myFiles
     * საქაღალდეში, ფაილებში ჩაწერს 1-დან 10 000-მდე რიცხვებს და შესაბამისად ფაილის
     * სახელი იქნება ის რიცხვი რაც ჩაწერილია შესაბამის ფაილში. მაგ(თუ ფაილში
     * ჩაწერილია რიცხვი 12 მაშინ ამ ფაილის სახელი იქნება 12.txt).
     */
    public void task9() throws IOException{
        this.handleFolder("myFiles");

        for (int i = 0; i < 10000; i++) {
            this.writer = new BufferedWriter(
                    new FileWriter(String.format("myFiles/%d.txt", i))
            );

            this.writer.write(i + "\n");
            this.writer.close();
        }
    }

    /**
     * დაწერეთ პროგრამა, რომელიც ათობით რიცხვს გადაიყვანს ორობითში.
     */
    public String task10(int decimal){
        return Integer.toBinaryString(decimal);
    }

    /**
     * დაწერეთ პროგრამა, რომელიც ორობით რიცხვს გადაიყვანს ათობითში.
     */
    public int task11(String binary){
        return Integer.parseInt(binary, 2);
    }

    /**
     * დაწერეთ მარტივი პროცენტის გამოსათვლელი პროგრამა. მოცემულია ოთხი მონაცემი
     * p - საწყისი თანხა,
     * n - წლების რაოდენობა,
     * q - საბოლოო თანხა.
     * k - პროცენტების რაოდენობა.
     * დანარჩენი სამი სიდიდის მიხედვით გამოთვალეთ მეოთხე.
     */
    public double task12(double principal, float rate, int period){
        return principal * rate * period;
    }

    /**
     * დავწეროთ რთული პროცენტის გამოსათვლელი პროგრამა. მოცემულია ოთხი
     * მონაცემი
     *
     * p - საწყისი თანხა,
     * n - წლების რაოდენობა,
     * q - საბოლოო თანხა.
     * k - პროცენტების რაოდენობა.
     * დანარჩენი სამი სიდიდის მიხედვით გამოთვალეთ მეოთხე.
     */
    public double task13(double principal, float rate, int number, int time){
        return principal * (Math.pow( (1 + rate / number), number * time));
    }

    /**
     * შეიტანეთ ორი a და b რიცხვები, ჩაწერეთ numbers.txt ფაილში ამ რიცხვებს შორის
     * მოთავსებული 40 მთელი რიცხვი, დაადგინეთ რამდენია ლუწი და რამდენი კენტი
     * ფაილში ჩაწერილ რიცხვებს შორის, მოახდინეთ ლუწი რიცხვებისა და კენტი
     * რიცხვების ჯამის გამოტანა ეკრანზე და მიღებულ ჯამებს შორის 5 შემთხვევითი
     * რიცხვი ჩაწეროთ ფაილში numbers2.txt ფაილში.
     */
    public void task14() throws IOException {
        int a, b, oddCount = 0, evenCount = 0, oddSum = 0, evenSum = 0;

        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();

        Random random = new Random();
        this.handleFolder("myFiles3");
        this.writer = new BufferedWriter(
                new FileWriter("myFiles3/numbers.txt")
        );

        for (int i = 0; i < 40; i++) {
            int randomNumber = random.nextInt(a, b);
            this.writer.write(randomNumber + "\n");
            if (randomNumber % 2 == 0){
                evenCount++;
                evenSum += randomNumber;
            } else {
                oddCount++;
                oddSum += randomNumber;
            }
        }
        this.writer.close();
        System.out.printf("Odd Sum = %d\nEven Sum = %d", oddSum, evenSum);

        this.writer = new BufferedWriter(
                new FileWriter("myFiles3/numbers2.txt")
        );

        for (int i = 0; i < 5; i++) {
            int randomNumber = random.nextInt(evenSum, oddSum);
            this.writer.write(randomNumber + "\n");
        }
        this.writer.close();
    }

    /**
     * კლავიატურიდან შეტანილი m<=50 და n<=50 ნატურალური რიცხვების მიხედვით.
     * info.txt ფაილში ჩაწერეთ შემთხვევითი 1 ან 0 ციფრები m სტრიქონში და n სვეტში.
     * მოახდინეთ info.txt ფაილის წაკითხვა, დაითვალეთ რამდენი 1 და რამდენი 1
     * სიმბოლოა ჩაწერილი ფაილში.
     */
    public void task15() throws IOException {
        int m = 100, n = 100, countZero = 0, countOne = 0;
        while (!(m <= 50) || !(n <= 50)){
            Scanner scanner = new Scanner(System.in);
            m = scanner.nextInt();
            n = scanner.nextInt();
        }

        this.handleFolder("myFiles3");
        this.writer = new BufferedWriter(
                new FileWriter("myFiles3/info.txt")
        );
        Random random = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.writer.write(
                        String.format("%d", random.nextInt(0, 2))
                );
            }
            this.writer.newLine();
        }
        this.writer.close();

        BufferedReader reader = new BufferedReader(
                new FileReader("myFiles3/info.txt")
        );
        String line;
        while((line = reader.readLine()) != null){
            char[] chars = line.toCharArray();
            for (char myChar : chars){
                if(myChar == '0') countZero++;
                if(myChar == '1') countOne++;
            }
        }
        reader.close();
        System.out.printf("Ones : %d\nZeros : %d", countOne, countZero);
    }
}
