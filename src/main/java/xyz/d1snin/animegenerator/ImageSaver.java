package xyz.d1snin.animegenerator;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageSaver {
    public static void downloadFrom(String url) {
        URL imageUrl = null;
        try {
            imageUrl = new URL(url);
        } catch (MalformedURLException e) {
        }
        String[] preFileName = url.split("/");
        String fileName = preFileName[preFileName.length - 1];
        downloadFile(imageUrl, fileName);
    }

    private static void downloadFile(URL url, String fileName) {
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get(fileName));
        } catch (IOException exception) {
            downloadFile(url, fileName);
        }
    }
}
