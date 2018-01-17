package com.example.jonas.starwarproject.Movies;

import java.io.Serializable;

/**
 * Created by Jonas on 16/01/2018.
 */

public class Movie implements Serializable {
    private String title;
    private String episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;

    public String getTitle() {
        return title;
    }

    public String getEpisode() {
        return episode_id;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEpisode(String episode) {
        this.episode_id = episode;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}


