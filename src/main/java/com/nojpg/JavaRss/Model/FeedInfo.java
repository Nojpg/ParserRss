package com.nojpg.JavaRss.Model;

import com.rometools.rome.feed.synd.SyndImage;

import java.util.List;

/**
 * Created by Nojpg on 29.05.17.
 */
public class FeedInfo {

    private SyndImage image;

    private String name;
    private List<FeedEntryContent> feedEntryContent;


    public SyndImage getImage() {
        return image;
    }

    public void setImage(SyndImage image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FeedEntryContent> getFeedEntryContent() {
        return feedEntryContent;
    }

    public void setFeedEntryContent(List<FeedEntryContent> feedEntryContent) {
        this.feedEntryContent = feedEntryContent;
    }
}
