package xyz.d1snin.animegenerator;

public class Start {
    public static void main(String[] args) {
        int strings = Integer.parseInt(args[0]);
        System.out.println("Welcome!");
        System.out.println("Generating...");
        Generator.Generate(strings);
        System.exit(0);
    }
}
