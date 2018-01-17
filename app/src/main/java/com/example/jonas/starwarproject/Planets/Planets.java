package com.example.jonas.starwarproject.Planets;

import java.util.List;

/**
 * Created by Jonas on 16/01/2018.
 */

public class Planets {
    private String next;
    private String previous;
    private String count;
    private List<Planet> results;

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public String getCount() {
        return count;
    }

    public List<Planet> getResults() {
        return results;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setResults(List<Planet> results) {
        this.results = results;
    }
}
