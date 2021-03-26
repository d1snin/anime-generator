package xyz.d1snin.animegenerator;

import com.github.hanshsieh.pixivj.api.PixivApiClient;
import com.github.hanshsieh.pixivj.exception.PixivException;
import com.github.hanshsieh.pixivj.model.FilterType;
import com.github.hanshsieh.pixivj.model.SearchTarget;
import com.github.hanshsieh.pixivj.model.SearchedIllusts;
import com.github.hanshsieh.pixivj.model.SearchIllustsFilter;
import com.github.hanshsieh.pixivj.token.FixedTokenProvider;

import sg4e.danbooru.Danbooru;
import sg4e.danbooru.DanbooruBuilder;
import sg4e.danbooru.Post;

import java.io.IOException;
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
    private static String getImagePxv(String tag) {
        FixedTokenProvider tokenProvider =
                new FixedTokenProvider("MOBrBDS8blbauoSck0ZfDbtuzpyT"); //mfw doesnt work
        PixivApiClient client = new PixivApiClient.Builder()
                .setTokenProvider(tokenProvider)
                .build();
        SearchIllustsFilter searchIllustFilter = new SearchIllustsFilter();
        searchIllustFilter.setFilter(FilterType.FOR_ANDROID);
        searchIllustFilter.setIncludeTranslatedTagResults(true);
        searchIllustFilter.setMergePlainKeywordResults(true);
        searchIllustFilter.setOffset(0);
        searchIllustFilter.setSearchTarget(SearchTarget.PARTIAL_MATCH_FOR_TAGS);
        searchIllustFilter.setWord(tag);
        SearchedIllusts searchedIllusts = null;
        try {
            searchedIllusts = client.searchIllusts(searchIllustFilter);
        } catch (PixivException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchedIllusts.getNextUrl();
    }
    public static List<String> getImages(int count, String tag, boolean isSaveMode, String resouce) {
        if (resouce.equalsIgnoreCase("danbooru")) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String url = getImage(tag);
                if (url == null) {
                    url = getImage(tag); //ok
                }
                res.add(url);
                System.out.println(" - Fetching " + "(" + (i + 1) + "/" + count + ")" + ": " + "[" + url + "]");
                if (isSaveMode) ImageSaver.downloadFrom(url);
            }
            return res;
        }
        if (resouce.equalsIgnoreCase("pixiv")) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String url = getImagePxv(tag);
                if (url == null) {
                    url = getImagePxv(tag);
                }
                res.add(url);
                System.out.println(" - Fetching " + "(" + (i + 1) + "/" + count + ")" + ": " + "[" + url + "]");
                if (isSaveMode) ImageSaver.downloadFrom(url);
            }
        }
        throw new InvalidSyntaxException();
    }
}


