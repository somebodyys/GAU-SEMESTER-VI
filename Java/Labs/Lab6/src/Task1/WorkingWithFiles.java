package Task1;

import java.io.*;
import java.lang.invoke.WrongMethodTypeException;
import java.util.Random;
import java.util.Scanner;

public class WorkingWithFiles {

    private Scanner scanner;

    /**
     * შექმნის ძირითადი (root) საქაღალდეს (რომელიმე დისკზე), დისკის ამორჩევა
     * შეუძლია მომხარებელს
     *
     * ლინუქსზე C: D: და მსგავსი დისკები არ მაქვს.
     */
    public void method1(){
        String path;
        scanner = new Scanner(System.in);
        System.out.print("Enter Path : ");
        path = scanner.nextLine();
        File file = new File(path);
        if(!file.exists())
            if (file.mkdirs()) System.out.println("Success!");
    }

    /**
     * ძირითად საქაღალდეში ქმნის საქაღალდეებს ან ფაილებს (ირჩევს მომხარებელი)
     */
    public void method2() throws IOException {
        char command;
        scanner = new Scanner(System.in);
        System.out.print("Directory Or File? (d/f) : ");
        command = scanner.next().charAt(0);
        switch (command) {
            case 'd' -> method1();
            case 'f' -> {
                System.out.print("Filename : ");
                String fileName = scanner.next();
                File file = new File(fileName);
                if(file.createNewFile()) System.out.println("File Created!");
            }
            default -> throw new WrongMethodTypeException("Unknown Command!");
        }
    }

    /**
     * ჩაწერს ნებისმიერ ფაილში მონაცემებს რომელიც შეაქვს მომხარებელს, ან
     * შემთხვევით მონაცემებს, მომხარებლის მიერ ბრძანების შეტანის შესაბამისად
     */
    public void method3() throws IOException {
        char command;
        String filePath;
        scanner = new Scanner(System.in);
        System.out.print("Random or Your Data (r/y) : ");
        command = scanner.next().charAt(0);
        System.out.print("What file Should I use? :");
        filePath = scanner.next();
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(filePath)
        );
        Random random = new Random();

        switch (command) {
            case 'r' -> bufferedWriter.write(random.nextInt() + "");
            case 'y' -> {
                System.out.print("TELL ME DATA : ");
                String data = scanner.next();
                bufferedWriter.write(data);
            }
            default -> throw new WrongMethodTypeException("Unknown Command!");
        }

        bufferedWriter.close();
    }


    /**
     * წაიკითხავს ფაილების და დაბეჭდავს შიგნით არსებული მონაცემებს მომხარებლის
     * სურვლის შესაბამისად.
     */
    public void method4() throws IOException {
        String filePath;
        scanner = new Scanner(System.in);
        System.out.print("File : ");
        filePath = scanner.next();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(filePath)
        );
        String newLine;

        while((newLine = bufferedReader.readLine()) != null){
            System.out.println(newLine);
        }
    }
}
