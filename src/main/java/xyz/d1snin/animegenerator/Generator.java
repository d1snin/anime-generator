package xyz.d1snin.animegenerator;

import sg4e.danbooru.Danbooru;
import sg4e.danbooru.DanbooruBuilder;
import sg4e.danbooru.Post;

import java.util.List;
import java.util.Random;

public class Generator {
    public static void Generate(int stringsCount, String filename, String tag) {
        String[] urls = new String[stringsCount + 1];
        for (int i = 0; i <= stringsCount; i++) {
            Danbooru danbooru = new DanbooruBuilder().build();
            List<Post> posts = danbooru.getPosts(tag, true);
            Random rand = new Random();
            Post randomElement = null;
            try {
                randomElement = posts.get(rand.nextInt(posts.size()));
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("It looks like there are too few pictures with this tag, please try again, remember that this is a test function");
                System.exit(0);
            }
            urls[i] = randomElement.getFileUrl();
            if (randomElement.getFileUrl() == null) {
                i++;
                continue;
            }
            System.out.println("Generating: " + randomElement.getFileUrl());
        }
        Writer.write(stringsCount, urls, filename);
    }
}

