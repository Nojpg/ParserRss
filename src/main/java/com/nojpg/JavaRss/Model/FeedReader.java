package com.nojpg.JavaRss.Model;

import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nojpg on 29.05.17.
 */

public class FeedReader {

    private static final int FEED_COUNT = 10;

    public static FeedInfo readFeed(String url){

        FeedInfo feedInfo = new FeedInfo();

        List<FeedEntryContent> feedContent = new ArrayList<>();

        feedInfo.setFeedEntryContent(feedContent);
        try{
            URL feedUrl = new URL(url);
            SyndFeed feed = new SyndFeedInput().build(new XmlReader(feedUrl));

            feedInfo.setImage(feed.getImage());
            feedInfo.setName(feed.getTitle());

            for (int i = 0; i<FEED_COUNT; i++){
                SyndEntry entry = feed.getEntries().get(i);

                FeedEntryContent feedEntryContent = new FeedEntryContent();
                feedEntryContent.setTitle(entry.getTitle());
                feedEntryContent.setUrl(entry.getLink());
                System.out.println(entry.getTitle());
                System.out.println(entry.getLink());
                System.out.println(entry.getCategories());
                if (entry.getDescription() != null) {
                    feedEntryContent.setDescription(entry.getDescription().getValue());
                } else {
                    SyndContent syndContent = entry.getContents().get(0);
                    feedEntryContent.setDescription(syndContent.getValue());
                }
                feedContent.add(feedEntryContent);
            }

        } catch (Exception ex){
            System.out.println("err");
        }

        return feedInfo;
    }
}
