package xyz.d1snin.animegenerator;

import sg4e.danbooru.Danbooru;
import sg4e.danbooru.DanbooruBuilder;
import sg4e.danbooru.Post;

import java.util.List;
import java.util.Random;

public class ImageGen {
    private static String getImage(String tag) {
        Danbooru danbooru = new DanbooruBuilder().build();
        List<Post> posts = danbooru.getPosts(tag, true);
        Random rand = new Random();
        Post randomElement = null;
        try {
            while (randomElement == null) {
                randomElement = posts.get(rand.nextInt(posts.size()));
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(" - It looks like there are too few pictures with this tag, please try again, remember that this is a test function");
            System.exit(0);
        }
        return randomElement.getFileUrl();
    }

    public static String[] getImages(int count, String tag, boolean isSaveMode) {
        String[] res = new String[count];
        for (int i = 0; i < res.length; i++) {
            String url = getImage(tag);
            res[i] = url;
            if (isSaveMode) ImageSaver.downloadFrom(url);
        }
        return res;
    }
}


