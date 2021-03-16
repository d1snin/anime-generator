package xyz.d1snin.animegenerator;
import java.io.*;

public class Writer {
    public static void Write(String filename, int strings, String[] content) {
        File fileToWrite = new File(filename + ".json");
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileToWrite, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
