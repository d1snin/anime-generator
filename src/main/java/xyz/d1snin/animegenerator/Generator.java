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
            Post randomElement = posts.get(rand.nextInt(posts.size()));
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

