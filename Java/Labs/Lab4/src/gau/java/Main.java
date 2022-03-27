package gau.java;

import gau.java.workingWithFiles.Files;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Files files = new Files();

            files.task1();
            files.task2();
            files.task3();
            files.task4();
            files.task5();
            files.task6();
            files.task7();
            files.task8();
            files.task9();
            System.out.println(
                    files.task10(10)
            );
            System.out.println(
                    files.task11("1010")
            );
            System.out.println(
                    files.task12(10000, 0.3f, 5)
            );
            System.out.println(
                    files.task13(10000, 0.3f, 2, 5)
            );
            files.task14();
            files.task15();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
