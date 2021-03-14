package xyz.d1snin.animegenerator;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Please enter a name for the JSON file to be generated: ");
        String fileName = scanner.nextLine();
        System.out.println("Please enter the number of created links for your file: ");
        int strings = scanner.nextInt();
        System.out.println("Generating...");
        Generator.Generate(strings, fileName);
    }
}
