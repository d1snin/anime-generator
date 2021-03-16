package xyz.d1snin.animegenerator;

public class Application {
    public static void main(String[] args) {
        try {
            String tag = "";
            try {
                tag = args[findIndex(args, "-t") + 1];
            } catch (InvalidSyntaxException invalidSyntaxException) {
            }
            int stringsCount = Integer.parseInt(args[findIndex(args, "-l") + 1]);
            String fileName;
            fileName = args[findIndex(args, "-n") + 1];
            System.out.println(" - Welcome!");
            System.out.println(" - Generating according to your parameters...");
            Writer.write(ImageGen.getImages(stringsCount, tag), fileName);
            System.exit(0);
        } catch (InvalidSyntaxException | NumberFormatException exception) {
            System.out.println(" - Please use the following syntax:\njava -jar animegen.jar -l <count of generated images> -n <file name> -t <tag (optional)> -s <((optional) All pictures will be saved to the current folder)>");
        }
    }
    private static int findIndex(String[] arr, String toFind) throws InvalidSyntaxException {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(toFind)) {
                return i;
            }
        }
        throw new InvalidSyntaxException();
    }
}
