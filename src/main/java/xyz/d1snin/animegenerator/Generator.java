package xyz.d1snin.animegenerator;

import sg4e.danbooru.Danbooru;
import sg4e.danbooru.DanbooruBuilder;
import sg4e.danbooru.Post;

import java.util.List;
import java.util.Random;

public class Generator {
    public static void Generate(int strings, String filename) {
        List<String> urls = null;
        for (int i = 0; i <= strings; i++) {
            Danbooru danbooru = new DanbooruBuilder().build();
            List<Post> posts = danbooru.getPosts("", true);
            Random rand = new Random();
            Post randomElement = posts.get(rand.nextInt(posts.size()));
            String url = randomElement.getFileUrl();
            urls.add(url);
            System.out.println("Writing: " + url);
        }
        Writer.Write(filename, strings, urls);
    }
}

