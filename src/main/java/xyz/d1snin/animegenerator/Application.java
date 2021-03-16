package xyz.d1snin.animegenerator;

public class Application {
    public static void main(String[] args) {
        try {
            int strings = Integer.parseInt(args[findIndex(args, "-l") + 1]);
            String fileName = args[findIndex(args, "-n") + 1];
            System.out.println("Welcome!");
            System.out.println("Generating according to your parameters...");
            Generator.Generate(strings, fileName);
            System.exit(0);
        } catch (RuntimeException exception) {
            System.out.println("Please use the following syntax:\njava -jar animegen.jar -l <count of generated images> -n <file name>");
        }
    }
    private static int findIndex(String[] arr, String toFind) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(toFind)) {
                return i;
            }
        }
        throw new RuntimeException();
    }
}
