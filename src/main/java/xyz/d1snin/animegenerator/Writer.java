package xyz.d1snin.animegenerator;
import java.io.*;

public class Writer {
    private static File fileToWrite;
    public Writer(int length, String[] content, String fileName) {
        fileToWrite = new File(fileName);
        write(length, content, fileName);
    }
    private static FileWriter writer;

    static {
        try {
            writer = new FileWriter(fileToWrite.getAbsoluteFile(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(int strings, String[] content, String fileName) {
        try {
            if (fileToWrite.createNewFile()) {
                System.out.println("output.json created");
            } else {
                System.out.println("output.json already exist.");
                System.out.println("Writing your file...");
                writer.append("{");
                writer.append(System.getProperty("line.separator"));
                for (int i = 0; i < strings; i++) {
                    writer.append(String.valueOf('"')).append(String.valueOf(i)).append(String.valueOf('"')).append(": ").append(String.valueOf('"')).append(content[i]).append(String.valueOf('"')).append(",");
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
