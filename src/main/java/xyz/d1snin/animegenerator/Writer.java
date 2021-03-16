package xyz.d1snin.animegenerator;
import java.io.*;
import java.util.List;

public class Writer {
    private static File fileToWrite;
    private static FileWriter writer;

    static {
        try {
            assert false;
            writer = new FileWriter(fileToWrite.getAbsoluteFile(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Write(String filename, int strings, String[] content) {
        fileToWrite = new File(filename + ".json");
        try {
            if (fileToWrite.createNewFile()) {
                System.out.println(filename + ".json created.");
            } else {
                writer.append("{");
                writer.append(System.getProperty("line.separator"));
                for (int i = 0; i < strings; i++) {
                    writer.append(String.valueOf('"')).append(String.valueOf(i)).append(String.valueOf('"')).append(": ").append(String.valueOf('"')).append(content[i]).append(String.valueOf('"')).append(",");
                    writer.append(System.getProperty("line.separator"));
                }
                writer.append("}");
                writer.flush();
            }
        } catch (IOException ex) {
            //ignored.
        }
    }
}
