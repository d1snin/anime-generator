package xyz.d1snin.animegenerator;

import java.io.IOException;

public class ImageSave {
    public static void saver(String[] urls) {
        for (String s : urls) {
            try {
                Runtime.getRuntime().exec("wget " + s); //lol
            } catch (IOException ioException) {
                //ignore
            }
        }
    }
}
