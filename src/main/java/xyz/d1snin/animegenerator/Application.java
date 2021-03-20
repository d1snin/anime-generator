package xyz.d1snin.animegenerator;

public class Application {
    public static void main(String[] args) {
        try {
            boolean isSaveMode = false;
            String tag = "";
            try {
                tag = args[findIndex(args, "-t") + 1];
            } catch (InvalidSyntaxException invalidSyntaxException) {
                /* ignore */
            }
            try {
                findIndex(args, "-s");
                isSaveMode = true;
            } catch (InvalidSyntaxException invalidSyntaxException) {
                /* ignore */
            }
            int stringsCount = Integer.parseInt(args[findIndex(args, "-l") + 1]);
            String fileName;
            fileName = args[findIndex(args, "-n") + 1];
            System.out.println(" - Welcome, " + System.getProperty("user.name") + "!");
            System.out.println(" - Generating according to your parameters...");
            System.out.println(" - How much will be generated: " + stringsCount);
            Writer.write(ImageGen.getImages(stringsCount, tag, isSaveMode), fileName);
            System.exit(0);
        } catch (InvalidSyntaxException | NumberFormatException exception) {
            System.out.println(" - Please use the following syntax:\njava -jar animegen.jar " +
                    "\n-l <count of generated images> " +
                    "\n-n <file name> " +
                    "\n-t <tag (optional)> " +
                    "\n-s <((optional) All pictures will be saved to the current folder)>");
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
