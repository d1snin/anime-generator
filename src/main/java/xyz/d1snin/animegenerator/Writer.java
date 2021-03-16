package xyz.d1snin.animegenerator;
import java.io.*;

public class Writer {
    private static final File fileToWrite = new File("output.json");
    private static FileWriter writer;

    static {
        try {
            writer = new FileWriter(fileToWrite.getAbsoluteFile(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(int strings, String[] content) {
        try {
            if (fileToWrite.createNewFile()) {
                System.out.println("output.json created");
            } else {
                writer.append("{");
                writer.append(System.getProperty("line.separator"));
                for (int i = 0; i < strings; i++) {
                    writer.append(String.valueOf('"')).append(String.valueOf(i)).append(String.valueOf('"')).append(": ").append(String.valueOf('"')).append(content[i]).append(String.valueOf('"')).append(",");
                    System.out.println("Writing: " + content[i]);
                    writer.append(System.getProperty("line.separator"));
                }
                writer.append("}");
                writer.flush();
                System.out.println("Done!");
            }
        } catch (IOException ex) {
            //ignored.
        }
    }
}
