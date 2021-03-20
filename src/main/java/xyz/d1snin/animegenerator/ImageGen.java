package xyz.d1snin.animegenerator;

import sg4e.danbooru.Danbooru;
import sg4e.danbooru.DanbooruBuilder;
import sg4e.danbooru.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImageGen {
    private static String getImage(String tag) {
        Danbooru danbooru = new DanbooruBuilder().build();
        List<Post> posts = null;
        try {
            posts = danbooru.getPosts(tag, true);
        } catch (Exception exception) {
            System.out.println(" - Unable to get posts from Danbooru, check your network connection or use a VPN.");
            System.exit(0);
        }
        Random rand = new Random();
        Post randomElement = null;
        try {
            do {
                randomElement = posts.get(rand.nextInt(posts.size()));
            } while (randomElement == null);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(" - It looks like there are too few pictures with this tag, please try again, remember that this is a test function");
            System.exit(0);
        }
        return randomElement.getFileUrl();
    }

    public static List<String> getImages(int count, String tag, boolean isSaveMode) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String url = getImage(tag);
            if (url == null) {
                url = getImage(tag); //ok
            }
            res.add(url);
            System.out.println(" - Fetching " + "(" + i + "/" + count + ")" + ": " + "[" + url + "]");
            if (isSaveMode) ImageSaver.downloadFrom(url);
        }
        return res;
    }
}


