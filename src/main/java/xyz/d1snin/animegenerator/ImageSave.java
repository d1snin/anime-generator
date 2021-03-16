package xyz.d1snin.animegenerator;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageSave {
    public static void downloadFile(String[] content, String fileName) throws Exception {
        for (int i = 0; i< content.length; i++) {
            URL url = new URL(content[i]);
            try (InputStream in = url.openStream()) {
                Files.copy(in, Paths.get(fileName));
            }
        }
    }
}
