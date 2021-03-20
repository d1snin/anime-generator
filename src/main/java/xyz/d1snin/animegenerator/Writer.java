package xyz.d1snin.animegenerator;
import java.io.*;
import java.util.List;

public class Writer {
    public static void write(List<String> content, String fileName) {
        File fileToWrite = new File(fileName + ".json");
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileToWrite.getAbsoluteFile(), false);
        } catch (IOException e) {
            /* ignore */
        }
        try {
            if (fileToWrite.createNewFile()) { } else {
                System.out.println(" - Writing your file...");
                writer.append("{");
                writer.append(System.getProperty("line.separator"));
                for (int i = 0; i < content.size(); i++) {
                    writer.append(String.valueOf('"')).append(String.valueOf(i)).append(String.valueOf('"')).append(": ").append(String.valueOf('"')).append(content.get(i)).append(String.valueOf('"')).append(i == (content.size() - 1) ? "" : ",");
                    writer.append(System.getProperty("line.separator"));
                }
                writer.append("}");
                writer.flush();
                System.out.println(" - Done!");
            }
        } catch (IOException ioException) {
            //ignore
        }
    }
}
