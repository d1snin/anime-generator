package xyz.d1snin.animegenerator;

public class Start {
    public static void main(String[] args) {
        String fileName = args[0];
        int strings = Integer.parseInt(args[1]);
        System.out.println("Welcome!");
        System.out.println("Generating...");
        Generator.Generate(strings);
    }
}
